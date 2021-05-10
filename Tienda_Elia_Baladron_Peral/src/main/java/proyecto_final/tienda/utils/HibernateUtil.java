package proyecto_final.tienda.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
//import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	// La SessionFactory se establece una sola vez por app!
	private static final SessionFactory sessionFactory = buildSessionFactory();
	
	private static SessionFactory buildSessionFactory() {
		String methodName = HibernateUtil.class.getSimpleName() + ".buildSessionFactory()";
		// configure settings from hibernate.cfg.xml
		final StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
                                                          		.configure("hibernate/hibernate.cfg.xml").build();

		try {
			Metadata metadata = new MetadataSources(standardRegistry).getMetadataBuilder().build();
			SessionFactory sessionFactory= metadata.getSessionFactoryBuilder().build();
			System.out.println(String.format("%1$s: SessionFactory created.", methodName));
//			SessionFactory sessionFactoryAlt =
//					new Configuration().configure("hibernate.cfg.xml")
//									   .addAnnotatedClass(Product.class)
//									   .buildSessionFactory();
			return sessionFactory;
		} catch (Exception ex) {
			System.out.println(String.format("%1$s: Initial SessionFactory creation failed (%2$s).", methodName, ex.getMessage())); 
			throw new ExceptionInInitializerError(ex);
		}
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
}
