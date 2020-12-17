/**
 * 
 */
package fr.lusseau.bibliotheque.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import fr.lusseau.bibliotheque.entity.Role;
import fr.lusseau.bibliotheque.entity.RoleName;

/**
 * Class in charge of defining .
 * @Version Bibliotheque -v1,0
 * @date  2 nov. 2020 - 17:37:44
 * @author Claude LUSSEAU
 *
 */
@RepositoryRestResource
public interface RoleDAO extends JpaRepository<Role, Long>{
	
	Optional<Role> findByName(RoleName roleName);
	

}
