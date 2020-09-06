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
	
//	@Query(value = "SELECT SUM(valeur) FROM Caution", nativeQuery = true)
//	public int sumCaution();
	
	@Query(value = "SELECT SUM(c.valeur) total, COUNT(p.id_caution) FROM personne p INNER JOIN caution c ON c.id_caution = p.id_caution", nativeQuery = true)
	public double sumCaution();
	
//	@Query(value = "SELECT p.id_personne, p.id_caution, SUM(c.valeur) AS total FROM Personne p INNER JOIN Caution c ON p.id_caution = c.id_caution GROUP BY p.id_personne", nativeQuery = true)
//	public float sumCaution();
	
}
