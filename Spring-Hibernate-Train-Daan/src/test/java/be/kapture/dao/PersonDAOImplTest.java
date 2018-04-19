package be.kapture.dao;

import be.kapture.model.Person;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

public class PersonDAOImplTest {
    private PersonDAO personDAO = Mockito.mock(PersonDAO.class);
    private List<Person> persons;

    @Before
    public void before() {
        int i = 1;
        persons = Arrays.asList(new Person("Daan", "Belgium"), new Person("Jos", "Germany"));
        for (Person person :
                persons) {
            person.setId(i);
            i++;
        }
        Mockito.when(personDAO.list()).thenReturn(persons);
    }

    @Test
    public void listReturnsAListOfPersons() {
        Assert.assertSame(persons, personDAO.list());
    }
}
