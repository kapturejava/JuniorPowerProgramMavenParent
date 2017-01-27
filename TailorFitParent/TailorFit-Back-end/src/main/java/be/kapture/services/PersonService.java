package be.kapture.services;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import be.kapture.entities.ClothingItem;
import be.kapture.entities.Person;
import be.kapture.repositories.ClothingItemRepository;
import be.kapture.repositories.PersonRepository;
import be.kapture.util.HibernateUtil;

public class PersonService {
	private static final PersonRepository PERSON_REPOSITORY = new PersonRepository();
	private static final ClothingItemRepository CLOTHING_ITEM_REPOSITORY = new ClothingItemRepository(ClothingItem.class);
	
	public Person getPersonById(int id){
		PERSON_REPOSITORY.read(id);
		return null;
	}
	
	public List<Person> findFittingClothingItemsbyPersonId(int id){
		Person person = getPersonById(id);
		Session session = HibernateUtil.getSession();
		return null;
		
	} 
	
}
