/**
 * 
 */
package fr.lusseau.bibliotheque.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.lusseau.bibliotheque.dao.RoleDAO;
import fr.lusseau.bibliotheque.entity.Role;
import fr.lusseau.bibliotheque.service.RoleService;

/**
 * Classe en charge de
 * @Version Bibliotheque -v1,0
 * @date  18 oct. 2020 - 07:48:56
 * @author Claude LUSSEAU
 *
 */
@Transactional
@Service(value = "RoleService")
public class RoleServiceImpl implements RoleService {

	
	@Autowired
	private RoleDAO dao;
	
	/**
	 * @{inheritDoc}
	*/
	@Override
	public Role saveRole(Role role) {
		return dao.save(role);
	}

	/**
	 * @{inheritDoc}
	*/
	@Override
	public Role updateRole(Role role) {
		return dao.save(role);
	}

	/**
	 * @{inheritDoc}
	*/
	@Override
	public void deleteRole(Integer idRole) {
		dao.deleteById(idRole);
	}

	/**
	 * @{inheritDoc}
	*/
	@Override
	public Role findRoleByLibelle(String libelle) {
		return dao.findByLibelle(libelle);
	}

	/**
	 * @{inheritDoc}
	*/
	@Override
	public List<Role> findByLibelleContaining(String libelle) {
		return dao.findByLibelleContaining(libelle);
	}

	/**
	 * @{inheritDoc}
	*/
	@Override
	public boolean checkIfIdExists(Integer idRole) {
		return dao.existsById(idRole);
	}

}
