package com.oracle.api.array;

import java.util.Arrays;
import java.util.List;

public class App {

	public static void main(String[] args) {
		
		int numbers1[] = new int[3];
		int numbers2[] = new int[] {1,2,3};
		int numbers3[] = { 1,2,3 };  // anonymous array
		
		int numbers[][] = { {1,2}, {3}, {4,5,6,7,8,9} };  // Asymmetric anonymous multi-dimensional array
		
		
		List<Integer> l = Arrays.asList(1,2,3,4,5);  // list backed by array (FIXED size)
		//l.add(6);  // not supported
		l.set(1, 6);
		
		int getallen[] = {10,9,8,7,6,5,4,3,2,1};
		
		Arrays.sort(getallen);
		Arrays.binarySearch(getallen, 3);  // 2
		
		for(int i: getallen) System.out.println(i);
		
		
	}
	
}
