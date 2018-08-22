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
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

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
import org.xml.sax.SAXException;

import com.tekvizion.AutomationEditor.modal.Resources;
import com.tekvizion.AutomationEditor.modal.StateActionsResponse;
import com.tekvizion.AutomationEditor.service.ResourceService;
import com.tekvizion.AutomationEditor.service.StateService;
import com.tekvizion.tekeye.ws.WsAutomationScript;
import com.tekvizion.tekeye.ws.WsTestCase;
import com.tekvizion.tekeye.ws.WsTestPlan;

@Controller
@Scope(value="session")
@SuppressWarnings({"unchecked","rawtypes"})
public class HomeController implements Serializable {

	private static final long serialVersionUID = 1L;

	static Logger logger = Logger.getLogger("automationHome");

	@Autowired
	private StateService stateService;

	@Autowired
	private ResourceService resourceService;

	List<String> entered_actions = new ArrayList<String>();

	List<String> keyPress = new ArrayList<String>();

	Map<String, String> map = new HashMap<String, String>();

	Resources origin = new Resources();

	Resources terminator = new Resources();

	StateActionsResponse actionResponse = null;

	WsTestCase testCase = new WsTestCase();

	WsTestPlan testPlan = new WsTestPlan();

	WsAutomationScript testCaseScript = new WsAutomationScript();

	WsAutomationScript sipScript = new WsAutomationScript();

	boolean allActionEnable = false;

	boolean flag = false;

	boolean sipscriptflag = false;

	String scenarioName = "";
	String procedure = "";
	String expectedResults = "";
	String testPlanName = "";

