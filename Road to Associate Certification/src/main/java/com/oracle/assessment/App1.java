package com.oracle.assessment;

/**
 * Created by vanmoj1 on 11/04/2017.
 */
class Mammal {
    public Mammal(int age) {
        System.out.println("Mammal");
    }
}

public class App1 extends Mammal {
    public App1() {
        super(8);
        System.out.println("App1");
    }
}
