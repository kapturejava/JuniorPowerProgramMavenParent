package com.oracle.recursion;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Created by vanmoj1 on 10/04/2017.
 */
public class App2 {
    public static void main(String[] args) {
        Random r = new Random();
        Set<Integer> aSet = new HashSet<Integer>();
        int anInt;
        do {
            anInt = r.nextInt(10);
            if (anInt % 2 == 0)
                continue;
            System.out.println(anInt);
        } while (aSet.add(anInt));
        System.out.println(aSet);
    }
}
