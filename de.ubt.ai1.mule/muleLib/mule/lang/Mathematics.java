package mule.lang;

import java.util.Random;

public class Mathematics {
	
	public static Integer randomInteger(int min, int max){
		Integer result = 0;
		Random random = new Random();
		Integer range = max - min + 1;
		result = random.nextInt(range) + min;
		return result;
	}
	
	public static Double randomRational(){
		Double result = Math.random();
		return result;
	}
	
	public static Double pi() {
		Double result = Math.PI;
		return result;
	}
	
	public static Double e() {
		Double result = Math.E;
		return result;
	}
	
	public static Double sin(Double a) {
		Double result = Math.sin(a);
		return result;
	}
	
	public static Double cos(Double a) {
		Double result = Math.cos(a);
		return result;
	}
	
	public static Double tan(Double a) {
		Double result = Math.tan(a);
		return result;
	}
	
	public static Double asin(Double a) {
		Double result = Math.asin(a);
		return result;
	}
	
	public static Double acos(Double a) {
		Double result = Math.acos(a);
		return result;
	}
	
	public static Double atan(Double a) {
		Double result = Math.atan(a);
		return result;
	}
	
	public static Double log(Double a) {
		Double result = Math.log(a);
		return result;
	}
	
	public static Double log10(Double a) {
		Double result = Math.log10(a);
		return result;
	}
	
	public static Integer round(Double a) {
		Integer result = (int) Math.round(a);
		return result;
	}
	
	public static Integer floor(Double a) {
		Integer result = (int) Math.floor(a);
		return result;
	}
	
	public static Integer absoluteInteger(Integer a) {
		Integer result = Math.abs(a);
		return result;
	}
	
	public static Double absoluteRational(Double a) {
		Double result = Math.abs(a);
		return result;
	}
	
	public static Double toDegrees(Double a) {
		Double result = Math.toDegrees(a);
		return result;
	}
	
	public static Double toRadians(Double a) {
		Double result = Math.toRadians(a);
		return result;
	}
	
	public static Integer getMaxIntegerValue() {
		Integer result = Integer.MAX_VALUE;
		return result;
	}
	
	public static Integer getMinIntegerValue() {
		Integer result = Integer.MIN_VALUE;
		return result;
	}
	
	public static Double getMaxRationalValue() {
		Double result = Double.MAX_VALUE;
		return result;
	}
	
	public static Double getMinRationalValue() {
		Double result = Double.MIN_VALUE;
		return result;
	}
}
