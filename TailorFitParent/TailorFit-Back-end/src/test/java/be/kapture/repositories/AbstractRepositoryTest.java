package be.kapture.repositories;

import org.hibernate.Session;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import be.kapture.util.HibernateUtil;

public abstract class AbstractRepositoryTest {

    protected AbstractRepositoryTest() {

    }
    
    @BeforeClass
    public static void beforeClass(){
    	HibernateUtil.getSession().getTransaction().begin();
    }

    @AfterClass
    public static void afterClass() {
    	HibernateUtil.getSession().getTransaction().rollback();
    	HibernateUtil.getSession().close();
    }

    @Test
    public abstract void update();

    @Test
    public abstract void delete();

    @Test
    public abstract void read_With_Negative_Id_Returns_Null();

}
