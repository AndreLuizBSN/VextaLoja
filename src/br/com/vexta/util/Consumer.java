package br.com.vexta.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Consumer {
	
	private String urlStr;

	public Consumer(String urlStr) {
		this.urlStr = urlStr;
	}
	
	public JSONObject getDatas() {
		
		JSONObject json = null;
				
		try {
			
			URL url = new URL(this.urlStr);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(
				(conn.getInputStream())));
			
			StringBuffer JsonStr = new StringBuffer();
			
			String output;
			char[] out;
			while ((output = br.readLine()) != null) {
				out = output.toCharArray();
				for (int i = 0; i < out.length; i++) {
					if(out[i] == '"') {
						out[i] = '\"';
					}
				}
				JsonStr.append(String.valueOf(out));
			}
						
			try {
				json = (JSONObject)new JSONParser().parse(JsonStr.toString());
				
			}catch (ParseException e) {
				
			}

			conn.disconnect();

		  } catch (MalformedURLException e) {

			e.printStackTrace();

		  } catch (IOException e) {

			e.printStackTrace();

		  }
		
		
		return json;
	}
}
