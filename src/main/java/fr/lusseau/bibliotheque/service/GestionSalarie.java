/**
 * 
 */
package fr.lusseau.bibliotheque.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.lusseau.bibliotheque.dao.SalarieDAO;
import fr.lusseau.bibliotheque.entity.Personne;
import fr.lusseau.bibliotheque.entity.Salarie;

/**
 * Classe en charge de definir la gestion des personnes en base.
 * 
 * @Version Bibliotheque -v1,0
 * @date 14 août 2020 - 11:20:27
 * @author Claude LUSSEAU
 *
 */
@Service(value = "gestionSalarie")
@Transactional
public class GestionSalarie   {

	private final SalarieDAO dao;

	
	@Autowired
	public GestionSalarie(SalarieDAO dao) {
		this.dao = dao;
	}

	
	public List<Salarie> listeSalaries() {
		return dao.findAll();
	}

	public Salarie trouverSalarie(int i) {
		return dao.findById(i).get();
	}
	
	public Salarie ajouterSalarie(Salarie model) {
		Salarie personne = new Salarie();

		personne.setPrenom(model.getPrenom());
		personne.setPrenom(model.getNom());
		personne.setCoordonnee(model.getCoordonnee());
		personne.setRole(model.getRole());

		return dao.save(model);
	}
	
	public void modifierSalarie(Salarie personne) {
//		Personne personne = dao.findOne(p.getId());
//		personne.setNom(p.getNom());
//		personne.setPrenom(p.getPrenom());
//		personne.setMotDePasse(p.getMotDePasse());
//		dao.save(personne);
		dao.save(personne);
	}


	public void supprimerSalarie(Personne personne) {
		dao.delete((Salarie) personne);
	}

	public List<Salarie> trier(String par) {
		List<Salarie> liste = null;

		switch (par) {
		case "nA":
			liste = (List<Salarie>) dao.findByOrderByNomAsc();
			break;
		case "nD":
			liste = (List<Salarie>) dao.findByOrderByNomDesc();
			break;
		case "pA":
			liste = (List<Salarie>) dao.findByOrderByPrenomAsc();
			break;
		case "pD":
			liste = (List<Salarie>) dao.findByOrderByPrenomDesc();
			break;
		case "iA":
			liste = (List<Salarie>) dao.findByOrderByDateInscriptionAsc();
			break;
		case "iD":
			liste = (List<Salarie>) dao.findByOrderByDateInscriptionDesc();
			break;
//		case "vA": liste = (List<Personne>) dao.findByOrderByVilleAsc(); break;
//		case "vD": liste = (List<Personne>) dao.findByOrderByVilleDesc(); break;
		default:
			liste = dao.findAll();

		}

		return liste;
	}
	
	public long countSalarie() {
		return dao.count();
	}
	


}
