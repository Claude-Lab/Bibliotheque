/**
 * 
 */
package fr.lusseau.bibliotheque.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.lusseau.bibliotheque.entity.Role;

/**
 * Classe en charge de
 * @Version Bibliotheque -v1,0
 * @date  14 août 2020 - 11:09:42
 * @author Claude LUSSEAU
 *
 */
public interface RoleDAO extends JpaRepository<Role, Integer> {
	
	Iterable<Role> findByOrderByLibelleAsc();
	Iterable<Role> findByOrderByLibelleDesc();
	Iterable<Role> findByOrderByIdRoleAsc();
	Iterable<Role> findByOrderByIdRoleDesc();

}
