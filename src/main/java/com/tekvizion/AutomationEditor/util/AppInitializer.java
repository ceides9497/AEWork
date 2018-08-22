package com.tekvizion.AutomationEditor.util;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import com.tekvizion.AutomationEditor.modal.Resources;
import com.tekvizion.AutomationEditor.modal.UserType;
import com.tekvizion.AutomationEditor.modal.Users;
import com.tekvizion.AutomationEditor.service.ResourceService;
import com.tekvizion.AutomationEditor.service.UserTypeService;
import com.tekvizion.AutomationEditor.service.UsersService;

public class AppInitializer {

	
	@Autowired
	private UserTypeService userTypeService;
	
	@Autowired
	private ResourceService resourceService;
	
	@Autowired
	private UsersService usersService;
	
	@PostConstruct
	public void initApp(){
		
		//adding user types
		if(this.userTypeService.listAll().size() == 0){
			UserType type = new UserType();		
			type = new UserType();
			type.setDescription("Admin");
			type.setName("ROLE_ADMIN");
			this.userTypeService.add(type);
		}
		
		//adding default user
		if(this.usersService.getAll().size() == 0){
			
			UserType userType = this.userTypeService.findByName("ROLE_ADMIN");
			
			Users user = new Users();	
			user.setLoginId("tekvizionadmin");
			user.setName("tekvizion");
			user.setPassword("tekV1z10n");			
			user.setUsertype(userType);
			
			this.usersService.addUser(user);
		}
		
		if(this.resourceService.getAll().size() == 0){
			Resources resource;
			resource = new Resources();
			resource.setName("LocalA");
			this.resourceService.addResource(resource);
			
			resource = new Resources();
			resource.setName("LocalB");
			this.resourceService.addResource(resource);
			
			resource = new Resources();
			resource.setName("LocalC");
			this.resourceService.addResource(resource);
			
			resource = new Resources();
			resource.setName("LocalD");
			this.resourceService.addResource(resource);
			
			resource = new Resources();
			resource.setName("LocalE");
			this.resourceService.addResource(resource);
			
			resource = new Resources();
			resource.setName("LocalF");
			this.resourceService.addResource(resource);
			
			resource = new Resources();
			resource.setName("LocalG");
			this.resourceService.addResource(resource);
			
			resource = new Resources();
			resource.setName("LocalH");
			this.resourceService.addResource(resource);
			
			resource = new Resources();
			resource.setName("PSTNA");
			this.resourceService.addResource(resource);
			
			resource = new Resources();
			resource.setName("PSTNB");
			this.resourceService.addResource(resource);
			
			resource = new Resources();
			resource.setName("PSTNC");
			this.resourceService.addResource(resource);
			
			resource = new Resources();
			resource.setName("PSTND");
			this.resourceService.addResource(resource);
			
			resource = new Resources();
			resource.setName("PSTNE");
			this.resourceService.addResource(resource);
			
			resource = new Resources();
			resource.setName("PSTNF");
			this.resourceService.addResource(resource);
			
			resource = new Resources();
			resource.setName("Remote1A");
			this.resourceService.addResource(resource);
			
			resource = new Resources();
			resource.setName("Remote1B");
			this.resourceService.addResource(resource);
			
			resource = new Resources();
			resource.setName("Remote1C");
			this.resourceService.addResource(resource);
			
			resource = new Resources();
			resource.setName("Remote1D");
			this.resourceService.addResource(resource);
			
			resource = new Resources();
			resource.setName("Remote1E");
			this.resourceService.addResource(resource);
			
			resource = new Resources();
			resource.setName("Remote1F");
			this.resourceService.addResource(resource);
			
			resource = new Resources();
			resource.setName("SoftLocalA");
			this.resourceService.addResource(resource);
			
			resource = new Resources();
			resource.setName("SoftLocalB");
			this.resourceService.addResource(resource);
			
			resource = new Resources();
			resource.setName("SoftLocalC");
			this.resourceService.addResource(resource);
			
			resource = new Resources();
			resource.setName("SoftLocalD");
			this.resourceService.addResource(resource);
			
			resource = new Resources();
			resource.setName("SoftLocalE");
			this.resourceService.addResource(resource);
			
			resource = new Resources();
			resource.setName("SoftLocalF");
			this.resourceService.addResource(resource);
			
			resource = new Resources();
			resource.setName("TurretA");
			this.resourceService.addResource(resource);
			
			resource = new Resources();
			resource.setName("TurretB");
			this.resourceService.addResource(resource);
			
			resource = new Resources();
			resource.setName("TurretC");
			this.resourceService.addResource(resource);
			
			resource = new Resources();
			resource.setName("TurretD");
			this.resourceService.addResource(resource);
			
			resource = new Resources();
			resource.setName("TurretE");
			this.resourceService.addResource(resource);
			
			resource = new Resources();
			resource.setName("TurretF");
			this.resourceService.addResource(resource);
			
		}
	}
}
