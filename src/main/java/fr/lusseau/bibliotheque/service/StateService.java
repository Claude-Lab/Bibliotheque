/**
 * 
 */
package fr.lusseau.bibliotheque.service;

import java.util.List;

import fr.lusseau.bibliotheque.entity.State;

/**
 * Class in charge of defining .
 * @Version Bibliotheque -v1,0
 * @date  23 oct. 2020 - 14:49:30
 * @author Claude LUSSEAU
 *
 */
public interface StateService {
	
	public State save(State sate);
	
	public State update(State state);
	
	void delete(Integer id);
	
	State getOne(Integer id);
	
	boolean existsByLabel(String label);
	
	public State findStateByLabel(String label);
	
	public List<State> findByLabelContaining(String label);
	
	public List<State> findAll();

}
