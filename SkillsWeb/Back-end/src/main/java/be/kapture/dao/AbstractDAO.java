package be.kapture.dao;

import org.hibernate.Session;

import be.kapture.util.HibernateUtil;

public abstract class AbstractDAO {
	
	
	
	protected Session getCurrentSession(){
		return HibernateUtil.getSession();
	}
	
	protected <T> void create(T t){
		getCurrentSession().save(t);
	}
	
	protected <T> void update(T t) {
		getCurrentSession().update(t);
	}
	
	protected <T> void delete(T t){
		getCurrentSession().delete(t);
	}

	public abstract Object read(int id);
	
	
}
