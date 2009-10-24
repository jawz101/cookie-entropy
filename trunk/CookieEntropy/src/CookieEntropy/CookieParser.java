package CookieEntropy;

import java.util.*;

public class CookieParser {
	private String cookies;

	public CookieParser(String cookies) {
		this.cookies = cookies;
	}

	public List<KeyValuePair> parseCookie(){
		List<KeyValuePair> kvp = new LinkedList<KeyValuePair>();
		String[] cookie = cookies.split("[:;]");
		for (int i = 0; i < cookie.length; i++){
			if (cookie[i].startsWith("PREF="))
				cookie[i] = cookie[i].substring(5);
			else if (cookie[i].startsWith("NID="))
				cookie[i] = cookie[i].substring(4);
			else if (cookie[i].startsWith("SNID="))
				cookie[i] = cookie[i].substring(5);
			int equal = cookie[i].indexOf("=");
			String key = cookie[i].substring(0, equal);
			key = this.removeLeadingSpace(key);
			String value = cookie[i].substring(equal+1, cookie[i].length());
			value = this.removeLeadingSpace(value);
			kvp.add(new KeyValuePair(key, value));
		}
		return kvp;
	}
	
	public String removeLeadingSpace(String s){
		if (s.startsWith(" "))
			return s.substring(1);
		else
			return s;
	}

}
