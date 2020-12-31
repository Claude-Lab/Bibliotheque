/**
 * 
 */
package fr.lusseau.bibliotheque.service;

import java.util.List;

import fr.lusseau.bibliotheque.entity.Book;

/**
 * Class in charge of defining .
 * @Version Bibliotheque -v1,0
 * @date  25 oct. 2020 - 12:29:02
 * @author Claude LUSSEAU
 *
 */
public interface BookService {

	Book save(Book book);
	
	Book update(Book book);
	
	void delete(Integer idBook);
	
	List<Book> findByTitleContainingIgnoreCase(String title);
		
	Book findByTitle(String title);
	
	List<Book> findAll();
	
	Book getOne(Integer id);
	
	boolean existsByIsbn(String isbn);
	
	boolean existsByTitle(String title);
	
	
}
