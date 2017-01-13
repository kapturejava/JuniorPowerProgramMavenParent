package be.kapture.entities;


import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertNotSame;

import org.junit.Before;
import org.junit.Test;

import be.kapture.enums.Gender;

public class PersonTest {
	
	private Person person, otherPerson;
	
	
	@Before
	public void before() {
		person = new Person("voornaam", "lastname", 180, Gender.MALE);
		otherPerson = new Person("voornaam", "lastname", 180, Gender.MALE);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void createPersonWithEmptyFirstname() {
		person = new Person("", "lastname", 195, Gender.MALE);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void createPersonWithFirstnameNull() {
		person = new Person(null, "lastname", 195, Gender.MALE);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void createPersonWithEmptyLastname() {
		person = new Person("firstname", "", 195, Gender.MALE);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void createPersonWithLastnameNull() {
		person = new Person("firstname", null, 195, Gender.MALE);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void createPersonWithNegativeSize() {
		person = new Person("firstname", "lastname", -7, Gender.MALE);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void createPersonWithSizeZero() {
		person = new Person("firstname", "lastname", 0, Gender.MALE);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void createPersonWithGenderNull() {
		person = new Person("firstname", "lastname", 115, null);
	}
	
	public void personEqualsOtherPerson() {
		assertSame(person, otherPerson);
		
		otherPerson.setFirstName("otherFirstName");
		assertNotSame(person, otherPerson);
		person.setFirstName("otherFirstName");
		assertSame(person, otherPerson);
		
		otherPerson.setLastName("otherFirstName");
		assertNotSame(person, otherPerson);
		person.setLastName("otherFirstName");
		assertSame(person, otherPerson);
		
		otherPerson.setSize(115);
		assertNotSame(person, otherPerson);
		person.setSize(115);
		assertSame(person, otherPerson);
		
		otherPerson.setGender(Gender.FEMALE);
		assertNotSame(person, otherPerson);
		person.setGender(Gender.FEMALE);
		assertSame(person, otherPerson);
	}
}
