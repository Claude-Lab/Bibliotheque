/**
 * 
 */
package fr.lusseau.bibliotheque.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.lusseau.bibliotheque.dao.ClientDAO;
import fr.lusseau.bibliotheque.entity.Client;
import fr.lusseau.bibliotheque.entity.Personne;

/**
 * Classe en charge de definir la gestion des personnes en base.
 * 
 * @Version Bibliotheque -v1,0
 * @date 14 août 2020 - 11:20:27
 * @author Claude LUSSEAU
 *
 */
@Service(value = "gestionClient")
@Transactional
public class GestionClient   {

	private final ClientDAO dao;

	
	@Autowired
	public GestionClient(ClientDAO dao) {
		this.dao = dao;
	}

	
	public List<Client> listeClients() {
		return dao.findAll();
	}

	public Client trouverClient(int i) {
		return dao.findById(i).get();
	}
	
	public Client ajouterClient(Client model) {
		Personne personne = new Client();

		personne.setPrenom(model.getPrenom());
		personne.setPrenom(model.getNom());
		personne.setCoordonnee(model.getCoordonnee());

		return dao.save(model);
	}
	
	public void modifierClient(Client personne) {
//		Personne personne = dao.findOne(p.getId());
//		personne.setNom(p.getNom());
//		personne.setPrenom(p.getPrenom());
//		personne.setMotDePasse(p.getMotDePasse());
//		dao.save(personne);
		dao.save(personne);
	}


	public void supprimerClient(Personne personne) {
		dao.delete((Client) personne);
	}

	public List<Client> trier(String par) {
		List<Client> liste = null;

		switch (par) {
		case "nA":
			liste = (List<Client>) dao.findByOrderByNomAsc();
			break;
		case "nD":
			liste = (List<Client>) dao.findByOrderByNomDesc();
			break;
		case "pA":
			liste = (List<Client>) dao.findByOrderByPrenomAsc();
			break;
		case "pD":
			liste = (List<Client>) dao.findByOrderByPrenomDesc();
			break;
		case "iA":
			liste = (List<Client>) dao.findByOrderByDateInscriptionAsc();
			break;
		case "iD":
			liste = (List<Client>) dao.findByOrderByDateInscriptionDesc();
			break;
//		case "vA": liste = (List<Personne>) dao.findByOrderByVilleAsc(); break;
//		case "vD": liste = (List<Personne>) dao.findByOrderByVilleDesc(); break;
		default:
			liste = dao.findAll();

		}

		return liste;
	}
	
	public long countClient() {
		return dao.count();
	}
	


}
