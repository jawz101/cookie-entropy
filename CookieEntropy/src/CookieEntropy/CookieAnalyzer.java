/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CookieEntropy;

import java.util.regex.*;
import java.util.List;
import java.util.ArrayList; //import java.util.LinkedList;
import java.util.Iterator;
import java.util.Arrays;
import java.text.DecimalFormat;

/**
 * The cookie analyzer class analyzes a cookie based on a method call. Possible
 * methods are counting the number of characters in a cookie value, calculating
 * the entropy of each column in an array of cookie values, estimating the
 * character set (encoding) used for the cookie value, and determines if the
 * cookie key is a session management cookie value or not.
 * 
 * @author Tyler
 */
public class CookieAnalyzer {

	/*************************************************************
	 * VARIABLES
	 *************************************************************/

	/**
	 * List of all the cookie values as a list
	 */
	private List<String> values;
	/**
	 * The key of the cookie
	 */
	private String key;

	/*************************************************************
	 * CONSTANTS
	 *************************************************************/

	/**
	 * Hex
	 */
	private static final int HEX = 1;
	/**
	 * ASCII
	 */
	private static final int ASCII = 2;
	/**
	 * Decimal
	 */
	private static final int DECIMAL = 3;
	/**
	 * Base64
	 */
	private static final int BASE64 = 4;
	/**
	 * Binary
	 */
	private static final int BINARY = 5;
	/**
	 * AlphaNumeric
	 */
	private static final int ALPHANUM = 6;

	/*************************************************************
	 * CONSTRUCTOR
	 *************************************************************/

	/**
	 * Constructor that accepts a CookieValues object and sets the values the
	 * key to the class variables
	 * 
	 * @param cv
	 *            CookieValues to be analyzed
	 */
	CookieAnalyzer(CookieValues cv) {
		this.values = cv.values;
		this.key = cv.name;
	}

	/*************************************************************
	 * METHODS
	 *************************************************************/

	/**
	 * Determines the shortest cookie length and takes characters from each
	 * column and calls the entropy() method which calculates the entropy on the
	 * specific column string
	 * 
	 * @return Returns an array of entropy values for each column as a String
	 */
	public String[] columnEntropy() {
		DecimalFormat df = new DecimalFormat("0.000");
		// converts the values List to an array for easier manipulation
		String[] arrayVals = values.toArray(new String[0]);
		// finds the shortest char length of all cookie values
		int shortest = findShortest(arrayVals);
		String[] entropyStr = new String[shortest];
		// val stores the value of the column splits into a String
		String val = "";
		// Splits all cookie value strings by column and creates new strings
		// to calculate entropy
		for (int i = 0; i < shortest; i++) {
			for (int j = 0; j < arrayVals.length; j++) {
				val = val + arrayVals[j].charAt(i);
			}
			entropyStr[i] = "Col " + (int) (i + 1) + ": "
					+ df.format(entropy(val));
			val = "";
		}
		return entropyStr;
	}

	/**
	 * Calculates the entropy of each cookie value
	 * 
	 * @return Returns a String array of entropy values
	 */
	public String[] cookieEntropy() {
		DecimalFormat df = new DecimalFormat("0.000");
		// converts the values List to an array for easier manipulation
		String[] arrayVals = values.toArray(new String[0]);
		String[] entropyVals = new String[arrayVals.length];
		for (int i = 0; i < arrayVals.length; i++) {
			entropyVals[i] = "Cookie " + (int) (i + 1) + ": "
					+ df.format(entropy(arrayVals[i]));
		}
		return entropyVals;
	}

	/**
	 * Concatenates all Strings and calculates the total entropy of all the
	 * cookie values
	 * 
	 * @return Returns the entropy of all the cookie values
	 */
	public String totalEntropy() {
		DecimalFormat df = new DecimalFormat("0.000");
		// converts the values List to an array for easier manipulation
		String[] arrayVals = values.toArray(new String[0]);
		String entropyStr = "";
		for (int i = 0; i < arrayVals.length; i++) {
			entropyStr = entropyStr + arrayVals[i];
		}
		entropyStr = "Total entropy: " + df.format(entropy(entropyStr));
		return entropyStr;
	}

