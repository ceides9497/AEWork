package com.tekvizion.AutomationEditor.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.tekvizion.tekeye.ws.AutomationServiceWsImpl;
import com.tekvizion.tekeye.ws.AutomationServiceWsImplService;
import com.tekvizion.tekeye.ws.WsAutomationScript;
import com.tekvizion.tekeye.ws.WsErrorCodes;
import com.tekvizion.tekeye.ws.WsTestCase;
import com.tekvizion.tekeye.ws.WsTestPlan;

@Controller
public class TestPlansController{
	
static Logger logger = Logger.getLogger("automationHome");	
	
	public AutomationServiceWsImplService wsService = new AutomationServiceWsImplService();
	public AutomationServiceWsImpl wsServicePort;
	
	@PostConstruct
	public void initConfig(){
		 this.wsServicePort = this.wsService.getAutomationServiceWsImplPort();
	}
	
	@RequestMapping(value = {"/","/testPlans"}, method = {RequestMethod.GET,RequestMethod.POST})
	public String testPlans(Model model,HttpServletRequest request) {
		
		/*try{
			//Sample Coding to for the list of test plans Page..
			//Manual logging the user
		UserDetails userDetails = userDetailsServiceImpl.loadUserByUsername("sample");
		Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, userDetails.getPassword(), userDetails.getAuthorities());
		SecurityContext securityContext = SecurityContextHolder.getContext();
		securityContext.setAuthentication(authentication);
		HttpSession session = request.getSession(true);
		session.setAttribute("SPRING_SECURITY_CONTEXT", securityContext);
		}catch(Exception e){
			logger.debug("...."+e);
		}*/
		
		try{
			List<WsTestPlan> wsTestPlans = new ArrayList<WsTestPlan>();
			wsTestPlans = wsServicePort.listAutomatableTestplans();
			model.addAttribute("wsTestPlans", wsTestPlans);
			model.addAttribute("totalTestplans", wsTestPlans.size());
			logger.debug("Listing All Automatable Test Plans");
		}catch(Exception e){
			model.addAttribute("error", true);
			logger.debug("Error occurred while accessing the test plans.... "+e.getMessage());
		}
		return "testPlans";
	}
	
	@RequestMapping(value = "/testCases", method = {RequestMethod.GET,RequestMethod.POST})
	public String testCases(Model model,@RequestParam("id") String testPlanId) {
		
		try{
			List<WsTestCase> wsTestCases = new ArrayList<WsTestCase>();
			wsTestCases = this.wsServicePort.listAutomatableTestcaseListByTestPlan(testPlanId);
			model.addAttribute("wsTestCases", wsTestCases);
			WsTestPlan wsTestPlanDetails = this.wsServicePort.getTestPlanDetails(testPlanId);
			model.addAttribute("testPlan",wsTestPlanDetails);
			int UDcount = 0;
			int GAcount = 0;
			model.addAttribute("totalTestcases", wsTestCases.size());
				if(wsTestCases.size()>0){
					for(WsTestCase eachTestCase : wsTestCases){
						if(eachTestCase.getAutomationStatus().equalsIgnoreCase("UD")||eachTestCase.getAutomationStatus().equalsIgnoreCase("")){
							UDcount++;
						}else if(eachTestCase.getAutomationStatus().equalsIgnoreCase("GA")){
							GAcount++;
						}
					}
				}
			model.addAttribute("UDcount", UDcount);
			model.addAttribute("GAcount", GAcount);
			logger.debug(wsTestCases);
			logger.debug("Listing All Automatable Test Cases for the Test Plan Id : "+testPlanId);
		}catch(Exception e){
			model.addAttribute("error", true);
			logger.debug("Error occurred while accessing the test cases.... "+e.getMessage());
		}
		return "testCases";
	}
	
	@RequestMapping(value = "/testCaseEditor", method = {RequestMethod.GET,RequestMethod.POST})
	public String testCaseEditor(Locale locale, Model model,@RequestParam(value="tcId") String tcID,
									@RequestParam(value="tpId") String testPlanId, RedirectAttributes redAttr) {
		try{
			logger.debug("Editing the Test Case with ID "+tcID);
			
			WsTestCase wsTestCaseDetails = this.wsServicePort.getTestCaseDetails(tcID);
			WsTestPlan wsTestPlanDetails = this.wsServicePort.getTestPlanDetails(testPlanId);
			
			List<WsAutomationScript> allTestCaseScripts = this.wsServicePort.listTestCaseAutomationScriptsByExtension(tcID,".etc");
			List<WsAutomationScript> sipTestCaseScripts = this.wsServicePort.listTestCaseAutomationScriptsByExtension(tcID,".stc");
			
				if(!allTestCaseScripts.isEmpty()){
					logger.debug("Script Exists for the testCase");
					redAttr.addFlashAttribute("tcScript", allTestCaseScripts.get(0));
				}
				else{
					redAttr.addFlashAttribute("tcScript", null);
				}
				
				if(!sipTestCaseScripts.isEmpty()){
					logger.debug("SIP Script Exists for the testCase");
					redAttr.addFlashAttribute("stcScript", sipTestCaseScripts.get(0));
				}
				else{
					redAttr.addFlashAttribute("stcScript", null);
				}
			redAttr.addFlashAttribute("tcDetails", wsTestCaseDetails);
			redAttr.addFlashAttribute("tpDetails", wsTestPlanDetails);
			redAttr.addFlashAttribute("setFlag", "true");
		}catch(Exception e){
			logger.debug("Error occurred while getting the test case details for the editor .... "+e.getMessage());
			model.addAttribute("error", true);
			return "testCases";
		}
		return "redirect:editor";
	}
	
