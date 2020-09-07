/**
 * 
 */
package fr.lusseau.bibliotheque.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.lusseau.bibliotheque.dao.CautionDAO;
import fr.lusseau.bibliotheque.entity.Caution;

/**
 * Classe en charge de
 * 
 * @Version Bibliotheque -v1,0
 * @date 14 août 2020 - 13:18:06
 * @author Claude LUSSEAU
 *
 */

@Service
public class GestionCaution {

	@Autowired
	CautionDAO dao;

	public List<Caution> listeCautions() {
		return dao.findAll();
	}

	public Caution trouverCaution(int i) {
		return dao.findById(i).get();
	}

	public void ajouterCaution(Caution c) {
		dao.save(c);
	}

	public void modifierCaution(Caution c) {
//		Personne personne = dao.findOne(p.getId());
//		personne.setNom(p.getNom());
//		personne.setPrenom(p.getPrenom());
//		personne.setMotDePasse(p.getMotDePasse());
//		dao.save(personne);
		dao.save(c);
	}

	public void supprimerCaution(Caution c) {
		dao.delete(c);
	}

	public List<Caution> trier(String par) {
		List<Caution> liste = null;

		switch (par) {
		case "lA":
			liste = (List<Caution>) dao.findByOrderByNbLivresAsc();
			break;
		case "lD":
			liste = (List<Caution>) dao.findByOrderByNbLivresDesc();
			break;
		case "vA":
			liste = (List<Caution>) dao.findByOrderByValeurAsc();
			break;
		case "vD":
			liste = (List<Caution>) dao.findByOrderByValeurDesc();
			break;
		default:
			liste = dao.findAll();

		}

		return liste;
	}

	public double sumCaution() {
		return dao.sumCaution();
	}

}
