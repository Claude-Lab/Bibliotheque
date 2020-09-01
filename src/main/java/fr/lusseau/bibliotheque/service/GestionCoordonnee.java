/**
 * 
 */
package fr.lusseau.bibliotheque.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.lusseau.bibliotheque.dao.CoordonneeDAO;
import fr.lusseau.bibliotheque.entity.Coordonnee;

/**
 * Classe en charge de
 * @Version Bibliotheque -v1,0
 * @date  19 août 2020 - 13:16:43
 * @author Claude LUSSEAU
 *
 */
@Service
public class GestionCoordonnee {

	@Autowired
	CoordonneeDAO dao;
	
	public List<Coordonnee> listeCoordonnee() {
		return dao.findAll();
	}
	
	public Coordonnee trouverCoordonnee(int i){
		return dao.findById(i).get(); 
	}
	
	public void ajouterCoordonnee(Coordonnee c) {
		dao.save(c);
	}
	
	public void modifierCoordonnee(Coordonnee c) {
//		Personne personne = dao.findOne(p.getId());
//		personne.setNom(p.getNom());
//		personne.setPrenom(p.getPrenom());
//		personne.setMotDePasse(p.getMotDePasse());
//		dao.save(personne);
		dao.save(c);
	}
	
	public void supprimerCoordonnee(Coordonnee c) {
		dao.delete(c);
	}
	
//	public List<Coordonnee> trier(String par) {
//		List<Coordonnee> liste = null;
//		
//		switch (par) {
//		case "lA": liste = (List<Coordonnee>) dao.findByOrderByNbLivresAsc(); break;
//		case "lD": liste = (List<Coordonnee>) dao.findByOrderByNbLivresDesc(); break;
//		case "vA": liste = (List<Coordonnee>) dao.findByOrderByValeurAsc(); break;
//		case "vD": liste = (List<Coordonnee>) dao.findByOrderByValeurDesc(); break;
//		default : liste = dao.findAll();
//
//		}
//		
//		return liste;
//	}
}
