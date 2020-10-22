/**
 * 
 */
package fr.lusseau.bibliotheque.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.lusseau.bibliotheque.dao.CategorieDAO;
import fr.lusseau.bibliotheque.entity.Categorie;
import fr.lusseau.bibliotheque.service.CategorieService;

/**
 * Classe en charge de
 * @Version Bibliotheque -v1,0
 * @date  21 oct. 2020 - 13:59:04
 * @author Claude LUSSEAU
 *
 */
@Service("CategorieService")
@Transactional
public class CategorieServiceImpl implements CategorieService{

	@Autowired
	private CategorieDAO dao;
	
	/**
	 * @{inheritDoc}
	*/
	@Override
	public Categorie saveCategorie(Categorie categorie) {
		return dao.save(categorie);
	}

	/**
	 * @{inheritDoc}
	*/
	@Override
	public Categorie updateCategorie(Categorie categorie) {
		return dao.save(categorie);
	}

	/**
	 * @{inheritDoc}
	*/
	@Override
	public void deleteCategorie(Integer idCategorie) {
		dao.deleteById(idCategorie);
	}

	/**
	 * @{inheritDoc}
	*/
	@Override
	public List<Categorie> findByLibelleContaining(String libelle) {
		return dao.findByLibelleContaining(libelle);
	}

	/**
	 * @{inheritDoc}
	*/
	@Override
	public Categorie findCategorieByLibelleIgnoreCase(String libelle) {
		return dao.findCategorieByLibelleIgnoreCase(libelle);
	}

	/**
	 * @{inheritDoc}
	*/
	@Override
	public boolean checkIfIdExists(Integer idCategorie) {
		return dao.existsById(idCategorie);
	}

	/**
	 * Methode en charge de
	 * @param categorie
	 * @return
	 */
	public List<Categorie> findAllCategorie() {
		return dao.findAll();
	}

}
