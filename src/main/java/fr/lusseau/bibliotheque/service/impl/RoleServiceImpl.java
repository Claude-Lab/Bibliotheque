/**
 * 
 */
package fr.lusseau.bibliotheque.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.lusseau.bibliotheque.dao.RoleDAO;
import fr.lusseau.bibliotheque.entity.Role;
import fr.lusseau.bibliotheque.entity.RoleName;
import fr.lusseau.bibliotheque.service.RoleService;

/**
 * Class in charge of defining .
 * @Version Bibliotheque -v1,0
 * @date  2 nov. 2020 - 17:39:58
 * @author Claude LUSSEAU
 *
 */
@Service("RoleService")
@Transactional
public class RoleServiceImpl implements RoleService{

	RoleDAO dao;

	/**
	 * @{inheritDoc}
	*/
	@Override
	public Optional<Role> findByName(RoleName roleName){
		return dao.findByName(roleName);
	}
	
}
