/**
 * 
 */
package fr.lusseau.bibliotheque.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.lusseau.bibliotheque.entity.Salarie;

/**
 * Classe en charge de
 * @Version Bibliotheque -v1,0
 * @date  4 sept. 2020 - 12:58:18
 * @author Claude LUSSEAU
 *
 */
public interface SalarieDAO extends JpaRepository<Salarie, Integer>{

	@Query(value = "select id_personne, email from Personne p, join coordonnee c On c.id_personne = p.id_personne where c.email= :email", nativeQuery = true)
	Optional<Salarie> findByEmail(@Param("email") String email);
	
	@Query("select p from Personne p where p.username = ?1")
    Optional<Salarie> findSalarieWithUsername(String username);
	
	List<Salarie> findByOrderByNomAsc();
	List<Salarie> findByOrderByNomDesc();
	List<Salarie> findByOrderByPrenomAsc();
	List<Salarie> findByOrderByPrenomDesc();
	List<Salarie> findByOrderByDateInscriptionAsc();
	List<Salarie> findByOrderByDateInscriptionDesc();
	
	long count();
}
