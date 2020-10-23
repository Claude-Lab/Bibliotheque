/**
 * 
 */
package fr.lusseau.bibliotheque.dao;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fr.lusseau.bibliotheque.entity.User;

/**
 * Classe en charge de
 * @Version Bibliotheque -v1,0
 * @date  14 août 2020 - 10:55:30
 * @author Claude LUSSEAU
 *
 */
@Repository
public interface UserDAO extends JpaRepository<User, Integer> {
	
	@Query(value = "select p.id_user, p.id_contact, c.email from User u INNER JOIN Contact c ON u.id_contact = c.id_contact WHERE c.email = :email")
	public User findUserByContactEmail(@Param("email") String email);
	
//	@Query(value = "select p.id_personne, p.id_coordonnee, c.email from PERSONNE p INNER JOIN COORDONNEE c ON p.id_coordonnee = c.id_coordonnee WHERE p.id_personne = :id_personne")
//	public String getEmail(@Param("idPersonne") Integer idPersonne);
//	
//	@Query(value = "select email from coordonnee c, join personne p On p.id_personne = c.id_personne where p.id_personne = :id_personne ")
//	Personne findEmail(@Param("idPersonne") Personne personne);

	List<User> findByLastNameIgnoreCase(String lastName);
	
	List<User>  findByLastNameLikeIgnoreCase(String lastName);
	
	List<User> findByLastNameContaining(String lastName);
	
	long count();


}
