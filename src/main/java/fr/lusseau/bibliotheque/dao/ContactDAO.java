/**
 * 
 */
package fr.lusseau.bibliotheque.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import fr.lusseau.bibliotheque.entity.Contact;

/**
 * Classe en charge de
 * @Version Bibliotheque -v1,0
 * @date  19 août 2020 - 13:17:00
 * @author Claude LUSSEAU
 *
 */
@RepositoryRestResource
public interface ContactDAO extends JpaRepository<Contact, Integer> {
	
		

}
