package com.tekvizion.AutomationEditor.util;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.tekvizion.AutomationEditor.modal.Action;
import com.tekvizion.AutomationEditor.modal.ActionType;

@Component
public class ParseJsonRequest {
	public static final String RIGHT_TAG = ">";
	public static final String DESCRIPTION = "Desc:";
	public static final String COLON = ":";
	public static final String NONE = "NONE";
	public static final String PHONE = "Phone";
	public static final String LINE = "LINE";
	public static final String LINE_STATE = "LS";
	public static final String CALL_STATE = "CS";
	public static final String CALL_STATE2 = "CS2";
	public static final String CALL_TYPE = "CT";
	public static final String CALL_TYPE2 = "CT2";
	public static final String INDEX_CALLS = "Calls";
	public static final String INDEX_VIA = "VIA";
	public static final String FROM_LINE = "FROMLINE";
	public static final String TO_LINE = "TOLINE";
	public static final String SIDE = "SIDE";
	public static final String PRIVACY = "PRIVACY";
	public static final String RECORDING = "RECORDING";
	public static final String TYPE = "TYPE";
	public static final String DEVICE = "DEVICE";
	public static final String LINENUM = "LINENUM";
	public static final String INDEX_ANSWERED = "Answered";
	public static final String INDEX_TRANSFERRED = "Transfered";
	public static final String INDEX_ENDED = "Ended";
	public static final String INDEX_COMPLETED = "Completed";
	public static final String INDEX_FOR = "For";
	public static final String INDEX_HOLD = "Hold";
	public static final String INDEX_PARK = "Park";
	public static final String INDEX_RETRIEVE = "Retrieve";
	public static final String INDEX_UNHOLD = "Unhold";
	public static final String INDEX_CONFERENCES = "Conferences";
	public static final String INDEX_SECONDS = "seconds";
	public static final String INDEX_UNATTENDED_TRANSFER = "Unattended Transfer";
	public static final String INDEX_LINE = "Line";
	public static final String INDEX_SOFTKEY = "SoftKey";
	public static final String INDEX_DIALPAD = "Dialpad";
	public static final String INDEX_REMOVE_PARTY = "Remove From Conference";
	public static final String REMOVE_PARTY_ACTION = "remove_party";
	public static final String INDEX_USER = "USER:";
	public static final String INDEX_NEWPASSWORD = "NEWPASSWORD:";
	public static final String INDEX_CUSTOMPASSWORD = "CUSTOMPASSWORD:";
	public static final String INDEX_FORCELOGOUT = "FORCELOGOUT:";
	public static final String INDEX_WAIT = "WAIT";
	public static final String INDEX_MESSAGES = "Messages";
	public static final String INDEX_PRESENCE = "Presence";
	public static final String HANDS_FREE = "handsfree";
	public static final String CALL_ACTION = "call";
	public static final String END_ACTION = "end";
	public static final String PAUSE_ACTION = "pause";
	public static final String CONFERENCE_START = "conf_start";
	public static final String CONFERENCE_COMPLETE = "conf_complete";
	public static final String TRANSFER_START = "xfer_start";
	public static final String UNATTENDED_TRANSFER_START = "unattended_xfer_start";
	public static final String UNATTENDED_TRANSFER_COMPLETE = "unattended_xfer_complete";
	public static final String TRANSFER_COMPLETE = "xfer_complete";
	public static final String CHECK_AUDIO = "check_audio";
	public static final String CHECK_MWI = "check_mwi";
	public static final String CHECK_PRESENCE = "check_presence";
	public static final String CALL_RECORDING = "call_recording";
	public static final String EMPTY_SPACE = " ";
	public static final String COMMA_SEPARATED = ",";
	public static final String STRING_LINE = "line";
	public static final String STRING_SOFT = "soft";
	public static final String STRING_KEY = "key";
	public static final String STRING_PHONE = "phone";
	public static final String EMPTY_STRING = "";
	public static final String POUND_SIGN = "#";
	public static final String POUND = "Pound";
	public static final String STAR_SIGN = "*";
	public static final String STAR = "Star";
	public static final String DELIMITER = "//";
	public static final String SUPPRESSCLI = "SUPPRESSCLI";
	public static final String INTERMEDIATELINE = "INTERMEDIATELINE";
	public static final String CHECK_DND = "dnd";
	public static final String INDEX_DND = "dnd";
	public static final String PRIVACY_ACTION = "privacy";
	public static final String INDEX_PRIVACY = "privacy";
	public static final String INDEX_CALLBACK = "callbacks";
	public static final String CALLBACK_ACTION = "callback";
	public static final String EVENT_TYPE = "EVENTTYPE";
	public static final String INDEX_CHECKHISTORY = "checkHistory";
	public static final String CHECKHISTORY_ACTION = "check_history";
	