	@RequestMapping(value = "/editor", method = {RequestMethod.GET,RequestMethod.POST})
	public String editor(Locale locale, Model model,@ModelAttribute("setFlag") String setFlag,@ModelAttribute("tcDetails") WsTestCase tcDetails,
										@ModelAttribute("tpDetails") WsTestPlan tpDetails, @ModelAttribute("tcScript") WsAutomationScript tcScript,
										@ModelAttribute("stcScript") WsAutomationScript stcScript){
		if(!setFlag.isEmpty()){
			scenarioName = tcDetails.getTitle();
			logger.debug("Opening Editor from Test Cases with Scenario Name.. " +scenarioName);
			scenarioName = tcDetails.getTitle();
			procedure = tcDetails.getProceedure();
			testPlanName = tpDetails.getName();
			expectedResults = tcDetails.getExpectedResults();
			flag = true;
			testCase = tcDetails;
			testPlan = tpDetails;
			testCaseScript = tcScript;
			entered_actions.clear();
			actionResponse = null;

			if(tcScript!=null){
				allActionEnable=true;
				convertBytesToFile(tcScript.getScript());
			}else{
				allActionEnable=false;
			}
			if(stcScript!=null){
				sipscriptflag = true;
				sipScript = stcScript;
			}
		}

		if(flag==false){
			model.asMap().clear();
			return "redirect:/";
		}
		model.addAttribute("allActionEnable",allActionEnable);

		model.addAttribute("testCase",testCase);
		model.addAttribute("testPlan",testPlan);

		logger.debug("Welcome to Editor Page!");
		map.put("Start","Calls");
		map.put("Answer","Answered Call");
		map.put("CallPark", "Park Call");
		map.put("CallRetrieve", "Retrieve Parked Call");
		map.put("hold","Pressed Hold Button");
		map.put("unhold","Pressed Hold Button");
		map.put("TransfStart"," Transfered Call To ");
		map.put("TransfComp"," Completed Transfer Call");
		map.put("ConfStart"," Conferences ");
		map.put("ConfComp"," Completed Conference");
		map.put("UnattendedTransferStart"," Unattended Transfered To ");
		map.put("End"," Ended the Call");
		map.put("Pause", " seconds");
		map.put("Validate", "");
		map.put("MultiKeyPress", "");
		map.put("Validate Audio", " For ");
		map.put("Login", "");
		map.put("Logout", "");
		map.put("ForceLogout", "");
		map.put("ChangePassword","");
		map.put("RemoveParty","Remove From Conference");
		map.put("MwiMacro","Messages");
		map.put("CheckMwi", "");
		map.put("CheckPresence", " Presence ");
		map.put("CallRecording", "");
		map.put("DND", " dnd ");
		map.put("Privacy", " privacy ");
		map.put("SIDE", " SIDE ");
		map.put("checkHistory", " checkHistory ");
		map.put("callBack", " callbacks ");
		
//		entered_actions.clear();
		keyPress.clear();

		List<Resources> r = this.resourceService.getAll();
		model.addAttribute("resources", r);

		JSONObject json = new JSONObject();
		json.put("entered_actions", entered_actions);

		model.addAttribute("entAct", json);
			if(actionResponse!=null){
				model.addAttribute("states", actionResponse.getNextState());
				model.addAttribute("actionList", actionResponse.getActionList());
			}else{
				model.addAttribute("states", "initialState");
				model.addAttribute("actions", "");
			}
		return "home";
	}

	
	@RequestMapping(value = "/actionCall", method = {RequestMethod.GET, RequestMethod.POST})
	public @ResponseBody
	Map actionCall(@RequestParam("currentState") String currentState, @RequestParam("action") String action,
				@RequestParam("originId") String originId,	@RequestParam("terminatorId") String terminatorId,
				@RequestParam("via") String via, @RequestParam("fromlineno") String fromlineno, @RequestParam("tolineno") String tolineno,
				@RequestParam("side") String side, @RequestParam("privacy") String privacy, @RequestParam("recording") String recording,
				@RequestParam("type") String type, @RequestParam("device") String device, @RequestParam("linenum") String linenum,
				@RequestParam("suppressCLI") String suppressCLI,@RequestParam("interline") String interline,
				@RequestParam("waittime") String waittime) {

		Resources from = this.resourceService.getResourceByID(originId);
		Resources to = this.resourceService.getResourceByID(terminatorId);

		logger.info("currentState = "+currentState+" action = "+action +" ");
		
		String value ="";
		if(map.containsKey(action)){
			value = from.getName() + " "+map.get(action);
			if(to!=null){
				value += " "+to.getName();
				if(via!=""){
					value += " VIA "+via;
				}
				value += " FROMLINE "+fromlineno;	
				value += " TOLINE "+tolineno;
			}
			
			if(to==null){
				value += " LINENUM "+linenum;
			}

			if(from.getName().contains("Turret")){
				if(to==null){
					//value += " LINENUM "+linenum;
				}else{
					if(side!=""){
					value += " SIDE "+side;
					value += " PRIVACY "+privacy;
					value += " RECORDING "+recording;
					value += " TYPE "+type;
					value += " DEVICE "+device;
					value += " SUPPRESSCLI "+suppressCLI;
						if(action.contains("ConfStart")){
							value += " INTERMEDIATELINE "+interline;
						}
					}
				}
			}
//			if(to!=null){
//				//if(to.getName().contains("Turret")) {
//					value += " FROMLINE "+fromlineno;	
//					value += " TOLINE "+tolineno;
//				//}
//			}
		}
		
		
		JSONObject json = new JSONObject();
		
		if(action.equals("MwiMacro")){
			json.put("updateState", false);
			value += " WAIT "+ waittime + " seconds";
		}else{
			try {
				actionResponse = stateService.getCurrentStateAndActions(currentState, action);
				logger.info("Next state :"+actionResponse.getNextState());
			} catch (XPathExpressionException e) {
				logger.error(e.getMessage());
			} catch (ParserConfigurationException e) {
				logger.error(e.getMessage());
			} catch (SAXException e) {
				logger.error(e.getMessage());
			} catch (IOException e) {
				logger.error(e.getMessage());
			}
			json.put("updateState", true);
			json.put("states", actionResponse.getNextState());
			json.put("actions", actionResponse.getActionList());
			json.put("allActionEnable", allActionEnable);
		}
		
		logger.debug(value);
		if(!value.isEmpty()){
			entered_actions.add(""+action.toUpperCase()+"> "+value);
		}
	
		json.put("entered_actions", entered_actions);

		return json;
	}
	
