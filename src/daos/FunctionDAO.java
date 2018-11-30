/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import entities.Region;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Ignatius
 */
public class FunctionDAO {
    private SessionFactory factory;
    private Session session;
    private Transaction transaction;

    public FunctionDAO() {
    }

    public FunctionDAO(SessionFactory factory) {
        this.factory = factory;
    }
    
    /**
     * Fungsi untuk melakukan insert atau update Region
     * @param region
     * @param isDelete
     * @return 
     */
    public boolean insertOrUpdateOrDelete(Object object, 
            boolean isDelete){
        boolean result = false;
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            if (isDelete) {
                session.delete(object);
            }else{
                session.saveOrUpdate(object);
            }
            result = true;
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if(transaction!=null) transaction.rollback();
        } finally {
            session.close();
        }
        return result;
    }
    
    /**
     * 
     * @param query
     * @return 
     */
    public List<Object> getDatas(Object entities, String key){
        List<Object> regions = new ArrayList<>();
        String className = entities.getClass().getName();
            
            className = className.substring(className.indexOf(".")+1);
            String query = "From "+className;
            
            
            if(!key.equals("")){
                query = getQuery(entities, key, query);
            }
//            System.out.println(query);
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            
            session.createQuery(query).list();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if(transaction!=null)transaction.rollback();
        } finally {
            session.close();
        }
        return regions;
    }
    
    public String getQuery(Object entity, String key, String query){
        String className = entity.getClass().getName();
        query += " WHERE ";
        short count =0;
        int Flenght=0;
            for (Object gfield : entity.getClass().getDeclaredFields()) {
                String sfield = gfield +"";
                if(!sfield.contains("UID")&& !sfield.contains("List")){
                    Flenght+=1;
                    }
                }
            for (Object field : entity.getClass().getDeclaredFields()) {
                String sfield = field +"";
                if(!sfield.contains("UID")&& !sfield.contains("List")){
                    sfield = sfield.substring(sfield.lastIndexOf(".")+1);
                    query += sfield + " LIKE '%"+key+"%' ";
                    if(count < Flenght-1){
                        query += "OR ";
                    }
                }
                count++;
            }
            return query;
    }
    
    /**
     * 
     * @param query
     * @return 
     */
    public Object getById(Object entity, Object id){
        Object object = new Object();
        String className = entity.getClass().getName();
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            object = session.createQuery("FROM "+ entity.getClass().getSimpleName() 
                    +" WHERE "+"?"+" ="+id)
                    .uniqueResult();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if(transaction!=null)transaction.rollback();
        } finally {
            session.close();
        }
        return object;
    }
}
