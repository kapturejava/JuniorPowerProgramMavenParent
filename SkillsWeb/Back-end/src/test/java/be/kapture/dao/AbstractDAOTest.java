package be.kapture.dao;

import org.hibernate.Session;
import org.junit.AfterClass;
import org.junit.BeforeClass;

import be.kapture.util.HibernateUtil;

public abstract class AbstractDAOTest {
	
	protected static Session session = HibernateUtil.getSession();
	
	@BeforeClass
	public static void beforeClass(){
		session.beginTransaction();
	}
	
	@AfterClass
	public static void afterClass(){
		session.getTransaction().rollback();
	}
	
	

}
