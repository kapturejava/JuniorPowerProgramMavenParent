package com.oracle.interfaces.functionalInterfaceExample;

/**
 * Created by vanmoj1 on 14/04/2017.
 */
@FunctionalInterface
public interface MyFirstFunctionalInterface {
    public void firstWork();

    default void doSomeMoreWork() {

    }

    default void doSomeMoreWork1() {
    }
}
