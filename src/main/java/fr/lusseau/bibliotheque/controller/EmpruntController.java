/**
 * 
 */
package fr.lusseau.bibliotheque.controller;

import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import fr.lusseau.bibliotheque.entity.Client;
import fr.lusseau.bibliotheque.entity.Emprunt;
import fr.lusseau.bibliotheque.entity.Livre;
import fr.lusseau.bibliotheque.entity.Personne;
import fr.lusseau.bibliotheque.entity.Salarie;
import fr.lusseau.bibliotheque.service.GestionAuteur;
import fr.lusseau.bibliotheque.service.GestionEmprunt;
import fr.lusseau.bibliotheque.service.GestionLivre;
import fr.lusseau.bibliotheque.service.GestionPersonne;
import fr.lusseau.bibliotheque.service.GestionStyle;

/**
 * Classe en charge de
 * 
 * @Version Bibliotheque -v1,0
 * @date 7 sept. 2020 - 15:12:33
 * @author Claude LUSSEAU
 *
 */
@RestController
public class EmpruntController {

	@Autowired
	GestionEmprunt gm;
	@Autowired
	GestionLivre gl;
	@Autowired
	GestionPersonne gp;
	@Autowired
	GestionAuteur ga;
	@Autowired
	GestionStyle gs;

	@PostConstruct
	private void init() {
	}

	/**
	 * Methode en charge de lister tout les emprunts.
	 * 
	 * @return
	 */
	@RequestMapping(path = "/listeEmprunts", method = RequestMethod.GET)
	public ModelAndView listerEmprunts() {
		List<Emprunt> liste = gm.listeEmprunts();
		ModelAndView mav = new ModelAndView("/admin/listes/listeEmprunts", "liste", liste);
		infosEmpruntLivrePersonne(mav);
		return mav;
	}

	/**
	 * Methode en charge de lister les emprunts passés.
	 * 
	 * @return
	 */
	@RequestMapping(path = "/listeEmpruntsPasses", method = RequestMethod.GET)
	public ModelAndView listerEmpruntsPasses() {
		Emprunt emprunt = new Emprunt();
		List<Emprunt> liste = gm.listeEmpruntsPasses();
		ModelAndView mav = new ModelAndView("/admin/listes/listeEmpruntsPasses", "liste", liste);
		infosEmpruntLivrePersonne(mav);
		mav.addObject("localDateTimeFormat", DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		mav.getModelMap().addAttribute("emprunt", emprunt);
		return mav;
	}

	/**
	 * Methode en charge de lister les emprunts futurs.
	 * 
	 * @return
	 */
	@RequestMapping(path = "/listeEmpruntsAVenir", method = RequestMethod.GET)
	public ModelAndView listerEmpruntsFuturs() {
		Emprunt emprunt = new Emprunt();
		List<Emprunt> liste = gm.listeEmpruntsFuturs();
		ModelAndView mav = new ModelAndView("/admin/listes/listeEmpruntsAVenir", "liste", liste);
		infosEmpruntLivrePersonne(mav);
		mav.addObject("localDateTimeFormat", DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		mav.getModelMap().addAttribute("emprunt", emprunt);
		return mav;
	}

	/**
	 * Methode en charge de de lister les emprunts en cours.
	 * 
	 * @return
	 */
	@RequestMapping(path = "/listeEmpruntsEnCours", method = RequestMethod.GET)
	public ModelAndView listerEmpruntsEnCours() {
		Emprunt emprunt = new Emprunt();
		List<Emprunt> liste = gm.listeEmpruntsEnCours();
		ModelAndView mav = new ModelAndView("/admin/listes/listeEmpruntsEnCours", "liste", liste);
		infosEmpruntLivrePersonne(mav);
		mav.addObject("localDateTimeFormat", DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		mav.getModelMap().addAttribute("emprunt", emprunt);
		return mav;
	}

	@RequestMapping(value = "/gestionEmprunts", method = RequestMethod.GET)
	public ModelAndView gererEmprunts() {
		List<Emprunt> liste = gm.listeEmprunts();
		Emprunt emprunt = new Emprunt();
		ModelAndView mav = new ModelAndView("/admin/gestion/gestionEmprunts", "liste", liste);
		infosEmpruntLivrePersonne(mav);
		mav.addObject("localDateTimeFormat", DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		mav.getModelMap().addAttribute("emprunt", emprunt);

		return mav;
	}

	@RequestMapping(value = "/ajoutEmprunt", method = RequestMethod.GET)
	public ModelAndView ajouterEmprunt() {
		Emprunt emprunt = new Emprunt();
		List<Livre> listeLivres = gl.listeLivres();
		List<Personne> listePersonnes = gp.listePersonnes();
		ModelAndView mav = new ModelAndView("/admin/ajouts/ajoutEmprunt", "emprunt", emprunt);
		mav.getModelMap().addAttribute("listeLivres", listeLivres);
		mav.getModelMap().addAttribute("listePersonnes", listePersonnes);
		return mav;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/validEmprunt")
	public ModelAndView ajoutEmpruntValid(@ModelAttribute("emprunt") Emprunt emprunt, BindingResult result) {
		if (result.hasErrors()) {
			return new ModelAndView("/admin/ajouts/ajoutEmprunt");
		} else {
			gm.ajouterEmprunt(emprunt);
			return new ModelAndView("redirect:/gestionEmprunts");
		}
	}

	@RequestMapping(value = "/supprimerEmprunt", method = RequestMethod.GET)
	public ModelAndView supprimerEmprunt(String index) {
		int i = Integer.parseInt(index.substring(1));
		Emprunt emprunt = gm.trouverEmprunt(i);
		try {
			gm.supprimerEmprunt(emprunt);
		} catch (Exception e) {
		}

		return gererEmprunts();
	}

	/**
	 * Methode en charge d'ajouter les classes Livre et Personne à la liste
	 * d'emprunts.
	 * 
	 * @param mav
	 */
	private void infosEmpruntLivrePersonne(ModelAndView mav) {
		Personne personne = null;
		if (personne instanceof Client) {
			Livre livre = new Livre();
			personne = new Client();
			mav.addObject("livre", livre);
			mav.addObject("personne", personne);
		} else if (personne instanceof Salarie) {
			Livre livre = new Livre();
			personne = new Salarie();
			mav.addObject("livre", livre);
			mav.addObject("personne", personne);
		}
	}
}
