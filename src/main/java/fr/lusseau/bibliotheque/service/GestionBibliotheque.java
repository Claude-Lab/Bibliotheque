/**
 * 
 */
package fr.lusseau.bibliotheque.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.lusseau.bibliotheque.dao.BibliothequeDAO;
import fr.lusseau.bibliotheque.entity.Bibliotheque;

/**
 * Classe en charge de
 * @Version Bibliotheque -v1,0
 * @date  14 août 2020 - 12:58:07
 * @author Claude LUSSEAU
 *
 */
@Service
public class GestionBibliotheque {

	@Autowired
	BibliothequeDAO dao;
	
	public List<Bibliotheque> listeBibliotheques() {
		return dao.findAll();
	}
	
	public Bibliotheque trouverBibliotheque(int id) {
		return dao.findById(id).get();
	}
	
	public void ajouterBibliotheque(Bibliotheque b) {
		dao.save(b);
	}
	
	public void modifierBibliotheque(Bibliotheque b) {
		dao.save(b);
	}
	
	public void supprimerBibliotheque(Bibliotheque b) {
		dao.delete(b);
	}
	
	public List<Bibliotheque> trier(String par) {
		List<Bibliotheque> liste = null;
		
		switch (par) {
		case "nA": liste = (List<Bibliotheque>) dao.findByOrderByNomAsc(); break;
		case "nD": liste = (List<Bibliotheque>) dao.findByOrderByNomDesc(); break;
		default : liste = dao.findAll();

		}
		
		return liste;
		
	}
	
}
