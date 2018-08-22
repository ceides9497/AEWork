package com.tekvizion.AutomationEditor.repository;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.tekvizion.AutomationEditor.modal.UserType;



@Repository
public class UserTypeRepositoryImpl implements UserTypeRepository {

	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public void add(UserType userType) {
		entityManager.persist(userType);
	}

	@Override
	public void edit(UserType userType) {
		entityManager.merge(userType);
	}

	@Override
	public boolean delete(UserType userType) {
		entityManager.remove(userType);
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<UserType> listAll() {		
		Query q = entityManager.createQuery("from UserType where active = true");
		return q.getResultList();
	}

	@Override
	public UserType findById(String id) {		
		return (UserType) entityManager.find(UserType.class, id);
	}
	
	/**
	 * This method returns the UserType object with the type 
	 */
	@Override
	public UserType findByName(String name) {
		return (UserType) this.entityManager.createQuery("from UserType where active = true and name='"+name+"'").getResultList().get(0);
	}
	
}
