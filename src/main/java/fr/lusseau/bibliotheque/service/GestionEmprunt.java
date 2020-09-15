/**
 * 
 */
package fr.lusseau.bibliotheque.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.lusseau.bibliotheque.dao.EmpruntDAO;
import fr.lusseau.bibliotheque.entity.Emprunt;

/**
 * Classe en charge de
 * @Version Bibliotheque -v1,0
 * @date  14 août 2020 - 14:43:58
 * @author Claude LUSSEAU
 *
 */
@Service
public class GestionEmprunt {

	@Autowired
	EmpruntDAO dao;
	
	public List<Emprunt> listeEmprunts() {
		return dao.findAll();
	}
	
	public Emprunt trouverEmprunt(int i){
		return dao.findById(i).get();
	}
	
	public void ajouterEmprunt(Emprunt e) {
		dao.save(e);
	}
	
	public void modifierEmprunt(Emprunt e) {
//		Emprunt emprunt = dao.findOne(e.getId());
//		emprunt.setNom(p.getNom());
//		emprunt.setDateRetrait(p.getDateRetrait());
//		emprunt.setDateRetour(p.getDateRetour());
//		emprunt.setLivre(e.getLivre());
//		emprunt.setPersonne(e.getPersonne());
//		dao.save(emprunt);
		dao.save(e);
	}
	
	public void supprimerEmprunt(Emprunt e) {
		dao.delete(e);
	}
	
	public List<Emprunt> trier(String par) {
		List<Emprunt> liste = null; 
		
		switch (par) {
		case "nA": liste = (List<Emprunt>) dao.findByOrderByDateRetraitAsc(); break;
		case "nD": liste = (List<Emprunt>) dao.findByOrderByDateRetraitDesc(); break;
		case "pA": liste = (List<Emprunt>) dao.findByOrderByDateRetourAsc(); break;
		case "pD": liste = (List<Emprunt>) dao.findByOrderByDateRetourDesc(); break;
		default : liste = dao.findAll();

		}
		
		return liste;
	}
	
	public void countEmprunt() {
		dao.count();
	}

	
	public List<Emprunt> listeEmpruntsPasses() {
		return dao.findAllWithDateRetourBefore();
	}
	
	public List<Emprunt> listeEmpruntsFuturs() {
		return dao.findAllWithDateRetraitAfter();
	}
	
	public List<Emprunt> listeEmpruntsEnCours() {
		return dao.findAllWithEmpruntNow();
		
	}
	
	public List<Emprunt> listEmpruntLivreenCoursEtAVenir(int i) {
		return dao.findAllEmpruntByLivre(i);
	}
	
public List<Emprunt> listEmpruntPersonneEnCoursEtAVenir(int i) {
		return dao.findAllEmpruntByPersonne(i);
	}

}
