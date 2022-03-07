package com.bnpparibas.lafabrique.TPAlimentation.infrastructure.persistence;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DaoFactory {

    public static SessionFactory sessionFactory = null;

    public static SessionFactory createSession(){

        if (sessionFactory == null) {
            sessionFactory = new Configuration()
                    .configure("hibernate-cfg.xml")
                    .buildSessionFactory();
        }
        return sessionFactory;

    }

}
