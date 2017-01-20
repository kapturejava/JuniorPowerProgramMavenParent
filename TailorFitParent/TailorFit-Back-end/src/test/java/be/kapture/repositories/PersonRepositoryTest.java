package be.kapture.repositories;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

import org.junit.Before;
import org.junit.Test;

import be.kapture.entities.Person;
import be.kapture.enums.Gender;

public class PersonRepositoryTest extends AbstractRepositoryTest {

    private Person dario = new Person("d", "j", 185, Gender.MALE);
    private PersonRepository personRepository = new PersonRepository();
    private long id;

    @Before
    public void before() {
        // person = new Person("voornaam", "lastname", 180, Gender.MALE);
        personRepository.create(dario);
        id = dario.getId();
    }

    @Test
    public void read_With_Negative_Id_Returns_Null() {
        assertNull(personRepository.read((long) -1));
    }

    @Test
    public void create_And_Read() {
        assertSame(dario, personRepository.read(id));
    }

    @Test
    public void update() {
        dario.setFirstName("updateFirstname");
        personRepository.update(dario);
        assertSame(dario, personRepository.read(id));
    }

    @Test
    public void delete() {
        personRepository.delete(dario);
        assertNull(personRepository.read(id));
    }

}
