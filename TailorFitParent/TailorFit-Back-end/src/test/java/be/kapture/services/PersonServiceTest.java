package be.kapture.services;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import be.kapture.entities.ClothingItem;
import be.kapture.entities.Person;
import be.kapture.enums.Gender;
import be.kapture.repositories.ClothingItemRepository;
import be.kapture.repositories.PersonRepository;

@RunWith(MockitoJUnitRunner.class)
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
		person = new Person("Jo", "Van Montfort", 115, Gender.MALE /* ??? */);
		personService = new PersonService(personRepository, clothingItemRepository);
		id = 1;
		list = new ArrayList<>();
		ClothingItem item1 = new ClothingItem(120, "RED");
		ClothingItem item2 = new ClothingItem(125, "RED");
		ClothingItem item3 = new ClothingItem(130, "RED");
		list.add(item1);
		list.add(item2);
		list.add(item3);
		
		when(personService.getPersonById(1)).thenReturn(person);
		when(clothingItemRepository.findClothingItemsBySize(115)).thenReturn(list);
	}
	
	@Test
	public void getPersonByIdTest(){
		assertSame(person, personService.getPersonById(id));
	}
	
	@Test
	public void getFittingClothingItemsByPersonId(){
		assertSame(list, personService.findFittingClothingItemsbyPersonId(id));
	}
	
	
	@After
	public void teardown()
	{
	}

}