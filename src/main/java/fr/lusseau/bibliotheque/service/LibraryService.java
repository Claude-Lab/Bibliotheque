/**
 * 
 */
package fr.lusseau.bibliotheque.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import fr.lusseau.bibliotheque.entity.Library;

/**
 * Classe en charge de
 * @Version Bibliotheque -v1,0
 * @date  17 oct. 2020 - 17:29:56
 * @author Claude LUSSEAU
 *
 */
public interface LibraryService {

	public Library saveLibrary (Library library);

	public Library updateLibrary (Library library);
	
	public void deleteLibrary (Integer idLibrary);
	
	public List<Library> findByNameContaining(String name);
	
	public boolean checkIsLibraryExists(Integer idLibrary);
	
	public Library findLibraryByContactEmail(@Param("email") String email);
	
	public Library findByName(String name);
	
	public Library findOne(Integer idLibrary);

}
