/**
 * 
 */
package fr.lusseau.bibliotheque.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.lusseau.bibliotheque.entity.Category;

/**
 * Classe en charge de
 * @Version Bibliotheque -v1,0
 * @date  19 oct. 2020 - 17:28:49
 * @author Claude LUSSEAU
 *
 */
@Repository
public interface CategoryDAO extends JpaRepository<Category, Integer>{

	List<Category> findByLabelContaining(String label);
	
	Category findCategoryByLabelIgnoreCase(String label);
}