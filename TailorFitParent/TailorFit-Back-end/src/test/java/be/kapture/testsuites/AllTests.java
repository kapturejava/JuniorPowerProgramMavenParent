package be.kapture.testsuites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ EntityTests.class, RepositoryTests.class, ServiceTests.class })
public class AllTests {

}
