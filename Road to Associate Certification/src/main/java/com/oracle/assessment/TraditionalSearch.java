package com.oracle.assessment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vanmoj1 on 11/04/2017.
 */
public class TraditionalSearch {
    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("fish", false, true));
        animals.add(new Animal("kangaroo", true, false));
        animals.add(new Animal("rabbit", true, false));
        animals.add(new Animal("turtle", false, true));

        //print(animals, new CheckIfHopper());
        print(animals, a -> a.isCanHop());

        print(animals, a -> a.isCanSwim());
    }

    private static void print(List<Animal> animals, CheckTrait checker) {
        for (Animal animal : animals) {
            if (checker.test(animal)) {
                System.out.println(animal + " ");
            }
        }
        System.out.println();
    }
}
