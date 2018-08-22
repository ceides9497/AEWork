package com.tekvizion.AutomationEditor.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.tekvizion.AutomationEditor.modal.SipActionType;
import com.tekvizion.AutomationEditor.modal.SipActions;

@Component
public class ParseSipData {
	public static final String RIGHT_TAG = ">";
	public static final String MULTICHECK_TAG = ">>>";
	public static final String PROTOCOL = "PROTOCOL:";
	public static final String COLON = ":";
	public static final String NONE = "NONE";
	public static final String FROM = "FROM:";
	public static final String TO = "TO:";
	public static final String SOURCE = "SOURCE:";
	public static final String DESTINATION = "DESTINATION:";
	public static final String METHOD = "METHOD:";
	public static final String MESSAGE_TYPE = "MSGTYPE:";
	public static final String STATUS = "STATUS:";
	public static final String SDPEXISTS = "SDP:";
	public static final String SDP_VALUE = "SDPVALUE:";
	public static final String HEADER_VALUE = "HEADERS:";
	public static final String XML_HEADER = "XML_HEADER:";
	public static final String PAYLOADTYPE = "PAYLOADTYPE:";
	public static final String DESCRIPTION = "DESC:";
	public static final String EVENTID = "EVENTID:";
	public static final String ENDOFEVENT = "ENDOFEVENT:";

	static Logger logger = Logger.getLogger("automationHome");
	/**
	 * method to parse the entered_actions string coming from the UI
	 * @param List
	 * @return
	 */
	public List<SipActions> parseRequestString(List<String> requestString){
		List<SipActions> actionList = new ArrayList<SipActions>();
		SipActions action = null;
		for(String userAction : requestString){
			if(userAction.contains(MULTICHECK_TAG)){
				if(userAction.split(MULTICHECK_TAG, 2).length>1){
					String key = userAction.split(MULTICHECK_TAG)[0];
					SipActionType actionTypeEnum = findSipActionType(key);
					if(actionTypeEnum==null){
						return null;
					}
					String val = userAction.split(MULTICHECK_TAG, 2)[1].trim();
					String[] listOfChecks = val.trim().split("[\\[\\]]");
					
					List<SipActions> subActionsList = new ArrayList<SipActions>();
					SipActions subaction = null;
					
					for(String eachCheck:listOfChecks){
						if(eachCheck.contains(RIGHT_TAG)){
							if(eachCheck.trim().split(RIGHT_TAG, 2).length>1){
								String key1 = eachCheck.split(RIGHT_TAG, 2)[0].trim();
								SipActionType subactionTypeEnum = findSipActionType(key1.trim());
								if(subactionTypeEnum==null){
									return null;
								}
								String val1 = eachCheck.split(RIGHT_TAG, 2)[1];

								subaction = new SipActions();
								subaction.setName(key1.toLowerCase().trim());
								setActionForXmlGeneration(subactionTypeEnum, val1.trim(), subaction);

								subActionsList.add(subaction);
							}
						}
					}
					action = new SipActions();
					action.setName(key.toLowerCase().trim());
					action.setMulticheckactions(subActionsList);
					
					actionList.add(action);
				}
			}else if(userAction.contains(RIGHT_TAG)){
				if(userAction.split(RIGHT_TAG, 2).length>1){
					String key = userAction.split(RIGHT_TAG, 2)[0];
					SipActionType actionTypeEnum = findSipActionType(key);
					if(actionTypeEnum==null){
						return null;
					}
					String val = userAction.split(RIGHT_TAG, 2)[1];

					action = new SipActions();
					action.setName(key.toLowerCase());
					setActionForXmlGeneration(actionTypeEnum, val, action);

					actionList.add(action);
				}
			} 
		}
		return actionList;
	}

	/**
	 * A utility method to convert action name string representation to Enum type
	 * @param type
	 * @return
	 */
	private SipActionType findSipActionType(String type){
		if(type.equalsIgnoreCase(SipActionType.CHECK.toString())){
			return SipActionType.CHECK;
		}else if(type.equalsIgnoreCase(SipActionType.MULTICHECK.toString())){
			return SipActionType.MULTICHECK;
		}else if(type.equalsIgnoreCase(SipActionType.EITHERCHECK.toString())){
			return SipActionType.EITHERCHECK;
		}else if(type.equalsIgnoreCase(SipActionType.ABSENCE.toString())){
			return SipActionType.ABSENCE;
		}
		else {
			return null;
		}
	}

