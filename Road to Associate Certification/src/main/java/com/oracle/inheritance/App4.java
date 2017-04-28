package com.oracle.inheritance;

/**
 * Created by vanmoj1 on 10/04/2017.
 */
class M {
    N b = new N();

    M() {
        System.out.print("X");
    }
}

class N {
    N() {
        System.out.print("Y");
    }
}

public class App4 extends M {
    N y = new N();

    App4() {
        System.out.print("Z");
    }

    public static void main(String[] args) {
        new App4();
    }
}
