package be.kapture.training.main;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import be.kapture.training.model.*;
import be.kapture.training.dao.*;

/**
 * Created by vanmoj1 on 3/04/2017.
 */
public class SpringHibernateMain {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        PersonDAO personDAO = context.getBean(PersonDAO.class);

        Person person = new Person();
        person.setName("J"); person.setCountry("Belgium");

        personDAO.save(person);

        System.out.println("Person::"+person);

        List<Person> list = personDAO.list();

        for(Person p : list){
            System.out.println("Person List::"+p);
        }
        //close resources
        context.close();
    }
}