	/**
	 * method to set the action values based on the SipActionTypeEnum
	 * @param SipActionType
	 * @param value
	 * @param action
	 * @return
	 */
	private void setActionForXmlGeneration(SipActionType actionTypeEnum, String value, SipActions action){
		switch(actionTypeEnum){
			case CHECK:
				checkAction(value, action);
				break;
			case MULTICHECK:
				checkAction(value, action);
				break;
			case EITHERCHECK:
				checkAction(value, action);
				break;
			case ABSENCE:
				checkAction(value, action);
				break;
			default:
				break;
		}
	}
	
	/**
	 * method to set the parameter values 
	 * @param action
	 * @param val
	 * @return
	 */
	private void checkAction(String val, SipActions action){
		
		//SET PROTOCOL
		if(val.indexOf(PROTOCOL)>=0){
			int start = val.indexOf(PROTOCOL)+9;
			int end = 0;
			
			if(val.indexOf(METHOD)>=0){
				end = val.indexOf(METHOD);
				action.setProtocol(val.substring(start, end-1).trim());
			}else if(val.indexOf(FROM)>=0){
				end = val.indexOf(FROM);
				action.setProtocol(val.substring(start, end-1).trim());
			}else if(val.indexOf(SOURCE)>=0){
				end = val.indexOf(SOURCE);
				action.setProtocol(val.substring(start, end-1).trim());
			}else if(val.indexOf(TO)>=0){
				end = val.indexOf(TO);
				action.setProtocol(val.substring(start, end-1).trim());
			}else if(val.indexOf(DESTINATION)>=0){
				end = val.indexOf(DESTINATION);
				action.setProtocol(val.substring(start, end-1).trim());
			}
		}
		
		//SET METHOD
		if(val.indexOf(METHOD)>=0){
			int start = val.indexOf(METHOD)+7;
			int end = 0;
			
			if(val.indexOf(FROM)>=0){
				end = val.indexOf(FROM);
				action.setMethod(val.substring(start, end-1).trim());
			}else if(val.indexOf(TO)>=0){
				end = val.indexOf(TO);
				action.setMethod(val.substring(start, end-1).trim());
			}
		}
		
		//SET FROM
		if(val.indexOf(FROM)>=0){
			int start = val.indexOf(FROM)+5;
			int end = 0;
			
			if(val.indexOf(TO)>=0){
				end = val.indexOf(TO);
				action.setFrom(val.substring(start, end-1).trim());
			}else if(val.indexOf(SOURCE)>=0){
				end = val.indexOf(SOURCE);
				action.setFrom(val.substring(start, end-1).trim());
			}else if(val.indexOf(DESTINATION)>=0){
				end = val.indexOf(DESTINATION);
				action.setFrom(val.substring(start, end-1).trim());
			}else if(val.indexOf(MESSAGE_TYPE)>=0){
				end = val.indexOf(MESSAGE_TYPE);
				action.setFrom(val.substring(start, end-1).trim());
			}
		}
		
		//SET SOURCE
		if(val.indexOf(SOURCE)>=0){
			int start = val.indexOf(SOURCE)+7;
			int end = 0;
			
			if(val.indexOf(DESTINATION)>=0){
				end = val.indexOf(DESTINATION);
				action.setSource(val.substring(start, end-1).trim());
			}else if(val.indexOf(MESSAGE_TYPE)>=0){
				end = val.indexOf(MESSAGE_TYPE);
				action.setSource(val.substring(start, end-1).trim());
			}else if(val.indexOf(PAYLOADTYPE)>=0){
				end = val.indexOf(PAYLOADTYPE);
				action.setSource(val.substring(start, end-1).trim());
			}else if(val.indexOf(DESCRIPTION)>=0){
				end = val.indexOf(DESCRIPTION);
				action.setSource(val.substring(start, end-1).trim());
			}
		}
		
		//SET TO
		if(val.indexOf(TO)>=0){
			int start = val.indexOf(TO)+3;
			int end = 0;
			
			if(val.indexOf(SOURCE)>=0){
				end = val.indexOf(SOURCE);
				action.setTo(val.substring(start, end-1).trim());
			}else if(val.indexOf(DESTINATION)>=0){
				end = val.indexOf(DESTINATION);
				action.setTo(val.substring(start, end-1).trim());
			}else if(val.indexOf(MESSAGE_TYPE)>=0){
				end = val.indexOf(MESSAGE_TYPE);
				action.setTo(val.substring(start, end-1).trim());
			}else if(val.indexOf(PAYLOADTYPE)>=0){
				end = val.indexOf(PAYLOADTYPE);
				action.setTo(val.substring(start, end-1).trim());
			}else if(val.indexOf(DESCRIPTION)>=0){
				end = val.indexOf(DESCRIPTION);
				action.setTo(val.substring(start, end-1).trim());
			}
		}
		
		//SET DESTINATION
		if(val.indexOf(DESTINATION)>=0){
			int start = val.indexOf(DESTINATION)+12;
			int end = 0;
			
			if(val.indexOf(MESSAGE_TYPE)>=0){
				end = val.indexOf(MESSAGE_TYPE);
				action.setDestination(val.substring(start, end-1).trim());
			}else if(val.indexOf(PAYLOADTYPE)>=0){
				end = val.indexOf(PAYLOADTYPE);
				action.setDestination(val.substring(start, end-1).trim());
			}else if(val.indexOf(DESCRIPTION)>=0){
				end = val.indexOf(DESCRIPTION);
				action.setDestination(val.substring(start, end-1).trim());
			}
		}
		
		//SET MESSAGE_TYPE
		if(val.indexOf(MESSAGE_TYPE)>=0){
			int start = val.indexOf(MESSAGE_TYPE)+8;
			int end = 0;
			
			if(val.indexOf(STATUS)>=0){
				end = val.indexOf(STATUS);
				action.setMessagetype(val.substring(start, end-1).trim());
			}else if(val.indexOf(SDPEXISTS)>=0){
				end = val.indexOf(SDPEXISTS);
				action.setMessagetype(val.substring(start, end-1).trim());
			}
		}
		
		//SET STATUS
		if(val.indexOf(STATUS)>=0){
			int start = val.indexOf(STATUS)+7;
			int end = 0;
			
			if(val.indexOf(SDPEXISTS)>=0){
				end = val.indexOf(SDPEXISTS);
				action.setStatus(val.substring(start, end-1).trim());
			}
		}
		
		//SET SDP
		if(val.indexOf(SDPEXISTS)>=0){
			int start = val.indexOf(SDPEXISTS)+4;
			int end = 0;
			
			if(val.indexOf(SDP_VALUE)>=0){
				end = val.indexOf(SDP_VALUE);
				action.setSdp(val.substring(start, end-1).trim());
			}else if(val.indexOf(HEADER_VALUE)>=0){
				end = val.indexOf(HEADER_VALUE);
				if(val.substring(start, end-1).trim().equalsIgnoreCase("true"))
					action.setSdp(val.substring(start, end-1).trim());
			}else if(val.indexOf(XML_HEADER)>=0){
				end = val.indexOf(XML_HEADER);
				if(val.substring(start, end-1).trim().equalsIgnoreCase("true"))
					action.setSdp(val.substring(start, end-1).trim());
			}else if(val.indexOf(DESCRIPTION)>=0){
				end = val.indexOf(DESCRIPTION);
				if(val.substring(start, end-1).trim().equalsIgnoreCase("true"))
					action.setSdp(val.substring(start, end-1).trim());
			}
		}
		
		//SET SDP VALUE
		if(val.indexOf(SDP_VALUE)>=0){
			int start = val.indexOf(SDP_VALUE)+9;
			int end = 0;
			if(val.indexOf(HEADER_VALUE)>=0){
				end = val.indexOf(HEADER_VALUE);
				action.setSdpvalue(val.substring(start, end-1).trim());
			}else if(val.indexOf(XML_HEADER)>=0){
				end = val.indexOf(XML_HEADER);
				action.setSdpvalue(val.substring(start, end-1).trim());
			}else if(val.indexOf(DESCRIPTION)>=0){
				end = val.indexOf(DESCRIPTION);
				action.setSdpvalue(val.substring(start, end-1).trim());
			}
		}
		
		//SET HEADER VALUE
		if(val.indexOf(HEADER_VALUE)>=0){
			int start = val.indexOf(HEADER_VALUE)+8;
			int end = 0;
			
			if(val.indexOf(XML_HEADER)>=0){
				end = val.indexOf(XML_HEADER);
				action.setHeaders(val.substring(start, end-1).trim());
			}else if(val.indexOf(DESCRIPTION)>=0){
				end = val.indexOf(DESCRIPTION);
				action.setHeaders(val.substring(start, end-1).trim());
			}
		}
		
		//SET XML HEADER VALUE
		if(val.indexOf(XML_HEADER)>=0){
			int start = val.indexOf(XML_HEADER)+11;
			int end = 0;
			
			if(val.indexOf(DESCRIPTION)>=0){
				end = val.indexOf(DESCRIPTION);
				action.setXmlheader(val.substring(start, end-1).trim());
			}
		}
		
		//SET PAYLOADTYPE
		if(val.indexOf(PAYLOADTYPE)>=0){
			int start = val.indexOf(PAYLOADTYPE)+12;
			int end = 0;
			
			if(val.indexOf(DESCRIPTION)>=0){
				end = val.indexOf(DESCRIPTION);
				action.setPayloadtype(val.substring(start, end-1).trim());
			}
		}
		
		//SET DESCRIPTION
		if(val.indexOf(DESCRIPTION)>=0){
			int start = val.indexOf(DESCRIPTION)+5;
			int end = 0;
			
			if(val.indexOf(EVENTID)>=0){
				end = val.indexOf(EVENTID);
				if(!val.substring(start, end).trim().equalsIgnoreCase("")){
					action.setDesc(val.substring(start, end-1).trim());
				}
			}else if(val.indexOf(ENDOFEVENT)>=0){
				end = val.indexOf(ENDOFEVENT);
				if(!val.substring(start, end).trim().equalsIgnoreCase("")){
					action.setDesc(val.substring(start, end-1).trim());
				}
			}else{
				if(!val.substring(start, val.length()).trim().equalsIgnoreCase("")){
					action.setDesc(val.substring(start, val.length()).trim());
				}
			}
		}
		
		//SET EVENTID
		if(val.indexOf(EVENTID)>=0){
			int start = val.indexOf(EVENTID)+8;
			int end = 0;
			
			if(val.indexOf(ENDOFEVENT)>=0){
				end = val.indexOf(ENDOFEVENT);
				action.setEventid(val.substring(start, end-1).trim());
			}else{
				action.setEventid(val.substring(start, val.length()).trim());
			}
		}
		
		//SET ENDOFEVENT
		if(val.indexOf(ENDOFEVENT)>=0){
			int start = val.indexOf(ENDOFEVENT)+11;
			action.setEndofevent(val.substring(start, val.length()).trim());
		}		
		
	}
	
	/**
	 * To Validate Sip Actions
	 * @param ListofStrings
	 */
	public Boolean validateEnteredSipActions(List<String> requestString){
		Boolean result = Boolean.FALSE;
		for(String userAction : requestString){
			if(userAction.contains(RIGHT_TAG)){
				String[] stringArr = userAction.split(RIGHT_TAG);
				String key = stringArr[0];
				result = validateSipAction(key);
				if(result == Boolean.FALSE){
					logger.debug("Key validation failed for  - " +key);
					break;
				}
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

	private Boolean validateSipAction(String type){
		if(type.equalsIgnoreCase(SipActionType.CHECK.toString())){
			return Boolean.TRUE;
		}
		if(type.equalsIgnoreCase(SipActionType.EITHERCHECK.toString())){
			return Boolean.TRUE;
		}
		if(type.equalsIgnoreCase(SipActionType.MULTICHECK.toString())){
			return Boolean.TRUE;
		}
		logger.debug("Not a valid action in the file - " +type);
		return Boolean.FALSE;
	}
}
