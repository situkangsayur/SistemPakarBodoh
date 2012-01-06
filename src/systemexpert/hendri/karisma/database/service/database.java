/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package systemexpert.hendri.karisma.database.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author hendri
 */
public class database {

    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;

    public static EntityManagerFactory getConnection(){

        if(entityManagerFactory == null){
            entityManagerFactory = Persistence.createEntityManagerFactory("SystemExpertPU");

        }
        return entityManagerFactory;
    }
    public static EntityManager getEntityManager(){

        if(entityManager == null){
            entityManager = getConnection().createEntityManager();
        }

        return entityManager;

    }

}
