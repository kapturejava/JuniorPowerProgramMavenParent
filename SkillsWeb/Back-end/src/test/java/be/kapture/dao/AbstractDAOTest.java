package be.kapture.dao;

import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;

import be.kapture.util.HibernateUtil;

public abstract class AbstractDAOTest {
	
	protected Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	
	@Before
	public void before(){
		session.getTransaction().begin();
	}
	
	@After
	public void after(){
		session.getTransaction().rollback();		
	}

}
