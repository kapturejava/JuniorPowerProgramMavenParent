package be.kapture.repositories;

import be.kapture.entities.Person;

public class PersonRepository extends AbstractRepository<Person> {

    public PersonRepository() {
        this(Person.class);
    }

    public PersonRepository(Class<Person> typeParameterClass) {
        super(typeParameterClass);
    }

    public void create(Person person) {

    }

    public Object read(long l) {
        return null;
    }
    //
    // public void update(Person person) {
    // // TODO Auto-generated method stub
    //
    // }
    //
    // public void delete(Person person) {
    // // TODO Auto-generated method stub
    //
    // }

}
