/**
 * 
 */
package fr.lusseau.bibliotheque.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.lusseau.bibliotheque.dao.RoleDAO;
import fr.lusseau.bibliotheque.entity.Role;

/**
 * Classe en charge de
 * @Version Bibliotheque -v1,0
 * @date  14 août 2020 - 14:40:48
 * @author Claude LUSSEAU
 *
 */

@Service
public class GestionRole {

	@Autowired
	RoleDAO dao;
	
	public List<Role> listeRoles() {
		return dao.findAll();
	}
	
	public Role trouverRole(int i){
		return dao.findById(i).get();
	}
	
	public void ajouterRole(Role r) {
		dao.save(r);
	}
	
	public void modifierRole(Role r) {
		dao.save(r);
	}
	
	public void supprimerRole(Role r) {
		dao.delete(r);
	}
	
	public List<Role> trier(String par) {
		List<Role> liste = null;
		
		switch (par) {
		case "iA": liste = (List<Role>) dao.findByOrderByIdRoleAsc(); break;
		case "iD": liste = (List<Role>) dao.findByOrderByIdRoleDesc(); break;
		case "nA": liste = (List<Role>) dao.findByOrderByLibelleAsc(); break;
		case "nD": liste = (List<Role>) dao.findByOrderByLibelleDesc(); break;
		default : liste = dao.findAll();

		}
		
		return liste;
	}
	
}
