package be.kapture.training.dao;

import be.kapture.training.model.Customer;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by vanmoj1 on 3/04/2017.
 */
public class CustomerDAOImpl implements CustomerDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

//    @Autowired
//    private HibernateTemplate template;

    @Override
    public void create(Customer customer) {
        //String queryCustomer = "insert into Customer(id, name) values (?,?)";
        //String queryAddress = "insert into Address (id, address,country)" + " values (?,?,?)";
        //String findCustomer = "SELECT c FROM Customer c WHERE c.name LIKE ?";
        Transaction transaction = sessionFactory.getCurrentSession().beginTransaction();
        sessionFactory.getCurrentSession().save(customer.getAddress());
        sessionFactory.getCurrentSession().save(customer);
        transaction.commit();
//        template.bulkUpdate(queryCustomer, customer.getId(),
//                customer.getName());
//        template.bulkUpdate(queryAddress, customer.getId(),
//                customer.getAddress().getAddress(),
//                customer.getAddress().getCountry());
//        template.find(findCustomer);
    }

}
