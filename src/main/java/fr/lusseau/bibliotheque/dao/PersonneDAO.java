/**
 * 
 */
package fr.lusseau.bibliotheque.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.lusseau.bibliotheque.entity.Personne;

/**
 * Classe en charge de
 * @Version Bibliotheque -v1,0
 * @date  14 août 2020 - 10:55:30
 * @author Claude LUSSEAU
 *
 */
public interface PersonneDAO extends JpaRepository<Personne, Integer> {
	
	@Query(value = "select id_personne, email from Personne p, join coordonnee c On c.id_personne = p.id_personne where c.email= :email", nativeQuery = true)
	Optional<Personne> findByEmail(@Param("email") String email);
	
	@Query("select p from Personne p where p.username = :username")
    Personne findByUsername(String username);
	
//	@Query("SELECT u FROM User u WHERE u.username = :username")
//    public Personne getPersonneByUsername(@Param("username") String username);
	
	List<Personne> findByOrderByNomAsc();
	List<Personne> findByOrderByNomDesc();
	List<Personne> findByOrderByPrenomAsc();
	List<Personne> findByOrderByPrenomDesc();
	List<Personne> findByOrderByDateInscriptionAsc();
	List<Personne> findByOrderByDateInscriptionDesc();
	
	
	
	long count();

}
