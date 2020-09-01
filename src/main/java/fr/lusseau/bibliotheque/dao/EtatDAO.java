/**
 * 
 */
package fr.lusseau.bibliotheque.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.lusseau.bibliotheque.entity.Etat;

/**
 * Classe en charge de
 * @Version Bibliotheque -v1,0
 * @date  14 août 2020 - 11:10:07
 * @author Claude LUSSEAU
 *
 */
public interface EtatDAO extends JpaRepository<Etat, Integer> {

	List<Etat> findByOrderByLibelleAsc();
	List<Etat> findByOrderByLibelleDesc();
	
}
