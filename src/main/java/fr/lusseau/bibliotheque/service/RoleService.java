/**
 * 
 */
package fr.lusseau.bibliotheque.service;

import java.util.Optional;

import fr.lusseau.bibliotheque.entity.Role;
import fr.lusseau.bibliotheque.entity.RoleName;

/**
 * Class in charge of defining .
 * @Version Bibliotheque -v1,0
 * @date  2 nov. 2020 - 17:39:11
 * @author Claude LUSSEAU
 *
 */
public interface RoleService {
	
	Optional<Role> findByName(RoleName roleName);
	 
}
