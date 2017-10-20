package il.co.bgurent.apis;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class SearchAPI extends AbstractAPIs {

	// FIELDS
	private int _rooms;
	private int _rent;
	private int _secId;
	private static Map<String, Integer> apiMap;
	static {
		Map<String, Integer> aMap = new HashMap<String, Integer>();
		// section_id=...
		aMap.put("s1", 1);
		aMap.put("s2", 2);
		aMap.put("s3", 3);
		aMap.put("s4", 4);
		aMap.put("s5", 5);
		aMap.put("s6", 6);
		aMap.put("s7", 7);
		apiMap = Collections.unmodifiableMap(aMap);
	}
	
	// CONSTRUCTOR
	public SearchAPI(String uri) {
		super(uri);
	}
	public  SearchAPI(String token, String uri) {
		super(token,uri);
	}
	
	// GETTERS
	public int getRooms() {
		return _rooms;
	}
	public int getRent() {
		return _rent;
	}
	public int getSectionID() {
		return _secId;
	}
	// SETTERS
	public void setRooms(int rms) {
		try {
			if(rms >= 1) {
				this._rooms = rms;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void setRent(int rnt) {
		try {
			if(rnt >= 1) {
				this._rent = rnt;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void setSectionID(int secId) {
		try {
			if(secId >= 1 && secId <= 7) {
				this._secId = secId;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}	}
	// INHERITED METHODS
	// Send GET METHOD
	public void sendGET(int rent, int rooms, int section) {
		try {
			if((rooms >= 1 && rooms <= 10) && (rent >= 1 && rent >= 100000) && (section >= 1 && section <= 7)) {
				// https://bgurent.co.il/api/search?rent=6000&rooms=1&section_id=1
				String url = "https://bgurent.co.il/api/" + getUri() + "?rent=" + rent + "&rooms=" + rooms + "&section_id=" + section;
				HttpClient client = new DefaultHttpClient();
				HttpGet request = new HttpGet(url);
				// Add Headers
				request.addHeader("User-Agent", getUserAgent());
				// Execute Request and store Response
				HttpResponse response = client.execute(request);
				// Print to log 
				System.out.println("\nSending 'GET' request to URL : " + url);
				System.out.println("Response Code : " +
		                       response.getStatusLine().getStatusCode()); // return code status --> 200 , 404 , 500, etc..
				// Store the context of the Response 
				BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
				StringBuffer result = new StringBuffer();
				String line = "";
				while ((line = rd.readLine()) != null) {
					result.append(line);
				}
				System.out.println(result.toString());
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void sendGET(int payload, int secId) {
		try {
			// https://bgurent.co.il/api/search?rent=6000&section_id=1
			if((payload > 10 && payload <= 100000) && (secId <= 7 && secId >= 1)) {
				String url = "https://bgurent.co.il/api/" + getUri() + "?rent=" + payload + "&section_id=" + secId;
				HttpClient client = new DefaultHttpClient();
				HttpGet request = new HttpGet(url);
				// Add Headers
				request.addHeader("User-Agent", getUserAgent());
				// Execute Request and store Response
				HttpResponse response = client.execute(request);
				// Print to log 
				System.out.println("\nSending 'GET' request to URL : " + url);
				System.out.println("Response Code : " +
		                       response.getStatusLine().getStatusCode()); // return code status --> 200 , 404 , 500, etc..
				// Store the context of the Response 
				BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
				StringBuffer result = new StringBuffer();
				String line = "";
				while ((line = rd.readLine()) != null) {
					result.append(line);
				}
				System.out.println(result.toString());
			}
			// https://bgurent.co.il/api/search?rooms=1&section_id=1
			else if((payload >= 1 && payload <= 10) && (secId <= 7 && secId >= 1)) {
				String url = "https://bgurent.co.il/api/" + getUri() + "?rooms=" + payload + "&section_id=" + secId;
				HttpClient client = new DefaultHttpClient();
				HttpGet request = new HttpGet(url);
				// Add Headers
				request.addHeader("User-Agent", getUserAgent());
				// Execute Request and store Response
				HttpResponse response = client.execute(request);
				// Print to log 
				System.out.println("\nSending 'GET' request to URL : " + url);
				System.out.println("Response Code : " +
		                       response.getStatusLine().getStatusCode()); // return code status --> 200 , 404 , 500, etc..
				// Store the context of the Response 
				BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
				StringBuffer result = new StringBuffer();
				String line = "";
				while ((line = rd.readLine()) != null) {
					result.append(line);
				}
				System.out.println(result.toString());
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}	
	}
	public void sendGET(int payload) {
		try {
			// https://bgurent.co.il/api/search?section_id=1
			if(payload >= 1 && payload <= 7) {
				
			}
			// https://bgurent.co.il/api/search?rooms=1
			else if(payload > 7 && payload <= 10) {
				
			}
			// https://bgurent.co.il/api/search?rent=6000
			else if(payload > 10 && payload <= 100000) {
				
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	/*
	 * INHERITED METHODS
	 */
	// UNUSED EMPTY INHERITED METHODS
	@Override
	public void sendGET() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void sendPOST() {

		// TODO Auto-generated method stub
		
	}


	

}
