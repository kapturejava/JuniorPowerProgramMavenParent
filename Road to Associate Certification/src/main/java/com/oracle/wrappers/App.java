package com.oracle.wrappers;

public class App {

	public static void main(String[] args) {
		
		Byte b1 = new Byte((byte)1);
		Byte b2 = new Byte("1");
		
		Byte b3 = Byte.valueOf((byte)1);
		Byte b4 = Byte.valueOf("1");
		
		byte b5 = Byte.parseByte("1");
		
		
		
		Float f1 = new Float(1.0);
		Float f2 = new Float("1.0");
		
		Float f3 = Float.valueOf(1.0f);
		Float f4 = Float.valueOf("1.0");
		
		float f5 = Float.parseFloat("1.0");
		
		
		
		boolean bo = Boolean.parseBoolean("TRUE");
		
	}
	
}
