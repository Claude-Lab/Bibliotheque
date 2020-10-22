/**
 * 
 */
package fr.lusseau.bibliotheque.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import fr.lusseau.bibliotheque.entity.Caution;

/**
 * Classe en charge de
 * @Version Bibliotheque -v1,0
 * @date  14 août 2020 - 11:09:32
 * @author Claude LUSSEAU
 *
 */
@Repository
public interface CautionDAO extends JpaRepository<Caution, Integer>{

	
	@Query(value = "SELECT SUM(c.valeur) total, COUNT(p.id_caution) FROM personne p INNER JOIN caution c ON c.id_caution = p.id_caution", nativeQuery = true)
	public double sumCaution();
	
	
}
