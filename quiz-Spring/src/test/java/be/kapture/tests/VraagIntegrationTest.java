package be.kapture.tests;

import com.jayway.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.Test;

import static com.jayway.restassured.RestAssured.get;

/**
 * Created by peeters.t on 18/10/2017.
 */
public class VraagIntegrationTest {

    @BeforeClass
    public static void setUp() throws Exception {
        RestAssured.port = 8085;
    }

    @Test
    public void endPointTest(){
        get("/themaOut/1").then().assertThat().statusCode(200);
    }

}
