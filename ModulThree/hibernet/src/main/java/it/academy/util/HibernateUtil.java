package it.academy.util;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


public class HibernateUtil {

    private static SessionFactory sessionFactory;

    public HibernateUtil() {
        StandardServiceRegistry registry =
                new StandardServiceRegistryBuilder()
                        .configure()
                        .build();
        sessionFactory =
                new MetadataSources(registry)
                        .buildMetadata()
                        .buildSessionFactory();
    }

    public HibernateUtil(String xmlFile) {
        StandardServiceRegistry registry =
                new StandardServiceRegistryBuilder()
                        .configure(xmlFile)
                        .build();
        sessionFactory =
                new MetadataSources(registry)
                        .buildMetadata()
                        .buildSessionFactory();
    }

    public static Session getSession() {
        return sessionFactory.openSession();
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}










/*public class HibernateUtil {
    //Управление сущностями начинается с создания EntityManagerFactory, которая отвечает за отображение объектов в базу,
    //поддержку соединений, кэш состояний и всякие такие вещи.
    //Создание EntityManagerFactory  довольно дорогая операция, поэтому обычно её создают один раз и на всё приложение.

    private static final EntityManagerFactory emFactory;

    static {
        emFactory = Persistence.createEntityManagerFactory("it.academy");
    }

    public static EntityManager getEntityManager() {
        return emFactory.createEntityManager();
    }

    public static void close() {
        emFactory.close();
    }
}*/