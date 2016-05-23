package be.kapture.dao;

import org.hibernate.Session;

import be.kapture.util.HibernateUtil;

public abstract class AbstractDAO<T> {

	final Class<T> typeParameterClass;

	public AbstractDAO(Class<T> typeParameterClass) {
		this.typeParameterClass = typeParameterClass;
	}

	public Session getCurrentSession() {
		return HibernateUtil.getSession();
	}

	public void create(T t) {
		getCurrentSession().save(t);
	}

	public void update(T t) {
		getCurrentSession().update(t);
	}

	public void delete(T t) {
		getCurrentSession().delete(t);
	}

	public T read(int id) {
		return (T) getCurrentSession().get(typeParameterClass, id);
	}

}