	static Logger logger = Logger.getLogger("automationHome");
	/**
	 * method to parse the entered_actions string coming from the UI
	 * 
	 * The last word before RIGHT_TAG'>' should be equalsIgnorecase() with respective ActionType
	 * eg. Check Audio>for A,   Audio->ActionType.AUDIO
	 * @param List
	 * @return
	 */
	public List<Action> parseRequestString(List<String> requestString){
		List<Action> actionList = new ArrayList<Action>();
		Action action = null;
		
		for(String userAction : requestString){
			
			if(userAction.contains(RIGHT_TAG)){
				StringTokenizer st = new StringTokenizer(userAction, RIGHT_TAG);
				while(st.hasMoreTokens()) {
					String key = st.nextToken().trim();
					if(key.contains(" ")){
						key = key.substring(key.lastIndexOf(" "));
					}
					ActionType actionTypeEnum = findActionType(key);
					
					if(actionTypeEnum==null){
						logger.debug("Unable to find Action Type for " + key + ". Proceed with next action.");
						continue;
					}
					String val = st.nextToken();
					//List of actions for Unattended transfer
					if(key.equalsIgnoreCase(ActionType.UNATTENDEDTRANSFERSTART.toString())){
						callUnattendedTransferStartAction(val, actionList);
					}else if(key.equalsIgnoreCase(ActionType.MULTIKEYPRESS.toString())){
						//MULTI KEY PRESS
						StringTokenizer spaceTk = new StringTokenizer(val);
						String phone = EMPTY_STRING;
						while(spaceTk.hasMoreTokens()) {
							phone = spaceTk.nextToken();
							if(phone.indexOf(STRING_PHONE)>=0){
								phone = phone.substring(phone.indexOf(STRING_PHONE)).trim();
							}
						}
						callMultiKeyPressAction(val, actionList, phone);
					}else if(key.equalsIgnoreCase(ActionType.MWIMACRO.toString())){
						//MWI MACRO to be translated to multiple actions
						mwiMacroAction(val, actionList);
					}else{
						action = new Action();
						action.setName(key.toLowerCase());
						setActionForXmlGeneration(actionTypeEnum, val, action);

						//tokenizing the validate string
						StringTokenizer spaceTk = new StringTokenizer(val);
						while(spaceTk.hasMoreTokens()) {
							String key2 = spaceTk.nextToken();
							if(val.indexOf(DESCRIPTION)>=0){
								int start = val.indexOf(DESCRIPTION);
								action.setDesc(checkIsEmpty(val.substring(start+5).trim()));
							}
							StringTokenizer res = new StringTokenizer(key2, COLON);
							while(res.hasMoreTokens()) {
								String key3 = res.nextToken();
								while(res.hasMoreTokens()) {
									String val3 = res.nextToken();
									setValidateAction(key3, val3, action);
								}
							}
						}
						actionList.add(action);
					}
				}
			} else if(userAction.contains(DELIMITER)){
				 String[] stComment = userAction.split(DELIMITER);
				 action = new Action();
				 action.setComment(stComment[1]);
				 actionList.add(action);
			}
		}
		return actionList;
	}

