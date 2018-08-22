package com.tekvizion.AutomationEditor.repository;

import java.util.List;

import com.tekvizion.AutomationEditor.modal.Users;


public interface UsersRepository {

	public List<Users> getAll();
	
	public void addUser(Users user);
	
	public void editUser(Users user);
	
}
