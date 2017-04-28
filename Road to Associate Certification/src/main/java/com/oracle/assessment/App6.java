package com.oracle.assessment;

/**
 * Created by vanmoj1 on 14/04/2017.
 */
public class App6 {
    public static void swing() {
        System.out.println("swing ");
    }

    public void climb() {
        System.out.println("climb ");
    }

    public static void play() {
        swing();
        //climb();
    }

    public static void main(String[] args) {
        App6 app6 = new App6();
        app6.play();
        App6 app61 = null;
        app61.play();
    }
}
