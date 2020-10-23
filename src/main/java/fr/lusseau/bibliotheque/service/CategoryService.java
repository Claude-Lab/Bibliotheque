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

	public Category saveCategory (Category category);
	
	public Category updateCategory (Category category);
	
	public void deleteCategory(Integer idPersonne);
	
	public List<Category> findByLabelContaining(String label);
	
	public Category findCategoryByLabelIgnoreCase(String label);
	
	public boolean checkIfIdExists(Integer idCategory);
}
