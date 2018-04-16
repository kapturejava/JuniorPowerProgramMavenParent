package be.kapture.main;

import be.kapture.dao.PersonDAO;
import be.kapture.model.Person;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class SpringHibernateMain {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring4.xml");

        PersonDAO personDAO = context.getBean(PersonDAO.class);

        Person person = new Person();
        person.setName("Bill");
        person.setCountry("Estonia");

        personDAO.save(person);

        System.out.println("Person::" + person);

        List<Person> list = personDAO.list();

        for (Person p : list
             ) {
            System.out.println("Person List::" + p);
        }
        //close resources
        context.close();
    }
}
