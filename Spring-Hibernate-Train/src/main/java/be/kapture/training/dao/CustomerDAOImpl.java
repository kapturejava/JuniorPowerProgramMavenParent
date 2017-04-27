package be.kapture.training.dao;

import be.kapture.training.model.Customer;
import org.hibernate.SessionFactory;

/**
 * Created by vanmoj1 on 3/04/2017.
 */
public class CustomerDAOImpl implements CustomerDAO {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void create(Customer customer) {
        sessionFactory.getCurrentSession().save(customer);
    }

}
