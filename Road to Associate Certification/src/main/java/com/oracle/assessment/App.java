package com.oracle.assessment;

/**
 * Created by vanmoj1 on 11/04/2017.
 */
interface HasTail {
    int getTailLength();
}

abstract class Puma implements HasTail {
    @Override
    public int getTailLength() {
        return 4;
    }
}

public class App extends Puma {
    private static int $;

    public static void main(String[] args) {
        App app = new App();
        System.out.println(app.getTailLength());
    }

    public int getTailLength(int length) {
        return 2;
    }
}
