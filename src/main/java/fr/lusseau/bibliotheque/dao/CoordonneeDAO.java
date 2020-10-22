/**
 * 
 */
package fr.lusseau.bibliotheque.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.lusseau.bibliotheque.entity.Coordonnee;

/**
 * Classe en charge de
 * @Version Bibliotheque -v1,0
 * @date  19 août 2020 - 13:17:00
 * @author Claude LUSSEAU
 *
 */
@Repository
public interface CoordonneeDAO extends JpaRepository<Coordonnee, Integer> {
	
	public Coordonnee findByEmail(String email);
	
	

}
