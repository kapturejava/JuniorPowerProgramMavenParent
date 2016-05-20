package be.kapture.dao;

import be.kapture.entities.Person;

public class PersonDAO extends AbstractDAO<Person> {

	public PersonDAO(){
		this(Person.class);
	}
	
	protected PersonDAO(Class<Person> typeParameterClass) {
		super(typeParameterClass);
	}
}
