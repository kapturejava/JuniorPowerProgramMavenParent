package com.oracle._static;

class A {
	public void test() { System.out.println("A"); }
}

public class App {

	private static void doStuff(A a) { a.test(); }  // Instance members mogen wel aangeroepen worden wanneer een object wordt mee gegeven
	
	private static void main(String[] args) {
		A a = new A();
		doStuff(a);
	}
}
