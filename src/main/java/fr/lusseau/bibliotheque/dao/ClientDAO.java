/**
 * 
 */
package fr.lusseau.bibliotheque.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.lusseau.bibliotheque.entity.Client;

/**
 * Classe en charge de
 * @Version Bibliotheque -v1,0
 * @date  4 sept. 2020 - 12:58:52
 * @author Claude LUSSEAU
 *
 */
public interface ClientDAO extends JpaRepository<Client, Integer>{
	
	@Query(value = "select id_personne, email from Personne p, join coordonnee c On c.id_personne = p.id_personne where c.email= :email", nativeQuery = true)
	Client getClientByEmail(@Param("email") String email);
	
	@Query("select p from Personne p where p.username = :username")
	Client getClientByUsername(@Param("username") String username);
	
	List<Client> findByOrderByNomAsc();
	List<Client> findByOrderByNomDesc();
	List<Client> findByOrderByPrenomAsc();
	List<Client> findByOrderByPrenomDesc();
	List<Client> findByOrderByDateInscriptionAsc();
	List<Client> findByOrderByDateInscriptionDesc();
	
	long count();

}
