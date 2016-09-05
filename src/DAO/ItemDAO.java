package DAO;

import entities.Item;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import utils.HibernateUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ItemDAO {
    public List getItemsByCategory(String categoryName)throws SQLException{
        Session session = null;
        List<Item> items=new ArrayList<Item>();
        try{
            session= HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            Criteria criteria=session.createCriteria(Item.class,"item");
            criteria.createCriteria("item.category","category");
            criteria.add(Restrictions.eq("category.name",categoryName));
            items=criteria.list();

            session.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            if(session!=null&&session.isOpen()){
                session.close();
            }

        }
        return items;
    }

    public Item getItemById(Integer id) throws SQLException {


        /*Session session = HibernateUtil.getSessionFactory().openSession();
       Item item = (Item) session.get(Item.class, id);
        session.close();*/





        Session session = null;
        Item item = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            item =  session.load(Item.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return item;
    }






}
