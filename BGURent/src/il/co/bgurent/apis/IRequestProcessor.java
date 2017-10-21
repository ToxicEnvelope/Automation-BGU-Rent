package il.co.bgurent.apis;

public interface IRequestProcessor {
	StringBuffer ExecutRequest(String url);
	String ParseQueryAndExecute(int rent, int rooms, int section);
}
