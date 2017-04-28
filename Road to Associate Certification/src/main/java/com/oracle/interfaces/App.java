package com.oracle.interfaces;

interface Miel {
	public static final String NAME = "Miel";
	public static final String LASTNAME = "De Jaeger";
	public default void test() { System.out.println("test Miel"); }
	public static void hello() { System.out.println("hello Miel"); }
}

interface Kim {
	public static final String NAME = "Kim";
	public default void test() { System.out.println("test Kim"); }
	public static void hello() { System.out.println("hello Kim"); }
}


public class App implements Miel, Kim {

	
	public void test() { System.out.println("test App"); }  // default method needs to be overridden !!!
	
	public static void main(String[] args) {

		System.out.println(Miel.NAME + " " + LASTNAME);
		System.out.println(Kim.NAME);
		
		// calling static methods here
		Miel.hello();
		Kim.hello();
		
	}

}
