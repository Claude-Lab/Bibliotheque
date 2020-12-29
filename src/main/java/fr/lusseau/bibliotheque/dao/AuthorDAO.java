/**
 * 
 */
package fr.lusseau.bibliotheque.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import fr.lusseau.bibliotheque.entity.Author;

/**
 * Classe en charge de
 * @Version Bibliotheque -v1,0
 * @date  21 août 2020 - 12:22:35
 * @author Claude LUSSEAU
 *
 */
@RepositoryRestResource
public interface AuthorDAO extends JpaRepository<Author, Integer> {
	
	List<Author> findByLastnameLikeIgnoreCase(String lastname);
	
	List<Author> findByFirstnameLikeIgnoreCase(String lastname);
	
	Author findByLastname(String lastname);
	
	List<Author> findByLastnameContaining(String lastname);
	
	List<Author> findByFirstnameContaining(String lastname);

	boolean existsByFullname(String fullname);
	
}
