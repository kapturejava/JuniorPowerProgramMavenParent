package be.kapture.oefeningopexceptionsenpolymorphisme.classes;


import be.kapture.oefeningopexceptionsenpolymorphisme.exceptions.MadeUpException;

/**
 * Created by cromhjo on 28/04/2016.
 */
public class MainClass {

    public static void main(String [] args){
        ClassA classAObject = new ClassA(1);
        ClassB classBObject = new ClassB(2);
        ClassA classBObjectInARef = new ClassB(3);
        classAObject.printNumber();
        classBObject.printNumber();
        classBObjectInARef.printNumber();

        try{
           classAObject.setNumber("a");
        }
        catch (IllegalArgumentException e){
            System.out.println("classAObject throwed " + e.getClass().getSimpleName());
        }

        try{
            classBObject.setNumber("b");
        }
        catch (IllegalArgumentException e){
            System.out.println("classBObject throwed " + (e instanceof MadeUpException ? ((MadeUpException) e).getClass().getSimpleName() : e.getClass().getSimpleName()));
        }
        try{
            classBObjectInARef.setNumber("c");
        }
        catch (IllegalArgumentException e){
            System.out.println("classBObjectInARef throwed " + (e instanceof MadeUpException? ((MadeUpException) e).getClass().getSimpleName() : e.getClass().getSimpleName()));
        }

        System.out.println("post en pre incrementoperatoren");
        int i = 0;
        int j = 0;
        int z = 0;
        int x = 3;
        for (;i  < 10; i++) {
            int result = ++x * 4 / x-- + ++x * x;
            System.out.println("i = " + i);
            System.out.println("j = " + j++);
            System.out.println("z = " + ++z);
            System.out.println("x = " + x);
            System.out.println("result = " + result);
        }



    }
}
