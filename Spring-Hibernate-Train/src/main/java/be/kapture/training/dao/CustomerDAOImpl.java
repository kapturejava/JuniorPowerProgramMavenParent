package be.kapture.training.dao;

import be.kapture.training.model.Customer;
import be.kapture.training.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by vanmoj1 on 3/04/2017.
 */
public class CustomerDAOImpl implements CustomerDAO {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(Customer c) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(c);
        tx.commit();
        session.close();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Customer> list() {
        Session session = this.sessionFactory.openSession();
        List<Customer> customerList = session.createQuery("from Customer").list();
        session.close();
        return customerList;
    }
}
