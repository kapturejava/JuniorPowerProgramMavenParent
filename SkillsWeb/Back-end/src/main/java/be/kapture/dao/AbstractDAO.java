package be.kapture.dao;

import org.hibernate.Session;

import be.kapture.util.HibernateUtil;

public abstract class AbstractDAO {
	
	protected Session getCurrentSession(){
		return HibernateUtil.getSessionFactory().getCurrentSession();
	}	

}
