package be.kapture.tests;

import be.kapture.MocksApplication;
import be.kapture.controller.VraagController;
import be.kapture.entity.Vraag;
import be.kapture.repository.VraagRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static com.jayway.restassured.RestAssured.when;

/**
 * Created by peeters.t on 18/10/2017.
 */
@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MocksApplication.class)
public class VraagControllerTest {

    @Autowired
    private VraagRepository vraagRepository;

    private VraagController vraagController;

    @Test
    public void controllerTest_basic(){
        Vraag expectedVraag = new Vraag();
        Mockito.when(vraagRepository.findOne(1)).thenReturn(expectedVraag);
        Vraag vraag = vraagController.themaOutput(1);
        Assert.assertEquals(vraag ,expectedVraag );
    }


}
