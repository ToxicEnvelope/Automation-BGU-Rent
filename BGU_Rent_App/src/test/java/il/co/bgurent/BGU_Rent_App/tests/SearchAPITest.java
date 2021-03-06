package il.co.bgurent.BGU_Rent_App.tests;



import java.util.Map.Entry;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import il.co.bgurent.BGU_Rent_App.core.apis.SearchAPI;


public class SearchAPITest {

	
	// FIELDS
	SearchAPI searchAPI = new SearchAPI("search");
	static final String DATA = System.getProperty("user.dir") + "/src/il/co/bgurent/or/datafile.properties";
	
	
	@Test
	public void TEST_SearchAPI_GET() throws Exception {
		/*
		 * 0/1 <= x <= 100,000
		 * 0/1 <= y <= 10
		 * 0/1 <= z <= 7
		 * Passing 0 will assure that the parameter's field will not be sent in the API call.
		 */
		// Simple Coverage
		searchAPI.sendGET(1,1,1);		// 1% 
		searchAPI.sendGET(50000,5,4);   // 50%
		searchAPI.sendGET(100000,10,7); // 100%

		// Boundary Values
		searchAPI.sendGET(100001,11,8); // out of bound  --> returns empty array
		searchAPI.sendGET(-1,-1,-1);	// Negative test
		
		// Single uri
		searchAPI.sendGET(0,0,0);
		searchAPI.sendGET(0,0,1);
		searchAPI.sendGET(0,1,0);
		searchAPI.sendGET(0,1,1);
		searchAPI.sendGET(1,0,0);
		searchAPI.sendGET(1,0,1);
		searchAPI.sendGET(1,1,0);
		searchAPI.sendGET(1,1,1);
		
		// JSON Data Fetch
		JsonObject jsObj = searchAPI.sendGETJson(1,1,1);
		for(Entry<String, JsonElement> entry : jsObj.entrySet()) {
			JsonElement val = entry.getValue();
			Assert.assertNotEquals(val, "[]");
			continue;
		}
	}
}
