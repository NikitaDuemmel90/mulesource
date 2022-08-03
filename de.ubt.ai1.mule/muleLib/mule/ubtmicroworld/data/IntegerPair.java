package mule.ubtmicroworld.data;

/**
 * This class holds two Integer vars as a tuple. 
 * @author Marco Jantos
 * 
 */
public class IntegerPair {
	private int first;
	private int second;
	
	public IntegerPair(int first, int second) {
		this.first = first;
		this.second = second;
	}
	
	public int getFirst() {
		return first;
	}
	
	public int getSecond() {
		return second;
	}	
}
