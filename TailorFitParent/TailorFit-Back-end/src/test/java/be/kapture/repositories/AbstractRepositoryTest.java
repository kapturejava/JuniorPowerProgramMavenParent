package be.kapture.repositories;

import org.hibernate.Session;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import be.kapture.util.HibernateUtil;

public abstract class AbstractRepositoryTest {

    protected static Session session = HibernateUtil.getSession();
    
    protected AbstractRepositoryTest() {

    }
    
    @BeforeClass
    public static void beforeClass(){
    	session.beginTransaction();

    }

    @AfterClass
    public static void afterClass() {
        session.getTransaction().rollback();
        session = HibernateUtil.getSession();
    }

    @Test
    public abstract void update();

    @Test
    public abstract void delete();

    @Test
    public abstract void read_With_Negative_Id_Returns_Null();

}
