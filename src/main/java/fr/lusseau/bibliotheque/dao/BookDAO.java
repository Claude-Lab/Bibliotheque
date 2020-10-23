/**
 * 
 */
package fr.lusseau.bibliotheque.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.lusseau.bibliotheque.entity.Book;

/**
 * Classe en charge de
 * @Version Bibliotheque -v1,0
 * @date  14 août 2020 - 10:55:17
 * @author Claude LUSSEAU
 *
 */
@Repository
public interface BookDAO extends JpaRepository<Book, Integer> {


	Book findByTitle(String title);
	
	long count();
	
}
