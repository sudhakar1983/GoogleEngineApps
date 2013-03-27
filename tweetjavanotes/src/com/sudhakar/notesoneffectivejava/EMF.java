package com.sudhakar.notesoneffectivejava;

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
        Persistence.createEntityManagerFactory("transactions-optional");

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
    public static EntityManager getEntityManager(){
    	return emfInstance.createEntityManager();
    }
}
