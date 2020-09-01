/**
 * 
 */
package fr.lusseau.bibliotheque.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.lusseau.bibliotheque.dao.EtatDAO;
import fr.lusseau.bibliotheque.entity.Etat;

/**
 * Classe en charge de
 * @Version Bibliotheque -v1,0
 * @date  14 août 2020 - 14:37:52
 * @author Claude LUSSEAU
 *
 */

@Service
public class GestionEtat {
	
	@Autowired
	EtatDAO dao;

	public List<Etat> listeEtats() {
		return dao.findAll();
	}
	
	public Etat trouverEtat(int i){
		return dao.findById(i).get();
	}
	
	public void ajouterEtat(Etat e) {
		dao.save(e);
	}
	
	public void modifierEtat(Etat e) {
		dao.save(e);
	}
	
	public void supprimerEtat(Etat e) {
		dao.delete(e);
	}
	
	public List<Etat> trier(String par) {
		List<Etat> liste = null;
		
		switch (par) {
		case "lA": liste = (List<Etat>) dao.findByOrderByLibelleAsc(); break;
		case "lD": liste = (List<Etat>) dao.findByOrderByLibelleDesc(); break;
		default : liste = dao.findAll();

		}
		
		return liste;
	}
	
}
