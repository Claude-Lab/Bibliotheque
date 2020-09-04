/**
 * 
 */
package fr.lusseau.bibliotheque.utils;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.core.convert.converter.Converter;

/**
 * Classe en charge de la convertion des dates en String.
 * 
 * @Version Bibliotheque -v1,0
 * @date 2 sept. 2020 - 10:35:20
 * @author Claude LUSSEAU
 *
 */
public class DateTimeToString implements Converter<LocalDateTime, String>, Serializable {
	
	
	private static final long serialVersionUID = -2382317313482415397L;

	/**
	 * @{inheritDoc}
	*/
	@Override
	public String convert(LocalDateTime source) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		String formatDateTime = source.format(formatter);
		return formatDateTime;
	}

}
