package be.kapture.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.model.naming.ImplicitNamingStrategyJpaCompliantImpl;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.Objects;

@SuppressWarnings("unused")
public class HibernateUtil {

	private static final SessionFactory sessionFactory = buildSessionFactory();
	private static final ThreadLocal<Session> sessionManagers = buildSessionManagers();

	private static SessionFactory buildSessionFactory() {
		try {
			StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
					.configure("/hibernate.cfg.xml").build();

			Metadata metadata = new MetadataSources(standardRegistry)
					.addResource("be/kapture/entities/Person.hbm.xml")
					.addResource("be/kapture/entities/ClothingItem.hbm.xml")
					.getMetadataBuilder()
					.applyImplicitNamingStrategy(ImplicitNamingStrategyJpaCompliantImpl.INSTANCE).build();

			SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
			return sessionFactory;

		} catch (Throwable ex) {
			System.err.println("initial SessionFactory creation failed " + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	private static ThreadLocal<Session> buildSessionManagers() {
		ThreadLocal<Session> sessionManagers = new ThreadLocal<>();
		sessionManagers.set(sessionFactory.getCurrentSession());
		return sessionManagers;
	}

	public static Session getSession() {
		Session session = sessionManagers.get();
		if(!session.isOpen()){
			sessionManagers.remove();
			session = sessionFactory.getCurrentSession();
			sessionManagers.set(session);
		}
		if(session.getTransaction() == null){
			session.beginTransaction();
		}
		return session;
	}
}
