/**
 * 
 */
package fr.lusseau.bibliotheque.dao;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fr.lusseau.bibliotheque.entity.Bibliotheque;

/**
 * Interface en charge de la liaison service-persistence de la class Bibliotheque.
 * @Version Bibliotheque -v1,0
 * @date  14 août 2020 - 11:10:17
 * @author Claude LUSSEAU
 *
 */
@Repository
public interface BibliothequeDAO extends JpaRepository<Bibliotheque, Integer>{
	
	@Query(value = "select b.id_bibliotheque, b.id_coordonnee, c.email from BIBLIOTHEQUE b INNER JOIN COORDONNEE c ON  b.id_coordonnee = c.id_coordonnee where c.email= :email")
	public Bibliotheque findBibliothequeByCoordonneeEmail(@Param("email") String email);
	
	public List<Bibliotheque> findByNomContaining(String nom);
	
	public Bibliotheque findByNom(String nom);
	

}
