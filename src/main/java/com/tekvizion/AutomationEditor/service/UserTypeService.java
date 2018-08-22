package com.tekvizion.AutomationEditor.service;

import java.util.Collection;

import com.tekvizion.AutomationEditor.modal.UserType;



public interface UserTypeService {

	public void add(UserType userType);
	
	public void edit(UserType userType);
	
	public boolean delete(UserType userType);
	
	public Collection<UserType> listAll();

	public UserType findById(String id);
	
	public UserType findByName(String name);
	
}
