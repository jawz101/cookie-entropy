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
public class CookieCollector implements Runnable {
    private String urlLogin;
    private boolean postMethod;         // use http post to login?
    private String urlLogout;
    private String paramNames[];
    private LinkedList<String []> paramValues;
    private CookieCollectorEvent eventHandler;

    public CookieCollector(String loginURL, CookieCollectorEvent evtHandler) {
        urlLogin = loginURL;
        urlLogout = null;
        paramValues = null;
        postMethod = true;
        eventHandler = evtHandler;
    }

    public void useHttpGetMethod() {
        postMethod = false;
    }

    public void setLogoutURL(String logoutURL) {
        urlLogout = logoutURL;
    }

    public void setLoginParamNames(String[] params) {
        paramNames = params;
    }

    public void addLoginParamValues(String[] values) {
        if (paramValues == null)
            paramValues = new LinkedList<String []>();
        paramValues.add(values);
    }
    
    public void run() {

    }
}
