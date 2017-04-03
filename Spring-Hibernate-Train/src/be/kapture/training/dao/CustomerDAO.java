package be.kapture.training.dao;

import be.kapture.training.model.*;

import java.util.List;

/**
 * Created by vanmoj1 on 3/04/2017.
 */
public interface CustomerDAO {
    public void save(Customer c);

    public List<Customer> list();
}
