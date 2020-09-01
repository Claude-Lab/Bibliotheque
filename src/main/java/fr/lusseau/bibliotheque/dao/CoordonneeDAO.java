/**
 * 
 */
package fr.lusseau.bibliotheque.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.lusseau.bibliotheque.entity.Coordonnee;

/**
 * Classe en charge de
 * @Version Bibliotheque -v1,0
 * @date  19 août 2020 - 13:17:00
 * @author Claude LUSSEAU
 *
 */
public interface CoordonneeDAO extends JpaRepository<Coordonnee, Integer> {
	
//	Coordonnee findByEmail();
	

}
