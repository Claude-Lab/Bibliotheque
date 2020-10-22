/**
 * 
 */
package fr.lusseau.bibliotheque.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.lusseau.bibliotheque.dao.CautionDAO;
import fr.lusseau.bibliotheque.entity.Caution;
import fr.lusseau.bibliotheque.service.CautionService;

/**
 * Classe en charge de
 * @Version Bibliotheque -v1,0
 * @date  18 oct. 2020 - 08:16:46
 * @author Claude LUSSEAU
 *
 */
@Service("CautionService")
@Transactional
public class CautionServiceImpl implements CautionService {

	@Autowired
	private CautionDAO dao;
	/**
	 * @{inheritDoc}
	*/
	@Override
	public Caution saveCaution(Caution caution) {
		return dao.save(caution);
	}

	/**
	 * @{inheritDoc}
	*/
	@Override
	public Caution updateCaution(Caution caution) {
		return dao.save(caution);
	}

	/**
	 * @{inheritDoc}
	*/
	@Override
	public void deleteCaution(Integer idCaution) {
		dao.deleteById(idCaution);
	}

	/**
	 * @{inheritDoc}
	*/
	@Override
	public boolean checkIfCautionExists(Integer idCaution) {
		return dao.existsById(idCaution);
	}

}
