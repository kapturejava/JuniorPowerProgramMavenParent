package be.kapture.dao;

import org.hibernate.Session;

import be.kapture.util.HibernateUtil;

public abstract class AbstractDAO<T> {

	final Class<T> typeParameterClass;

	protected AbstractDAO(Class<T> typeParameterClass) {
		this.typeParameterClass = typeParameterClass;
	}

	protected Session getCurrentSession() {
		return HibernateUtil.getSession();
	}

	protected void create(T t) {
		getCurrentSession().save(t);
	}

	protected void update(T t) {
		getCurrentSession().update(t);
	}

	protected void delete(T t) {
		getCurrentSession().delete(t);
	}

	protected T read(int id) {
		return (T) getCurrentSession().get(typeParameterClass, id);
	}

}
