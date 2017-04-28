package com.oracle.inheritance;

interface I {}

class G {}
class H extends G implements I {}

public class App3 {

	public static void main(String[] args) {
		G g = new G();
		I i = (I) g;  // java.lang.ClassCastException
	}
	
}
