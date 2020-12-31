/**
 * 
 */
package fr.lusseau.bibliotheque.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import fr.lusseau.bibliotheque.entity.State;

/**
 * Classe en charge de
 * @Version Bibliotheque -v1,0
 * @date  14 août 2020 - 11:10:07
 * @author Claude LUSSEAU
 *
 */
@RepositoryRestResource
public interface StateDAO extends JpaRepository<State, Integer> {

	State findByLabel(String label);
	
	List<State> findByLabelContaining(String label);
	
	boolean existsByLabel(String label);
}
