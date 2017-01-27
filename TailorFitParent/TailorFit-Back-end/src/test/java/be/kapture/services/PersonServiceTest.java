package be.kapture.services;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import be.kapture.entities.Person;
import be.kapture.enums.Gender;
import be.kapture.repositories.PersonRepository;

@RunWith(MockitoJUnitRunner.class)
public class PersonServiceTest {
	
    private static final PersonRepository personRepository = new PersonRepository();
    
    @Mock
	private Person person;
	
	@Before
	public void setup()
	{	
		person = new Person("Jo", "Van Montfort", 7, Gender.MALE);
	}
	
	@After
	public void teardown()
	{
	}

}