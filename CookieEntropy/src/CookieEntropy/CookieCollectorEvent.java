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
public interface CookieCollectorEvent {
    // be called when CookieCollector collect a cookie
    public void receiveCookie (HashMap<String, String> params,
            HashMap<String, String> cookies);
    // be called when CookieCollector occurs error and need to stop
    public void receiveException (Exception e);
}
