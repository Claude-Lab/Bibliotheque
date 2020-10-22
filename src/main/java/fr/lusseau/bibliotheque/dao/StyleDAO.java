/**
 * 
 */
package fr.lusseau.bibliotheque.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fr.lusseau.bibliotheque.entity.Categorie;

/**
 * Classe en charge de
 * @Version Bibliotheque -v1,0
 * @date  21 août 2020 - 12:46:26
 * @author Claude LUSSEAU
 *
 */
@Repository
public interface StyleDAO extends JpaRepository<Categorie, Integer> {
	
	
	
	@Query(value = "select s.id_style, s.libelle from Style s left join Livre_Style e on e.id_style = s.id_style left join Livre l on l.id_livre = e.id_livre where l.id_livre= :id_livre", nativeQuery = true)
	List<Categorie> findStyleLivre(@Param("id_livre") int idLivre);

}