	/**
	 * A utility method to convert action name string representation to Enum type
	 * @param type
	 * @return
	 */
	private ActionType findActionType(String type){

		try{
			return ActionType.valueOf(type.trim().toUpperCase());
		}catch(IllegalArgumentException e){
			logger.error("Type: " + type + " is not a valid Action Type");
			return null;
		}catch(NullPointerException e){
			logger.error("Type is null");
			return null;
		}
				
		
//		if(type.equalsIgnoreCase(ActionType.START.toString())){
//			return ActionType.START;
//		} else if(type.equalsIgnoreCase(ActionType.VALIDATE.toString())){
//			return ActionType.VALIDATE;
//		} else if(type.equalsIgnoreCase(ActionType.PAUSE.toString())){
//			return ActionType.PAUSE;
//		} else if(type.equalsIgnoreCase(ActionType.ANSWER.toString())){
//			return ActionType.ANSWER;
//		} else if(type.equalsIgnoreCase(ActionType.END.toString())){
//			return ActionType.END;
//		}else if(type.equalsIgnoreCase(ActionType.TRANSFSTART.toString())){
//			return ActionType.TRANSFSTART;
//		}else if(type.equalsIgnoreCase(ActionType.TRANSFCOMP.toString())){
//			return ActionType.TRANSFCOMP;
//		}else if(type.equalsIgnoreCase(ActionType.CONFSTART.toString())){
//			return ActionType.CONFSTART;
//		}else if(type.equalsIgnoreCase(ActionType.CONFCOMP.toString())){
//			return ActionType.CONFCOMP;
//		}else if(type.equalsIgnoreCase(ActionType.HOLD.toString())){
//			return ActionType.HOLD;
//		}else if(type.equalsIgnoreCase(ActionType.UNHOLD.toString())){
//			return ActionType.UNHOLD;
//		}else if(type.contains(ActionType.AUDIO.toString())){
//			return ActionType.AUDIO;
//		}else if(type.contains(ActionType.UNATTENDEDTRANSFERSTART.toString())){
//			return ActionType.UNATTENDEDTRANSFERSTART;
//		}else if(type.contains(ActionType.MULTIKEYPRESS.toString())){
//			return ActionType.MULTIKEYPRESS;
//		}else if(type.contains(ActionType.LOGIN.toString())){
//			return ActionType.LOGIN;
//		}else if(type.contains(ActionType.LOGOUT.toString())){
//			return ActionType.LOGOUT;
//		}else if(type.contains(ActionType.CHANGEPASSWORD.toString())){
//			return ActionType.CHANGEPASSWORD;
//		}else if(type.contains(ActionType.REMOVEPARTY.toString())){
//			return ActionType.REMOVEPARTY;
//		}else if(type.contains(ActionType.MWIMACRO.toString())){
//			return ActionType.MWIMACRO;
//		}else if(type.contains(ActionType.CHECKMWI.toString())){
//			return ActionType.CHECKMWI;
//		}else if(type.contains(ActionType.CHECKPRESENCE.toString())){
//			return ActionType.CHECKPRESENCE;
//		}
//		else {
//			return null;
//		}
	}

	/**
	 * method to set the action values based on the ActionTypeEnum
	 * @param ActionType
	 * @param value
	 * @param action
	 * @return
	 */
	private void setActionForXmlGeneration(ActionType actionTypeEnum, String value, Action action){

		switch(actionTypeEnum){
			case START:
				callStartAction(value, action);
				break;
			case ANSWER:
				callAnswerAction(value, action);
				break;
			case TRANSFSTART:
				callTransferStartAction(value, action);
				break;
			case TRANSFCOMP:
				callTransferEndAction(value, action);
				break;
			case CONFSTART:
				callConferenceStartAction(value, action);
				break;
			case CONFCOMP:
				callConferenceEndAction(value, action);
				break;
			case AUDIO:
				callValidateAudioAction(value, action);
				break;
			case HOLD:
				callHoldAction(value, action);
				break;
			case UNHOLD:
				callUnholdAction(value, action);
				break;
			case PAUSE:
				callPauseAction(value, action);
				break;
			case END:
				callEndAction(value, action);
				break;
			case LOGIN:
				callAdminAction(value, action);
				break;
			case LOGOUT:
				callAdminAction(value, action);
				break;
			case CHANGEPASSWORD:
				callAdminAction(value, action);
				break;
			case REMOVEPARTY:
				callRemovePartyAction(value, action);
				break;
			case CHECKMWI:
				checkMWIAction(value, action);
				break;
			case CHECKPRESENCE:
				checkPresenceAction(value, action);
				break;		
			case CALLPARK:
				callParkAction(value, action);
				break;	
			case CALLRETRIEVE:
				retrieveParkAction(value, action);
				break;
			case DND:
				checkDNDAction(value, action);
				break;	
			case PRIVACY:
				privacyAction(value, action);
				break;	
			case CALLRECORDING:
				callRecordingAction(value, action);
				break;
			case CHECKHISTORY:
				checkHistoryAction(value, action);
				break;
			case CALLBACK:
				callBackAction(value, action);
			default:
				break;
		}
	}

