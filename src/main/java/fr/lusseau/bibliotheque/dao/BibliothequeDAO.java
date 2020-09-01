/**
 * 
 */
package fr.lusseau.bibliotheque.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.lusseau.bibliotheque.entity.Bibliotheque;

/**
 * Interface en charge de la liaison service-persistence de la class Bibliotheque.
 * @Version Bibliotheque -v1,0
 * @date  14 août 2020 - 11:10:17
 * @author Claude LUSSEAU
 *
 */
public interface BibliothequeDAO extends JpaRepository<Bibliotheque, Integer>{
	
	List<Bibliotheque> findByOrderByNomAsc();
	List<Bibliotheque> findByOrderByNomDesc();

}
