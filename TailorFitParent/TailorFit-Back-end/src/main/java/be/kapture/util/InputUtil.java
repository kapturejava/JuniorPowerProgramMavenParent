package be.kapture.util;

import be.kapture.repositories.AbstractRepository;

public class InputUtil {
	public static String isStringEmpty(String string){
		if(string != null  && !string.trim().isEmpty()){
			return string;
		}
		throw new IllegalArgumentException();
	}
	public static String isStringEmpty(String string, String error){
		if(string != null  && !string.trim().isEmpty()){
			return string;
		}
		throw new IllegalArgumentException(error);
	}
	public static int isIntStricltyPositive(int number){
		if(number > 0){
			return number;
		}
		throw new IllegalArgumentException();
	}
	public static int isIntStricltyPositive(int number, String error){
		if(number > 0){
			return number;
		}
		throw new IllegalArgumentException(error);
	}
	public static Object isNotNull(Object obj) {
		if(obj == null){
			throw new IllegalArgumentException();
		}
		return obj;
	}
	public static Object isNotNull(Object obj, String error) {
		if(obj == null){
			throw new IllegalArgumentException(error);
		}
		return obj;
	}
	public static AbstractRepository<?> isNotNull(AbstractRepository<?> obj) {
		if(obj == null){
			throw new IllegalArgumentException();
		}
		return obj;
	}
	public static AbstractRepository<?> isNotNull(AbstractRepository<?> obj, String error) {
		if(obj == null){
			throw new IllegalArgumentException(error);
		}
		return obj;
	}
}
