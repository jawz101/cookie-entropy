/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package CookieEntropy;

import java.util.*;
/**
 *
 * @author Ming
 */

class KeyValuePair {
    public String key;
    public String value;

    public KeyValuePair(String k, String v) {
        key = k;
        value = v;
    }

    public String toString() {
	return key + "=" + value;
    }
}

class CookieValues {
    public String name;
    public List<String> values;

    public CookieValues (String cookieName) {
	name = cookieName;
	values = new LinkedList<String>();
    }

    public void addValue(String v) {
	values.add(v);
    }

    // return a concatenated string of all values
    public String allValues() {
	String res = "";
	Iterator<String> it = values.iterator();
	while (it.hasNext())
	    res = res + it.next();
	return res;
    }

    public String toString() {
	String r = "Cookie name="+name+" has "+values.size()+" values:\n";
	Iterator<String> it = values.iterator();
	while (it.hasNext())
	    r = r + it.next() + "\n";
	return r;
    }
}

public interface CookieCollectorEvent {
    // be called when CookieCollector collect a cookie
    public void receiveCookie (List<KeyValuePair> params,
            List<KeyValuePair> cookies);
    // be called when CookieCollector occurs error and need to stop
    public void receiveException (Exception e);

    public void receiveThreadEnds();
}
