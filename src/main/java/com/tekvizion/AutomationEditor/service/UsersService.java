package com.tekvizion.AutomationEditor.service;

import java.util.List;

import com.tekvizion.AutomationEditor.modal.Users;


public interface UsersService {

	public List<Users> getAll();
	
	public void addUser(Users user);
	
	public void editUser(Users user);
	
}
