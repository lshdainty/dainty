package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class WDB {

	public static void main(String[] args) {
		URL naver = null;
		
		try {
			naver = new URL("https://www.naver.com");
		} catch (MalformedURLException e) {
			
		}
		
		try {
			URLConnection naverConnection = naver.openConnection();
			InputStream is = naverConnection.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			
			String isLine;
			
			while((isLine = br.readLine())!=null) {
				System.out.println(isLine);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
