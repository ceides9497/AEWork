package com.tekvizion.AutomationEditor.service;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.tekvizion.AutomationEditor.modal.Action;
import com.tekvizion.AutomationEditor.modal.ActionDetails;
import com.tekvizion.AutomationEditor.modal.StateActionsResponse;
import com.tekvizion.AutomationEditor.util.GenerateXMLScript;
import com.tekvizion.AutomationEditor.util.ParseJsonRequest;

@Service
public class StateServiceImpl implements StateService{
	@Autowired 
	ParseJsonRequest parseJsonRequest;
	
	@Autowired 
	GenerateXMLScript generateXMLScript;
	
	private static final Logger logger = LoggerFactory.getLogger(StateServiceImpl.class);
	public static final String RIGHT_TAG	= ">";
	public static final String DESCRIPTION	= "Desc:";
	public static final String COLON	= ":";
	public static final String NONE	= "NONE";
	public static final String PHONE	= "Phone";
	public static final String LINE_STATE	= "LS";
	public static final String CALL_STATE	= "CS";
	public static final String CALL_STATE2	= "CS2";
	public static final String CALL_TYPE	= "CT";
	public static final String CALL_TYPE2	= "CT2";
	public static final String INDEX_CALLS	= "Calls";
	public static final String INDEX_VIA	= "via";
	public static final String INDEX_ANSWERED	= "Answered";
	public static final String INDEX_TRANSFERRED = "Transfered";
	public static final String INDEX_ENDED	= "Ended";
	public static final String INDEX_FOR	= "For";
	public static final String INDEX_HOLD	= "Hold";
	public static final String INDEX_UNHOLD	= "unhold";
	public static final String INDEX_CONFERENCES	= "Conferences";
	public static final String INDEX_SECONDS	= "seconds";
	public static final String INDEX_UNATTENDED_TRANSFER	= "Unattended Transfer";
	public static final String HANDS_FREE	= "handsfree";
	public static final String CALL_ACTION	= "call";
	public static final String CONFERENCE_START	= "conf_start";
	public static final String CONFERENCE_COMPLETE	= "conf_complete";
	public static final String TRANSFER_START	= "xfer_start";
	public static final String UNATTENDED_TRANSFER_START	= "unattended_xfer_start";
	public static final String UNATTENDED_TRANSFER_COMPLETE = "unattended_xfer_complete";
	public static final String TRANSFER_COMPLETE	= "xfer_complete";
	public static final String CHECK_AUDIO	= "check_audio";
	public java.io.StringWriter xmlString = new StringWriter();
	
	/**
	 * method to get the next state and the corresponding actions for the current state
	 * @param currentState
	 * @param action 
	 * @return
	 */
	public StateActionsResponse getCurrentStateAndActions(String currentState, String action) 
			throws ParserConfigurationException, SAXException, IOException, XPathExpressionException {
		
		String xmlPath = StateServiceImpl.class.getClassLoader().getResource("/StateMachine.xml").getPath();
		File xmlFile = new File(xmlPath);
		logger.info("Current directory's absolute  path: " + xmlFile.getCanonicalPath());
		
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		Document document = builder.parse(xmlFile);
		
		XPathFactory xPathfactory = XPathFactory.newInstance();
		XPath xpath = xPathfactory.newXPath();
		String expr = "/AutomationEditor/StateInformation/State[CurrentState='"+currentState+"' and Action='"+action+"']/NextState";
		NodeList nodeList = (NodeList) xpath.compile(expr).evaluate(document, XPathConstants.NODESET);
		
		StateActionsResponse actionResponse = new StateActionsResponse();
		logger.info("nodeList.getLength() : "+nodeList.getLength());
		
		//getting the next state
		if (nodeList.getLength() == 1) {
		    Node parent = nodeList.item(0).getParentNode();
		    // This node is the <State> node
		    Element element = (Element)parent;
		    actionResponse.setNextState(element.getElementsByTagName("NextState").item(0).getTextContent());
		}
		
		//getting the actions related to the current state
		String expr2 = "/AutomationEditor/ActionInfo/State[@CurrentState='"+actionResponse.getNextState()+"']/Action";
		NodeList actionsNodeList = (NodeList) xpath.compile(expr2).evaluate(document, XPathConstants.NODESET);
		
		List<ActionDetails> actionList = new ArrayList<ActionDetails>();
		for(int i=0; i< actionsNodeList.getLength(); i++){
			Node node = actionsNodeList.item(i);
			ActionDetails actionDetails = new ActionDetails();
			
			actionDetails.setActionName(node.getAttributes().getNamedItem("Name").getNodeValue());
			actionDetails.setEnabled(Boolean.valueOf(node.getAttributes().getNamedItem("Enabled").getNodeValue()));
			
			actionList.add(actionDetails);
		}
		actionResponse.setActionList(actionList);
		return actionResponse;
	}
	
	
	/**
	 * method to create testcase script based on the given actions
	 * @param scenarioName
	 * @param actionList 
	 * @return
	 */
	public String createTestCase(String scenarioName, List<String> actionList, String fileName,boolean idlePhonesInd){
		List<Action> finalList = new ArrayList<Action>();
		finalList = parseJsonRequest.parseRequestString(actionList);
		Set<String> tcResources = getTestCaseResources(finalList);
		xmlString.getBuffer().setLength(0); //To reuse the string writer clearing the old data
		generateXMLScript.generateTestCaseFile(scenarioName, finalList, xmlString, fileName,tcResources, idlePhonesInd);
		return xmlString.toString();
	}
	
	public Boolean validateEnteredActions(List<String> listContent){
		return parseJsonRequest.validateEnteredActions(listContent);
	}
	
	private Set<String> getTestCaseResources(List<Action> actionList){
		Set<String> resources = new HashSet<String>();
		
		for(Action action: actionList){
			resources.add(action.getPhone());
			resources.add(action.getFrom());
			resources.add(action.getTo());
		}
		resources.remove(null);
		return resources;
	}
	
}
