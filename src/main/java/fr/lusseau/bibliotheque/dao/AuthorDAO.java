/**
 * 
 */
package fr.lusseau.bibliotheque.dao;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
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
	
	@Query(value = "select distinct a.firstname, a.lasttname, a.id_author from Author a left join Book_Author e on e.id_author = a.id_author left join Book l on l.id_book = e.id_book where l.id_book= :id_book")
	List<Author> findByBooks(@Param("id_book") int idBook);
	
	List<Author> findByLastNameLikeIgnoreCase(String lastName);
	
	Author findByLastName(String lastName);
	
	Author findAuthorByIdAuthor(Integer idAuthor);
	
	List<Author> findByLastNameContaining(String lastName);

	
}
