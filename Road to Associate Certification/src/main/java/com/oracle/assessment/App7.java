package com.oracle.assessment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vanmoj1 on 14/04/2017.
 */
public class App7 {
    public static void main(String[] args) {
        List<String> bunnies = new ArrayList<>();
        bunnies.add("long ear");
        bunnies.add("floppy");
        bunnies.add("hoppy");
        System.out.println(bunnies);
        bunnies.removeIf(s -> s.charAt(0) != 'h');
        System.out.println(bunnies);
        bunnies.removeIf(s -> s.isEmpty());
        System.out.println(bunnies);
    }
}
