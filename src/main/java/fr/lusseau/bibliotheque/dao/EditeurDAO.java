/**
 * 
 */
package fr.lusseau.bibliotheque.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.lusseau.bibliotheque.entity.Editeur;

/**
 * Classe en charge de
 * @Version Bibliotheque -v1,0
 * @date  14 août 2020 - 11:09:51
 * @author Claude LUSSEAU
 *
 */
public interface EditeurDAO extends JpaRepository<Editeur, Integer> {
	
	Iterable<Editeur> findByOrderByNomAsc();
	Iterable<Editeur> findByOrderByNomDesc();
//	Iterable<Editeur> findByOrderByPaysAsc();
//	Iterable<Editeur> findByOrderByPaysDesc();
//	Iterable<Editeur> findByOrderByVilleAsc();
//	Iterable<Editeur> findByOrderByVilleDesc();

}
