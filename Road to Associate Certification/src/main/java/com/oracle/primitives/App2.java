package com.oracle.primitives;

public class App2 {

	static byte b;
	static short s;
	static int i;
	static long l;
	static float f;
	static double d;
	static char c;
	static boolean bool;
	static Object o;
	
	public static void main(String[] args) {
		System.out.println("b: " + b);
		System.out.println("s: " + s);
		System.out.println("i: " + i);
		System.out.println("l: " + l);
		System.out.println("f: " + f);  // 0.0
		System.out.println("d: " + d);  // 0.0
		System.out.println("c: " + c);
		System.out.println("bool: " + bool);  // false
		System.out.println("o: " + o);  // null
		
	}
	
}
