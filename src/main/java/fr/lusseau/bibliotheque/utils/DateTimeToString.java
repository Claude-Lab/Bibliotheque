/**
 * 
 */
package fr.lusseau.bibliotheque.utils;

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
public class DateTimeToString implements Converter<LocalDateTime, String>{
	
	

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
