/**
 * 
 */
package fr.lusseau.bibliotheque.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.lusseau.bibliotheque.entity.State;

/**
 * Classe en charge de
 * @Version Bibliotheque -v1,0
 * @date  14 août 2020 - 11:10:07
 * @author Claude LUSSEAU
 *
 */
@Repository
public interface StateDAO extends JpaRepository<State, Integer> {

	State findByLabel(String label);
	
	public List<State> findByLabelContaining(String label);
}