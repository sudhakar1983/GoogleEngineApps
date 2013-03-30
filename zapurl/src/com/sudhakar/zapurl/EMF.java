package com.sudhakar.zapurl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


/**
 * The Class EMF.
 *
 * @author Sudhakar Duraiswamy
 * The Class EMF.
 */
public final class EMF {
    
    /** The Constant emfInstance. */
    private static final EntityManagerFactory emfInstance =
        Persistence.createEntityManagerFactory("clipit_db");

    /**
     * Instantiates a new emf.
     */
    private EMF() {}

    /**
     * Gets the.
     *
     * @return the entity manager factory
     */
    public static EntityManagerFactory get() {
        return emfInstance;
    }
    
    /**
     * Gets the entity manager.
     *
     * @return the entity manager
     */
    public static synchronized EntityManager getEntityManager(){
    	return emfInstance.createEntityManager();
    }
}
