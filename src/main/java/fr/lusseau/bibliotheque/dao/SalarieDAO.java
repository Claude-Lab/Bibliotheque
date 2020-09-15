/**
 * 
 */
package fr.lusseau.bibliotheque.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.lusseau.bibliotheque.entity.Salarie;

/**
 * Classe en charge de
 * @Version Bibliotheque -v1,0
 * @date  14 août 2020 - 10:55:30
 * @author Claude LUSSEAU
 *
 */
public interface SalarieDAO extends JpaRepository<Salarie, Integer> {
	
//	@Query(value = "select id_salarie, c.email from salarie s join personne p on s.id_client = p.id_client left join coordonnee c On c.id_personne = p.id_personne where c.email= :email", nativeQuery = true)
//	Optional<Salarie> findByEmail(@Param("email") String email);
//	
//	@Query("select s from Salarie s where s.username = :username")
//	Salarie findByUsername(String username);
	
	
	List<Salarie> findByOrderByNomAsc();
	List<Salarie> findByOrderByNomDesc();
	List<Salarie> findByOrderByPrenomAsc();
	List<Salarie> findByOrderByPrenomDesc();
	List<Salarie> findByOrderByDateInscriptionAsc();
	List<Salarie> findByOrderByDateInscriptionDesc();
	
	
	
	long count();

}
