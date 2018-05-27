package services;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.TransactionException;
import java.io.Serializable;

public class DataBaseService {
    private        Session         session;
    private static DataBaseService instance = new DataBaseService();
    private        Transaction     transaction;
    
    private DataBaseService() {
        open();
    }
    
    public static DataBaseService getInstance() {
        return instance;
    }
    
    public void save(Object object) {
        try {
            transaction = session.beginTransaction();
            session.saveOrUpdate(object);
            transaction.commit();
        } catch (TransactionException exception) {
            transaction.rollback();
        }
    }
    
    public void delete(Object object) {
        try {
            transaction = session.beginTransaction();
            session.delete(object);
            transaction.commit();
        } catch (TransactionException exception) {
            transaction.rollback();
        }
    }
    
    public <T> void deleteById(Class<T> type, Serializable value) {
        T domain = null;
        
        try {
            transaction = session.beginTransaction();
            domain = session.load(type, value);
            transaction.commit();
        } catch (TransactionException exception) {
            transaction.rollback();
        }
    
        if(domain != null) {
            delete(domain);
        }
    }
    
    public <T> T selectById(Class<T> type, Serializable value) {
        return session.load(type, value);
    }
    
    private void open() {
        session = HibernateManager.getSessionFactory().openSession();
    }
    
    public void shutdown() {
        session.close();
        HibernateManager.shutdown();
    }
    
    public Session getSession() {
        return session;
    }
}
