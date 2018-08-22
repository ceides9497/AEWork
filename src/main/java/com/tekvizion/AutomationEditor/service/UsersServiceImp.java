package com.tekvizion.AutomationEditor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tekvizion.AutomationEditor.modal.Users;
import com.tekvizion.AutomationEditor.repository.UsersRepository;

@Service
public class UsersServiceImp implements UsersService {

	@Autowired
	private UsersRepository userRepo;
	
	@Override
	public List<Users> getAll() {
		return this.userRepo.getAll();
	}

	@Override
	@Transactional
	public void addUser(Users user) {
		this.userRepo.addUser(user);
	}

	@Override
	@Transactional
	public void editUser(Users user) {
		this.userRepo.editUser(user);	
	}

}
