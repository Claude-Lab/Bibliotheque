/**
 * 
 */
package fr.lusseau.bibliotheque.service.impl;

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
	public Surety saveSurety(Surety surety) {
		return dao.save(surety);
	}

	/**
	 * @{inheritDoc}
	*/
	@Override
	public Surety updateSurety(Surety surety) {
		return dao.save(surety);
	}

	/**
	 * @{inheritDoc}
	*/
	@Override
	public void deleteSurety(Integer idSurety) {
		dao.deleteById(idSurety);
	}

	/**
	 * @{inheritDoc}
	*/
	@Override
	public boolean checkIfSuretyExists(Integer idSurety) {
		return dao.existsById(idSurety);
	}

}
