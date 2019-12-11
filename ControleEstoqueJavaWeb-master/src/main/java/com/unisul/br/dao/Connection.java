package com.unisul.br.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Connection {
	private static EntityManagerFactory entityManagerFactory;

    public static EntityManager getEntityManager(){
        if (entityManagerFactory==null){
            entityManagerFactory= Persistence.createEntityManagerFactory("meuPU");
        }
        return entityManagerFactory.createEntityManager();
    }
}
