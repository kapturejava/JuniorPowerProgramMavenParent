package be.kapture.tdd.repository;

import be.kapture.tdd.domain.Car;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.*;


/**
 * Created with IntelliJ IDEA.
 * User: Thomas
 * Date: 29/07/2018
 * Time: 19:56
 */

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
@Sql(scripts = "/cleanup.sql",executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class CarRepositoryTest {

    @Autowired
    private CarRepository repository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void getCar_returnsCarDetails(){
        Car savedCar = entityManager.persistFlushFind(new Car("prius", "hybrid"));

        Car car = repository.findByName("prius");

        assertThat(car.getName()).isEqualTo(savedCar.getName());
        assertThat(car.getType()).isEqualTo(savedCar.getType());

    }

    @After
    public void breakDown(){
        entityManager.clear();
    }

}