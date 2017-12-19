package il.co.bgurent.BGU_Rent_App.core.apis;

public interface IRequestProcessor {
	StringBuffer ExecutRequest(String url);
	String ParseQueryAndExecute(int rent, int rooms, int section);
}
