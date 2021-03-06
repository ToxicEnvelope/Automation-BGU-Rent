package il.co.bgurent.BGU_Rent_App.core.apis;


import com.google.gson.Gson;
import com.google.gson.JsonObject;


public class SearchAPI extends AbstractAPIs {

	// FIELDS
	private int _rooms;
	private int _rent;
	private int _secId;
	
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
			if(rent >= 0  && rooms >= 0 && section >= 0) {
				String result = ParseQueryAndExecute(rent, rooms, section);
				System.out.println(result);
			}
			else {
				System.err.println("\n--XXXXXXXXXXXXXXXXXXXXX--"
						         + "\nPASSED INVALID PARAMETERS"
						         + "\n[rent]\t\t:\t" + rent
						         + "\n[rooms]\t\t:\t" + rooms
						         + "\n[section]\t:\t" + section
						         + "\nSending Request!");
				String result = ParseQueryAndExecute(rent, rooms, section);
				System.out.println(result);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public JsonObject sendGETJson(int rent, int rooms, int section) {
		try {
			if(rent >= 0  && rooms >= 0 && section >= 0) {
				String result = ParseQueryAndExecute(rent, rooms, section);
				_g = new Gson();
				return _g.fromJson(result, JsonObject.class);
			}
			else {
				
				System.err.println("\n--XXXXXXXXXXXXXXXXXXXXX--"
						         + "\nPASSED INVALID PARAMETERS"
						         + "\n[rent]\t\t:\t" + rent
						         + "\n[rooms]\t\t:\t" + rooms
						         + "\n[section]\t:\t" + section
						         + "\nSending Request!");
				String result = ParseQueryAndExecute(rent, rooms, section);
				_g = new Gson();
				return _g.fromJson(result, JsonObject.class);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