	/**
	 * method to set the validate action values
	 * @param key
	 * @param value
	 * @param action
	 * @return
	 */
	private void setValidateAction(String key, String value, Action action){
		if(key.equalsIgnoreCase(PHONE)) {
			action.setPhone(checkIsEmpty(value));
		} else if(key.equalsIgnoreCase(LINE)) {
			action.setLine(checkIsEmpty(value.toLowerCase()));
		} else if(key.equalsIgnoreCase(LINE_STATE)) {
			action.setLineState(checkIsEmpty(value.toLowerCase()));
		} else if(key.equalsIgnoreCase(CALL_STATE)) {
			action.setCallState(checkEmptyAndNone(value));
		} else if(key.equalsIgnoreCase(CALL_STATE2)) {
			action.setCallState2(checkEmptyAndNone(value));
		} else if(key.equalsIgnoreCase(CALL_TYPE)) {
			action.setCallType(checkEmptyAndNone(value));
		} else if(key.equalsIgnoreCase(CALL_TYPE2)) {
			action.setCallType2(checkEmptyAndNone(value));
		}
	}

	/**
	 * A utility method to check whether the String is empty
	 * @param str
	 * @return
	 */
	public String checkIsEmpty(String str){
		if(str == null || str.length() == 0) {
			return null;
		}
		return str.trim();
	}

	/**
	 * A utility method to check whether the String is empty or having the value as NONE
	 * @param str
	 * @return
	 */
	public String checkEmptyAndNone(String str){
		if(str == null || str.length() == 0) {
			return null;
		} else if(str.toLowerCase().equalsIgnoreCase(NONE)) {
			return null;
		} else {
			return str.trim().toLowerCase();
		}
	}

	private void callStartAction(String val, Action action){
		if(val.indexOf(INDEX_CALLS)>=0){
			int start = val.indexOf(INDEX_CALLS);
			int end = val.indexOf(INDEX_VIA);
			action.setName(CALL_ACTION);
			action.setFrom(val.substring(0, start-1).trim());
			action.setTo(val.substring(start+5, end).trim());
		}
		setCallVia(val, action);
	}

	private void callAnswerAction(String val, Action action){
		if(val.indexOf(INDEX_ANSWERED)>=0){
			int start = val.indexOf(INDEX_ANSWERED);
			action.setPhone(val.substring(0, start-1).trim());
			action.setValue(HANDS_FREE);
		}
		setLineNum(val, action);
	}

	private void callTransferStartAction(String val, Action action){
		if(val.indexOf(INDEX_TRANSFERRED)>=0){
			int start = val.indexOf(INDEX_TRANSFERRED);
			int end = val.indexOf(INDEX_VIA);
			action.setName(TRANSFER_START);
			action.setFrom(val.substring(0, start-1).trim());
			action.setTo(val.substring(start+19, end).trim());
		}
		setCallVia(val, action);
	}

	private void callTransferEndAction(String val, Action action){
		if(val.indexOf(INDEX_COMPLETED)>=0){
			action.setName(TRANSFER_COMPLETE);
			int start = val.indexOf(INDEX_COMPLETED);
			action.setPhone(val.substring(0, start-1).trim());
		}
		setLineNum(val, action);
	}

	private void callConferenceStartAction(String val, Action action){
		if(val.indexOf(INDEX_CONFERENCES)>=0){
			int start = val.indexOf(INDEX_CONFERENCES);
			int end = val.indexOf(INDEX_VIA);
			action.setName(CONFERENCE_START);
			action.setFrom(val.substring(0, start-1).trim());
			action.setTo(val.substring(start+11, end).trim());
		}
		setCallVia(val, action);
	}

	private void callConferenceEndAction(String val, Action action){
		if(val.indexOf(INDEX_COMPLETED)>=0){
			int start = val.indexOf(INDEX_COMPLETED);
			action.setName(CONFERENCE_COMPLETE);
			action.setPhone(val.substring(0, start-1).trim());
		}
		setLineNum(val, action);
	}

	private void callUnattendedTransferStartAction(String val, List<Action> actionList){
		if(val.indexOf(INDEX_UNATTENDED_TRANSFER)>=0){
			int start = val.indexOf(INDEX_UNATTENDED_TRANSFER);
			int end = val.indexOf(INDEX_VIA);
			Action action = new Action(UNATTENDED_TRANSFER_START, val.substring(0, start-1).trim(), val.substring(start+24, end).trim());
			//Action endAction = new Action(UNATTENDED_TRANSFER_COMPLETE, val.substring(0, start-1).trim());
			setCallVia(val, action);
			actionList.add(action);
			//actionList.add(endAction);
		}
	}

