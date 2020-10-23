/**
 * 
 */
package fr.lusseau.bibliotheque.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

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
public class StateServiceImpl implements StateService {

	
	@Autowired
	private StateDAO dao;
	
	
	/**
	 * @{inheritDoc}
	*/
	@Override
	public State saveState(State sate) {
		// TODO Auto-generated method stub
		return dao.save(sate);
	}

	/**
	 * @{inheritDoc}
	*/
	@Override
	public State updateState(State state) {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		return dao.findByLabel(label);
	}

	/**
	 * @{inheritDoc}
	*/
	@Override
	public List<State> findByLabelContaining(String label) {
		// TODO Auto-generated method stub
		return dao.findByLabelContaining(label);
	}

	/**
	 * @{inheritDoc}
	*/
	@Override
	public boolean checkIfIdExists(Integer idState) {
		// TODO Auto-generated method stub
		return dao.existsById(idState);
	}

}
