package be.kapture.training.main;

import be.kapture.training.dao.PersonDAO;
import be.kapture.training.logging.LogMyInfo;
import be.kapture.training.model.Person;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by vanmoj1 on 3/04/2017.
 */
public class SpringHibernateMain {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        PersonDAO personDAO = context.getBean(PersonDAO.class);

        Person person = new Person();
        person.setName("J");
        person.setCountry("Belgium");

        LogMyInfo.log();

        personDAO.save(person);

        System.out.println("Person::" + person);

        List<Person> list = personDAO.list();

        for (Person p : list) {
            System.out.println("Person List::" + p);
        }
        //close resources
        context.close();
    }
}
