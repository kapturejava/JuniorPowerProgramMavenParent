package be.kapture.dao;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

import org.junit.Before;
import org.junit.Test;

public class PersonDAOTest extends AbstractDAOTest {

	private PersonDAO personDAO = new PersonDAO();
	private int id;

	@Before
	public void before() {
		personDAO.create(person);
		id = person.getId();
	}

	@Test
	public void read_With_Negative_Id_Returns_Null() {
		assertNull(personDAO.read(-1));
	}

	@Test
	public void create_And_Read() {
		assertSame(person, personDAO.read(id));
	}

	@Test
	public void update() {
		person.setFirstName("updateFirstname");
		personDAO.update(person);
		assertSame(person, personDAO.read(id));
	}

	@Test
	public void delete() {
		personDAO.delete(person);
		assertNull(personDAO.read(id));
	}

}