	/**
	 * Calculates the entropy of a given string using Shannon's entropy equation
	 * for information theory. The basic concept is to calculate the total
	 * probability of each event occuring
	 * 
	 * @param values
	 *            the String to be calculated for an entropy value
	 * @return entropy as a double
	 */
	public double entropy(String values) {
		// number of values to compare
		int size = values.length();
		// creates a char array of each value
		char[] chars = values.toCharArray();
		// sorts the array so we can determine which chars are different
		Arrays.sort(chars);
		ArrayList<ValueCounts> counts = new ArrayList<ValueCounts>();
		int count = 1;
		for (int i = 0; i < size; i++) {
			// i<size-1 avoids array index out of bounds exception
			// checks if the values next to each other are equal and increments
			// count variable if they are
			if (i < size - 1 && chars[i] == chars[i + 1]) {
				count++;
				// if they are different, then creates ValueCounts object with
				// the
				// count and the char value
			} else {
				counts.add(new ValueCounts(count, chars[i]));
				count = 1;
			}
		}

		double entropy = 0.0;
		Iterator<ValueCounts> countsIterator = counts.iterator();
		while (countsIterator.hasNext()) {
			// gets the count of the number of times the char appeared in the
			// string
			int c = countsIterator.next().count;
			// calculates the probability the char appears in the string based
			// on the total number of chars
			double probability = (double) c / (double) size;
			// uses Shannon's entropy formula for information theory
			entropy = entropy
					+ (probability * (double) (Math.log10(probability) / Math
							.log10(2)));
		}
		return entropy;
	}