	/************************ACCESS TEST CASE DETAILS*****************************/
	@RequestMapping(value = "/testCaseDetails", method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView testCaseDetails(Locale locale, Model model,@RequestParam(value="tcId") String tcID,
			@RequestParam(value="tpId") String testPlanId){
		
		logger.debug(" Accessing the Test Case Details  for tcID "+tcID);
		try{
			WsTestCase wsTestCaseDetails = this.wsServicePort.getTestCaseDetails(tcID);
			WsTestPlan wsTestPlanDetails = this.wsServicePort.getTestPlanDetails(testPlanId);
			model.addAttribute("tcDetails", wsTestCaseDetails);
			model.addAttribute("tpDetails", wsTestPlanDetails);
		}catch(Exception e){
			logger.debug("Error occurred while getting the test case details"+e.getMessage());
			model.addAttribute("error", true);
		}
		return new ModelAndView("testCaseModalDetailed");
	}

	@RequestMapping(value = "/uploadScripts", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody
	String uploadScripts(Locale locale, Model model,@RequestParam("tcId") String tcId,@RequestParam("markComplete") boolean status) {
		try{
			WsTestCase testCase = this.wsServicePort.getTestCaseDetails(tcId);
			
			logger.debug("Method to Upload Scripts invoked");
			WsAutomationScript etcFile = new WsAutomationScript();
			etcFile.setFileName(testCase.getId()+".etc");
			etcFile.setId(null);
			etcFile.setTestCaseId(testCase.getId());
			etcFile.setScript(convertFileToBytes(etcFile.getFileName()));
			etcFile.setComplete(status);
			
			WsAutomationScript tcFile = new WsAutomationScript();
			tcFile.setFileName(testCase.getId()+".tc");
			tcFile.setId(null);
			tcFile.setTestCaseId(testCase.getId());
			tcFile.setScript(convertFileToBytes(tcFile.getFileName()));
			tcFile.setComplete(status);
			
			List<WsAutomationScript> scriptsToUpload = new ArrayList<WsAutomationScript>();
			scriptsToUpload.add(etcFile);
			scriptsToUpload.add(tcFile);
			
			List<String> phoneList = getPhonesFromTc(tcFile.getFileName());
			tcFile.setPhoneNames(phoneList);
			etcFile.setPhoneNames(phoneList);
			
			WsErrorCodes errorCode = this.wsServicePort.uploadMultipleAutomationScripts(scriptsToUpload);
			if(errorCode.equals(WsErrorCodes.SUCCESS)){
				logger.debug("Successfully Uploaded the Scripts");
				logger.debug("Deleting the test case files inorder to cleanup");
				try{
					File tcfile = new File(tcFile.getFileName());
					logger.debug(tcfile.delete());
					logger.debug("Deleted the .tc file " +tcFile.getFileName());
					File etcfile = new File(etcFile.getFileName());
					logger.debug(etcfile.delete());
					logger.debug("Deleted the .etc file " +etcFile.getFileName());
				}catch(Exception e){
					logger.debug("Error occurred while deleting the .tc test case files" );
					logger.debug("Error - "+e);
				}
				return "success";
			}
			else{
				logger.debug("Error Occurred while uploading the scripts...."+errorCode.name());
				return errorCode.value();
			}
		}catch(Exception e){
			logger.debug("Error occurred while uploading the scripts "+e.getMessage());
			return "Error Occurred while uploading the scripts.. Try again later.";
		}
	}
	
	private List<String> getPhonesFromTc(String filename){
		Document doc;
		List<String> phoneNames = new ArrayList<String>();
		
		try {
			doc = DocumentBuilderFactory.newInstance().newDocumentBuilder()
			           .parse(new File(filename));
					
			NodeList resourcesNode = doc.getElementsByTagName("resources");
			
			if (resourcesNode.getLength() > 0) {
				Node rNode= resourcesNode.item(0);	
				if (rNode.getNodeType() == Node.ELEMENT_NODE) {
					Element rElement = (Element) rNode;			 
					String phoneString = rElement.getAttribute("phoneresources").trim();
					phoneNames = Arrays.asList(phoneString.substring(1, phoneString.length()-1).split(", "));
				}
			}else{
				logger.debug("resources element does not exist in file " + filename);
			}
		} catch (SAXException e) {
			logger.error("Unable to parse file " + filename + " Reason: " + e.getMessage());
		} catch (IOException e) {
			logger.error("Unable to parse file " + filename + " Reason: " + e.getMessage());
		} catch (ParserConfigurationException e) {
			logger.error("Unable to parse file " + filename + " Reason: " + e.getMessage());
		}			
	
		return phoneNames;
	}
	
	@RequestMapping(value = "/sipRedirectEditor", method = {RequestMethod.GET,RequestMethod.POST})
	public String sipRedirectEditor(Locale locale, Model model,@RequestParam(value="tcId") String tcID,
									@RequestParam(value="tpId") String testPlanId, RedirectAttributes redAttr) {
		try{
			WsTestCase wsTestCaseDetails = this.wsServicePort.getTestCaseDetails(tcID);
			WsTestPlan wsTestPlanDetails = this.wsServicePort.getTestPlanDetails(testPlanId);
			
			List<WsAutomationScript> sipTestCaseScripts = this.wsServicePort.listTestCaseAutomationScriptsByExtension(tcID,".stc");
			
				if(!sipTestCaseScripts.isEmpty()){
					logger.debug("SIP Script Exists for the testCase");
					redAttr.addFlashAttribute("stcScript", sipTestCaseScripts.get(0));
				}
				else{
					redAttr.addFlashAttribute("stcScript", null);
				}
			redAttr.addFlashAttribute("tcDetails", wsTestCaseDetails);
			redAttr.addFlashAttribute("tpDetails", wsTestPlanDetails);
			redAttr.addFlashAttribute("setFlag", "true");
		}catch(Exception e){
			logger.debug("Error occurred while getting the test case details for the editor .... "+e.getMessage());
			model.addAttribute("error", true);
			model.asMap().clear();
			return "redirect:/";
		}
		return "redirect:sipEditor";
	}
	
	@RequestMapping(value = "/uploadSipScripts", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody
	String uploadSipScripts(Locale locale, Model model,@RequestParam("tcId") String tcId,@RequestParam("markComplete") boolean status) {
		try{
			WsTestCase testCase = this.wsServicePort.getTestCaseDetails(tcId);
			
			logger.debug("Method to Upload SIP Scripts invoked");
			WsAutomationScript stcFile = new WsAutomationScript();
			stcFile.setFileName(testCase.getId()+".stc");
			stcFile.setId(null);
			stcFile.setTestCaseId(testCase.getId());
			stcFile.setScript(convertFileToBytes(stcFile.getFileName()));
			stcFile.setComplete(status);
			
			WsAutomationScript svFile = new WsAutomationScript();
			svFile.setFileName(testCase.getId()+".sv");
			svFile.setId(null);
			svFile.setTestCaseId(testCase.getId());
			svFile.setScript(convertFileToBytes(svFile.getFileName()));
			svFile.setComplete(status);
			
			List<WsAutomationScript> scriptsToUpload = new ArrayList<WsAutomationScript>();
			scriptsToUpload.add(stcFile);
			scriptsToUpload.add(svFile);
			
			WsErrorCodes errorCode = this.wsServicePort.uploadMultipleAutomationScripts(scriptsToUpload);
			if(errorCode.equals(WsErrorCodes.SUCCESS)){
				logger.debug("Successfully Uploaded the Sip Scripts");
				logger.debug("Deleting the sip test case files inorder to cleanup");
				try{
					File svfile = new File(svFile.getFileName());
					logger.debug(svfile.delete());
					logger.debug("Deleted the .sv file " +svFile.getFileName());
					File stcfile = new File(stcFile.getFileName());
					logger.debug(stcfile.delete());
					logger.debug("Deleted the .stc file " +stcFile.getFileName());
				}catch(Exception e){
					logger.debug("Error occurred while deleting the .sv test case files" );
					logger.debug("Error - "+e);
				}
				return "success";
			}
			else{
				logger.debug("Error Occurred while uploading the sip scripts...."+errorCode.name());
				return errorCode.value();
			}
		}catch(Exception e){
			logger.debug("Error occurred while uploading the sip scripts "+e.getMessage());
			return "Error Occurred while uploading the Sip scripts.. Try again later.";
		}
	}
	
	public byte[] convertFileToBytes(String fileName){
		
		FileInputStream fileInputStream=null;
        File file = new File(fileName);
        byte[] bFile = new byte[(int) file.length()];
        
        try {
            //convert file into array of bytes
		    fileInputStream = new FileInputStream(file);
		    fileInputStream.read(bFile);
		    fileInputStream.close();
	    	return bFile;
        }catch(Exception e){
        	e.printStackTrace();
        	return null;
        }
	}
}