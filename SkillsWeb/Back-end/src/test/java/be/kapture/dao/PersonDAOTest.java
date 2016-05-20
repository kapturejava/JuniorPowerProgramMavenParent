package be.kapture.dao;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

import org.junit.Test;

public class PersonDAOTest extends AbstractDAOTest {

	private PersonDAO personDAO = new PersonDAO();

	@Test
	public void read_With_Negative_Id_Returns_Null() {
		assertNull(personDAO.read(-1));
	}

	@Test
	public void create_And_Read() {
		personDAO.create(person);
		int id = person.getId();
		assertSame(person, personDAO.read(id));
	}

	@Test
	public void update() {
		personDAO.create(person);
		int id = person.getId();
		person.setFirstName("updateFirstname");
		personDAO.update(person);
		assertSame(person, personDAO.read(id));
	}

	@Test
	public void delete() {
		personDAO.create(person);
		int id = person.getId();
		personDAO.delete(person);
		assertNull(personDAO.read(id));
	}

}
