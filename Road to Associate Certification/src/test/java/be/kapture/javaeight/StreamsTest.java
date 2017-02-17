package be.kapture.javaeight;

import be.kapture.javaeight.model.Gender;
import be.kapture.javaeight.model.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static be.kapture.javaeight.model.Person.printNames;

/**
 * Created by peeteth on 10/02/2017.
 */
public class StreamsTest {

    @Test
    public void personStreamTest(){
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Albert", 80, Gender.MALE));
        persons.add(new Person("Ben", 15, Gender.MALE));
        persons.add(new Person("Charlote", 20, Gender.FEMALE));
        persons.add(new Person("Dean", 6, Gender.MALE));
        persons.add(new Person("Elaine", 17, Gender.FEMALE));

        // How much code would you need to do the following without Lambdas?
        System.out.println("----------Printing Persons with age less than 18----------");
        printNames(persons, p -> ((Person) p).getAge() < 18);
        System.out.println("\n--------Printing all Males-------------");
        printNames(persons, p -> ((Person) p).getGender() == Gender.MALE);
        System.out.println("\n---------Printing Persons with Names starting With C------------");
        printNames(persons, p -> ((Person) p).getName().startsWith("C"));
    }
    


}
