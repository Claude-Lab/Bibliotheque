/**
 * 
 */
package fr.lusseau.bibliotheque.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
/**
 * Classe en charge de
 * @Version Bibliotheque -v1,0
 * @date  9 oct. 2020 - 17:51:52
 * @author Claude LUSSEAU
 *
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public ResourceNotFoundException(String message) {
		super(message);
	}
}
