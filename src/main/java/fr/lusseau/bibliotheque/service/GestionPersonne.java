/**
 * 
 */
package fr.lusseau.bibliotheque.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.lusseau.bibliotheque.dao.PersonneDAO;
import fr.lusseau.bibliotheque.entity.Personne;

/**
 * Classe en charge de definir la gestion des personnes en base.
 * 
 * @Version Bibliotheque -v1,0
 * @date 14 août 2020 - 11:20:27
 * @author Claude LUSSEAU
 *
 */
@Service(value = "gestionPersonne")
@Transactional
public class GestionPersonne   {

	private final PersonneDAO dao;

	
	@Autowired
	public GestionPersonne(PersonneDAO dao) {
		this.dao = dao;
	}

	
	public List<Personne> listePersonnes() {
		return dao.findAll();
	}

	public Personne trouverPersonne(int i) {
		return dao.findById(i).get();
	}
	
//	public Personne ajouterPersonne(Personne model) {
//		Personne personne = new Personne();
//
//		personne.setPrenom(model.getPrenom());
//		personne.setPrenom(model.getNom());
//		personne.setCoordonnee(model.getCoordonnee());
//		personne.setRole(model.getRole());
//
//		return dao.save(model);
//	}
//	
	public void modifierPersonne(Personne personne) {
//		Personne personne = dao.findOne(p.getId());
//		personne.setNom(p.getNom());
//		personne.setPrenom(p.getPrenom());
//		personne.setMotDePasse(p.getMotDePasse());
//		dao.save(personne);
		dao.save(personne);
	}


	public void supprimerPersonne(Personne p) {
		dao.delete(p);
	}

	public List<Personne> trier(String par) {
		List<Personne> liste = null;

		switch (par) {
		case "nA":
			liste = (List<Personne>) dao.findByOrderByNomAsc();
			break;
		case "nD":
			liste = (List<Personne>) dao.findByOrderByNomDesc();
			break;
		case "pA":
			liste = (List<Personne>) dao.findByOrderByPrenomAsc();
			break;
		case "pD":
			liste = (List<Personne>) dao.findByOrderByPrenomDesc();
			break;
		case "iA":
			liste = (List<Personne>) dao.findByOrderByDateInscriptionAsc();
			break;
		case "iD":
			liste = (List<Personne>) dao.findByOrderByDateInscriptionDesc();
			break;
//		case "vA": liste = (List<Personne>) dao.findByOrderByVilleAsc(); break;
//		case "vD": liste = (List<Personne>) dao.findByOrderByVilleDesc(); break;
		default:
			liste = dao.findAll();

		}

		return liste;
	}
	
	public long countPersonne() {
		return dao.count();
	}
	


}
