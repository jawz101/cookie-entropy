/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CookieEntropy;

import java.util.regex.*;
import java.util.List;
import java.util.ArrayList;
//import java.util.LinkedList;
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
     *                      VARIABLES
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
     *                      CONSTANTS
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
     *                      CONSTRUCTOR
     *************************************************************/

    /**
     * Constructor that accepts a CookieValues object and sets the values
     * the key to the class variables
     *
     * @param cv CookieValues to be analyzed
     */
    CookieAnalyzer(CookieValues cv) {
        this.values = cv.values;
        this.key = cv.key;
    }

    /*************************************************************
     *                      METHODS
     *************************************************************/

    /**
     * Determines the shortest cookie length and takes characters from each
     * column and calls the entropy() method which calculates the entropy
     * on the specific column string
     *
     * @return Returns an array of entropy values for each column as a String
     */
    public String[] cookieEntropy() {
        DecimalFormat df = new DecimalFormat("0.000");
        String[] arrayVals = values.toArray(new String[0]);
        int shortest = findShortest(arrayVals);
        String[] entropyStr = new String[shortest];
        String val = "";
        for (int i = 0; i < shortest; i++) {
            for (int j = 0; j < arrayVals.length; j++) {
                val = val + arrayVals[j].substring(i, i + 1);
            }
            entropyStr[i] = "Col " + (int) (i + 1) + ": " + df.format(entropy(val));
            val = "";
        }
        return entropyStr;
    }

    /**
     * Calculates the entropy of a given string using Shannon's entropy equation
     * for information theory. The basic concept is to calculate the total
     * probability of each event occuring
     *
     * @param values the String to be calculated for an entropy value
     * @return entropy as a double
     */
    public double entropy(String values) {
        int size = values.length();
        char[] chars = values.toCharArray();
        Arrays.sort(chars);
        ArrayList<ValueCounts> counts = new ArrayList<ValueCounts>();
        int count = 1;
        for (int i = 0; i < size; i++) {
            if (i < size - 1 && chars[i] == chars[i + 1]) {
                count++;
            } else {
                counts.add(new ValueCounts(count, chars[i]));
                count = 1;
            }
        }
        double entropy = 0.0;
        //System.out.println(counts.size());
        Iterator<ValueCounts> countsIterator = counts.iterator();
        while (countsIterator.hasNext()) {
            int c = countsIterator.next().count;
            double probability = (double) c / (double) size;
            //System.out.println(probability);
            entropy = entropy + (probability * (double) (Math.log10(probability) / Math.log10(2)));
            //System.out.println(entropy);
        }
        return entropy;
    }

    /**
     * Finds the shortest String in an array of String values
     *
     * @param arr the String array
     * @return Returns the smallest number of characters in a String of a String
     * Array
     */
    private int findShortest(String[] arr) {
        int shortest = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++){
            if (arr[i].length() < shortest)
                shortest = arr[i].length();
        }
        return shortest;
    }

    /**
     * Counts the number of characters in cookie values
     *
     * @return Returns fixed if values are fixed length and returns the values
     * of non-fixed length cookie values
     */
    public String countChars() {
        //char array is used to determine if there are fixed length cookie values or not
        int chars[] = new int[values.size()];
        boolean variable = false;
        String count = "";
        Iterator<String> valuesIterator = values.iterator();
        int i = 0;
        while (valuesIterator.hasNext()) {
            String value = valuesIterator.next().toString();
            chars[i] = value.length();
            if (i != 0) {
                if (value.length() != chars[i - 1]) {
                    variable = true;
                }
            }
            count = count + " " + value.length();
            i++;
        }
        if (variable) {
            return "Not fixed length. Character lengths of:" + count;
        } else {
            return "Fixed length of " + Integer.toString(chars[0]) + " characters";
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

        Pattern p = Pattern.compile("^[\\x00-\\x7F]+$");
        Matcher m = p.matcher(value);
        if (m.find()) {
            type = ASCII;
        }

        p = Pattern.compile("^[A-Za-z0-9/=]+$");
        m = p.matcher(value);
        if (m.find()) {
            type = BASE64;
        }

        p = Pattern.compile("^[0-9a-fA-F]+$");
        m = p.matcher(value);
        if (m.find()) {
            type = HEX;
        }

        p = Pattern.compile("^[0-9]+$");
        m = p.matcher(value);
        if (m.find()) {
            type = DECIMAL;
        }

        p = Pattern.compile("^[01]+$");
        m = p.matcher(value);
        if (m.find()) {
            type = BINARY;
        }

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
        String session = "Unknown or Non Session Management Key";
        Pattern p = Pattern.compile("^[__utm]");
        Matcher m = p.matcher(key);
        if (m.find()) {
            session = "Google Analytics used";
        } else if (key.equals("ASPSESSIONID")) {
            session = "ASP Session ID used";
        } else if (key.equals("PHPSESSID")) {
            session = "PHP Session ID used";
        } else if (key.equals("CFTOKEN") || key.equals("CFID")) {
            session = "Coldfusion Session ID used";
        } else if (key.equals("PHPSESSID")) {
            session = "PHP Session ID used";
        } else if (key.equals("JSESSIONID")) {
            session = "JAVA (JSP) Session ID";
        }
        return session;
    }

    /**
     * Testing code.........
     * @param args No command line arguments accepted
     */
    public static void main(String[] args) {
        List values = new ArrayList<String>();
        values.add("12358784359875ff");
        values.add("4234534f3345d35c");
        values.add("69873aac24545ed5");
        String key = "PHPSESSID";
        CookieValues cv = new CookieValues();
        cv.key = key;
        cv.values = values;
        CookieAnalyzer ca = new CookieAnalyzer(cv);

        System.out.println();
        String[] ce = ca.cookieEntropy();
        for (int i = 0; i < ce.length; i++) {
            System.out.println(ce[i]);
        }
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
     * @param c count
     * @param v value
     */
    ValueCounts(int c, char v) {
        this.count = c;
        this.value = v;
    }
}