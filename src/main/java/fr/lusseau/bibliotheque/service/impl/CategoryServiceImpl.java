/**
 * 
 */
package fr.lusseau.bibliotheque.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.lusseau.bibliotheque.dao.CategoryDAO;
import fr.lusseau.bibliotheque.entity.Category;
import fr.lusseau.bibliotheque.service.CategoryService;

/**
 * Classe en charge de
 * @Version Bibliotheque -v1,0
 * @date  21 oct. 2020 - 13:59:04
 * @author Claude LUSSEAU
 *
 */
@Service("CategoryService")
@Transactional
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryDAO dao;
	
	/**
	 * @{inheritDoc}
	*/
	@Override
	public Category saveCategory(Category categorie) {
		return dao.save(categorie);
	}

	/**
	 * @{inheritDoc}
	*/
	@Override
	public Category updateCategory(Category categorie) {
		return dao.save(categorie);
	}

	/**
	 * @{inheritDoc}
	*/
	@Override
	public void deleteCategory(Integer idCategory) {
		dao.deleteById(idCategory);
	}

	/**
	 * @{inheritDoc}
	*/
	@Override
	public List<Category> findByLabelContaining(String label) {
		return dao.findByLabelContaining(label);
	}

	/**
	 * @{inheritDoc}
	*/
	@Override
	public Category findCategoryByLabelIgnoreCase(String label) {
		return dao.findCategoryByLabelIgnoreCase(label);
	}

	/**
	 * @{inheritDoc}
	*/
	@Override
	public boolean checkIfIdExists(Integer idCategory) {
		return dao.existsById(idCategory);
	}

	/**
	 * Methode en charge de
	 * @param categorie
	 * @return
	 */
	public List<Category> findAllCategory() {
		return dao.findAll();
	}

}
