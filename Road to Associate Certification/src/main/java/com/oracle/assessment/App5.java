package com.oracle.assessment;

import java.util.Arrays;
import java.util.List;

/**
 * Created by vanmoj1 on 12/04/2017.
 */
public class App5 {
    static int st_int = 5;

    private void myMethod() {
        st_int = 15;
    }

    public static void main(String[] args) {
        st_int = 10;
        App5 app5 = new App5();
        app5.myMethod();
        System.out.println(st_int);

        String[] myNames = new String[5];
        System.out.println(myNames.length);
        myNames[4] = "Free";
        List myListOfNames = Arrays.asList(myNames);
    }
}
