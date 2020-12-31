/**
 * 
 */
package fr.lusseau.bibliotheque.service;

import java.util.List;
import java.util.Optional;

import fr.lusseau.bibliotheque.entity.Library;

/**
 * Classe en charge de
 * @Version Bibliotheque -v1,0
 * @date  17 oct. 2020 - 17:29:56
 * @author Claude LUSSEAU
 *
 */
public interface LibraryService {

	Library save (Library library);

	Library update (Library library);
	
	void delete (Integer id);
	
	Optional<Library> findById(Integer id);
	
	List<Library> findAll();
	
	List<Library> findByNameContaining(String name);
	
	Library findByName(String name);
	
	Library getOne(Integer id);
	
	boolean existsByName(String name);

}
