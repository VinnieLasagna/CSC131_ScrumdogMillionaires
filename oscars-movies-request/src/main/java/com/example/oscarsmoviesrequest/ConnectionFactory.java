package com.example.oscarsmoviesrequest;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map.Entry;

public class ConnectionFactory {
	private double API_VERSION = 0;
	private String API = "";
	private String METHOD = "POST";
	private String TYPE = "application/x-www-form-urlencoded";
	private String USER_AGENT = "Mozilla/5.0";
	private String data = "";
	private URL connection;
	private HttpURLConnection finalConnection;
	
	private HashMap<String, String> fields = new HashMap<String, String>();
	//private List<String[]> fields = new ArrayList<String[]>();
	
	public ConnectionFactory(String[] endpoint, String url, double version) {
		this.API_VERSION = version;
		this.API = url;
		fields.put("version",String.valueOf(version));
		//fields.add(version);
		for (int i = 0; i < endpoint.length; i++) {
			String[] points = endpoint[i].split(";");
			for (int j = 0; j < points.length; j++) {
				fields.put(points[j].split(":")[0], points[j].split(":")[1]);
			}
		}
	}
	
	public String buildConnection() {
		StringBuilder content = new StringBuilder();
		if (!this.getEndpoints().equals("") && !this.getEndpoints().isEmpty()) {
			String vars = "";
			String vals = "";
			try {
				for (Entry<String, String> entry : fields.entrySet()) {
					vars = entry.getKey();
					vals = entry.getValue();
					data += ("&" + vars + "=" + vals);
				}
				
				if (data.startsWith("&")) {
					data = data.replaceFirst("&", "");
				}
				connection = new URL(API);
				BufferedReader reader = new BufferedReader(new InputStreamReader(readWithAccess(connection, data)));
				String line;
				while ((line = reader.readLine()) != null) {
					content.append(line + "\n");					
				}
				
				reader.close();
				return content.toString();
			} catch(Exception e) {
				System.err.println(e.getMessage());
			}
		}
		else {
			return null;
		}
		return null;
	}
	
	private InputStream readWithAccess(URL url, String data) {
		try {
			byte[] out = data.toString().getBytes();
			finalConnection = (HttpURLConnection) url.openConnection();
			finalConnection.setRequestMethod(METHOD);
			finalConnection.setDoOutput(true);
			finalConnection.addRequestProperty("User-Agent", USER_AGENT);
			finalConnection.addRequestProperty("Content-Type", TYPE);
			finalConnection.connect();
			try {
				OutputStream os = finalConnection.getOutputStream();
				os.write(out);
			} catch(Exception e) {
				System.err.println(e.getMessage());
			}
			return finalConnection.getInputStream();
		} catch(Exception e) {
			System.err.println(e.getMessage());
			return null;
		}
	}
	
	
	public String getApiVersion() {
		return String.valueOf(API_VERSION);
	}
	
	public String getEndpoints() {
		return fields.toString();
	}
	
	public String getEndpointValue(String key) {
		return fields.get(key);
	}
	
	public void setUserAgent(String userAgent) {
		this.USER_AGENT = userAgent;
	}
	
	public void setMethod(String method) {
		this.METHOD = method;
	}
	
	public void setSubmissionType(String type) {
		this.TYPE = type;
	}
}