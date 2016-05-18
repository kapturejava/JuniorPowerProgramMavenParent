package be.kapture.dao;

import org.hibernate.SessionFactory;

import be.kapture.util.HibernateUtil;

public abstract class AbstractDAO {
	
	protected SessionFactory getSessionFactory(){
		return HibernateUtil.getSessionFactory();
	}

}
