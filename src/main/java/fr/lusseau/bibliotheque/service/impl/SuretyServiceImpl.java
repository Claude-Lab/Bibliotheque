/**
 * 
 */
package fr.lusseau.bibliotheque.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.lusseau.bibliotheque.dao.SuretyDAO;
import fr.lusseau.bibliotheque.entity.Surety;
import fr.lusseau.bibliotheque.service.SuretyService;

/**
 * Classe en charge de
 * @Version Bibliotheque -v1,0
 * @date  18 oct. 2020 - 08:16:46
 * @author Claude LUSSEAU
 *
 */
@Service("SuretyService")
@Transactional
public class SuretyServiceImpl implements SuretyService {

	@Autowired
	private SuretyDAO dao;
	/**
	 * @{inheritDoc}
	*/
	@Override
	public Surety save(Surety surety) {
		return dao.save(surety);
	}

	/**
	 * @{inheritDoc}
	*/
	@Override
	public void deleteSurety(Integer id) {
		dao.deleteById(id);
	}

	/**
	 * @{inheritDoc}
	*/
	@Override
	public boolean checkIfSuretyExists(Integer id) {
		return dao.existsById(id);
	}
	
	/**
	 * @{inheritDoc}
	*/
	@Override
	public List<Surety> findAll() {
		return dao.findAll();
	}
	
	/**
	 * @{inheritDoc}
	*/
	@Override
	public Surety getOne(Integer id) {
		return dao.getOne(id);
	}
	
	
	/**
	 * @{inheritDoc}
	*/
	@Override
	public Surety findByNbBooks(int nbBooks) {
		return dao.findByNbBooks(nbBooks);
	}

	/**
	 * @{inheritDoc}
	*/
	@Override
	public Surety findByValue(double value) {
		return dao.findByValue(value);
	}

	/**
	 * @{inheritDoc}
	*/
	@Override
	public boolean existsByValue(double value) {
		return dao.existsByValue(value);
	}

	/**
	 * @{inheritDoc}
	*/
	@Override
	public boolean existsByNbBooks(int nbBooks) {
		return dao.existsByNbBooks(nbBooks);
	}

}
