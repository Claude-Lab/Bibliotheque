/**
 * 
 */
package fr.lusseau.bibliotheque.service;

import java.util.List;

import fr.lusseau.bibliotheque.entity.Role;

/**
 * Classe en charge de
 * @Version Bibliotheque -v1,0
 * @date  18 oct. 2020 - 07:44:43
 * @author Claude LUSSEAU
 *
 */
public interface RoleService {
	
	public Role saveRole (Role role);
	
	public Role updateRole (Role role);
	
	public void deleteRole(Integer idRole);
	
	public Role findByLabel(String label);
	
	public List<Role> findByLabelContaining(String label);
	
	public boolean checkIfIdExists(Integer idRole);
	
	public List<Role> findAll();

}
