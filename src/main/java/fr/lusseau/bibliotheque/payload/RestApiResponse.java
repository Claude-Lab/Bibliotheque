/**
 * 
 */
package fr.lusseau.bibliotheque.payload;

/**
 * Class in charge of defining .
 * 
 * @Version Bibliotheque -v1,0
 * @date 17 déc. 2020 - 10:53:16
 * @author Claude LUSSEAU
 *
 */
public class RestApiResponse {

	private Boolean success;
	private String message;

	public RestApiResponse(Boolean success, String message) {
		this.success = success;
		this.message = message;
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
