package be.kapture.services;

import be.kapture.dao.PersonDAO;
import be.kapture.model.Person;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
class PersonServiceImpl implements PersonService {
    private PersonDAO personDAO;

    public PersonServiceImpl(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @Override
    public void save(Person person) {
        personDAO.save(person);
    }

    @Override
    public List<Person> list() {
       return personDAO.list();
    }
}
