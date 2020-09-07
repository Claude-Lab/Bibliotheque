/**
 * 
 */
package fr.lusseau.bibliotheque.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.lusseau.bibliotheque.dao.TypeDAO;
import fr.lusseau.bibliotheque.entity.Type;

/**
 * Classe en charge de
 * @Version Bibliotheque -v1,0
 * @date  7 sept. 2020 - 09:31:34
 * @author Claude LUSSEAU
 *
 */
@Service(value = "gestionType")
@Transactional
public class GestionType {

	private final TypeDAO dao;
	
	@Autowired
	public GestionType(TypeDAO dao) {
		this.dao = dao;
	}
	
	public List<Type> listeTypes() {
		return dao.findAll();
	}
	
	public Type trouverType(int i) {
		return dao.findById(i).get();
	}
	
	public Type ajouterType(Type model) {
		Type type = new Type();
		type.setLibelle(model.getLibelle());
		return dao.save(model);
	}
	
	public void supprimerType(Type t) {
		dao.delete(t);
	}
	
	public void modifierType(Type t) {
		dao.save(t);
	}
	
}
