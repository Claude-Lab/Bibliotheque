/**
 * 
 */
package fr.lusseau.bibliotheque.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.lusseau.bibliotheque.dao.BibliothequeDAO;
import fr.lusseau.bibliotheque.entity.Bibliotheque;
import fr.lusseau.bibliotheque.service.BibliothequeService;

/**
 * Classe en charge de
 * @Version Bibliotheque -v1,0
 * @date  18 oct. 2020 - 08:10:52
 * @author Claude LUSSEAU
 *
 */
@Service("BibliothequeService")
@Transactional
public class BibliothequeServiceImpl implements BibliothequeService {

	@Autowired
	private BibliothequeDAO dao;

	
	public List<Bibliotheque> findAllBibliotheque() {
		return dao.findAll();
	}
	
	/**
	 * @{inheritDoc}
	*/
	@Override
	public Bibliotheque saveBibliotheque(Bibliotheque bibliotheque) {
		return dao.save(bibliotheque);
	}

	/**
	 * @{inheritDoc}
	*/
	@Override
	public Bibliotheque updateBibliotheque(Bibliotheque bibliotheque) {
		return dao.save(bibliotheque);
	}

	/**
	 * @{inheritDoc}
	*/
	@Override
	public void deleteBibliotheque(Integer idBibliotheque) {
		dao.deleteById(idBibliotheque);
	}

	/**
	 * @{inheritDoc}
	*/
	@Override
	public List<Bibliotheque> findByNomContaining(String nom) {
		return dao.findByNomContaining(nom);
	}

	/**
	 * @{inheritDoc}
	*/
	@Override
	public boolean checkIsBibliothequExists(Integer idBibliotheque) {
		return dao.existsById(idBibliotheque);
	}

	/**
	 * @{inheritDoc}
	*/
	@Override
	public Bibliotheque findBibliothequeByCoordonneeEmail(@Param("email") String email) {
		return dao.findBibliothequeByCoordonneeEmail(email);
	}

	/**
	 * @{inheritDoc}
	*/
	@Override
	public Bibliotheque findByNom(String nom) {
		return dao.findByNom(nom);
	}

	/**
	 * @{inheritDoc}
	*/
	@Override
	public Bibliotheque findOne(Integer idBibliotheque) {
		return dao.getOne(idBibliotheque);
	}
	
	
}
