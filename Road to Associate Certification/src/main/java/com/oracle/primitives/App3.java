package com.oracle.primitives;

public class App3 {

	public static void main(String[] args) {
		
		char c = 'a';
		byte b = 97;
		System.out.println(c == b);
		
		long l = 97L;
		System.out.println(c == l);
		
		boolean bool = false;
		//System.out.println(c == bool);
		
		double d = 97.0;
		System.out.println(c == d);
		
		b = (byte) c;
		l = b;
		l = c;
		int i = c;
		b = (byte) d;
		short s = (short) c;
		
		
		Integer I = Integer.valueOf("1");
		System.out.println(I.equals(1));
		
		String str= "1";
		// I == S;  // type mismatch
		
		System.out.println(I.equals(str));  // false
		
		StringBuilder sb = new StringBuilder("1");
		
		// str== sb;  // type mismatch
		
		System.out.println(str.equals(sb));  // false
		System.out.println(str.equals(sb.toString()));  // true
		
		
	}
	
}
