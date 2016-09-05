package utils;


import entities.Category;
import entities.Client;
import entities.Item;
import entities.Order;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static SessionFactory sessionFactory;
    static {
        try {

            Configuration configuration = new Configuration()
                    .addAnnotatedClass(Item.class)
                    .addAnnotatedClass(Order.class)
                    .addAnnotatedClass(Category.class)
                    .addAnnotatedClass(Client.class);
            sessionFactory=configuration.configure().buildSessionFactory();

        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}
