package com.tekvizion.AutomationEditor.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.tekvizion.AutomationEditor.modal.Resources;

@Repository
public class ResourceRepositoryImp implements ResourceRepository{

	@PersistenceContext
	EntityManager entityManager;
	
	static Logger logger = Logger.getLogger("dbLogs");
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Resources> getAll() {
		Query q = this.entityManager.createQuery("from Resources");	
		return (List<Resources>) q.getResultList();
	}

	@Override
	public void addResource(Resources resource) {
		try{
			this.entityManager.persist(resource);
			this.entityManager.flush();
		}catch(Exception e){
			logger.fatal(e.getMessage());
		}
		
	}

	@Override
	public void editResource(Resources resource) {
		try{
			this.entityManager.merge(resource);
			this.entityManager.flush();	
		}catch(Exception e){
			logger.fatal(e.getMessage());
		}
		
	}

	@Override
	public Resources getResourceByID(String id) {
		Resources res = (Resources) this.entityManager.find(Resources.class, id);
		if(res==null){
			logger.debug("No Resource found with id - "+id);
			return null;
		}
		return res;
	}

}
