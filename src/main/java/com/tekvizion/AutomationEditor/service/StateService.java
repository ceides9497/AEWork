package com.tekvizion.AutomationEditor.service;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.xml.sax.SAXException;

import com.tekvizion.AutomationEditor.modal.StateActionsResponse;

public interface StateService {

	public StateActionsResponse getCurrentStateAndActions(String currentState, String action) 
			throws ParserConfigurationException, SAXException, IOException, XPathExpressionException;
	
	public String createTestCase(String scenarioName, List<String> actionList,String fileName, boolean idlePhonesInd);
	
	public Boolean validateEnteredActions(List<String> listContent);
}
