/**
 * 
 */
package fr.lusseau.bibliotheque.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Classe en charge de
 * @Version Bibliotheque -v1,0
 * @date  14 sept. 2020 - 21:03:18
 * @author Claude LUSSEAU
 *
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class AuteurIntrouvableException extends RuntimeException {
	
	private static final long serialVersionUID = 6857916420339077542L;

	public AuteurIntrouvableException (String message) {
		
		super(message);
	}

}
