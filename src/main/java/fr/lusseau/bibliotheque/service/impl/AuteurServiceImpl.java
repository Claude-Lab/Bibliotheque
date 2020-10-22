/**
 * 
 */
package fr.lusseau.bibliotheque.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.lusseau.bibliotheque.dao.AuteurDAO;
import fr.lusseau.bibliotheque.entity.Auteur;
import fr.lusseau.bibliotheque.service.AuteurService;

/**
 * Classe en charge de
 * @Version Bibliotheque -v1,0
 * @date  17 oct. 2020 - 10:22:52
 * @author Claude LUSSEAU
 *
 */
@Service("AuteurService")
@Transactional
public class AuteurServiceImpl implements AuteurService {

	@Autowired
	private AuteurDAO dao;
	
	
	public List<Auteur> findAllAuteur() {
		return dao.findAll();
	}
	
	@Override
	public Auteur saveAuteur(Auteur auteur) {
		return dao.save(auteur);
	}

	/**
	 * @{inheritDoc}
	*/
	@Override
	public Auteur updateAuteur(Auteur auteur) {
		return dao.save(auteur);
	}

	/**
	 * @{inheritDoc}
	*/
	@Override
	public void deleteAuteur(Integer idAuteur) {
		dao.deleteById(idAuteur);
	}

	/**
	 * @{inheritDoc}
	*/
	@Override
	public List<Auteur> findByPrenomNomContaining(String nom) {
		return dao.findByPrenomNomContaining((new StringBuilder()).append("%").append(nom).append("%").toString());
	}

	/**
	 * @{inheritDoc}
	*/
	@Override
	public boolean checkIfIdexists(Integer id) {
		return dao.existsById(id);
	}
	
	public List<Auteur> findByNomLikeIgnoreCase(String nom){
		return dao.findByNomLikeIgnoreCase(nom);
	}

	/**
	 * @{inheritDoc}
	*/
	@Override
	public Auteur findAuteurByPrenomNom(String prenomNom) {
		return dao.findByPrenomNom(prenomNom);
	}

}
