package be.kapture.oefeningopexceptionsenpolymorphisme.classes;

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
    }

    public void printNumber(){
        System.out.println("Printmethode uit classA: nummer = " + number);
    }
}
