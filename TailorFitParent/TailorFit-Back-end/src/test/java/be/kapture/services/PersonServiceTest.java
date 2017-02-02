package be.kapture.services;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.when;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.Every.everyItem;

import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import be.kapture.entities.ClothingItem;
import be.kapture.entities.Person;
import be.kapture.enums.Gender;
import be.kapture.repositories.ClothingItemRepository;
import be.kapture.repositories.PersonRepository;

public class PersonServiceTest {
	
    @Mock
	private PersonRepository personRepository;
    @Mock
    private ClothingItemRepository clothingItemRepository;
    
    private PersonService personService;
    
    Person person;
    
    List<ClothingItem> list;
    
    int id;
	
	@Before
	public void setup()
	{	
		MockitoAnnotations.initMocks(this);
		person = new Person("Jo", "Van Montfort", 115, Gender.MALE /* ??? */);
		personService = new PersonService(personRepository, clothingItemRepository);
		id = 1;
		list = Arrays.asList(new ClothingItem(120, "RED"), new ClothingItem(125, "RED"), new ClothingItem(130, "RED"));
	}
	
	@Test
	public void getPersonByIdTest(){
		when(personRepository.read(id)).thenReturn(person);
		assertThat(person, is(personService.getPersonById(id)));
	}
	
	@Test
	public void getFittingClothingItemsByPersonId(){
		when(personRepository.read(id)).thenReturn(person);
		when(clothingItemRepository.findClothingItemsBySize(115)).thenReturn(list);
		assertThat(list, is(personService.findFittingClothingItemsbyPersonId(id)));
	}
	
	@After
	public void teardown()
	{
	}

}