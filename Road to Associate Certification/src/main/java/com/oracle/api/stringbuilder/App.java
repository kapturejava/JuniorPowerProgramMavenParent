package com.oracle.api.stringbuilder;

public class App {

	
	public static void main(String[] args) {
		
		StringBuilder sb = new StringBuilder("ani");
		sb.append("mals");
		sb.insert(0, 123);
		System.out.println(sb);	// 123animals

		sb.delete(0, 3);
		System.out.println(sb);	// animals  (delete 3 - 0 = 3 characters)
		
		System.out.println(sb.equals("animals"));  // false
		System.out.println(sb.toString().equals("animals"));  // true
	}
	
}
