package com.oracle.casting;

/**
 * Created by vanmoj1 on 10/04/2017.
 */
public abstract class Animal implements Mammal {
    @Override
    public void eat() {
        System.out.println("Eating...");
    }

    @Override
    public void move() {
        System.out.println("Moving...");
    }

    @Override
    public void sleep() {
        System.out.println("Sleeping...");
    }
}
