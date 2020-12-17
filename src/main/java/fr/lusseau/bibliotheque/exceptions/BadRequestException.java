/**
 * 
 */
package fr.lusseau.bibliotheque.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Class in charge of defining .
 * @Version Bibliotheque -v1,0
 * @date  14 déc. 2020 - 09:10:02
 * @author Claude LUSSEAU
 *
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException {

	private static final long serialVersionUID = 3707714022022276734L;

	public BadRequestException(String message) {
        super(message);
    }

    public BadRequestException(String message, Throwable cause) {
        super(message, cause);
    }
}