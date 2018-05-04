package be.kapture.services;

import be.kapture.dao.CustomerDAO;
import be.kapture.model.Customer;
import org.springframework.transaction.annotation.Transactional;

class CustomerServiceImpl implements CustomerService {
    private CustomerDAO customerDAO;

    public CustomerServiceImpl(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    @Override
    @Transactional
    public void save(Customer customer) {
        customerDAO.save(customer);
    }
}
