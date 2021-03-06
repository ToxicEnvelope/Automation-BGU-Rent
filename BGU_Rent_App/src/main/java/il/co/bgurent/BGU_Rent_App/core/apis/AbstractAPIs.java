package il.co.bgurent.BGU_Rent_App.core.apis;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import com.google.gson.Gson;


public abstract class AbstractAPIs implements IRequestProcessor {
	
	// FIELDS
	private String _uri;
	private String _token;
	private String _userAgent = "Mozilla/5.0";
	protected static Gson _g;
	private final String _apiUrl = "https://bgurent.co.il/api/";
	
	
	// CONSTRUCTOROS
	public AbstractAPIs(String uri) {
		if(uri != null && !uri.isEmpty()) {
			this._uri = uri;
		}
	}
	public AbstractAPIs(String token, String uri) {
		if((token != null && !token.isEmpty()) && (uri != null && !uri.isEmpty())) {
			this._token = token;
			this._uri = uri;
		}
	}
	
	// GETTERS
	protected String getUserAgent() {
		return _userAgent;
	}
	protected String getUri() {
		return _uri;
	}
	protected String getToken() {
		return _token;
	}
	// SETTERS
	protected void setUri(String uri) {
		try {
			if(uri != null && !uri.isEmpty()) {
				this._uri = uri;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	protected void setUserAgent(String ua) {
		try {	
			if(ua != null && !ua.isEmpty()) {
				this._userAgent = ua;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	protected void setToken(String token) {
		try {
			if(token != null && !token.isEmpty()) {
				this._token = token;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	// ParseQuery
	public String ParseQueryAndExecute(int rent, int rooms, int section) {
		try {
			String strResponse = null;
			// https://bgurent.co.il/api/search?rent=6000&rooms=1&section_id=1
			if((rent != 0 && rooms != 0 && section != 0)) {
				// Execute API request with : rent & rooms & section_id
				strResponse = ExecutRequest(_apiUrl + getUri() + "?rent=" + rent + "&rooms=" + rooms + "&section_is=" + section).toString();
			}
			// https://bgurent.co.il/api/search?rent=6000&rooms=1
			else if((rent != 0 && rooms != 0 && section == 0)) {
				// Execute API request with : rent & rooms
				strResponse = ExecutRequest(_apiUrl + getUri() + "?rent=" + rent + "&rooms=" + rooms).toString();
			}
			// https://bgurent.co.il/api/search?rent=6000&section_id=1
			else if((rent != 0 && rooms == 0 && section != 0)) {
				// Execute API request with : rent & section_id
				strResponse = ExecutRequest(_apiUrl + getUri() + "?rent=" + rent + "&section_id=" + section).toString();
			}
			// https://bgurent.co.il/api/search?rooms=1&section_id=1
			else if((rent == 0 && rooms != 0 && section != 0)) {
				// Execute API request with : rooms & section_id
				strResponse = ExecutRequest(_apiUrl + getUri() + "?rooms=" + rooms + "&section_id=" + section).toString();
			}
			// https://bgurent.co.il/api/search?rent=1
			else if((rent != 0 && rooms == 0 && section == 0)) {
				// Execute API request with : rent
				strResponse = ExecutRequest(_apiUrl + getUri() + "?rent=" + rent).toString();
			}
			// https://bgurent.co.il/api/search?rooms=1
			else if((rent == 0 && rooms != 0 && section == 0)) {
				// Execute API request with : rooms
				strResponse = ExecutRequest(_apiUrl + getUri() + "?rooms=" + rooms).toString();
			}
			// https://bgurent.co.il/api/search?section_id=1
			else if((rent == 0 && rooms == 0 && section != 0)) {
				// Execute API request with : section_id
				strResponse = ExecutRequest(_apiUrl + getUri() + "?section_id=" + section).toString();
			}
			else {
				return ("\nUNKNOWN PARAMETERS!"
				      + "\n[rent]\t\t:\t" + rent
				      + "\n[rooms]\t\t:\t" + rooms
                      + "\n[section]\t:\t" + section);
			}
			return strResponse;
		}
		catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}
	// ExecuteRequest
	public StringBuffer ExecutRequest(String url) {
		try {
			// https://bgurent.co.il/api/search?rent=6000&rooms=1&section_id=1
			//String url = "https://bgurent.co.il/api/" + getUri() + "?section_id=" + section;
			HttpClient client = new DefaultHttpClient();
			HttpGet request = new HttpGet(url);
			// Add Headers
			request.addHeader("User-Agent", getUserAgent());
			// Execute Request and store Response
			HttpResponse response = client.execute(request);
			
			// Store Status Code as Integer
			// 200 , 404, 500, etc..
			int statusCode = response.getStatusLine().getStatusCode();
			if(statusCode == 200) {
				// Print the Response to Log
				System.out.println("\nSending 'GET' request to URL : " + url
								 + "\nResponse Code : " + statusCode); 
			}
			else {
				System.err.println("\nXXXXXXXXXXXXXXXXXXXX"
								 + "\nINCORRECT RESULTS!!!"
								 + "\nSending 'GET' request to URL : " + url
						         + "\nResponse Code : " + statusCode); 
			}
			// Store the context of the Response 
			BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			StringBuffer result = new StringBuffer();
			String line = "";
			while ((line = rd.readLine()) != null) {
				result.append(line);
			}
			return result;
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
