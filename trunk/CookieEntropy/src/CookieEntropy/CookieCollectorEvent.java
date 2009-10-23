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
    public String key;
    public List<String> values;

    public CookieValues () {
	key = null;
	values = new LinkedList<String>();
    }
}

public interface CookieCollectorEvent {
    // be called when CookieCollector collect a cookie
    public void receiveCookie (List<KeyValuePair> params,
            List<KeyValuePair> cookies);
    // be called when CookieCollector occurs error and need to stop
    public void receiveException (Exception e);
}