	private void setCallVia(String val, Action action){
		if(val.indexOf(INDEX_VIA)>=0){
			int start = val.indexOf(INDEX_VIA)+3;
			int end = 0;

			if(val.indexOf(FROM_LINE)>=0){
				end = val.indexOf(FROM_LINE);
				action.setVia(val.substring(start, end-1).trim());
				action.setFromline(val.substring(val.indexOf(FROM_LINE)+8, val.indexOf(TO_LINE)).trim());
			}
			if(val.indexOf(SIDE)>=0){
				end = val.indexOf(SIDE);
				action.setToline(val.substring(val.indexOf(TO_LINE)+6,end-1).trim());
				action.setSide(val.substring(val.indexOf(SIDE)+4, val.indexOf(PRIVACY)).trim());
				action.setPrivacy(val.substring(val.indexOf(PRIVACY)+7, val.indexOf(RECORDING)).trim());
				action.setRecording(val.substring(val.indexOf(RECORDING)+9, val.indexOf(TYPE)).trim());
				action.setType(val.substring(val.indexOf(TYPE)+4, val.indexOf(DEVICE)).trim());
				action.setDevice(val.substring(val.indexOf(DEVICE)+7, val.indexOf(SUPPRESSCLI)).trim());
				//if(val.indexOf(TO_LINE)>=0){
					//action.setSuppressCLI(val.substring(val.indexOf(SUPPRESSCLI)+11, val.indexOf(TO_LINE)).trim());
					//action.setToline(val.substring(val.indexOf(TO_LINE)+6).trim());
				//}
				//else{
				if(val.indexOf(INTERMEDIATELINE)>=0){
					action.setSuppressCLI(val.substring(val.indexOf(SUPPRESSCLI)+11,val.indexOf(INTERMEDIATELINE)).trim());
					action.setIntermediateline(val.substring(val.indexOf(INTERMEDIATELINE)+17).trim());
				}else{
					action.setSuppressCLI(val.substring(val.indexOf(SUPPRESSCLI)+11).trim());
				}
					
				//}
			}
			/*else if(val.indexOf(TO_LINE)>=0){
				end = val.indexOf(TO_LINE);
				action.setVia(val.substring(start, end-1).trim());
				action.setToline(val.substring(val.indexOf(TO_LINE)+6).trim());
			*/
			else{
				action.setToline(val.substring(val.indexOf(TO_LINE)+6).trim());
			}
		}
	}
	
	private void setCallBackVia(String val, Action action){
		if(val.indexOf(FROM_LINE)>=0){
				action.setFromline(val.substring(val.indexOf(FROM_LINE)+8, val.indexOf(INDEX_VIA)).trim());
				action.setVia(val.substring(val.indexOf(INDEX_VIA)+3, val.indexOf(SIDE)).trim());
				action.setSide(val.substring(val.indexOf(SIDE)+4, val.indexOf(PRIVACY)).trim());
				action.setPrivacy(val.substring(val.indexOf(PRIVACY)+7, val.indexOf(RECORDING)).trim());
				action.setRecording(val.substring(val.indexOf(RECORDING)+9, val.indexOf(DEVICE)).trim());
				action.setDevice(val.substring(val.indexOf(DEVICE)+6, val.indexOf(EVENT_TYPE)).trim());
				action.setEventType(val.substring(val.indexOf(EVENT_TYPE)+9).trim());
		}
	}

	private void setCheckHistoryToLine(String val, Action action){
		if(val.indexOf(TO_LINE)>=0){
			
			action.setToline(val.substring(val.indexOf(TO_LINE)+6, val.indexOf(TYPE)).trim());
			action.setType(val.substring(val.indexOf(TYPE)+4, val.indexOf(EVENT_TYPE)).trim());
			action.setEventType(val.substring(val.indexOf(EVENT_TYPE)+9).trim());
			
				
		}
	}
	
	private void setLineNum(String val, Action action){
		if(val.indexOf(LINENUM)>=0){
			int start = val.indexOf(LINENUM)+7;
			action.setLine(val.substring(start).trim());
		}
	}

	private void callValidateAudioAction(String val, Action action){
		if(val.indexOf(INDEX_FOR)>=0){
			action.setName(CHECK_AUDIO);
			int start = val.indexOf(INDEX_FOR);
			String phones = "";
			if(val.indexOf(DESCRIPTION)>0){
				phones = val.substring(start+4, val.indexOf(DESCRIPTION)).trim();
			}
			else{
				phones = val.substring(start+4).trim();
			}
			phones = phones.replaceAll(EMPTY_SPACE, COMMA_SEPARATED);
			action.setPhone(phones);
		}
	}
	
