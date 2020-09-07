/**
 * 
 */
package fr.lusseau.bibliotheque.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

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
	
	@Query("select e from Emprunt e where e.dateRetour < NOW()")
    List<Emprunt> findAllWithDateRetourBefore();
	
	@Query("select e from Emprunt e where e.dateRetrait > NOW()")
    List<Emprunt> findAllWithDateRetraitAfter();
	
	@Query("select e from Emprunt e where e.dateRetrait < NOW() AND e.dateRetour > NOW()")
    List<Emprunt> findAllWithEmpruntNow();
	
	Emprunt findByPersonne(int id);
	
	Emprunt findByLivre(int id);
	
	long count();
}
