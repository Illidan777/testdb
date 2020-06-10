package com.gmail.gorbasenko245.entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Utils {
    private static final String NAME = "JPATest";

    private EntityManagerFactory emFactory;
    private EntityManager em;


    public Utils() {
        this.emFactory = Persistence.createEntityManagerFactory(NAME);
        this.em = emFactory.createEntityManager();
    }

    public EntityManager getEm() {
        return em;
    }

}
