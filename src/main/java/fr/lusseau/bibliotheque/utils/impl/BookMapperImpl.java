/**
 * 
 */
package fr.lusseau.bibliotheque.utils.impl;

import fr.lusseau.bibliotheque.dto.registration.BookRegister;
import fr.lusseau.bibliotheque.dto.request.BookRequest;
import fr.lusseau.bibliotheque.entity.Book;

/**
 * Class in charge of defining .
 * @Version Bibliotheque -v1,0
 * @date  4 janv. 2021 - 21:26:07
 * @author Claude LUSSEAU
 *
 */
public class BookMapperImpl {
	
	/**
	 * Transforme un entity en un POJO DTO.
	 * 
	 * @param User
	 * @return
	 */
	BookRequest entityToBookDto(Book book) {
		return null;
	}
	
	BookRegister entityToBookDtoRegistration(Book book){
		return null;
	}
	
	Book BookDtoRegistrationToEntity(BookRegister dto){
		return null;
	}
	
	Book BookDtoToEntity(BookRequest dto){
		return null;
	}


}
