package com.oracle.api.arraylist;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class App1 {

	public static void main(String[] args) {
		
		List<Integer> numbers = new ArrayList<>();
		
		numbers.add(1);
		numbers.add(2);
		numbers.add(0, 3);
		
		numbers.set(0, 4);
		
		numbers.remove(new Integer(3));
		numbers.remove(0);
		
		numbers.contains(new Integer(3));
		
		numbers.clear();
		
		Collections.sort(numbers);
		Collections.binarySearch(numbers, 1);
		
		numbers.removeIf(i -> i > 10);  // Predicate<T>
		
		Integer getallen[] = numbers.toArray(new Integer[1]);  	// specify data type array 
		System.out.println(getallen.getClass());  				// class [Ljava.lang.Integer;
		
		Object objects[] = numbers.toArray();  		// default is Object array 
		System.out.println(objects.getClass());  	//class [Ljava.lang.Object;
		
		
		List<Integer> getallen2 = new ArrayList<>();
		getallen2.add(1);
		for(int i: getallen2) {
			System.out.println(i);
		}
	}

}
