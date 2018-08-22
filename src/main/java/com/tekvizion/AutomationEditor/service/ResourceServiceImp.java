package com.tekvizion.AutomationEditor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tekvizion.AutomationEditor.modal.Resources;
import com.tekvizion.AutomationEditor.repository.ResourceRepository;

@Service
public class ResourceServiceImp implements ResourceService {

	@Autowired
	private ResourceRepository resourceRepo;
	
	@Override
	public List<Resources> getAll() {
		return this.resourceRepo.getAll();
	}

	@Override
	@Transactional
	public void addResource(Resources resource) {
		this.resourceRepo.addResource(resource);
	}

	@Override
	@Transactional
	public void editResource(Resources resource) {
		this.resourceRepo.editResource(resource);	
	}

	@Override
	public Resources getResourceByID(String id) {
		return this.resourceRepo.getResourceByID(id);
	}

}
