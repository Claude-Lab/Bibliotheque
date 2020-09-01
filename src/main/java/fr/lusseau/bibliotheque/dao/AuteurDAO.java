/**
 * 
 */
package fr.lusseau.bibliotheque.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.lusseau.bibliotheque.entity.Auteur;

/**
 * Classe en charge de
 * @Version Bibliotheque -v1,0
 * @date  21 août 2020 - 12:22:35
 * @author Claude LUSSEAU
 *
 */
public interface AuteurDAO extends JpaRepository<Auteur, Integer> {
	
	List<Auteur> findByOrderByNomAsc();
	List<Auteur> findByOrderByNomDesc();
	
	@Query(value = "select distinct a.prenom, a.nom, a.id_auteur from Auteur a left join Livre_Auteur e on e.id_auteur = a.id_auteur left join Livre l on l.id_livre = e.id_livre where l.id_livre= :id_livre", nativeQuery = true)
	List<Auteur> findAuteurLivre(@Param("id_livre") int idLivre);
	
}
