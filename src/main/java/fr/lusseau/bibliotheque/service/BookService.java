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

	public Book saveBook (Book book);
	
	public Book updateBook (Book book);
	
	public void deleteBook(Integer idBook);
	
	public List<Book> findByTitleContainingIgnoreCase(String title);
		
	public boolean checkIfIdExists(Integer idBook);
	
	public Book findByTitle(String title);
	
	public List<Book> findAll();
	
	
}
