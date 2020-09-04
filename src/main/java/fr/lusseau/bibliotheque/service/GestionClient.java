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

/**
 * Classe en charge de
 * @Version Bibliotheque -v1,0
 * @date  4 sept. 2020 - 16:08:14
 * @author Claude LUSSEAU
 *
 */
@Service(value = "gestionClient")
@Transactional
public class GestionClient {

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
		Client personne = new Client();

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

	public void supprimerClient(Client p) {
		dao.delete(p);
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
//		case "vA": liste = (List<Salarie>) dao.findByOrderByVilleAsc(); break;
//		case "vD": liste = (List<Salarie>) dao.findByOrderByVilleDesc(); break;
		default:
			liste = dao.findAll();

		}

		return liste;
	}
	
	public long countClient() {
		return dao.count();
	}
	
	

}
