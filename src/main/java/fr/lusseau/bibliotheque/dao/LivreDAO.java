/**
 * 
 */
package fr.lusseau.bibliotheque.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.lusseau.bibliotheque.entity.Livre;

/**
 * Classe en charge de
 * @Version Bibliotheque -v1,0
 * @date  14 août 2020 - 10:55:17
 * @author Claude LUSSEAU
 *
 */
@Repository
public interface LivreDAO extends JpaRepository<Livre, Integer> {


	Livre findByTitre(String titre);
	
	long count();
	
}