	private void callParkAction(String val, Action action){
		if(val.indexOf(INDEX_PARK)>=0){
			int start = val.indexOf(INDEX_PARK);
			action.setPhone(val.substring(0, start-1).trim());
		}
		setLineNum(val, action);
	}
	
	private void retrieveParkAction(String val, Action action){
		if(val.indexOf(INDEX_RETRIEVE)>=0){
			int start = val.indexOf(INDEX_RETRIEVE);
			action.setPhone(val.substring(0, start-1).trim());
		}
		setLineNum(val, action);
	}
	
	private void callRecordingAction(String val, Action action){
		action.setName(CALL_RECORDING);
	}
	
	private void callHoldAction(String val, Action action){
		if(val.indexOf(INDEX_HOLD)>=0){
			int start = val.indexOf(INDEX_HOLD);
			action.setPhone(val.substring(0, start-9).trim());
		}
		setLineNum(val, action);
	}

	private void callUnholdAction(String val, Action action){
		if(val.indexOf(INDEX_HOLD)>=0){
			int start = val.indexOf(INDEX_HOLD);
			action.setPhone(val.substring(0, start-9).trim());
		}
		
		setLineNum(val, action);
	}

	private void callPauseAction(String val, Action action){
		action.setName(PAUSE_ACTION);
		if(val.indexOf(INDEX_SECONDS)>=0){
			int start = val.indexOf(INDEX_SECONDS);
			action.setValue(val.substring(0, start-1).trim());
		}
	}

	private void callEndAction(String val, Action action){
		action.setName(END_ACTION);
		if(val.indexOf(INDEX_ENDED)>=0){
			int start = val.indexOf(INDEX_ENDED);
			action.setPhone(val.substring(0, start-1).trim());
			action.setValue(HANDS_FREE);
		}
		setLineNum(val, action);
	}

	private void callMultiKeyPressAction(String val, List<Action> actionList, String phone){
		StringTokenizer spaceTk = new StringTokenizer(val);
		while(spaceTk.hasMoreTokens()) {
			String value = spaceTk.nextToken();
			if(value.indexOf(INDEX_LINE)>=0){
				Action action = new Action();
				int start = value.indexOf(INDEX_LINE);
				action = setMultiKeyPressAction(STRING_KEY, STRING_LINE+value.substring(start+4).trim(), phone, action);
				actionList.add(action);
			}
			if(value.indexOf(INDEX_SOFTKEY)>=0){
				Action action = new Action();
				int start = value.indexOf(INDEX_SOFTKEY);
				action = setMultiKeyPressAction(STRING_KEY, STRING_SOFT+value.substring(start+7).trim(), phone, action);
				actionList.add(action);
			}
			if(value.equalsIgnoreCase(HANDS_FREE)){
				Action action = new Action();
				action = setMultiKeyPressAction(STRING_KEY, HANDS_FREE.trim(), phone, action);
				actionList.add(action);
			}
			if(value.indexOf(INDEX_DIALPAD)>=0){
				Action action = new Action();
				int start = value.indexOf(INDEX_DIALPAD);
				String actionValue = value.substring(start+7).trim();
				if(actionValue.equalsIgnoreCase(POUND)){
					action = setMultiKeyPressAction(STRING_KEY, POUND_SIGN, phone, action);
				}else if(actionValue.equalsIgnoreCase(STAR)){
					action = setMultiKeyPressAction(STRING_KEY, STAR_SIGN, phone, action);
				}else {
					action = setMultiKeyPressAction(STRING_KEY, value.substring(start+7).trim(), phone, action);
				}
				actionList.add(action);
			}
		}
	}

	private Action setMultiKeyPressAction(String name, String value, String phone, Action action){
		action.setName(name);
		action.setValue(value);
		action.setPhone(phone);
		return action;
	}
	
	private void callRemovePartyAction(String val, Action action){
		if(val.indexOf(INDEX_REMOVE_PARTY)>=0){
			action.setName(REMOVE_PARTY_ACTION);
			int start = val.indexOf(INDEX_REMOVE_PARTY);
			action.setFrom(val.substring(0, start-1).trim());
			
			int end = val.indexOf(FROM_LINE);
			action.setTo(val.substring(start+22, end-1).trim());
			
			start = val.indexOf(TO_LINE);
			action.setFromline(val.substring(end+8, start-1).trim());
			action.setToline(val.substring(start+6).trim());
		}
	}
	
