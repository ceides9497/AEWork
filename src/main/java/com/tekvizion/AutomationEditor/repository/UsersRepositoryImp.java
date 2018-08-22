package com.tekvizion.AutomationEditor.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.tekvizion.AutomationEditor.modal.Users;

@Repository
public class UsersRepositoryImp implements UsersRepository{

	@PersistenceContext
	EntityManager entityManager;
	
	static Logger logger = Logger.getLogger("dbLogs");
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Users> getAll() {
		Query q = this.entityManager.createQuery("from Users");	
		return (List<Users>) q.getResultList();
	}

	@Override
	public void addUser(Users user) {
		try{
			this.entityManager.persist(user);
			this.entityManager.flush();
		}catch(Exception e){
			logger.fatal(e.getMessage());
		}
		
	}

	@Override
	public void editUser(Users user) {
		try{
			this.entityManager.merge(user);
			this.entityManager.flush();	
		}catch(Exception e){
			logger.fatal(e.getMessage());
		}
		
	}

}
