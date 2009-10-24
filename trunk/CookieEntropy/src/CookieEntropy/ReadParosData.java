package CookieEntropy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;

public class ReadParosData {
	String[] allCookies;

	ReadParosData(File inputFile, String host) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(inputFile));
		List<String> cookies = new LinkedList<String>();

		String line = "";

		while ((line = br.readLine()) != null) {
			if (line.startsWith("Host: ") && line.contains(host)) {
				while ((line = br.readLine()) != null) {
					if (line.startsWith("Cookie: ")) {
						line = line.substring(8);
						cookies.add(line);
						break;
					}
				}
			}
		}
		allCookies = cookies.toArray(new String[0]);
	}
	
	public String[] getCookies(){
		return allCookies;
	}

	public static void main(String[] args) {
		JFileChooser jfc = new JFileChooser(System.getProperty("user.dir"));
		jfc.addChoosableFileFilter(new ParosDataFileFilter());
		ReadParosData rpd;
		if (jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {

			try {
				rpd = new ReadParosData(jfc.getSelectedFile(),
						"google.com");
				String[] cookies = rpd.getCookies();
				
				for (int i = 0; i < cookies.length; i++){
					CookieParser cp = new CookieParser(cookies[i]);
					List<KeyValuePair> cookieList = cp.parseCookie();
					Iterator<KeyValuePair> cookieIterator = cookieList.iterator();
					while (cookieIterator.hasNext()) {
						System.out.println(cookieIterator.next().toString());
					}
				}
			} catch (IOException ioe) {
				System.out.println("Error reading file!");
			}
		}
		
		
	}
}