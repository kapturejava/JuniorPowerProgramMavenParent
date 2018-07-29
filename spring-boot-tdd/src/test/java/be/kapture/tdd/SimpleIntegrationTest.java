package be.kapture.tdd;

import be.kapture.tdd.domain.Car;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

/**
 * Created with IntelliJ IDEA.
 * User: Thomas
 * Date: 25/07/2018
 * Time: 20:42
 */

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
@Sql(scripts = "/cleanup.sql",executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class SimpleIntegrationTest {

    @Autowired
    private TestRestTemplate testRestTemplate;


    @Sql(scripts = "/prius.sql",executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(scripts = "/cleanup.sql",executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    @Test
    public void getCarsTest() {
        ResponseEntity<Car> response = testRestTemplate.getForEntity("/cars/prius", Car.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody().getName()).isEqualTo("prius");
        assertThat(response.getBody().getType()).isEqualTo("hybrid");
    }
}
