/**
 * 
 */
package fr.lusseau.bibliotheque.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.lusseau.bibliotheque.entity.Type;

/**
 * Classe en charge de
 * @Version Bibliotheque -v1,0
 * @date  7 sept. 2020 - 09:32:51
 * @author Claude LUSSEAU
 *
 */
public interface TypeDAO extends JpaRepository<Type, Integer>{
	
	

}
