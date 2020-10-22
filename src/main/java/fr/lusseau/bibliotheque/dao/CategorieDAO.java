/**
 * 
 */
package fr.lusseau.bibliotheque.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.lusseau.bibliotheque.entity.Categorie;

/**
 * Classe en charge de
 * @Version Bibliotheque -v1,0
 * @date  19 oct. 2020 - 17:28:49
 * @author Claude LUSSEAU
 *
 */
@Repository
public interface CategorieDAO extends JpaRepository<Categorie, Integer>{

	List<Categorie> findByLibelleContaining(String libelle);
	
	Categorie findCategorieByLibelleIgnoreCase(String libelle);
}
