package be.kapture.oefeningopexceptionsenpolymorphisme.classes;


import be.kapture.oefeningopexceptionsenpolymorphisme.exceptions.MadeUpException;

/**
 * Created by cromhjo on 28/04/2016.
 */
public class ClassB extends ClassA {

    public ClassB (int number){

        super(number);

    }

    public void setNumber(String number)throws MadeUpException{
        try {
            this.number = Integer.parseInt(number);
        }
        catch (IllegalArgumentException e){
            throw new MadeUpException();
        }

    }

    public void printNumber(){
        System.out.println("Printmethode uit classB: nummer = " + number);
    }
}


