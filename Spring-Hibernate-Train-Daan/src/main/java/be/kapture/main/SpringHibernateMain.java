package be.kapture.main;

import be.kapture.dao.CustomerDAO;
import be.kapture.dao.PersonDAO;
import be.kapture.model.Address;
import be.kapture.model.Customer;
import be.kapture.model.Person;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class SpringHibernateMain {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("spring4.xml");

        PersonDAO personDAO = context.getBean(PersonDAO.class);
        CustomerDAO customerDAO = context.getBean(CustomerDAO.class);

        Customer customer = new Customer();
        customer.setName("Dennis");
        Address address = new Address("Antwerp", "Belgium");
        customer.setAddress(address);

        customerDAO.save(customer);

        System.out.println(customer);


        List<Person> list = personDAO.list();

        for (Person p : list
             ) {
            System.out.println("Person List::" + p);
        }
        //close resources
        context.close();
    }
}
