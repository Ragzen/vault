package services;

import org.hibernate.Session;
import org.hibernate.TransactionException;

public class DataBaseService {
    private        Session         session;
    private static DataBaseService instance = new DataBaseService();
    
    private DataBaseService() {
        open();
    }
    
    public static DataBaseService getInstance() {
        return instance;
    }
    
    public void save(Object object) {
        try {
            session.beginTransaction();
            session.save(object);
            session.getTransaction().commit();
        } catch (TransactionException exception) {
            session.getTransaction().rollback();
        }
    }
    
    public void close() {
        session.close();
    }
    
    public void open() {
        session = HibernateManager.getSessionFactory().openSession();
    }
    
    public void off() {
        HibernateManager.shutdown();
    }
}
