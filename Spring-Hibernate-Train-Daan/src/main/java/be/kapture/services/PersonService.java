package be.kapture.services;

import be.kapture.model.Person;

import java.util.List;

public interface PersonService {
    public void save(Person person);
    public List<Person> list();
}
