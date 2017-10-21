package il.co.bgurent.apis;


public abstract class AbstractAPIs {
	
	// FIELDS
	private String _uri;
	private String _token;
	private String _userAgent = "Mozilla/5.0";
	
	
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
	// ABSTRACT METHODS
	protected abstract void sendGET();
	protected abstract void sendPOST();
}