	private void callAdminAction(String val, Action action){
		if(action.getName().contains("password")){
	
			if(val.indexOf(INDEX_NEWPASSWORD)>=0){
				int start = val.indexOf(INDEX_NEWPASSWORD)+13;
				action.setNewpassword(val.substring(start, val.length()).trim());
				val = val.substring(0, val.indexOf(INDEX_NEWPASSWORD)-1);
			}
			
			if(val.indexOf(INDEX_USER)>=0){
				action.setPhone(val.substring(0, val.indexOf(INDEX_USER)).trim());
				action.setUser(val.substring(val.indexOf(INDEX_USER)+5, val.length()).trim());
			}else{
				action.setPhone(val.substring(0, val.length()).trim());
			}
			
		}
		if(action.getName().contains("logout")){
			if(val.indexOf(INDEX_FORCELOGOUT)>=0){
				action.setPhone(val.substring(0,val.indexOf(INDEX_FORCELOGOUT)).trim());
				int start = val.indexOf(INDEX_FORCELOGOUT)+12;
				action.setForcelogout(val.substring(start, val.length()).trim());
			}	
		}
		if(action.getName().contains("login")){
			
			if(val.indexOf(INDEX_CUSTOMPASSWORD)>=0){
				int start = val.indexOf(INDEX_CUSTOMPASSWORD)+15;
				action.setCustompassword(val.substring(start, val.length()).trim());
				val = val.substring(0, val.indexOf(INDEX_CUSTOMPASSWORD)-1);
			}
			
			if(val.indexOf(INDEX_USER)>=0){
				action.setPhone(val.substring(0, val.indexOf(INDEX_USER)).trim());
				action.setUser(val.substring(val.indexOf(INDEX_USER)+5, val.length()).trim());
			}else{
				action.setPhone(val.substring(0, val.length()).trim());
			}
		}
	}
	
	private void checkMWIAction(String val, Action action){
		
		action.setName(CHECK_MWI);
		if(val.indexOf(LINENUM)>=0){
			action.setPhone(val.substring(0, val.indexOf(LINENUM)-1).trim());
		}
		
		setLineNum(val, action);		
	}
	
	private void checkPresenceAction(String val, Action action){
		
		action.setName(CHECK_PRESENCE);
		if(val.indexOf(INDEX_PRESENCE)>=0){
			action.setPhone(val.substring(0, val.indexOf(INDEX_PRESENCE)-1).trim());
			action.setValue(val.substring(val.indexOf(INDEX_PRESENCE)+8).trim());
		}
	
	}
	private void checkDNDAction(String val, Action action){
		
		action.setName(CHECK_DND);
		if(val.indexOf(INDEX_DND)>=0){
			action.setPhone(val.substring(0, val.indexOf(INDEX_DND)-1).trim());
			action.setValue(val.substring(val.indexOf(INDEX_DND)+3).trim());
		}
	
	}
	private void privacyAction(String val, Action action){
		
		action.setName(PRIVACY_ACTION);
		if(val.indexOf(INDEX_PRIVACY)>=0){
			action.setPhone(val.substring(0, val.indexOf(INDEX_PRIVACY)-1).trim());
			action.setValue(val.substring(val.indexOf(INDEX_PRIVACY)+7,val.indexOf(INDEX_PRIVACY)+13).trim());
			
		}
		if(val.indexOf("SIDE")>=0){
			action.setSide(val.substring(val.indexOf("SIDE")+4).trim());
		}	
	
	}
	
	private void mwiMacroAction(String val, List<Action> actionList){
		
		int indexOfWait = val.indexOf(INDEX_WAIT);
		String callStartVal =val.substring(0,indexOfWait).trim().replace(INDEX_MESSAGES, INDEX_CALLS);
		
		Action callAction = new Action();
		callAction.setName(CALL_ACTION);
		this.callStartAction(callStartVal, callAction);
		
		Action pauseAction = new Action();
		callPauseAction(val.substring(indexOfWait + INDEX_WAIT.length()).trim(), pauseAction);

		Action endAction = new Action();
		endAction.setName(END_ACTION);
		endAction.setPhone(callAction.getFrom());
		endAction.setLine(callAction.getFromline());
		endAction.setValue(HANDS_FREE);
		
		Action checkmwiAction = new Action();
		checkmwiAction.setName(CHECK_MWI);
		checkmwiAction.setPhone(callAction.getTo());
		checkmwiAction.setLine(callAction.getToline());
		
		Action pauseActionEnd = new Action();
		pauseActionEnd.setName(PAUSE_ACTION);
		pauseActionEnd.setValue("5");
		
		actionList.add(checkmwiAction);
		actionList.add(callAction);
		actionList.add(pauseAction);
		actionList.add(endAction);
		actionList.add(pauseActionEnd);
		actionList.add(checkmwiAction);
		
	}

