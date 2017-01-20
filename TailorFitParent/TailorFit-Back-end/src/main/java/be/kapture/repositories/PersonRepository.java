package be.kapture.repositories;

import be.kapture.entities.Person;

public class PersonRepository extends AbstractRepository<Person> {

    public PersonRepository() {
        this(Person.class);
    }

    public PersonRepository(Class<Person> typeParameterClass) {
        super(typeParameterClass);
    }

}
