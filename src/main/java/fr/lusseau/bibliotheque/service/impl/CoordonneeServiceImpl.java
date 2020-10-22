/**
 * 
 */
package fr.lusseau.bibliotheque.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.lusseau.bibliotheque.dao.CoordonneeDAO;
import fr.lusseau.bibliotheque.entity.Coordonnee;
import fr.lusseau.bibliotheque.service.CoordonneeService;

/**
 * Classe en charge de
 * @Version Bibliotheque -v1,0
 * @date  18 oct. 2020 - 08:20:42
 * @author Claude LUSSEAU
 *
 */
@Service("CoordonneeService")
@Transactional
public class CoordonneeServiceImpl implements CoordonneeService{
	
	@Autowired
	private CoordonneeDAO dao;
	

	/**
	 * @{inheritDoc}
	*/
	@Override
	public Coordonnee saveCoordonnee(Coordonnee coordonnee) {
		return dao.save(coordonnee);
	}

	/**
	 * @{inheritDoc}
	*/
	@Override
	public Coordonnee updateCoordonnee(Coordonnee coordonnee) {
		return dao.save(coordonnee);
	}

	/**
	 * @{inheritDoc}
	*/
	@Override
	public void deleteCoordonnee(Integer idCoordonnee) {
		dao.deleteById(idCoordonnee);
		
	}

	/**
	 * @{inheritDoc}
	*/
	@Override
	public boolean checkIfCoordonneeExists(Integer idCoordonnee) {
		return dao.existsById(idCoordonnee);
	}

	/**
	 * @{inheritDoc}
	*/
	@Override
	public Coordonnee findOne(Integer idCoordonnee) {
		return dao.getOne(idCoordonnee);
	}

	
	

}
