package com.oracle.api.arraylist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class App {

	public static void main(String[] args) {
		
		List<Integer> numbers = new ArrayList();  // let op alleen de reference variable heeft een type
		//numbers.add("een");
		numbers.add(3);
		numbers.add(-1);
		numbers.add(-10);
		numbers.add(20);
		
		Collections.sort(numbers);
		System.out.println(numbers);  // [-10, -1, 3, 20]  numeric because type is a number
		
		
		List<String> numbers2 = new ArrayList<>();
		numbers2.add("3");
		numbers2.add("-1");
		numbers2.add("-10");
		numbers2.add("20");
		
		Collections.sort(numbers2);
		System.out.println(numbers2);  // [-1, -10, 20, 3]  alpha numeriek because type is a String
		
		
		List numbers3 = new ArrayList();  // ArrayList of Objects
		numbers3.add(new Boolean(true));
		numbers3.add(false);
		numbers3.add("een");
		numbers3.add(3);
		numbers3.add(-1);
		numbers3.add(-10);
		numbers3.add(20);
		
//		Collections.sort(numbers3);  // java.lang.Boolean cannot be cast to java.lang.String
		System.out.println(numbers3);  // [true, false, een, 3, -1, -10, 20]
		
		
		List<Integer> numbers4 = new ArrayList<>();
		numbers4.add(1);
		numbers4.set(0, 2);
		numbers4.add(1, 3);
		System.out.println(numbers4);  // [2, 3]
		
		numbers.remove(1);
		
		
	}

}
