package il.co.bgurent.tests;



import org.testng.annotations.Test;

import il.co.bgurent.apis.SearchAPI;

public class SearchAPITest {

	
	// FIELDS
	SearchAPI api = new SearchAPI("search");
	
	@Test
	public void startUp() {
		//api.sendGET(6000, 3, 5);
		api.sendGET(11, 5);
	}
}