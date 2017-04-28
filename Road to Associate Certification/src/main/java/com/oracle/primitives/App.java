package com.oracle.primitives;

public class App {

	
	public static void main(String[] args) {
		
		// A char is an unsigned integer
		// An unsigned integer cannot be negative
		
		byte b = 'Z';
		System.out.println(b);  // 90
		
		int i = 'a';
		System.out.println(i);  // 97
		
		char c1 = 'a';
		System.out.println(c1);  // a
		System.out.println(++c1);  // b

		char c2 = 97;
		System.out.println(c2);  // a
	
		
		// Arrays met primitives are printed
		char chars1[] = { 'a', 'b', 'c' };
		System.out.println(chars1);
		
		char chars2[] = { 97, 98, 99 };
		System.out.println(chars2);
		
		
		String leesplankje[] = { "aap", "noot", "mies" };
		System.out.println(leesplankje);
	}
	
}
