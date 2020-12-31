/**
 * 
 */
package fr.lusseau.bibliotheque.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import fr.lusseau.bibliotheque.entity.Library;

/**
 * Interface en charge de la liaison service-persistence de la class Bibliotheque.
 * @Version Bibliotheque -v1,0
 * @date  14 août 2020 - 11:10:17
 * @author Claude LUSSEAU
 *
 */
@RepositoryRestResource
public interface LibraryDAO extends JpaRepository<Library, Integer>{

	
	List<Library> findByNameContaining(String name);
	
	Library findByName(String name);
	
	boolean existsByName(String name);
	

}
