package be.kapture.dao;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

import org.junit.Before;
import org.junit.Test;

import be.kapture.entities.Person;

public class PersonDAOTest extends AbstractDAOTest {

	private PersonDAO personDAO = new PersonDAO();
	private Person person;

	@Before
	public void before() {
		person = new Person();
		person.setFirstName("firstname");
		person.setLastName("lastname");
	}

	@Test
	public void read_With_Negative_Id_Returns_Null() {
		assertNull(personDAO.read(-1));
	}

	@Test
	public void create() {
		personDAO.create(person);
		assertSame(personDAO.read(person.getId()), person);
	}

}