	@RequestMapping(value = "/adminAction", method = {RequestMethod.GET, RequestMethod.POST})
	public @ResponseBody
	Map adminAction(@RequestParam("action") String action,@RequestParam("originId") String originId, @RequestParam("user") String user,
			@RequestParam("newpassword") String newpassword, @RequestParam("custompassword") String custompassword) {

		logger.debug("Adding Admin Actions");
		Resources from = this.resourceService.getResourceByID(originId);

		JSONObject json = new JSONObject();
		String value ="";
		if(map.containsKey(action)){
			if(from!=null){
				value= from.getName()+" ";
			}
			if(user.trim()!=""){
				value += " USER: "+user.trim();
			}
			if(newpassword.trim()!=""){
				value += " NEWPASSWORD: "+ newpassword.trim();
			}
			
			if(custompassword.trim()!=""){
				value += " CUSTOMPASSWORD: "+ custompassword.trim();
			}
			
			if(action.contains("Logout")){
				if(action.contains("Force")){
					action = "LOGOUT";
					value += " FORCELOGOUT: true";
				}else{
					value += " FORCELOGOUT: false";
				}
			}
			logger.debug(value);
			entered_actions.add(""+action.toUpperCase()+"> "+value);
		}
		json.put("entered_actions", entered_actions);
		json.put("allActionEnable", allActionEnable);
		return json;
	}

