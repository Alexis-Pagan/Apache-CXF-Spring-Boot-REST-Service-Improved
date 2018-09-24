package restpro.response;

public class Response {

	private String message;
	private RestCustCode status;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public RestCustCode getStatus() {
		return status;
	}
	public void setStatus(RestCustCode status) {
		this.status = status;
	}
}
