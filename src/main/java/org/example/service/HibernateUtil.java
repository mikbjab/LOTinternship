package org.example.service;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.HashMap;
import java.util.Map;

public class HibernateUtil {
    private static SessionFactory sessionFactory=null;
    private static Map<String,String> settings=new HashMap<>();

    static{
        Configuration config=new Configuration();
        config.configure();
        StandardServiceRegistryBuilder builder=new StandardServiceRegistryBuilder()
                .applySettings(config.getProperties());
        sessionFactory=config.buildSessionFactory();
    }

    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }
}
