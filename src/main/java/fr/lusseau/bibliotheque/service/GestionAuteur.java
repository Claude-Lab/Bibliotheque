/**
 * 
 */
package fr.lusseau.bibliotheque.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.lusseau.bibliotheque.dao.AuteurDAO;
import fr.lusseau.bibliotheque.entity.Auteur;

/**
 * Classe en charge de
 * 
 * @Version Bibliotheque -v1,0
 * @date 21 août 2020 - 12:24:20
 * @author Claude LUSSEAU
 *
 */
@Service(value = "ga")
public class GestionAuteur {

	@Autowired
	AuteurDAO dao;

	public List<Auteur> listeAuteurs() {
		return dao.findAll();
	}
	
	public List<Auteur> trouverAuteurLivre(int id){
		return dao.findAuteurLivre(id);
	}

	public Auteur trouverAuteur(int idAuteur) {
		return dao.findById(idAuteur).get();
	}
	
	public void ajouterAuteur(Auteur a) {
		dao.save(a);
	}

	public void modifierAuteur(Auteur a) {
		dao.save(a);
	}

	public void supprimerAuteur(Auteur a) {
		dao.delete(a);
	}
	
	public List<Auteur> trier(String par) {
		List<Auteur> liste = null;

		switch (par) {
		case "nA":
			liste = (List<Auteur>) dao.findByOrderByNomAsc();
			break;
		case "nD":
			liste = (List<Auteur>) dao.findByOrderByNomDesc();
			break;
		

		default:
			liste = (List<Auteur>) dao.findAll();

		}

		return liste;
	}
	
	
	
	

}
