package be.kapture.training.main;

import be.kapture.training.dao.CustomerDAO;
import be.kapture.training.dao.PersonDAO;
import be.kapture.training.logging.LogMyInfo;
import be.kapture.training.model.Address;
import be.kapture.training.model.Customer;
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
        CustomerDAO customerDAO = context.getBean(CustomerDAO.class);

        Person person = new Person();
        person.setName("J");
        person.setCountry("Belgium");

        Address customerAddress = new Address();
        customerAddress.setAddress("Klokjes");
        customerAddress.setCountry("Belgium");

        Customer customer = new Customer();
        customer.setName("Leo");
        customer.setAddress(customerAddress);

        LogMyInfo.log();

        personDAO.save(person);

        customerDAO.create(customer);

        System.out.println("Person::" + person);

        List<Person> list = personDAO.list();

        for (Person p : list) {
            System.out.println("Person List::" + p);
        }
        //close resources
        context.close();
    }
}