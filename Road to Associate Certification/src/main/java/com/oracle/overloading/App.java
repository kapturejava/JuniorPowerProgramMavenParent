package com.oracle.overloading;


public class App {

	public static void test(int i) { System.out.println("int"); }
	public static void test(double d) { System.out.println("double"); }
	public static void test(Integer i) { System.out.println("Integer"); }
	public static void test(Object o) { System.out.println("Object"); }
	public static void test(double... d) { System.out.println("varargs"); }
	
	public static void main(String args[]) {
		test(new Integer(1));
	}
	
}
