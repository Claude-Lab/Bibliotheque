/**
 * 
 */
package fr.lusseau.bibliotheque.controller;

import java.time.LocalDateTime;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import fr.lusseau.bibliotheque.entity.Emprunt;
import fr.lusseau.bibliotheque.entity.Livre;
import fr.lusseau.bibliotheque.entity.Personne;
import fr.lusseau.bibliotheque.service.GestionEmprunt;
import fr.lusseau.bibliotheque.service.GestionLivre;
import fr.lusseau.bibliotheque.service.GestionPersonne;
import fr.lusseau.bibliotheque.utils.DateTimeToString;
import fr.lusseau.bibliotheque.utils.StringToDateTime;

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
	static DateTimeToString dts = new DateTimeToString();
	@Autowired
	static StringToDateTime dst = new StringToDateTime();
	@Autowired
	GestionEmprunt gm;
	@Autowired
	GestionLivre gl;
	@Autowired
	GestionPersonne gp;

	@PostConstruct
	private void init() {
	}
	
	/**
	 * Methode en charge de lister tout les emprunts.
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
	 * @return
	 */
	@RequestMapping(path = "/listeEmpruntsPasses", method = RequestMethod.GET)
	public ModelAndView listerEmpruntsPasses() {
		List<Emprunt> liste = gm.listeEmpruntsPasses();
		ModelAndView mav =  new ModelAndView("/admin/listes/listeEmpruntsPasses", "liste", liste);
		infosEmpruntLivrePersonne(mav);
		return mav;
	}
	
	/**
	 * Methode en charge de lister les emprunts futurs.
	 * @return
	 */
	@RequestMapping(path = "/listeEmpruntsFuturs", method = RequestMethod.GET)
	public ModelAndView listerEmpruntsFuturs() {
		List<Emprunt> liste = gm.listeEmpruntsFuturs();
		ModelAndView mav =  new ModelAndView("/admin/listes/listeEmpruntsFuturs", "liste", liste);
		infosEmpruntLivrePersonne(mav);
		return mav;
	}

	
	/**
	 * Methode en charge de de lister les emprunts en cours.
	 * @return
	 */
	@RequestMapping(path = "/listeEmpruntsEnCours", method = RequestMethod.GET)
	public ModelAndView listerEmpruntsEnCours() {
		List<Emprunt> liste = gm.listeEmpruntsEnCours();
		ModelAndView mav =  new ModelAndView("/admin/listes/listeEmpruntsEnCours", "liste", liste);
		infosEmpruntLivrePersonne(mav);
		return mav;
	}
	
	@RequestMapping(path = "/gestionEmprunts", method = RequestMethod.GET)
	public ModelAndView gererEmprunts(@RequestParam(value="emprunt.getDateRetrait()", required = false) String dateRetrait, @RequestParam(value="emprunt.getDateRetour()", required = false) String dateRetour) {
		List<Emprunt> liste = gm.listeEmprunts();
		Emprunt emprunt = new Emprunt();
		dateRetrait = dts.convert(((Emprunt) liste).getDateRetrait());
		dateRetour = dts.convert(((Emprunt) liste).getDateRetour());
		ModelAndView mav = new ModelAndView("/admin/gestion/gestionEmprunts", "liste", liste);
		infosEmpruntLivrePersonne(mav);
		mav.getModelMap().addAttribute("emprunt", emprunt);
		mav.getModelMap().addAttribute("dateRetrait", dateRetrait);
		mav.getModelMap().addAttribute("dateRetour", dateRetour);
		
		return mav;
	}
	
	@RequestMapping(value = "/ajoutEmprunt", method = RequestMethod.GET)
	public ModelAndView ajouterEmprunt() {
		Emprunt emprunt = new Emprunt();
		List<Livre> listeLivres = gl.listeLivres();
		List<Personne> listePersonnes = gp.listePersonnes();
		LocalDateTime dateRetrait = emprunt.getDateRetrait();
		LocalDateTime dateRetour = emprunt.getDateRetour();
		ModelAndView mav = new ModelAndView("/admin/ajouts/ajoutEmprunt", "emprunt", emprunt);
		mav.getModelMap().addAttribute("listeLivres", listeLivres);
		mav.getModelMap().addAttribute("listePersonnes", listePersonnes);
		mav.getModelMap().addAttribute("dateRetrait", dateRetrait);
		mav.getModelMap().addAttribute("dateRetour", dateRetour);
		return mav;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/validEmprunt")
	public ModelAndView ajoutEmpruntValid(@ModelAttribute Emprunt emprunt, BindingResult result) {
		if (result.hasErrors()) {
			return new ModelAndView("/admin/ajouts/ajoutEmprunt");
		} else {
			gm.ajouterEmprunt(emprunt);
			return new ModelAndView("redirect:/gestionEmprunts");
		}
	}
	
	/**
	 * Methode en charge d'ajouter les classes Livre et Personne à la liste d'emprunts.
	 * @param mav
	 */
	private void infosEmpruntLivrePersonne(ModelAndView mav) {
		Livre livre = new Livre();
		Personne personne = new Personne();
		mav.addObject("livre", livre);
		mav.addObject("personne", personne);
	}
	
	
	
}
