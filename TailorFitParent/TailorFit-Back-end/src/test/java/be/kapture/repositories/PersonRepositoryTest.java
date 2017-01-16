package be.kapture.repositories;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

import org.junit.Before;
import org.junit.Test;

import be.kapture.entities.Person;
import be.kapture.enums.Gender;

public class PersonRepositoryTest extends AbstractRepositoryTest{

	private PersonRepository personRepository = new PersonRepository();
	private long id;
	private Person person;

	@Before
	public void before() {
		person = new Person("voornaam", "lastname", 180, Gender.MALE);
		id = person.getId();
	}

	@Test
	public void read_With_Negative_Id_Returns_Null() {
		assertNull(personRepository.read((long)-1));
	}

    @Test
    public void create() {
        // personRepository.create(person);
        // assertSame(person, personRepository.read(id));
    }

    @Test
    public void read() {
        // personRepository.create(person);
        // assertSame(person, personRepository.read(id));
    }

    @Test
    public void update() {
        // person.setFirstName("updateFirstname");
        // personRepository.update(person);
        // assertSame(person, personRepository.read(id));
    }

    @Test
    public void delete() {
        // personRepository.delete(person);
        // assertNull(personRepository.read(id));
    }

}
