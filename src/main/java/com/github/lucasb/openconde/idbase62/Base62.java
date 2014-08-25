package com.github.lucasb.openconde.idbase62;

/**
 * 
 * This class provide base 62 elements.
 * 
 * @author Boscaini, Lucas
 * 
 */
public class Base62 {

	public static final char[] ELEMENTS = {    'a', 'b', 'c', 'd', 'e', 'f',
			'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's',
			't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5',
			'6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I',
			'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',
			'W', 'X', 'Y', 'Z' };
	public static final long BASE = ELEMENTS.length;

	/**
	 * 
	 * Initializes is private because the every method this class is static.
	 *  
	 */
	private Base62() {}

	/**
	 * 
	 * Convert a value from decimal to base 62.
	 * 
	 * @param decimal Long with decimal value to convert.
	 * @return a string with base 62 value.
	 * 
	 */
	public static String fromDecimal(long decimal) {
		StringBuilder sb = new StringBuilder("");
		
		if(decimal == 0) {
			return String.valueOf(ELEMENTS[0]);
		}
		
		while (decimal > 0) {
			long rest = decimal % BASE;
			sb.append(ELEMENTS[(int) rest]);
			decimal = decimal / BASE;
		}
		
		return sb.reverse().toString();
	}
	
	/**
	 * 
	 * Convert a value from base 62 to decimal.
	 * 
	 * @param value String with base 62 value to convert.
	 * @return a long with decimal value.
	 * 
	 */
	public static long toDecimal(String value) {
		char[] chars = new StringBuilder(value).reverse().toString().toCharArray();
		long n = 0;
		
		for (int i = chars.length - 1; i >= 0; i--) {
			n += (new String(ELEMENTS).indexOf(chars[i])) * (long) Math.pow(BASE, i);
		}
		
		return n;
	}
	
	/**
	 * 
	 * Plus two base 62 values.
	 * 
	 * @param value String with base 62 value.
	 * @param value2 String with base 62 value.
	 * @return a string with result base 62 value.
	 * 
	 */
	public static String plus(String value, String value2) {
		return fromDecimal(toDecimal(value)+toDecimal(value2));
	}
	
	/**
	 * 
	 * Subtract two base 62 values, first value to second.
	 * 
	 * @param value String with base 62 value.
	 * @param value2 String with base 62 value.
	 * @return a long with decimal value.
	 * 
	 */
	public static String minus(String value, String value2) {
		return fromDecimal(toDecimal(value)-toDecimal(value2));
	}
	
	/**
	 * 
	 * Valid if the value is base 62 type or not.
	 * 
	 * @param value String with base 62 value.
	 * @return a boolean with true if and only if the value is valid.
	 * 
	 */
	public static boolean isValid(String value) {		
		
		if(value == null || value.trim().equals("")) {
			return false;
		}
		
		for (int i=0; i < value.length(); i++) {
	    	if(new String(ELEMENTS).indexOf(value.charAt(i)) == -1)
	    		return false;
		}
		return true;
	}

}
