/**
 * 
 */
package fr.lusseau.bibliotheque.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import fr.lusseau.bibliotheque.entity.Editor;

/**
 * Classe en charge de
 * @Version Bibliotheque -v1,0
 * @date  14 août 2020 - 11:09:51
 * @author Claude LUSSEAU
 *
 */
@RepositoryRestResource
public interface EditorDAO extends JpaRepository<Editor, Integer> {
	
	List<Editor> findByNameContaining(String name);
	
	Editor findByName(String name);
	
	boolean existsByName(String name);
	

}
