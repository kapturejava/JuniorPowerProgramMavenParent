package be.kapture.oefeningopexceptionsenpolymorphisme.classes;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cromhjo on 28/04/2016.
 */
public class ClassA {

    protected int number;

    public ClassA(int number){
        this.number = number;
    }

    public int getNumber(){
        return number;
    }

    public void setNumber(String number) throws IllegalArgumentException{
        this.number = Integer.parseInt(number);
        int j=0;
        for (int i = 0; i <= i && j< i ; ++i) {

        }

    }



    public void printNumber(){
        System.out.println("Printmethode uit classA: nummer = " + number);
    }
}
