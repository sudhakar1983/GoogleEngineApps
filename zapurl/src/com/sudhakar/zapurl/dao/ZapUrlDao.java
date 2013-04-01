package com.sudhakar.zapurl.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sudhakar.zapurl.EMF;
import com.sudhakar.zapurl.model.db.ZapUrl;

@Component
@Transactional(propagation=Propagation.MANDATORY)
public class ZapUrlDao {

	
	
	public void save(ZapUrl zapUrl) throws Exception{		
		EntityManager em = EMF.getEntityManager();
		em.getTransaction().begin();
		em.persist(zapUrl);
		em.getTransaction().commit();
	}
	
	public ZapUrl getLink(String zappedUrl){
		ZapUrl zapUrl = null;
		EntityManager em = EMF.getEntityManager();
		
		Query q = em.createQuery("Select from ZapUrl where zappedUrl=:zappedUrl");
		q.setParameter("zappedUrl", zappedUrl);
		@SuppressWarnings("unchecked")
		List<ZapUrl> zapUrls = q.getResultList();
		
		if(!zapUrls.isEmpty())zapUrl = zapUrls.get(0);
		
		return zapUrl;
	}
	
}
