/**
 * 
 */
package fr.lusseau.bibliotheque.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.lusseau.bibliotheque.dao.PersonneDAO;
import fr.lusseau.bibliotheque.entity.Personne;
import fr.lusseau.bibliotheque.service.PersonneService;

/**
 * Classe en charge de
 * @Version Bibliotheque -v1,0
 * @date  18 oct. 2020 - 07:56:22
 * @author Claude LUSSEAU
 *
 */
@Service("PersonneService")
@Transactional
public class PersonneServiceImpl implements PersonneService {

	
	@Autowired
	private PersonneDAO dao;
	/**
	 * @{inheritDoc}
	*/
	@Override
	public Personne savePersonne(Personne personne) {
		return dao.save(personne);
	}

	/**
	 * @{inheritDoc}
	*/
	@Override
	public Personne updatePersonne(Personne personne) {
		return dao.save(personne);
	}

	/**
	 * @{inheritDoc}
	*/
	@Override
	public void deletePersonne(Integer idPersonne) {
		dao.deleteById(idPersonne);
	}

	/**
	 * @{inheritDoc}
	*/
	@Override
	public boolean checkIfIdExists(Integer idPersonne) {
		return dao.existsById(idPersonne);
	}

	/**
	 * @{inheritDoc}
	*/
	@Override
	public Personne findPersonneByCoordonneeEmail(@Param("email") String email) {
		return dao.findPersonneByCoordonneeEmail(email);
	}
	
	/**
	 * @{inheritDoc}
	*/
	public Personne findPersonneById(Integer personneId) {
		return dao.getOne(personneId);
	}

	/**
	 * @{inheritDoc}
	*/
	@Override
	public List<Personne> findPersonneByNomIgnoreCase(String nom) {
		return dao.findNomByNomIgnoreCase(nom);
	}

	/**
	 * @{inheritDoc}
	*/
	@Override
	public List<Personne> findByNomContaining(String nom) {
		return dao.findByNomContaining(nom);
	}

//	/**
//	 * @{inheritDoc}
//	*/
//	@Override
//	public Personne findEmail(Personne personne) {
//		return dao.findEmail(personne);
//	}

	

	
	

}
