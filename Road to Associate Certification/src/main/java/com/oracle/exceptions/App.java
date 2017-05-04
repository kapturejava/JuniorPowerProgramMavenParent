package com.oracle.exceptions;

public class App {

	public static void test() throws StackOverflowError {
		throw new StackOverflowError();
	}

	public static void main(String[] args) {

		try {
			test();
		} catch (StackOverflowError e) {
			System.out.println("StackOverflowError");
			throw new RuntimeException();
		} catch (RuntimeException e) {
			System.out.println("RuntimeException");  // not printed!
		} finally {
			System.out.println("Finally");
		}
		
		System.out.println("Main");  // not printed!
	}

}
