/**
 * 
 */
package fr.lusseau.bibliotheque.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import fr.lusseau.bibliotheque.entity.Book;

/**
 * Classe en charge de
 * @Version Bibliotheque -v1,0
 * @date  14 août 2020 - 10:55:17
 * @author Claude LUSSEAU
 *
 */
@RepositoryRestResource
public interface BookDAO extends JpaRepository<Book, Integer> {


	List<Book> findByTitleContainingIgnoreCase(String title);
	
	Book findByTitle(String title);
	
	long count();

	boolean existsByIsbn(String isbn);
	
	boolean existsByTitle(String title);
	
}
