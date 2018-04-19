package be.kapture.dao;

import be.kapture.datasource.TestDataSourceConfig;
import be.kapture.model.Person;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestDataSourceConfig.class, TestDAOConfig.class})
@Transactional
public class PersonDAOTest {
    @Autowired
    private PersonDAO personDAO;

    @Test
    public void save() {
        Person person = new Person("Bernard", "Austria");
        personDAO.save(person);
        Assert.assertNotEquals(0, person.getId());
    }
}
