package be.kapture.services;

import static java.util.Objects.requireNonNull;

import java.util.List;

import be.kapture.entities.ClothingItem;
import be.kapture.entities.Person;
import be.kapture.repositories.ClothingItemRepository;
import be.kapture.repositories.PersonRepository;

public class PersonService {
	private PersonRepository personRepository;
	private ClothingItemRepository clothingItemRepository;
	
	public PersonService(PersonRepository pr, ClothingItemRepository cr){
		requireNonNull(pr);
		requireNonNull(cr);
		this.personRepository = pr;
		this.clothingItemRepository = cr;
	}
	
	public Person getPersonById(int id){
		return personRepository.read(id);
	}
	
	public List<ClothingItem> findFittingClothingItemsbyPersonId(int id){
		Person person = getPersonById(id);
		return clothingItemRepository.findClothingItemsBySize(person.getSize());
	} 
	
}
