/**
 * 
 */
package fr.lusseau.bibliotheque.service;

import java.util.List;

import fr.lusseau.bibliotheque.entity.Editor;

/**
 * Classe en charge de
 * 
 * @Version Bibliotheque -v1,0
 * @date 17 oct. 2020 - 17:40:06
 * @author Claude LUSSEAU
 *
 */
public interface EditorService {

	Editor save(Editor editor);

	Editor update(Editor editor);

	void delete(Integer id);

	List<Editor> findByNameContaining(String name);
	
	List<Editor> findAll();
	
	Editor findByName(String name);
	
	Editor getOne(Integer id);
	
	boolean existsByName(String name);

}
