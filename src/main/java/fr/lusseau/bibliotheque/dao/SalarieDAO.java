/**
 * 
 */
package fr.lusseau.bibliotheque.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.lusseau.bibliotheque.entity.Salarie;

/**
 * Classe en charge de
 * @Version Bibliotheque -v1,0
 * @date  4 sept. 2020 - 12:58:18
 * @author Claude LUSSEAU
 *
 */
public interface SalarieDAO extends JpaRepository<Salarie, Integer>{

}
