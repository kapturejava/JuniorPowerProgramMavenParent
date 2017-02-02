package be.kapture.testsuites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import be.kapture.entities.PersonTest;
import be.kapture.entities.ClothingItemTest;

@RunWith(Suite.class)
@SuiteClasses({ PersonTest.class, ClothingItemTest.class })
public class EntityTests {

}