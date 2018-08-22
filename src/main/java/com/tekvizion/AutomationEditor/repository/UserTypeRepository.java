package com.tekvizion.AutomationEditor.repository;

import java.util.Collection;

import com.tekvizion.AutomationEditor.modal.UserType;



public interface UserTypeRepository {

	public void add(UserType userType);
	
	public void edit(UserType userType);
	
	public boolean delete(UserType userType);
	
	public Collection<UserType> listAll();

	public UserType findById(String id);
	
	public UserType findByName(String name);
}
