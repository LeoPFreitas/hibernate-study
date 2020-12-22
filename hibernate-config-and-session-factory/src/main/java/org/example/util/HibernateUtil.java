package org.example.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;

import java.util.HashMap;
import java.util.Map;

public class HibernateUtil {

    private static StandardServiceRegistry standardServiceRegistry;
    private static SessionFactory sessionFactory;

    static {
        StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();

        Map<String, String> dbSettings = new HashMap<>();
        dbSettings.put(Environment.URL, "jdbc:postgresql://localhost/hibernate");
        dbSettings.put(Environment.USER, "postgres");
        dbSettings.put(Environment.PASS, "postgres");
        dbSettings.put(Environment.DRIVER, "org.postgresql.Driver");
        dbSettings.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQL82Dialect");

        registryBuilder.applySettings(dbSettings);
        standardServiceRegistry = registryBuilder.build();
        MetadataSources sources = new MetadataSources(standardServiceRegistry);
        Metadata metadata = sources.getMetadataBuilder().build();
        sessionFactory = metadata.getSessionFactoryBuilder().build();
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
