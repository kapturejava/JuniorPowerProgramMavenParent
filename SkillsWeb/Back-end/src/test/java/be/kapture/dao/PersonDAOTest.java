package be.kapture.dao;

import static org.junit.Assert.assertNull;

import org.junit.Test;

public class PersonDAOTest extends AbstractDAOTest {

	private PersonDAO personDAO = new PersonDAO();

	@Test
	public void read_With_Negative_Id_Returns_Null() {
		assertNull(personDAO.read(-1));
	}

}
