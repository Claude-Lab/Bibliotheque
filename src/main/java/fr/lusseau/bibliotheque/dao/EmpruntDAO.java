/**
 * 
 */
package fr.lusseau.bibliotheque.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.lusseau.bibliotheque.entity.Emprunt;

/**
 * Classe en charge de
 * @Version Bibliotheque -v1,0
 * @date  14 août 2020 - 11:12:29
 * @author Claude LUSSEAU
 *
 */
public interface EmpruntDAO extends JpaRepository<Emprunt, Integer>{

	Iterable<Emprunt> findByOrderByDateRetraitAsc();
	Iterable<Emprunt> findByOrderByDateRetraitDesc();
	Iterable<Emprunt> findByOrderByDateRetourAsc();
	Iterable<Emprunt> findByOrderByDateRetourDesc();
//	Iterable<Emprunt> findByOrderByLivresAsc();
//	Iterable<Emprunt> findByOrderByLivresDesc();
//	Iterable<Emprunt> findByOrderByPersonneAsc();
//	Iterable<Emprunt> findByOrderByPersonneDesc();
}
