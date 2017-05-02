package com.oracle.inheritance;

class A {}
class B extends A {}
class C extends B {}
class D {}


public class App {

	public static void main(String[] args) {
		
		// upcast naar object mag altijd
		
		Object o = new Object(); // java.lang.ClassCastException meestal bij een downcast!
		String s = (String) o;
		//Number n = (Number) s; // Can't convert String to Number
		
		A a = new A();
//		C c = (C) a; // java.lang.ClassCastException meestal bij een downcast!
		
		A a2 = new A();
//		D d = (D) a2;  // unrelated types compiler error
		
		Object o3 = new Object();
		A a3 = (A) o3;
		
	}

}