	/**
	 * Finds the shortest String in an array of String values
	 * 
	 * @param arr
	 *            the String array
	 * @return Returns the smallest number of characters in a String of a String
	 *         Array
	 */
	private int findShortest(String[] arr) {
		// sets initial value to largest integer value
		int shortest = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length; i++) {
			// checks if length is shorter than the shortest and if it is
			// sets to new shortest
			if (arr[i].length() < shortest)
				shortest = arr[i].length();
		}
		return shortest;
	}

	/**
	 * Counts the number of characters in cookie values
	 * 
	 * @return Returns fixed if values are fixed length and returns the values
	 *         of non-fixed length cookie values
	 */
	public String countChars() {
		// Char array is used to determine if there are fixed length cookie
		// values or not
		int chars[] = new int[values.size()];
		// boolean to determine if fixed or variable length
		boolean variable = false;
		// Counts the number of characters in each String
		String count = "";
		Iterator<String> valuesIterator = values.iterator();
		int i = 0;
		while (valuesIterator.hasNext()) {
			// Sets current String value to value
			String value = valuesIterator.next().toString();
			// Sets the length in a char array
			chars[i] = value.length();
			if (i != 0) {
				// checks if the length is different and if it is, it is
				// variable
				// length
				if (value.length() != chars[i - 1]) {
					variable = true;
				}
			}
			// creates a string of all the lengths
			count = count + " " + value.length();
			i++;
		}

		if (variable) {
			return "Not fixed length. Character lengths of:" + count;
		} else {
			return "Fixed length of " + Integer.toString(chars[0])
					+ " characters";
		}
	}

	/**
	 * Gets the encoding type based on a few popular encoding types
	 * 
	 * @return type of encoding: ASCII, Base64, Hex, Decimal, Binary
	 */
	public String encoding() {
		int type = 0;
		Iterator<String> valuesIterator = values.iterator();
		String value = "";
		while (valuesIterator.hasNext()) {
			value = value + valuesIterator.next().toString();
		}

		// Regex to find ASCII strings
		Pattern p = Pattern.compile("^[\\x00-\\x7F]+$");
		Matcher m = p.matcher(value);
		if (m.find()) {
			type = ASCII;
		}

		// Regex to find base64 strings
		p = Pattern.compile("^[A-Za-z0-9/=]+$");
		m = p.matcher(value);
		if (m.find()) {
			type = BASE64;
		}

		// Regex to find hexadecimal strings
		p = Pattern.compile("^[0-9a-fA-F]+$");
		m = p.matcher(value);
		if (m.find()) {
			type = HEX;
		}

		// Regex to find decimal strings
		p = Pattern.compile("^[0-9]+$");
		m = p.matcher(value);
		if (m.find()) {
			type = DECIMAL;
		}

		// Regex to find binary strings
		p = Pattern.compile("^[01]+$");
		m = p.matcher(value);
		if (m.find()) {
			type = BINARY;
		}

		// Returns type based on regex findings
		if (type == HEX) {
			return "Hexadecimal Values";
		} else if (type == ASCII) {
			return "ASCII Values";
		} else if (type == DECIMAL) {
			return "Decimal Values";
		} else if (type == BASE64) {
			return "Base64 Values";
		} else if (type == ALPHANUM) {
			return "AlphaNumeric Values";
		} else if (type == BINARY) {
			return "Binary Values";
		} else {
			return "Unknown Character Set";
		}

	}

	/**
	 * Identifies the type of session management the cookie is using if any at
	 * all. Also, if the cookie key is a Google Analytics cookies, this info
	 * will be returned as well
	 * 
	 * @return Returns the session management type
	 */
	public String sessionManagement() {
		// Default value
		String session = "Unknown";
		 if (key.equals("ASPSESSIONID")) {
			session = " ASP Session ID used";
		} else if (key.equals("PHPSESSID")) {
			session = " PHP Session ID used";
		} else if (key.equals("CFTOKEN") || key.equals("CFID")) {
			session = " Coldfusion Session ID used";
		} else if (key.equals("PHPSESSID")) {
			session = " PHP Session ID used";
		} else if (key.equals("JSESSIONID")) {
			session = " JAVA (JSP) Session ID";
		} 
		return session;
	}
	
	/**
	 * Checks if the cookie is using Google Analytics
	 * 
	 * @return Returns boolean value true if using Google Analytics
	 */
	public boolean googleAnalytics(){
		// Regex to find Google Analytics cookie keys
		Pattern p = Pattern.compile("^[__utm]");
		Matcher m = p.matcher(key);
		// Searches through a few common session management key strings
		return m.find();
	}

	/**
	 * Testing code.........
	 * 
	 * @param args
	 *            No command line arguments accepted
	 */
	public static void main(String[] args) {
		List values = new ArrayList<String>();
		values.add("12358784359875ff");
		values.add("4234534f3345d35c");
		values.add("69873aac24545ed5");
		values.add("69873aac245634d5");
		values.add("69873a6644545ed5");
		values.add("69873aac54545ed5");
		values.add("69873aac24545645");
		values.add("69873aac24555ed5");
		values.add("69873aac24545ed5");
		values.add("69873aac24545ed5");
		values.add("69873aa453636ed5");
		values.add("aaaaaaaaaaaaaaaa");
		String key = "PHPSESSID";
		CookieValues cv = new CookieValues();
		cv.name = key;
		cv.values = values;
		CookieAnalyzer ca = new CookieAnalyzer(cv);

		System.out.println();
		String[] ce = ca.columnEntropy();
		for (int i = 0; i < ce.length; i++) {
			System.out.println(ce[i]);
		}
		ce = ca.cookieEntropy();
		for (int i = 0; i < ce.length; i++) {
			System.out.println(ce[i]);
		}
		System.out.println(ca.totalEntropy());
		System.out.println(ca.encoding());
		System.out.println(ca.countChars());
		System.out.println(ca.sessionManagement());
	}
}

/**
 * Class used to store the value and the count when calculating entropy to store
 * each character and the number of times that character appears in a String
 * 
 * @author Tyler
 */
class ValueCounts {

	/**
	 * Number of times a character appears in a String
	 */
	public int count;
	/**
	 * Character in a String
	 */
	public char value;

	/**
	 * Constructor that accepts count and char value
	 * 
	 * @param c
	 *            count
	 * @param v
	 *            value
	 */
	ValueCounts(int c, char v) {
		this.count = c;
		this.value = v;
	}
}