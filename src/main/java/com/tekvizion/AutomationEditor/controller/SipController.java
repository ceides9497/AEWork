package com.tekvizion.AutomationEditor.controller;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.tekvizion.AutomationEditor.modal.Resources;
import com.tekvizion.AutomationEditor.service.ResourceService;
import com.tekvizion.AutomationEditor.service.SipEditorService;
import com.tekvizion.tekeye.ws.WsAutomationScript;
import com.tekvizion.tekeye.ws.WsTestCase;
import com.tekvizion.tekeye.ws.WsTestPlan;

@Controller
@Scope(value="session")
@SuppressWarnings({"unchecked","rawtypes"})
public class SipController implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ResourceService resourceService;
	
	@Autowired
	private SipEditorService sipEditorService;
	
	List<String> sip_entered_actions = new ArrayList<String>();
	
	WsTestCase testCase = new WsTestCase();
	
	WsTestPlan testPlan = new WsTestPlan();
	
	WsAutomationScript testCaseScript = new WsAutomationScript();
	
	boolean flag = false;
	
	String scenarioName = "";
	String procedure = "";
	String expectedResults = "";
	String testPlanName = "";

	static Logger logger = Logger.getLogger("automationHome");	
	
	@RequestMapping(value = "/sipEditor", method = {RequestMethod.GET,RequestMethod.POST})
	public String sippeditor(Locale locale, Model model,@ModelAttribute("setFlag") String setFlag,@ModelAttribute("tcDetails") WsTestCase tcDetails,
										@ModelAttribute("tpDetails") WsTestPlan tpDetails, @ModelAttribute("stcScript") WsAutomationScript stcScript){
		if(!setFlag.isEmpty()){
			scenarioName = tcDetails.getTitle();
			logger.debug("Opening SIP Editor from Test Cases with Scenario Name.. " +scenarioName);
			scenarioName = tcDetails.getTitle();
			procedure = tcDetails.getProceedure();
			testPlanName = tpDetails.getName();
			expectedResults = tcDetails.getExpectedResults();
			flag = true;
			testCase = tcDetails;
			testPlan = tpDetails;
			testCaseScript = stcScript;
			sip_entered_actions.clear();
			
			if(stcScript!=null){
				convertBytesToFile(stcScript.getScript());
			}
		}
		if(flag==false){
			model.asMap().clear();
			return "redirect:/";
		}
		
		List<Resources> r = this.resourceService.getAll();
		model.addAttribute("resources", r);

		JSONObject json = new JSONObject();
		json.put("entered_actions", sip_entered_actions);
		
		model.addAttribute("entAct", json);
		model.addAttribute("testCase",testCase);
		model.addAttribute("testPlan",testPlan);
		return "sipeditor";
	}
	
	@RequestMapping(value = "/addSipValidate", method = RequestMethod.POST)
	public @ResponseBody
	Map addSipValidate(Model model,@RequestParam("action") String action,@RequestParam("method") String method,
					@RequestParam("sdp") String sdp,@RequestParam("msgType") String msgtype,@RequestParam("status") String status,
					@RequestParam("fromPhone") String fromPhoneId,@RequestParam("toPhone") String toPhoneId,
					@RequestParam("sourcePhone") String sourcePhoneId,@RequestParam("destinationPhone") String destinationPhoneId,
					@RequestParam("sdpVal") String sdpvalue,@RequestParam("headersVal") String headersValue,
					@RequestParam("xmlHeadersVal") String xmlHeadersValue, @RequestParam("sipDesc") String sipDesc) {
		
		logger.debug("Adding Sip Validate Action Method Invoked");
		Resources fromPhone = this.resourceService.getResourceByID(fromPhoneId);
		Resources toPhone = this.resourceService.getResourceByID(toPhoneId);
		Resources sourcePhone = this.resourceService.getResourceByID(sourcePhoneId);
		Resources destinationPhone = this.resourceService.getResourceByID(destinationPhoneId);
		String validate = action.toUpperCase()+"> ";
		validate+= "PROTOCOL: Sip "+"METHOD: "+method;
			if(fromPhone!=null){
				validate+=" FROM: "+fromPhone.getName();
			}
			if(toPhone!=null){
				validate+=" TO: "+toPhone.getName();
			}
			if(sourcePhone!=null){
				validate+=" SOURCE: "+sourcePhone.getName();
			}
			if(destinationPhone!=null){
				validate+=" DESTINATION: "+destinationPhone.getName();
			}
		validate+=" MSGTYPE: "+msgtype;
			if(msgtype.equalsIgnoreCase("Response")){
				validate+=" STATUS: "+status;
			}
		validate+=" SDP: "+sdp;
			if(!sdpvalue.equalsIgnoreCase("")){
				validate+=" SDPVALUE: "+sdpvalue;
			}
			if(!headersValue.trim().equalsIgnoreCase("")){
				validate+=" HEADERS: "+headersValue;
			}
			if(!xmlHeadersValue.trim().equalsIgnoreCase("")){
				validate+=" XML_HEADER: "+xmlHeadersValue;
			}
		validate+=" DESC: "+sipDesc;
		logger.debug(validate);

		sip_entered_actions.add(validate);
		JSONObject json = new JSONObject();
		json.put("entered_actions", sip_entered_actions);
		return json;
	}
	
	@RequestMapping(value = "/deleteSipActions", method = RequestMethod.POST)
	public @ResponseBody
	Map deleteActions(Locale locale, Model model,@RequestParam("ids") List<Integer> ids) {
		
		Collections.sort(ids, Collections.reverseOrder());
		
		List<String> entered_actions_dup = new ArrayList<String>();
		entered_actions_dup = sip_entered_actions;
			for(int id : ids){
				logger.debug("Removed id "+id+"...."+entered_actions_dup.get(id));
				entered_actions_dup.remove(id);
			}
		sip_entered_actions = entered_actions_dup;
		JSONObject json = new JSONObject();
		json.put("entered_actions", sip_entered_actions);
		return json;
	}
	
	@RequestMapping(value = "/multiCheckSipActions", method = RequestMethod.POST)
	public @ResponseBody
	Map multiCheckSipActions(Locale locale, Model model,@RequestParam("ids") List<Integer> ids) {
		
		int firstInt = ids.get(0);
		List<String> entered_actions_dup = new ArrayList<String>();
		entered_actions_dup = sip_entered_actions;
		
			for(int i=0;i<ids.size();i++){
				if(entered_actions_dup.get(ids.get(i)).contains("MULTICHECK") || entered_actions_dup.get(ids.get(i)).contains("EITHERCHECK")){
					return null;
				}
			}
		
		String validate = "MULTICHECK"+">>> ";
		
			for(int i=0;i<ids.size();i++){
				validate += "[ "+entered_actions_dup.get(ids.get(i))+" ]";
				
				if(i+1!=ids.size()){
					validate += " AND "; 
				}
			}
			
		Collections.sort(ids, Collections.reverseOrder());
			for(int id : ids){
				logger.debug("Removed id "+id+"...."+entered_actions_dup.get(id));
				entered_actions_dup.remove(id);
			}
		
		entered_actions_dup.add(firstInt, validate);
		sip_entered_actions = entered_actions_dup;
		JSONObject json = new JSONObject();
		json.put("entered_actions", sip_entered_actions);
		return json;
	}
	
	@RequestMapping(value = "/eitherSipActions", method = RequestMethod.POST)
	public @ResponseBody
	Map eitherSipActions(Locale locale, Model model,@RequestParam("ids") List<Integer> ids) {
		
		int firstInt = ids.get(0);
		List<String> entered_actions_dup = new ArrayList<String>();
		entered_actions_dup = sip_entered_actions;
		
			for(int i=0;i<ids.size();i++){
				if(entered_actions_dup.get(ids.get(i)).contains("EITHERCHECK") || entered_actions_dup.get(ids.get(i)).contains("MULTICHECK")){
					return null;
				}
			}
		
		String validate = "EITHERCHECK"+">>> ";
		
			for(int i=0;i<ids.size();i++){
				validate += "[ "+entered_actions_dup.get(ids.get(i))+" ]";
				
				if(i+1!=ids.size()){
					validate += " OR "; 
				}
			}
			
		Collections.sort(ids, Collections.reverseOrder());
			for(int id : ids){
				logger.debug("Removed id "+id+"...."+entered_actions_dup.get(id));
				entered_actions_dup.remove(id);
			}
		
		entered_actions_dup.add(firstInt, validate);
		sip_entered_actions = entered_actions_dup;
		JSONObject json = new JSONObject();
		json.put("entered_actions", sip_entered_actions);
		return json;
	}
	
	@RequestMapping(value = "/sipActionUp", method = RequestMethod.POST)
	public @ResponseBody
	Map sipActionUp(Locale locale, Model model,@RequestParam("id") Integer id) {
		if(id!=0){
			Collections.swap(sip_entered_actions, id, id-1);
		}
		JSONObject json = new JSONObject();
		json.put("entered_actions", sip_entered_actions);
		return json;
	}
	
	@RequestMapping(value = "/sipActionDown", method = RequestMethod.POST)
	public @ResponseBody
	Map sipActionDown(Locale locale, Model model,@RequestParam("id") Integer id) {
		if(id!=sip_entered_actions.size()-1){
			Collections.swap(sip_entered_actions, id, id+1);
		}
		JSONObject json = new JSONObject();
		json.put("entered_actions", sip_entered_actions);
		return json;
	}
	
	@RequestMapping(value = "/addRtpValidate", method = RequestMethod.POST)
	public @ResponseBody
	Map addRtpValidate(Model model,@RequestParam("action") String action,@RequestParam("payloadType") String payloadType,
					@RequestParam("fromPhone") String fromPhoneId,@RequestParam("toPhone") String toPhoneId,
					@RequestParam("bidirection") boolean bidir, @RequestParam("rtpDesc") String rtpDesc,
					@RequestParam("eventId") String eventId, @RequestParam("endOfevent") String endOfevent) {

	logger.debug("Add RTP Action Method Invoked");
		Resources fromPhone = this.resourceService.getResourceByID(fromPhoneId);
		Resources toPhone = this.resourceService.getResourceByID(toPhoneId);
		String validate = action.toUpperCase()+"> ";
		validate+= "PROTOCOL: Rtp ";
			if(fromPhone!=null){
				validate+=" SOURCE: "+fromPhone.getName();
			}
			if(toPhone!=null){
				validate+=" DESTINATION: "+toPhone.getName();
			}
			if(!payloadType.trim().equalsIgnoreCase("")){
				validate+=" PAYLOADTYPE: "+payloadType;
			}
		validate+=" DESC: "+rtpDesc;
		
		if(eventId.trim()!=""){
			validate+= " EVENTID: "+eventId;
		}
		if(endOfevent.trim()!=""){
			validate+= " ENDOFEVENT: "+endOfevent;
		}
		
		logger.debug(validate);
		sip_entered_actions.add(validate);
			if(bidir){
				validate+=" BIDIRECTIONAL: "+bidir;
				String bidirectional_string = action.toUpperCase()+"> ";
				bidirectional_string+= "PROTOCOL: Rtp ";
				if(toPhone!=null){
					bidirectional_string+=" SOURCE: "+toPhone.getName();
				}
				if(fromPhone!=null){
					bidirectional_string+=" DESTINATION: "+fromPhone.getName();
				}
				if(!payloadType.trim().equalsIgnoreCase("")){
					bidirectional_string+=" PAYLOADTYPE: "+payloadType;
				}
				bidirectional_string+=" DESC: "+rtpDesc;
				
				if(eventId.trim()!=""){
					bidirectional_string+= " EVENTID: "+eventId;
				}
				if(endOfevent.trim()!=""){
					bidirectional_string+= " ENDOFEVENT: "+endOfevent;
				}
			logger.debug(bidirectional_string);
			sip_entered_actions.add(bidirectional_string);
			}
		JSONObject json = new JSONObject();
		json.put("entered_actions", sip_entered_actions);
		return json;
	}

	@RequestMapping(value = "/generateSipScript", method = RequestMethod.POST)
	public @ResponseBody
	String generateScript(Locale locale, Model model) throws IOException {
		logger.debug("Generating SIP .sv file for testcase id : "+testCase.getId());
		if(testCase.getId()==null){
			return "expired";
		}
		
		if(sip_entered_actions.isEmpty()){
			logger.debug("No Actions Entered to generate sip script file");
			return null;
		}
		String xmlString = sipEditorService.createSipValidationTestCase(testCase.getTitle(), sip_entered_actions, testCase.getId());
		
		logger.debug("Generating .stc file for testcase id : "+testCase.getId());
		PrintWriter writer = new PrintWriter(testCase.getId()+".stc", "UTF-8");
			for(String str: sip_entered_actions) {
				writer.write(str+"\n");
			}
		writer.close();
		return xmlString;
	}
	
	public void convertBytesToFile(byte[] byteFile){
		 String s = new String(byteFile);
		 String lines[] = s.split("\\r?\\n");
		 for(String str : lines){
			 sip_entered_actions.add(str);
		 }
	}
	
	@RequestMapping(value = "/uploadSipTemplate", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody
	Map uploadSipTemplate(@RequestParam("file") MultipartFile file) throws Exception {
		JSONObject json = new JSONObject();
		logger.debug("Uploading Sip File Template");
			if(file==null || file.isEmpty()){
				logger.debug("Empty File");
				json.put("emptyFile", true);
				return json;
			}
		ByteArrayInputStream stream = new   ByteArrayInputStream(file.getBytes());
		String fileContent = IOUtils.toString(stream, "UTF-8");
		List<String> listContent = Arrays.asList(fileContent.split("\\n"));
		logger.debug("Validating File Content.....");
		Boolean validEnteredAction = sipEditorService.validateEnteredSipActions(listContent);
			if(validEnteredAction==false){
				logger.debug("Invalid Content Format of the File");
				json.put("inValid", true);
				return json;
			}
		logger.debug("File Content is in Valid Format");
		sip_entered_actions.clear();
			for(String s : listContent){
				if(!s.trim().equalsIgnoreCase("")){
					sip_entered_actions.add(s);
				}
			}
		
		json.put("emptyFile", false);
		json.put("inValid", false);
		json.put("entered_actions", sip_entered_actions);
		return json;
	}
	
	@RequestMapping(value = "/downloadSipTemplate", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody
	String downloadSipTemplate(HttpServletResponse response) throws Exception {
		 if(sip_entered_actions.isEmpty()){
	    	logger.debug("Empty Sip Script ...");
	    	return "Empty";
	    }
		logger.debug("Generating .stc file for testcase id : "+testCase.getId()+"  testcaseNo "+testCase.getTestCaseId());
		PrintWriter writer = new PrintWriter(testCase.getTestCaseId()+".stc", "UTF-8");
			for(String str: sip_entered_actions) {
				writer.write(str+"\n");
			}
		writer.close();
	   
		// create full filename and get input stream
	    File sipTestFile = new File (""+testCase.getTestCaseId()+".stc");
	    if(!sipTestFile.exists()){
	    	//file does not exists no download
	    	logger.debug("Sip Test case file doesn't exist to download");
	    	return "NoExist";
	    }
	    else{
		    InputStream is = new FileInputStream(sipTestFile);
	
		    // set file as attached data and copy file data to response output stream
		    response.setHeader("Content-Disposition", "attachment; filename=\"" + testCase.getTestCaseId() + ".stc\"");
		    FileCopyUtils.copy(is, response.getOutputStream());
	
		    // close stream and return to view
		    response.flushBuffer();
		    
		    logger.debug("Sip File downloading...");
		    return "file";
	    }
	}

	@RequestMapping(value = "/deleteSavedSipTemplate", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody
	void deleteSavedSipTemplate(HttpServletResponse response) throws Exception {
		try{
			logger.debug("Deleting the saved sip template file");
			File sipTestFile = new File (""+testCase.getTestCaseId()+".stc");
			if(sipTestFile.exists()){
				logger.debug("Deleted - "+sipTestFile.delete());
			}
		}catch(Exception e){
			logger.debug("Exception occurred while deleting the saved template file");
			logger.debug("Error - "+e);
		}
	}
}