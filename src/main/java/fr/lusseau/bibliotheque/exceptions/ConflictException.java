/**
 * 
 */
package fr.lusseau.bibliotheque.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Class in charge of defining .
 * @Version Bibliotheque -v1,0
 * @date  18 déc. 2020 - 10:57:57
 * @author Claude LUSSEAU
 *
 */
@ResponseStatus(HttpStatus.CONFLICT)
public class ConflictException extends RuntimeException {

	private static final long serialVersionUID = -5903338757826089772L;

	public ConflictException(String message) {
        super(message);
    }

    public ConflictException(String message, Throwable cause) {
        super(message, cause);
    }
}
