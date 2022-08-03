package mule.lang;

import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Function;


public class Strings {
	
	public static String subString(String str, Integer startPos, Integer endPos) {
		return str.substring(startPos, endPos + 1);
	}
	
	public static Integer lengthOf(String str) {
		return str.length();
	}
	
	public static Integer indexOfSubString(String str, String subStr) {
		return str.indexOf(subStr);
	}
	
	public static String replaceAll(String str, String regex, String replacement) {
		return str.replaceAll(regex, replacement);
	}
	
	public static String replaceFirst(String str, String regex, String replacement) {
		return str.replaceFirst(regex, replacement);
	}
	
	public static ArrayList<String> split(String str, String regex) {
		ArrayList<String> result = new ArrayList<>();
		result.addAll(Arrays.asList(str.split(regex)));
		return result;
	}
	
	public static String toLowerCase(String str) {
		return str.toLowerCase();
	}
	
	public static String toUpperCase(String str) {
		return str.toUpperCase();
	}
	
	public static String integerToString(Integer num) {
		return num.toString();
	}
	
	public static String rationalToString(Double num) {
		return num.toString();
	}
	
	public static String booleanToString(Boolean num) {
		return num.toString();
	}
	
	public static <T> String genericToString(T object) {
		if (object == null)
			return "null";
//		if (object instanceof Function) {
//			Function f = ((Function)object);
//			String str = "operation";
//			for (TypeVariable t : f.getClass().getTypeParameters()) {
//				str = str + "_" + t.getName();
//			}
//			return str;
//		}
		return object.toString();
	}

}
