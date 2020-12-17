/**
 * 
 */
package fr.lusseau.bibliotheque.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Class in charge of defining .
 * @Version Bibliotheque -v1,0
 * @date  14 déc. 2020 - 09:09:15
 * @author Claude LUSSEAU
 *
 */
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class AppException extends RuntimeException {
    
	private static final long serialVersionUID = 833077951759347697L;

	public AppException(String message) {
        super(message);
    }

    public AppException(String message, Throwable cause) {
        super(message, cause);
    }
}
