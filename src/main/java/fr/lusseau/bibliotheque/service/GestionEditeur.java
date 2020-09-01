/**
 * 
 */
package fr.lusseau.bibliotheque.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.lusseau.bibliotheque.dao.EditeurDAO;
import fr.lusseau.bibliotheque.entity.Editeur;

/**
 * Classe en charge de
 * @Version Bibliotheque -v1,0
 * @date  14 août 2020 - 13:28:32
 * @author Claude LUSSEAU
 *
 */
@Service
public class GestionEditeur {

	@Autowired
	EditeurDAO dao;
	
	public List<Editeur> listeEditeurs() {
		return dao.findAll();
	}
	
	public Editeur trouverEditeur(int i){
		return dao.findById(i).get();
	}
	
	public void ajouterEditeur(Editeur e) {
		dao.save(e);
	}
	
	public void modifierEditeur(Editeur e) {
//		Personne personne = dao.findOne(p.getId());
//		personne.setNom(p.getNom());
//		personne.setPrenom(p.getPrenom());
//		personne.setMotDePasse(p.getMotDePasse());
//		dao.save(personne);
		dao.save(e);
	}
	
	public void supprimerEditeur(Editeur e) {
		dao.delete(e);
	}
	
	public List<Editeur> trier(String par) {
		List<Editeur> liste = null;
		
		switch (par) {
		case "nA": liste = (List<Editeur>) dao.findByOrderByNomAsc(); break;
		case "nD": liste = (List<Editeur>) dao.findByOrderByNomDesc(); break;
		default : liste = dao.findAll();

		}
		
		return liste;
	}
}
