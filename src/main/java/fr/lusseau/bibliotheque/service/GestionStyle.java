/**
 * 
 */
package fr.lusseau.bibliotheque.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.lusseau.bibliotheque.dao.StyleDAO;
import fr.lusseau.bibliotheque.entity.Style;

/**
 * Classe en charge de
 * @Version Bibliotheque -v1,0
 * @date  21 août 2020 - 12:47:05
 * @author Claude LUSSEAU
 *
 */
@Service(value = "gs")
public class GestionStyle {

	@Autowired
	StyleDAO dao;
	
	public List<Style> listeStyles() {
		return dao.findAll();
	}
	
	public Style trouverStyle(int i){
		return dao.findById(i).get();
	}
	
	public List<Style> trouverStyleLivre(int i){
		return dao.findStyleLivre(i);
	}
	
	public void ajouterStyle(Style s) {
		dao.save(s);
	}
	
	public void modifierStyle(Style s) {
		dao.save(s);
	}
	
	public void supprimerStyle(Style s) {
		dao.delete(s);
	}
	
	public List<Style> trier(String par) {
		List<Style> liste = null;
		
		switch (par) {
		case "lA": liste = (List<Style>) dao.findByOrderByLibelleAsc(); break;
		case "lD": liste = (List<Style>) dao.findByOrderByLibelleDesc(); break;
		default : liste = (List<Style>) dao.findAll();

		}
		
		return liste;
	}
	
}
