/**
 * 
 */
package fr.lusseau.bibliotheque.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.lusseau.bibliotheque.entity.Role;

/**
 * Classe en charge de
 * @Version Bibliotheque -v1,0
 * @date  14 août 2020 - 11:09:42
 * @author Claude LUSSEAU
 *
 */
@Repository
public interface RoleDAO extends JpaRepository<Role, Integer> {
	
	Role findByLibelle(String libelle);
	
	public List<Role> findByLibelleContaining(String libelle);

}
