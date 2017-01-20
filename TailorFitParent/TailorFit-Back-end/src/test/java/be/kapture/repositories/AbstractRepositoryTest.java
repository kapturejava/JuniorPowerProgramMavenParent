package be.kapture.repositories;

import org.hibernate.Session;
import org.junit.AfterClass;
import org.junit.Test;

import be.kapture.util.HibernateUtil;

public abstract class AbstractRepositoryTest {

    protected static Session session = HibernateUtil.getSession();
    
    protected AbstractRepositoryTest() {

    }

    @AfterClass
    public static void afterClass() {
        session.getTransaction().rollback();
    }

    @Test
    public abstract void create();

    @Test
    public abstract void read();

    @Test
    public abstract void update();

    @Test
    public abstract void delete();

    @Test
    public abstract void read_With_Negative_Id_Returns_Null();

}
