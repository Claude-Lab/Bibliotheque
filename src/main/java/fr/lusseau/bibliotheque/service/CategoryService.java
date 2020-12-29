/**
 * 
 */
package fr.lusseau.bibliotheque.service;

import java.util.List;

import fr.lusseau.bibliotheque.entity.Category;

/**
 * Classe en charge de
 * @Version Bibliotheque -v1,0
 * @date  21 oct. 2020 - 13:58:30
 * @author Claude LUSSEAU
 *
 */
public interface CategoryService {

	Category save (Category category);
	
	Category update (Category category);
	
	void delete(Integer id);
	
	Category getOne(Integer id);
	
	List<Category> findAll();
	
	List<Category> findByLabelContaining(String label);
	
	Category findCategoryByLabelIgnoreCase(String label);
	
	boolean existsByLabel(String label);
	
	boolean existsByCode(String code);
	
}
