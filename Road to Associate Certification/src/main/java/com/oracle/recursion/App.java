package com.oracle.recursion;

/**
 * Created by vanmoj1 on 5/04/2017.
 */
public class App {
    private static int[] numbers = {1, 2, 3};

    public static void main(String[] args) {
        Recursion recursion = new Recursion();

        System.out.println(recursion.sum(numbers));
    }
}
