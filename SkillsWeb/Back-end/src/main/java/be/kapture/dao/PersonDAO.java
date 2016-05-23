package be.kapture.dao;

import java.util.List;

import be.kapture.entities.Person;

public class PersonDAO extends AbstractDAO<Person> {

	public PersonDAO(){
		this(Person.class);
	}
	
	protected PersonDAO(Class<Person> typeParameterClass) {
		super(typeParameterClass);
	}
	
	@SuppressWarnings("unchecked")
	public List<Person> findAll(){
		return (List<Person>) getCurrentSession().createQuery("select p from Person p").list();
	}
}
