package com.sudhakar.zapurl.dao;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sudhakar.zapurl.EMF;
import com.sudhakar.zapurl.model.ZapUrl;

@Component
@Transactional(propagation=Propagation.MANDATORY)
public class ZapUrlDao {

	
	
	public void save(ZapUrl zapUrl) throws Exception{		
		EntityManager em = EMF.getEntityManager();
		em.getTransaction().begin();
		em.persist(zapUrl);
		em.getTransaction().commit();
	}
	
}
