/**
 * 
 */
package fr.lusseau.bibliotheque.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.lusseau.bibliotheque.entity.Emprunt;

/**
 * Classe en charge de
 * 
 * @Version Bibliotheque -v1,0
 * @date 14 août 2020 - 11:12:29
 * @author Claude LUSSEAU
 *
 */
@Repository
public interface EmpruntDAO extends JpaRepository<Emprunt, Integer> {

	public List<Emprunt> findByEndDateBefore(LocalDate maxEndDate);

//	@Query("SELECT e from EMPRUNT e JOIN PERSONNE p ON e.pk.personne = p.ID_PERSONNE LEFT JOIN COORDONNEE c ON p.ID_COORDONNEE = c.ID_COORDONNEE WHERE c.EMAIL = ?1 AND e.STATUS = ?2")
//	@Query("SELECT e from EMPRUNT e INNER JOIN e.pk.personne p WHERE p.ID_PERSONNE = ?1 AND e.STATUS = ?2")
//	public List<Emprunt> getAllOpenEmpruntsOfThisPersonne(String email, EmpruntStatus status);

//	@Query("SELECT e FROM emprunt e INNER JOIN livre l ON l.id_livre = e.id_livre INNER JOIN personne p ON p.id_personne = e.id_personne "
//			+ "WHERE e.id_livre = ?1 AND e.id_personne = ?2  AND e.status = ?3 ")
//	public Emprunt getEmpruntByCriteria(Integer idLivre, Integer idPersonne, EmpruntStatus status);

	
	
	long count();
}
