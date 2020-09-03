/**
 * 
 */
package fr.lusseau.bibliotheque.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import org.springframework.core.convert.converter.Converter;

/**
 * Classe en charge de la convertion des String en Date/Time.
 * @Version Bibliotheque -v1,0
 * @date  2 sept. 2020 - 11:10:36
 * @author Claude LUSSEAU
 *
 */
public class StringToDateTime implements Converter<String, LocalDateTime> {


	/**
	 * @{inheritDoc}
	*/
	@Override
	public LocalDateTime convert(String source) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy HH:mm", Locale.FRANCE);
        LocalDateTime date = LocalDateTime.parse(source, formatter);
		return date;
	}
}