	@RequestMapping(value = "/checkPresenceAction", method = {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public Map checkPresenceAction(@RequestParam("action") String action,@RequestParam("originId") String originId,
			@RequestParam("miscValue") String miscValue) {

		logger.debug("Adding CheckPresence Actions");
		Resources from = this.resourceService.getResourceByID(originId);

		JSONObject json = new JSONObject();
		String value ="";
		if(map.containsKey(action)){
			if(from!=null){
				value= from.getName()+" ";
			}
			
			if(miscValue.trim()!=""){
				value += map.get(action) +miscValue.trim();
			}
			
			logger.debug(value);
			entered_actions.add(""+action.toUpperCase()+"> "+value);
		}
		json.put("entered_actions", entered_actions);
		json.put("allActionEnable", allActionEnable);
		return json;
	}
	@RequestMapping(value = "/checkDNDAction", method = {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public Map checkDNDAction(@RequestParam("action") String action,@RequestParam("originId") String originId,
			@RequestParam("miscValue") String miscValue) {

		logger.debug("Adding DND Actions");
		Resources from = this.resourceService.getResourceByID(originId);

		JSONObject json = new JSONObject();
		String value ="";
		if(map.containsKey(action)){
			if(from!=null){
				value= from.getName()+" ";
			}
			
			if(miscValue.trim()!=""){
				value += map.get(action) +miscValue.trim();
			}
			
			logger.debug(value);
			entered_actions.add(""+action.toUpperCase()+"> "+value);
		}
		json.put("entered_actions", entered_actions);
		json.put("allActionEnable", allActionEnable);
		return json;
	}
	@RequestMapping(value = "/privacyAction", method = {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public Map checkPrivacyAction(@RequestParam("action") String action,@RequestParam("originId") String originId,
			@RequestParam("miscValue") String miscValue,@RequestParam("sideValue") String sideValue) {

		logger.debug("Adding Privacy Actions");
		Resources from = this.resourceService.getResourceByID(originId);

		JSONObject json = new JSONObject();
		String value ="";
		if(map.containsKey(action)){
			if(from!=null){
				value= from.getName()+" ";
			}
			
			if(miscValue.trim()!=""){
				value += map.get(action) +miscValue.trim();
			}
			if(sideValue.trim()!=""){
				value += map.get("SIDE")+sideValue.trim();
			}
			logger.debug(value);
			entered_actions.add(""+action.toUpperCase()+"> "+value);
		}
		json.put("entered_actions", entered_actions);
		json.put("allActionEnable", allActionEnable);
		return json;
	}
	
	@RequestMapping(value = "/checkHistoryAction", method = {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public Map checkHistoryAction(@RequestParam("action") String action,@RequestParam("originId") String originId,
			@RequestParam("miscFromPhone") String fromPhone,@RequestParam("miscToPhone") String toPhone,@RequestParam("miscEventType") String eventType,
			@RequestParam("miscToLine") String toLine,@RequestParam("miscHistType") String type) {

		logger.debug("Adding Check History Actions");
		
		JSONObject json = new JSONObject();
		String value ="";
		if(map.containsKey(action)){
			if(fromPhone!=null){
				value= fromPhone+ " "+map.get(action);
			}
			if(toPhone.trim()!=""){
				value += " TO " +toPhone.trim();
			}
			
			if(toLine.trim()!=""){
				value += " TOLINE " +toLine.trim();
			}
			if(type.trim()!=""){
				value += " TYPE " +type.trim();
			}
			
			if(eventType.trim()!=""){
				value += " EVENTTYPE " +eventType.trim();
			}
			
			logger.debug(value);
			entered_actions.add(""+action.toUpperCase()+"> "+value);
		}
		json.put("entered_actions", entered_actions);
		json.put("allActionEnable", allActionEnable);
		return json;
	}
	
	@RequestMapping(value = "/callBackAction", method = {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public Map callBackAction(@RequestParam("action") String action,@RequestParam("originId") String originId,
			@RequestParam("miscFromPhone") String fromPhone,@RequestParam("miscFromLine") String fromLine,
			@RequestParam("miscEventType") String eventType,@RequestParam("miscVia") String via,
			@RequestParam("miscSide") String side,@RequestParam("miscPrivacy") String privacy,
			@RequestParam("miscRecording") String recording,@RequestParam("miscDevice") String device) {

		logger.debug("Adding Check History Actions");
		
		JSONObject json = new JSONObject();
		String value ="";
		if(map.containsKey(action)){
			if(fromPhone!=null){
				value= fromPhone+ " "+map.get(action);
			}
			if(fromLine.trim()!=""){
				value += " FROMLINE " +fromLine.trim();
			}
			
			if(via.trim()!=""){
				value += " VIA " +via.trim();
			}
			if(side.trim()!=""){
				value += " SIDE " +side.trim();
			}
			
			if(privacy.trim()!=""){
				value += " PRIVACY " +privacy.trim();
			}
			if(recording.trim()!=""){
				value += " RECORDING " +recording.trim();
			}
			if(device.trim()!=""){
				value += " DEVICE " +device.trim();
			}
						
			if(eventType.trim()!=""){
				value += " EVENTTYPE " +eventType.trim();
			}
			
			logger.debug(value);
			entered_actions.add(""+action.toUpperCase()+"> "+value);
		}
		json.put("entered_actions", entered_actions);
		json.put("allActionEnable", allActionEnable);
		return json;
	}
	
	@RequestMapping(value = "/checkMwiAction", method = {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public Map checkMwiAction(@RequestParam("action") String action,@RequestParam("originId") String originId,
			@RequestParam("linenum") String linenum) {

		logger.debug("Adding CheckMWI Actions");
		Resources from = this.resourceService.getResourceByID(originId);

		JSONObject json = new JSONObject();
		String value ="";
		if(map.containsKey(action)){
			if(from!=null){
				value= from.getName()+" ";
			}
			
			if(linenum.trim()!=""){
				value += " LINENUM "+linenum.trim();
			}
			
			logger.debug(value);
			entered_actions.add(""+action.toUpperCase()+"> "+value);
		}
		json.put("entered_actions", entered_actions);
		json.put("allActionEnable", allActionEnable);
		return json;
	}	
	
	@RequestMapping(value = "/addCallRecording", method = {RequestMethod.GET, RequestMethod.POST})
	public @ResponseBody
	Map addCallRecording(@RequestParam("action") String action) {
		logger.debug("Adding CallRecording Actions");
		if(map.containsKey(action)){
			entered_actions.add(""+action.toUpperCase()+"> ");
		}
		JSONObject json = new JSONObject();
		json.put("entered_actions", entered_actions);
		json.put("allActionEnable", allActionEnable);
		return json;
	}	
	
	@RequestMapping(value = "/resetActions", method = RequestMethod.POST)
	public @ResponseBody
	Map resetActions(Locale locale, Model model) {
		entered_actions.clear();
		actionResponse = null;

		JSONObject json = new JSONObject();
		json.put("allActionEnable", allActionEnable);
		logger.debug("RESET ALL ACTIONS");
		return json;
	}

	@RequestMapping(value = "/deleteActions", method = RequestMethod.POST)
	public @ResponseBody
	Map deleteActions(Locale locale, Model model,@RequestParam("ids") List<Integer> ids) {
		Collections.sort(ids, Collections.reverseOrder());
		List<String> entered_actions_dup = new ArrayList<String>();
		entered_actions_dup = entered_actions;
			for(int id : ids){
				logger.debug("Removed id "+id+"...."+entered_actions_dup.get(id));
				entered_actions_dup.remove(id);
			}
		entered_actions = entered_actions_dup;
		JSONObject json = new JSONObject();
		json.put("entered_actions", entered_actions);
		return json;
	}

	@RequestMapping(value = "/actionUp", method = RequestMethod.POST)
	public @ResponseBody
	Map actionUp(Locale locale, Model model,@RequestParam("id") Integer id) {
		if(id!=0){
			Collections.swap(entered_actions, id, id-1);
		}
		JSONObject json = new JSONObject();
		json.put("entered_actions", entered_actions);
		return json;
	}

	@RequestMapping(value = "/actionDown", method = RequestMethod.POST)
	public @ResponseBody
	Map actionDown(Locale locale, Model model,@RequestParam("id") Integer id) {
		if(id!=entered_actions.size()-1){
			Collections.swap(entered_actions, id, id+1);
		}
		JSONObject json = new JSONObject();
		json.put("entered_actions", entered_actions);
		return json;
	}

	@RequestMapping(value = "/addComment", method = {RequestMethod.GET, RequestMethod.POST})
	public @ResponseBody
	Map addComment(@RequestParam("comment") String comment) {
		logger.info("Entered comment "+comment);
		JSONObject json = new JSONObject();
		entered_actions.add("//"+comment);
		json.put("entered_actions", entered_actions);
		return json;
	}

	@RequestMapping(value = "/addValidate", method = RequestMethod.POST)
	public @ResponseBody
	Map addValidate(Model model, @RequestParam("phoneId") String phoneId,@RequestParam("line") String line,@RequestParam("ls") String ls,
			@RequestParam("ct") String ct,@RequestParam("cs") String cs,@RequestParam("ct2") String ct2,
			@RequestParam("cs2") String cs2,@RequestParam("desc") String desc) {
		Resources phone = this.resourceService.getResourceByID(phoneId);
		String validate = "Phone:"+phone.getName()+" Line:"+line+" LS:"+ls+" CS:"+cs+" CT:"+ct+" CS2:"+cs2+" CT2:"+ct2+" Desc: "+desc;
		logger.debug(validate);

		String action = "Validate";
			if(map.containsKey(action)){
				entered_actions.add(""+action.toUpperCase()+"> "+validate);
			}
		JSONObject json = new JSONObject();
		json.put("entered_actions", entered_actions);
		return json;
	}

	@RequestMapping(value = "/addkeyPress", method = {RequestMethod.GET, RequestMethod.POST})
	public @ResponseBody
	Map addkeyPress(Model model,@RequestParam("phoneId") String phoneId) {
		if(keyPress.isEmpty()){
			logger.debug("Nothing to Add");
			return null;
		}
		Resources phone = this.resourceService.getResourceByID(phoneId);
		String action = "MultiKeyPress";
			if(map.containsKey(action)){
				String keyString = action.toUpperCase()+">";
					for(int i=0;i<keyPress.size();i++){
						keyString += "  "+keyPress.get(i);
					}
					keyString += "  "+phone.getName();
				entered_actions.add(keyString);
			}
		JSONObject json = new JSONObject();

		json.put("entered_actions", entered_actions);
		keyPress.clear();
		return json;
	}

	@RequestMapping(value = "/keyPressArray", method = RequestMethod.POST)
	public @ResponseBody
	Map keyPressArray(Model model,@RequestParam("keyPressed") String keyPressed) {
		logger.info("Adding data to keyPress array "+keyPressed);
		keyPress.add(keyPressed);
		JSONObject json = new JSONObject();
		json.put("keyPressArray", keyPress);
		return json;
	}

	@RequestMapping(value = "/deleteKeyPressArray", method = RequestMethod.POST)
	public @ResponseBody
	Map deleteKeyPressArray(Locale locale, Model model,@RequestParam("ids") List<Integer> ids) {
		Collections.sort(ids, Collections.reverseOrder());
		List<String> keyPress_dup = new ArrayList<String>();
		keyPress_dup = keyPress;
			for(int id : ids){
				logger.debug("Removed id from keyPressArray "+id+"...."+keyPress_dup.get(id));
				keyPress_dup.remove(id);
			}
		keyPress = keyPress_dup;
		JSONObject json = new JSONObject();
		json.put("keyPressArray", keyPress);
		return json;
	}

	@RequestMapping(value = "/keyPressUp", method = RequestMethod.POST)
	public @ResponseBody
	Map keyPressUp(Locale locale, Model model,@RequestParam("id") Integer id) {
		if(id!=0){
			Collections.swap(keyPress, id, id-1);
		}
		JSONObject json = new JSONObject();
		json.put("keyPressArray", keyPress);
		return json;
	}

	@RequestMapping(value = "/keyPressDown", method = RequestMethod.POST)
	public @ResponseBody
	Map keyPressDown(Locale locale, Model model,@RequestParam("id") Integer id) {
		if(id!=keyPress.size()-1){
			Collections.swap(keyPress, id, id+1);
		}
		JSONObject json = new JSONObject();
		json.put("keyPressArray", keyPress);
		return json;
	}

	@RequestMapping(value = "/addPause", method = {RequestMethod.GET, RequestMethod.POST})
	public @ResponseBody
	Map addPause(Model model, @RequestParam("pause") String pause) {
		String action = "Pause";
			if(map.containsKey(action)){
				entered_actions.add(""+action.toUpperCase()+"> "+pause+ map.get(action));
			}
		JSONObject json = new JSONObject();
		json.put("entered_actions", entered_actions);
		return json;
	}

	@RequestMapping(value = "/addValidateAudio", method = RequestMethod.POST)
	public @ResponseBody
	Map addValidateAudio(Model model, @RequestParam("validateAudioId") List<String> validateAudioId) {
		List<Resources> r = new ArrayList<Resources>();
			for(int i=0;i<validateAudioId.size();i++){
				Resources phone = this.resourceService.getResourceByID(validateAudioId.get(i));
				r.add(phone);
			}
		String action = "Validate Audio";
			if(map.containsKey(action)){
				String validate = "";
					for(int i=0;i<r.size();i++){
						validate += r.get(i).getName()+" ";
					}
				entered_actions.add(""+action.toUpperCase()+"> "+map.get(action)+" "+validate);
			}
		JSONObject json = new JSONObject();
		json.put("entered_actions", entered_actions);
		return json;
	}

	@RequestMapping(value = "/generateScript", method = RequestMethod.POST)
	public @ResponseBody
	String generateScript(Locale locale, Model model, @RequestParam boolean idlePhones) throws IOException {
		
		logger.debug("Generating .tc file for testcase id : "+testCase.getId() + "   idlePhones Indicator: " +idlePhones);
			if(entered_actions.isEmpty()){
				logger.debug("No Actions Entered to generate script file");
				return null;
			}
		String xmlString = stateService.createTestCase(testCase.getTitle(), entered_actions, testCase.getId(), idlePhones);
		logger.debug("Generating .etc file for testcase id : "+testCase.getId());
		PrintWriter writer = new PrintWriter(testCase.getId()+".etc", "UTF-8");
			for(String str: entered_actions) {
				writer.write(str+"\n");
			}
		writer.close();
		return xmlString;
	}

	@RequestMapping(value = "/procedure", method = RequestMethod.GET)
	public String procedure(Locale locale, Model model) {
		model.addAttribute("testCase", testCase);
		model.addAttribute("testPlan", testPlan);
		logger.debug("Viewing the Procedure for the testcase id "+testCase.getTestCaseId());
		return "procedure";
	}

	@RequestMapping(value = "/expectedResults", method = RequestMethod.GET)
	public String expectedResults(Locale locale, Model model) {
		model.addAttribute("testCase", testCase);
		model.addAttribute("testPlan", testPlan);
		logger.debug("Viewing the Expected results for the testcase id "+testCase.getTestCaseId());
		return "expectedResults";
	}

	public void convertBytesToFile(byte[] byteFile){
		 String s = new String(byteFile);
		 String lines[] = s.split("\\r?\\n");
			 for(String str : lines){
				 entered_actions.add(str);
			 }
	}

	@RequestMapping(value = "/saveTemplate", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody
	String saveTestFile(HttpServletResponse response) throws Exception {
		 if(entered_actions.isEmpty()){
	    	logger.debug("Empty Script ...");
	    	return "Empty";
	    }
		logger.debug("Generating .etc file for testcase id : "+testCase.getId()+"  testcaseNo "+testCase.getTestCaseId());
		PrintWriter writer = new PrintWriter(testCase.getTestCaseId()+".etc", "UTF-8");
			for(String str: entered_actions) {
				writer.write(str+"\n");
			}
		writer.close();

		// create full filename and get input stream
	    File testFile = new File (""+testCase.getTestCaseId()+".etc");
	    if(!testFile.exists()){
	    	//file does not exists no download
	    	logger.debug("Test case file doesn't exist to download");
	    	return "NoExist";
	    }
	    else{
		    InputStream is = new FileInputStream(testFile);

		    // set file as attached data and copy file data to response output stream
		    response.setHeader("Content-Disposition", "attachment; filename=\"" + testCase.getTestCaseId() + ".etc\"");
		    FileCopyUtils.copy(is, response.getOutputStream());

		    // close stream and return to view
		    response.flushBuffer();

		    logger.debug("File downloading...");
		    return "file";
	    }
	}

	@RequestMapping(value = "/deleteSavedTemplate", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody
	void deleteSavedTemplate(HttpServletResponse response) throws Exception {
		try{
			logger.debug("Deleting the saved template file");
			File testFile = new File (""+testCase.getTestCaseId()+".etc");
			if(testFile.exists()){
				logger.debug("Deleted - "+testFile.delete());
			}
		}catch(Exception e){
			logger.debug("Exception occurred while deleting the saved template file");
			logger.debug("Error - "+e);
		}
	}

	@RequestMapping(value = "/uploadTemplate", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody
	Map uploadTestFile(@RequestParam("file") MultipartFile file) throws Exception {
		JSONObject json = new JSONObject();
		logger.debug("Uploading File Template");
			if(file==null || file.isEmpty()){
				logger.debug("Empty File");
				json.put("emptyFile", true);
				return json;
			}
		ByteArrayInputStream stream = new   ByteArrayInputStream(file.getBytes());
		String fileContent = IOUtils.toString(stream, "UTF-8");
		List<String> listContent = Arrays.asList(fileContent.split("\\n"));
		logger.debug("Validating File Content.....");
		Boolean validEnteredAction = stateService.validateEnteredActions(listContent);
			if(validEnteredAction==false){
				logger.debug("Invalid Content Format of the File");
				json.put("inValid", true);
				return json;
			}
		logger.debug("File Content is in Valid Format");
		entered_actions.clear();
			for(String s : listContent){
				if(!s.trim().equalsIgnoreCase("")){
					entered_actions.add(s);
				}
			}
		allActionEnable=true;

		json.put("emptyFile", false);
		json.put("inValid", false);
		json.put("entered_actions", entered_actions);
		return json;
	}

	@RequestMapping(value = "/allActionEnable", method = {RequestMethod.GET, RequestMethod.POST})
	public @ResponseBody
	Map allActionEnable(Model model) {
		JSONObject json = new JSONObject();
		allActionEnable = true;
		json.put("allActionEnable", allActionEnable);
		return json;
	}
	
	@RequestMapping(value = "/editAction", method = RequestMethod.POST)
	public @ResponseBody
	Map editAction(Locale locale, Model model,@RequestParam("id") Integer id,@RequestParam("action") String action) {
		logger.debug("Editing Action ");
		entered_actions.set(id, action);
		JSONObject json = new JSONObject();
		json.put("entered_actions", entered_actions);
		return json;
	}
}