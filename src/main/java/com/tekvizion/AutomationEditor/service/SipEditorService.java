package com.tekvizion.AutomationEditor.service;

import java.util.List;

public interface SipEditorService {

	public String createSipValidationTestCase(String scenarioName, List<String> actionList,String fileName);
	
	public Boolean validateEnteredSipActions(List<String> listContent);
}
