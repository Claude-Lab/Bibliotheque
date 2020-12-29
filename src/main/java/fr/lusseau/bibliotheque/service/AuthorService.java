/**
 * 
 */
package fr.lusseau.bibliotheque.service;

import java.util.List;

import fr.lusseau.bibliotheque.entity.Author;

/**
 * Classe en charge de
 * @Version Bibliotheque -v1,0
 * @date  17 oct. 2020 - 10:15:59
 * @author Claude LUSSEAU
 *
 */
public interface AuthorService {
	
	List<Author> findAll();
	
	Author save(Author author);
	
	void delete(Integer id);
	
	Author getOne(Integer id);
	
	Author findByLastname(String lastname);
	
	List<Author> findByLastnameLikeIgnoreCase(String lastname);
	
	List<Author> findByLastnameContaining(String lastname);
	
	boolean checkIfIdexists(Integer id);
	
	boolean existsByFullname(String fullname);
}
