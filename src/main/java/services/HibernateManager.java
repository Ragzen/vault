package services;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateManager {
    private static StandardServiceRegistry registry;
    private static SessionFactory          sessionFactory;
    
    private HibernateManager() {
        //
    }
    
    static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                registry = new StandardServiceRegistryBuilder().configure().build(); // Create registry
                
                MetadataSources sources  = new MetadataSources(registry); // Create MetadataSources
                Metadata        metadata = sources.getMetadataBuilder().build(); // Create Metadata
                
                sessionFactory = metadata.getSessionFactoryBuilder().build(); // Create SessionFactory
            } catch (Exception e) {
                e.printStackTrace();
                
                if (registry != null) {
                    StandardServiceRegistryBuilder.destroy(registry);
                }
            }
        }
        
        return sessionFactory;
    }
    
    static void shutdown() {
        if (registry != null) {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
}