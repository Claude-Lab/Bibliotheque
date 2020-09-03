/**
 * 
 */
package fr.lusseau.bibliotheque.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.lusseau.bibliotheque.entity.Caution;

/**
 * Classe en charge de
 * @Version Bibliotheque -v1,0
 * @date  14 août 2020 - 11:09:32
 * @author Claude LUSSEAU
 *
 */
public interface CautionDAO extends JpaRepository<Caution, Integer>{

	List<Caution> findByOrderByNbLivresAsc();
	List<Caution> findByOrderByNbLivresDesc();
	List<Caution> findByOrderByValeurAsc();
	List<Caution> findByOrderByValeurDesc();
	
	@Query(value = "SELECT SUM(valeur) FROM Caution", nativeQuery = true)
	public float sumCaution();
	
}
