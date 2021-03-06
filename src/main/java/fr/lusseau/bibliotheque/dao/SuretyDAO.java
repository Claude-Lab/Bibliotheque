/**
 * 
 */
package fr.lusseau.bibliotheque.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import fr.lusseau.bibliotheque.entity.Surety;

/**
 * Classe en charge de
 * @Version Bibliotheque -v1,0
 * @date  14 août 2020 - 11:09:32
 * @author Claude LUSSEAU
 *
 */
@RepositoryRestResource
public interface SuretyDAO extends JpaRepository<Surety, Integer>{

	Surety findByNbBooks(int nbBooks);
	
	Surety findByValue(double value);
	
	boolean existsByValue(double value);
	
	boolean existsByNbBooks(int nbBooks);
	
	@Query(value = "SELECT SUM(c.value) total, COUNT(p.id_surety) FROM User u INNER JOIN Surety s ON s.id_surety = u.id_surety", nativeQuery = true)
	double sumSurety();
	
}
