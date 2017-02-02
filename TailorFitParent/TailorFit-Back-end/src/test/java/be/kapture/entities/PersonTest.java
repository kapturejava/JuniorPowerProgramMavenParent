package be.kapture.entities;


import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

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
	
	@Test
	public void personEqualsOtherPerson() {
		assertEquals(person, otherPerson);
		
		otherPerson.setFirstName("otherFirstName");
		assertNotEquals(person, otherPerson);
		person.setFirstName("otherFirstName");
		assertEquals(person, otherPerson);
		
		otherPerson.setLastName("otherFirstName");
		assertNotEquals(person, otherPerson);
		person.setLastName("otherFirstName");
		assertEquals(person, otherPerson);
		
		otherPerson.setSize(115);
		assertNotEquals(person, otherPerson);
		person.setSize(115);
		assertEquals(person, otherPerson);
		
		otherPerson.setGender(Gender.FEMALE);
		assertNotEquals(person, otherPerson);
		person.setGender(Gender.FEMALE);
		assertEquals(person, otherPerson);
	}
}
