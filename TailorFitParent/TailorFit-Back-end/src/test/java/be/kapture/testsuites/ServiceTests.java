package be.kapture.testsuites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import be.kapture.services.PersonServiceTest;

@RunWith(Suite.class)
@SuiteClasses({ PersonServiceTest.class })
public class ServiceTests {

}