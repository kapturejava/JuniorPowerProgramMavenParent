package be.kapture.dao;

import be.kapture.model.Person;

import java.util.List;

public interface PersonDAO {

    public void save(Person p);

    public List<Person> list();
}