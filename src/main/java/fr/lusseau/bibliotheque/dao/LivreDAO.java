/**
 * 
 */
package fr.lusseau.bibliotheque.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.lusseau.bibliotheque.entity.Livre;

/**
 * Classe en charge de
 * @Version Bibliotheque -v1,0
 * @date  14 août 2020 - 10:55:17
 * @author Claude LUSSEAU
 *
 */
public interface LivreDAO extends JpaRepository<Livre, Integer> {

	Iterable<Livre> findByOrderByTitreAsc();
	Iterable<Livre> findByOrderByTitreDesc();
//	Iterable<Livre> findByOrderByAuteursAsc();
//	Iterable<Livre> findByOrderByAuteursDesc();
//	Iterable<Livre> findByOrderByEditeurAsc();
//	Iterable<Livre> findByOrderByEditeurDesc();
	Iterable<Livre> findByOrderByIsbnAsc();
	Iterable<Livre> findByOrderByIsbnDesc();
	Livre findByTitre(String titre);
	
	long count();
	
}
