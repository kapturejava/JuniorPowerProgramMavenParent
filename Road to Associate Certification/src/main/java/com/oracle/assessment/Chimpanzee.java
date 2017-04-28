package com.oracle.assessment;

/**
 * Created by vanmoj1 on 11/04/2017.
 */
class Primate {
    public Primate(int age) {
        System.out.println("Primate" + age);
    }
}

class Ape extends Primate {
    public Ape(int age) {
        super(age);
        System.out.println("Ape" + age);
    }
}

public class Chimpanzee extends Ape {
    Chimpanzee(int age) {
        super(age);
    }

    public static void main(String[] args) {
        new Chimpanzee(8);
    }
}
