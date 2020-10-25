/**
 * 
 */
package fr.lusseau.bibliotheque.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.lusseau.bibliotheque.dao.StateDAO;
import fr.lusseau.bibliotheque.entity.State;
import fr.lusseau.bibliotheque.service.StateService;

/**
 * Class in charge of defining .
 * @Version Bibliotheque -v1,0
 * @date  23 oct. 2020 - 14:51:10
 * @author Claude LUSSEAU
 *
 */
@Service("StateService")
@Transactional
public class StateServiceImpl implements StateService {

	
	@Autowired
	private StateDAO dao;
	
	
	/**
	 * @{inheritDoc}
	*/
	@Override
	public State saveState(State state) {
		return dao.save(state);
	}

	/**
	 * @{inheritDoc}
	*/
	@Override
	public State updateState(State state) {
		return dao.save(state);
	}

	/**
	 * @{inheritDoc}
	*/
	@Override
	public void deleteState(Integer idState) {
		dao.deleteById(idState);
	}

	/**
	 * @{inheritDoc}
	*/
	@Override
	public State findStateByLabel(String label) {
		return dao.findByLabel(label);
	}

	/**
	 * @{inheritDoc}
	*/
	@Override
	public List<State> findByLabelContaining(String label) {
		return dao.findByLabelContaining(label);
	}

	/**
	 * @{inheritDoc}
	*/
	@Override
	public boolean checkIfIdExists(Integer idState) {
		return dao.existsById(idState);
	}
	
	/**
	 * @{inheritDoc}
	*/
	@Override
	public List<State> findAll() {
		return dao.findAll();
	}

}
