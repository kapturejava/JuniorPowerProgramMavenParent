package be.kapture.testsuites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import be.kapture.repositories.ClothingItemRepositoryTest;
import be.kapture.repositories.PersonRepositoryTest;

@RunWith(Suite.class)
@SuiteClasses({ PersonRepositoryTest.class, ClothingItemRepositoryTest.class })
public class RepositoryTests {

}