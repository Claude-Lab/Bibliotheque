/**
 * 
 */
package fr.lusseau.bibliotheque.utils;

import fr.lusseau.bibliotheque.dto.registration.BookRegister;
import fr.lusseau.bibliotheque.dto.request.BookRequest;
import fr.lusseau.bibliotheque.entity.Book;

/**
 * Class in charge of defining .
 * @Version Bibliotheque -v1,0
 * @date  2 janv. 2021 - 18:15:28
 * @author Claude LUSSEAU
 *
 */
public interface BookMapper {

	BookRequest entityToBookDto(Book user);
		
	BookRegister entityToBookDtoRegistration(Book user);
	
	Book BookDtoRegistrationToEntity(BookRegister dto);
	
	Book BookDtoToEntity(BookRequest dto);
}
