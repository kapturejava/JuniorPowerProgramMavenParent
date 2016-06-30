package be.kapture.services;

import be.kapture.dao.PersonDAO;
import be.kapture.entities.Person;

import java.util.List;

/**
 * Created by Yannick Thibos.
 */
public class PersonService {

    private PersonDAO personDAO = new PersonDAO();

    public List<Person> findAll() {
        List<Person> foundPeople = personDAO.findAll();
        return foundPeople;
    }

}
