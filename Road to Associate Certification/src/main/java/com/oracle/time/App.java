package com.oracle.time;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class App {

	
	
	public static void main(String[] args) {
		
		// java.time classes are IMMUTABLE!
		
		
		LocalDate d = LocalDate.now();
		DateTimeFormatter f = DateTimeFormatter.ISO_LOCAL_DATE;
		DateTimeFormatter f2 = DateTimeFormatter.ofPattern("HH:mm");
		DateTimeFormatter f3 = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
		
		System.out.println(d.format(f));
		//System.out.println(d.format(f2));  // java.time.temporal.UnsupportedTemporalTypeException
		System.out.println(f3.format(d));	 // 16-7-16
		
		Period p = Period.of(1, 0, 0);  // Period versus duration
		System.out.println(d.minus(p));
		System.out.println(d.plus(p));
		System.out.println(d);  // note LocalDate is IMMUTABLE
		System.out.println(d.plusYears(1).plusMonths(1).plusDays(1));
		
		
		LocalTime t = LocalTime.now();
		// t.minus(p);  // java.time.temporal.UnsupportedTemporalTypeException
		// t.plus(p);   // java.time.temporal.UnsupportedTemporalTypeException
		// t.plusYears(1);  // compiler error
	}

}
