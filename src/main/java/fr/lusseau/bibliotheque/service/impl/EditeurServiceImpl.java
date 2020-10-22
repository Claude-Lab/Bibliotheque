/**
 * 
 */
package fr.lusseau.bibliotheque.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.lusseau.bibliotheque.dao.EditeurDAO;
import fr.lusseau.bibliotheque.entity.Editeur;
import fr.lusseau.bibliotheque.service.EditeurService;

/**
 * Classe en charge de
 * @Version Bibliotheque -v1,0
 * @date  18 oct. 2020 - 08:23:37
 * @author Claude LUSSEAU
 *
 */
@Service("EditeurService")
@Transactional
public class EditeurServiceImpl implements EditeurService {

	@Autowired
	private EditeurDAO dao;
	/**
	 * @{inheritDoc}
	*/
	@Override
	public Editeur saveEditeur(Editeur editeur) {
		return dao.save(editeur);
	}

	/**
	 * @{inheritDoc}
	*/
	@Override
	public Editeur updateEditeur(Editeur editeur) {
		return dao.save(editeur);
	}

	/**
	 * @{inheritDoc}
	*/
	@Override
	public void deleteEditeur(Integer idEditeur) {
		dao.deleteById(idEditeur);
	}

	/**
	 * @{inheritDoc}
	*/
	@Override
	public List<Editeur> findByNomContaining(String nom) {
		return dao.findByNomContaining(nom);
	}

	/**
	 * @{inheritDoc}
	*/
	@Override
	public boolean checkIfEditeurExists(Integer idEditeur) {
		return dao.existsById(idEditeur);
	}

}
