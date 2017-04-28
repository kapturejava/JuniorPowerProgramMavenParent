package com.oracle.inheritance;

class X {
    public void test() throws Exception {
        throw new Exception();
    }
}

class Y extends X {
    public void test() {
    }
}

public class App2 {

    public static void main(String args[]) {

        Y y = new Y();
        y.test();

        X x = y;
        try {
            x.test();
        } catch (Exception e) {
            System.out.println("catch exception");
        }
    }

}
