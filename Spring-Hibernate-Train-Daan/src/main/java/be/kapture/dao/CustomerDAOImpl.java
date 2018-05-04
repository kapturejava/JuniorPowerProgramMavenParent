package be.kapture.dao;

import be.kapture.model.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

class CustomerDAOImpl implements CustomerDAO {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(Customer customer) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(customer);
        tx.commit();
        session.close();
    }
}
