package DAO;

import entities.Client;
import org.hibernate.Session;
import utils.HibernateUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ConcatN on 23.05.2016.
 */
public class ClientDAO {






    public void saveClient(Client client) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(client);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public static List getAllClients() throws SQLException {
        Session session = null;
        List clients = new ArrayList<Client>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            clients = session.createCriteria(Client.class).list();
        } catch (Exception e) {
          e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return clients;
    }






}
