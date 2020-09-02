/**
 * 
 */
package fr.lusseau.bibliotheque.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.lusseau.bibliotheque.entity.Auteur;
import fr.lusseau.bibliotheque.service.GestionAuteur;

/**
 * Classe en charge de
 * @Version Bibliotheque -v1,0
 * @date  21 août 2020 - 14:11:38
 * @author Claude LUSSEAU
 *
 */
@Controller
public class AuteurController {

	@Autowired
	GestionAuteur ga;
	
	@PostConstruct
	private void init() {
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/listeAuteurs")
	public ModelAndView listerAuteurs() {
		List<Auteur> liste = ga.listeAuteurs();
		return new ModelAndView("/admin/listes/listeAuteurs", "liste", liste);
	}
	
	@RequestMapping(value = "/gestionAuteurs", method = RequestMethod.GET)
	public ModelAndView gererAuteurs() {
		List<Auteur> liste = ga.listeAuteurs();
		Auteur auteur = new Auteur();
		ModelAndView mav = new ModelAndView("/admin/gestion/gestionAuteurs", "liste", liste);
		mav.getModelMap().addAttribute("auteur", auteur);
		return mav;
	}
	
	@RequestMapping( value = "/ajoutAuteur", method = RequestMethod.GET)
	public ModelAndView ajoutAuteur() {
		Auteur auteur = new Auteur();
		ModelAndView mav = new ModelAndView("/admin/ajouts/ajoutAuteur", "auteur", auteur);
		mav.getModelMap().addAttribute("auteur", auteur);
		return mav;
	}
	
	@RequestMapping( value = "/validAuteur", method = RequestMethod.POST)
	public String ajoutAuteurValid(@Valid @ModelAttribute("auteur") Auteur auteur, BindingResult result) {
		if (result.hasErrors()) 
			return "/admin/ajouts/ajoutAuteur";
		 else
			ga.ajouterAuteur(auteur);
			return "redirect:/gestionAuteurs";
	}
	
	
	@RequestMapping(value="/modifierAuteur", method=RequestMethod.GET)
	public ModelAndView modifAuteur(String index){
		int i = Integer.parseInt(index.substring(1));
		return new ModelAndView("/admin/modifs/modifAuteur", "auteur", ga.trouverAuteur(i));
	}
	
	@RequestMapping(value="/modifierAuteurValid", method=RequestMethod.POST)
	public ModelAndView listeAuteurValid(Auteur auteur){	
		ga.modifierAuteur(auteur);
		return gererAuteurs();
	}
	
	@RequestMapping(value="/supprimerAuteur", method=RequestMethod.GET)
	public ModelAndView supprimerAuteur(String index){
		int i = Integer.parseInt(index.substring(1));
		Auteur auteur = ga.trouverAuteur(i);
		try {
			ga.supprimerAuteur(auteur);
		} catch (Exception e) {			
		}
		
		return gererAuteurs();
	}
}