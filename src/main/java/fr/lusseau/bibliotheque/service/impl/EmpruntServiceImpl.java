/**
 * 
 */
package fr.lusseau.bibliotheque.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.lusseau.bibliotheque.dao.EmpruntDAO;
import fr.lusseau.bibliotheque.entity.Emprunt;
import fr.lusseau.bibliotheque.entity.EmpruntStatus;
import fr.lusseau.bibliotheque.service.EmpruntService;

/**
 * Classe en charge de
 * @Version Bibliotheque -v1,0
 * @date  18 oct. 2020 - 07:36:43
 * @author Claude LUSSEAU
 *
 */
@Service("EmpruntService")
@Transactional
public class EmpruntServiceImpl implements EmpruntService {

	@Autowired
	EmpruntDAO dao;
	
	/**
	 * @{inheritDoc}
	*/
	@Override
	public List<Emprunt> findAllEmpruntsByEndDateBefore(LocalDate maxEndDate) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @{inheritDoc}
	*/
	@Override
	public List<Emprunt> getAllOpenEmpruntsOfThisPersonne(String email, EmpruntStatus status) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @{inheritDoc}
	*/
	@Override
	public Emprunt getOpenedEmprunt(Emprunt emrpunt) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @{inheritDoc}
	*/
	@Override
	public boolean checkIfEmpruntExists(Emprunt emrpunt) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * @{inheritDoc}
	*/
	@Override
	public Emprunt saveEmprunt(Emprunt emrpunt) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @{inheritDoc}
	*/
	@Override
	public void closeEmprunt(Emprunt emrpunt) {
		// TODO Auto-generated method stub
		
	}

}
