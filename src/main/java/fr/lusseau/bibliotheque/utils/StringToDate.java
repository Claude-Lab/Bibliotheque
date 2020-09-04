/**
 * 
 */
package fr.lusseau.bibliotheque.utils;

import java.io.Serializable;
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
public class StringToDate implements Converter<String, LocalDateTime>, Serializable {

	private static final long serialVersionUID = -4179256559659948676L;

	/**
	 * @{inheritDoc}
	*/
	@Override
	public LocalDateTime convert(String source) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy", Locale.FRANCE);
        LocalDateTime date = LocalDateTime.parse(source, formatter);
		return date;
	}
}
