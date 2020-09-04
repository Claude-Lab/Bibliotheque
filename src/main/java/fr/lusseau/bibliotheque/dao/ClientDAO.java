/**
 * 
 */
package fr.lusseau.bibliotheque.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.lusseau.bibliotheque.entity.Client;

/**
 * Classe en charge de
 * @Version Bibliotheque -v1,0
 * @date  4 sept. 2020 - 12:58:52
 * @author Claude LUSSEAU
 *
 */
public interface ClientDAO extends JpaRepository<Client, Integer>{

}
