package com.tekvizion.AutomationEditor.service;

import java.util.List;

import com.tekvizion.AutomationEditor.modal.Resources;


public interface ResourceService {

	public List<Resources> getAll();
	
	public void addResource(Resources resource);
	
	public void editResource(Resources resource);
	
	public Resources getResourceByID(String id);
	
}
