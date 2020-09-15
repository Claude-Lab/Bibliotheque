/**
 * 
 */
package fr.lusseau.bibliotheque.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.lusseau.bibliotheque.dao.AuteurDAO;
import fr.lusseau.bibliotheque.dao.EmpruntDAO;
import fr.lusseau.bibliotheque.dao.LivreDAO;
import fr.lusseau.bibliotheque.dao.StyleDAO;
import fr.lusseau.bibliotheque.entity.Livre;

/**
 * Classe en charge de
 * 
 * @Version Bibliotheque -v1,0
 * @date 14 août 2020 - 13:20:25
 * @author Claude LUSSEAU
 *
 */
@Transactional
@Service(value = "gl")
public class GestionLivre {

	@Autowired
	LivreDAO daoL;
	@Autowired
	AuteurDAO daoA;
	@Autowired
	StyleDAO daoS;
	@Autowired
	EmpruntDAO daoE;
	
	
	/**
	 * Constructeur.
	 * @param daoL
	 * @param daoA
	 * @param daoS
	 */
	public GestionLivre(LivreDAO daoL, AuteurDAO daoA, StyleDAO daoS) {
		super();
		this.daoL = daoL;
		this.daoA = daoA;
		this.daoS = daoS;
	}

	@Transactional
	public void ajouterLivre(Livre livre) {
		daoL.save(livre);
	}
	
	
	@Transactional
	public void saveLivre(Livre model) {
		Livre livre = new Livre();
		
		livre.setTitre(model.getTitre());
		livre.setIsbn(model.getIsbn());
		livre.setDescription(model.getDescription());
		livre.setEditeur(model.getEditeur());
		livre.setBibliotheque(model.getBibliotheque());
		livre.setEtat(model.getEtat());
		livre.setAuteurs(model.getAuteurs());
		livre.setStyles(model.getStyles());
		
		daoL.save(livre);
	}

	public List<Livre> listeLivres() {
		return daoL.findAll();
	}
	
	public Livre trouverLivre(int i) {
		return daoL.findById(i).get();
	}

	public void modifierLivre(Livre livre) {
		daoL.save(livre);
	}
	

	public void supprimerLivre(Livre livre) {
		daoL.delete(livre);
	}

	public List<Livre> trier(String par) {
		List<Livre> liste = null;

		switch (par) {
		case "tA":
			liste = (List<Livre>) daoL.findByOrderByTitreAsc();
			break;
		case "tD":
			liste = (List<Livre>) daoL.findByOrderByTitreDesc();
			break;
		case "iA":
			liste = (List<Livre>) daoL.findByOrderByIsbnAsc();
			break;
		case "iD":
			liste = (List<Livre>) daoL.findByOrderByIsbnDesc();
			break;
		default:
			liste = daoL.findAll();

		}

		return liste;
	}
	
	public long countLivre() {
		return daoL.count();
	}

	
	
	
}
