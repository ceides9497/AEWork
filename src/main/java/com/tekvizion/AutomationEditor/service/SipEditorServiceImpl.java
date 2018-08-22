package com.tekvizion.AutomationEditor.service;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tekvizion.AutomationEditor.modal.SipActions;
import com.tekvizion.AutomationEditor.util.GenerateSIPXMLScript;
import com.tekvizion.AutomationEditor.util.ParseSipData;

@Service
public class SipEditorServiceImpl implements SipEditorService{
	@Autowired 
	ParseSipData parseSipDataRequest;
	
	@Autowired 
	GenerateSIPXMLScript generateSipXMLScript;
	
	private static final Logger logger = LoggerFactory.getLogger(SipEditorServiceImpl.class);
	public static final String RIGHT_TAG = ">";
	public static final String PROTOCOL = "Protocol:";
	public static final String COLON = ":";
	public static final String NONE = "NONE";
	public static final String FROM = "FROM";
	public static final String TO = "TO";
	public static final String METHOD = "METHOD";
	public static final String MESSAGE_TYPE = "MSGTYPE";
	public static final String STATUS = "STATUS";
	public static final String SDPEXISTS = "SDP";
	public static final String SDP_VALUE = "SDPVALUE";
	public static final String HEADER_VALUE = "HEADERS";
	public static final String PAYLOADTYPE = "PAYLOADTYPE";
	public static final String BIDIRECTION = "BIDIRECTIONAL";
	public java.io.StringWriter xmlString = new StringWriter();
	
	/**
	 * method to create testcase script based on the given actions
	 * @param scenarioName
	 * @param actionList 
	 * @param fileName
	 * @return
	 */
	public String createSipValidationTestCase(String scenarioName, List<String> actionList, String fileName){
		logger.debug("Initiating to Create Sip Validation Test Case");
		List<SipActions> finalList = new ArrayList<SipActions>();
		finalList = parseSipDataRequest.parseRequestString(actionList);
			if(finalList==null){
				return null;
			}
		xmlString.getBuffer().setLength(0); //To reuse the string writer clearing the old data
		generateSipXMLScript.generateSipValidationTestCaseFile(scenarioName, finalList, xmlString, fileName);
		return xmlString.toString();
	}
	
	public Boolean validateEnteredSipActions(List<String> listContent){
		return parseSipDataRequest.validateEnteredSipActions(listContent);
	}
	
}
