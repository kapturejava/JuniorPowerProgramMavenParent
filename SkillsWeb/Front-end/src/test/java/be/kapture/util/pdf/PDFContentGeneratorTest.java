package be.kapture.util.pdf;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

import be.kapture.dao.PersonDAO;
import be.kapture.entities.Person;
import be.kapture.util.HibernateUtil;

public class PDFContentGeneratorTest {
	
	private PersonDAO personDAO;
	private PDFContentGenerator pdfContentGenerator = new PDFContentGenerator();
	
	@Before
	public void before(){
		personDAO = mock(PersonDAO.class);
		Person person1 = new Person();
		person1.setId(1);
		person1.setFirstName("firstname1");
		person1.setLastName("lastname1");
		Person person2 = new Person();
		person2.setId(2);
		person2.setFirstName("firstname2");
		person2.setLastName("lastname2");
		
		when(personDAO.findAll()).thenReturn(asList(person1, person2));		
	}
	
	@Test	
	public void createContent(){
		HibernateUtil.getSession().beginTransaction();
		pdfContentGenerator.generate("testPDF");
		assertTrue(new File("testPDF.pdf").exists());		
	}

}
