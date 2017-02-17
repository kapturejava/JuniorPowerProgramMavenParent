package be.kapture.javaeight.model;

import java.util.List;
import java.util.function.Predicate;

/**
 * Created by peeteth on 10/02/2017.
 */

public class Person {

    private final String name;
    private final int age;
    private final Gender gender;

    public Person(String name, int age, Gender gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }


    public static void printNames(List<Person> persons, Predicate predicate) {
        persons.stream()
                .filter(predicate)
                .map(p -> ((Person) p).getName())
                .forEach(System.out::println);
    }
}
