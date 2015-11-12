package config;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * hibernate配置
 */
public class HibernateConfig {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
        	// 加载配置文件  默认classpath下 hibernate.cfg.xml
        	StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder().configure( "hibernate.xml" ).build();
        	Metadata metadata = new MetadataSources(standardRegistry).getMetadataBuilder().build();
        	return metadata.getSessionFactoryBuilder().build();
        }catch (Throwable ex) {
        	ex.printStackTrace();
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
    public static Session getSession() {
    	return sessionFactory.getCurrentSession();
    }

    
}