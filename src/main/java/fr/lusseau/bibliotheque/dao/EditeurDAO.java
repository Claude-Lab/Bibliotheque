/**
 * 
 */
package fr.lusseau.bibliotheque.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.lusseau.bibliotheque.entity.Editeur;

/**
 * Classe en charge de
 * @Version Bibliotheque -v1,0
 * @date  14 août 2020 - 11:09:51
 * @author Claude LUSSEAU
 *
 */
@Repository
public interface EditeurDAO extends JpaRepository<Editeur, Integer> {
	
	List<Editeur> findByNomContaining(String nom);

}