	public Boolean validateEnteredActions(List<String> requestString){
		Boolean result = Boolean.FALSE;
		for(String userAction : requestString){
			if(userAction.contains(RIGHT_TAG)){
				String[] stringArr = userAction.split(RIGHT_TAG);
				String key = stringArr[0].trim();
				result = validateAction(key);
				if(result == Boolean.FALSE){
					logger.debug("Key validation failed for  - " +key);
					break;
				}
			} else if(userAction.startsWith(DELIMITER)){
				result = Boolean.TRUE;
			}  else if(userAction.trim().equalsIgnoreCase("")){
				result = Boolean.TRUE;
			}  else {
				logger.debug("String doesn't start with a delimiter or contains right tag - "+userAction);
				result = Boolean.FALSE;
				break;
			}
		}
		return result;
	}

	private Boolean validateAction(String type){
		if(type.equalsIgnoreCase(ActionType.START.toString()) || type.equalsIgnoreCase(ActionType.VALIDATE.toString())
				||type.equalsIgnoreCase(ActionType.PAUSE.toString())||type.equalsIgnoreCase(ActionType.ANSWER.toString())
				||type.equalsIgnoreCase(ActionType.CALLPARK.toString())||type.equalsIgnoreCase(ActionType.CALLRETRIEVE.toString())
				||type.equalsIgnoreCase(ActionType.END.toString())||type.equalsIgnoreCase(ActionType.TRANSFSTART.toString())
				||type.equalsIgnoreCase(ActionType.TRANSFCOMP.toString())||type.equalsIgnoreCase(ActionType.CONFSTART.toString())
				||type.equalsIgnoreCase(ActionType.CONFCOMP.toString())||type.equalsIgnoreCase(ActionType.HOLD.toString())
				||type.equalsIgnoreCase(ActionType.UNHOLD.toString())||type.contains(ActionType.AUDIO.toString())
				||type.contains(ActionType.UNATTENDEDTRANSFERSTART.toString())||type.contains(ActionType.MULTIKEYPRESS.toString())
				||type.contains(ActionType.LOGIN.toString())||type.contains(ActionType.LOGOUT.toString())
				||type.contains(ActionType.CHANGEPASSWORD.toString())||type.contains(ActionType.REMOVEPARTY.toString())
				||type.equalsIgnoreCase(ActionType.MWIMACRO.toString())||type.equalsIgnoreCase(ActionType.CHECKMWI.toString())
				||type.equalsIgnoreCase(ActionType.CHECKPRESENCE.toString())||type.equalsIgnoreCase(ActionType.CALLRECORDING.toString())
				||type.equalsIgnoreCase(ActionType.DND.toString())||type.equalsIgnoreCase(ActionType.PRIVACY.toString())
				||type.equalsIgnoreCase(ActionType.CALLBACK.toString()) ||type.equalsIgnoreCase(ActionType.CHECKHISTORY.toString())
				){
			return Boolean.TRUE;
		}
		logger.debug("Not a valid action in the file - " +type);
		return Boolean.FALSE;
	}
	
	private void callBackAction(String val, Action action){
		if(val.indexOf(INDEX_CALLBACK)>=0){
			int start = val.indexOf(INDEX_CALLBACK);
			int end = val.indexOf(INDEX_VIA);
			action.setName(CALLBACK_ACTION);
			action.setFrom(val.substring(0, start-1).trim());
			
		}
		setCallBackVia(val, action);
	}
	private void checkHistoryAction(String val, Action action){
		if(val.indexOf(INDEX_CHECKHISTORY)>=0){
			int start = val.indexOf(INDEX_CHECKHISTORY);
			int end = val.indexOf(TO_LINE);
			action.setName(CHECKHISTORY_ACTION);
			action.setFrom(val.substring(0, start-1).trim());
			action.setTo(val.substring(start+16, end).trim());
		}
		setCheckHistoryToLine(val, action);
	}
	
	
}
