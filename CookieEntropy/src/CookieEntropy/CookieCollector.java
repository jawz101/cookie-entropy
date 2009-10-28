/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package CookieEntropy;

import java.util.*;

import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.client.params.ClientPNames;
import org.apache.http.client.params.CookiePolicy;
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
    int     times;

    public CookieCollector(String loginURL, int repeats, CookieCollectorEvent evtHandler) {
        urlLogin = loginURL;
        urlLogout = null;
        paramValues = null;
        postMethod = true;
        eventHandler = evtHandler;
        times = repeats;
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
        int i, j;  // loop variable

        //System.out.println("hello thread");
 
        if (postMethod) // not support post at this moment
            return;


        try {
            for (i=0; i<times; i++) {
		DefaultHttpClient httpclient = new DefaultHttpClient();
	        HttpGet httpget = new HttpGet(urlLogin);

		httpget.addHeader("User-Agent", "Mozilla/5.0 (Windows; U; Windows NT 6.1; en-US; rv:1.9.1.3)");
		httpclient.getParams().setParameter(
			ClientPNames.COOKIE_POLICY, CookiePolicy.BROWSER_COMPATIBILITY);

                HttpResponse response = httpclient.execute(httpget);
                HttpEntity entity = response.getEntity();
                if (entity != null)
                    entity.consumeContent();

                List<Cookie> cookies = httpclient.getCookieStore().getCookies();
                List<KeyValuePair> kvp = new LinkedList<KeyValuePair>();
                for (j=0; j<cookies.size(); j++) {
                    Cookie c = cookies.get(j);
                    kvp.add(new KeyValuePair(c.getName(), c.getValue()));
                }
                eventHandler.receiveCookie(null, kvp);

		httpclient.getConnectionManager().shutdown();
            }
        } catch (java.io.IOException e) {
            // pass the exception to the caller thread
            eventHandler.receiveException(e);
        }

	eventHandler.receiveThreadEnds();
    }

    static String removeTrailingEqualSigns(String s) {
	while (s.lastIndexOf('=') == s.length()-1)
	    s = s.substring(0, s.length()-1);
	return s;
    }
    // decompose composit cookies values
    //	e.g. PREF=ID=ec1502047692c217:TM=1256251566:LM=1256251566:S=wfMouMqDAS9maRZa
    // return simple cookies
    static List<KeyValuePair> decomposeCookies(List<KeyValuePair> cookies) {
	int i;
	Iterator<KeyValuePair> it = cookies.iterator();
	List<KeyValuePair> result = new LinkedList<KeyValuePair>();

	while (it.hasNext()) {
	    KeyValuePair kv = it.next();
	    //System.out.println("Original Cookie: "+kv);
	    String[] terms = kv.value.split(":");
	    if (terms.length == 1)
		terms = kv.value.split("&");

	    if (terms.length == 1) {    // this is a simple cookie
		String v = removeTrailingEqualSigns(kv.value);
		String ss[] = v.split("=", 2);
		KeyValuePair k;
		if (ss.length == 1)
		    k = new KeyValuePair(kv.key, ss[0]);
		else
		    k = new KeyValuePair(ss[0], ss[1]);
		result.add(k);
		continue;
	    }

	    // Further check if we have single '=' in each decomposed cookie
	    boolean true_composit = true;
	    // start from 1 because the first part may just be value
	    for (i=1; i<terms.length; i++) {
		if (terms[i].indexOf('=') == -1) {
		    true_composit = false;
		}
	    }

	    if (!true_composit) {   // return the simple cookie directly
		result.add(kv);
		continue;

	    }

	    //for (i=0; i<terms.length; i++)
		//System.out.println("terms " +i+ "=" + terms[i]);
	    int start_index = 0;
	    if (terms[0].indexOf('=') == -1) {
		result.add(new KeyValuePair(kv.key, terms[0]));
		start_index = 1;
	    }
	    // here we get truely composit cookies
	    for (i=start_index; i<terms.length; i++) {
		String[] ss = terms[i].split("=");
		// some cookie may have empty value
		result.add(new KeyValuePair(ss[0], ss.length>1? ss[1]:""));

	    }
	}

	return result;
    }
}
