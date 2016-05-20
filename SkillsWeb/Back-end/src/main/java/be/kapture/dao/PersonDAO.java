package be.kapture.dao;

import be.kapture.entities.Person;

public class PersonDAO extends AbstractDAO {

	@Override
	public Person read(int id) {
		return getCurrentSession().get(Person.class, id);
	}

}
