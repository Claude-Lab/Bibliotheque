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

import fr.lusseau.bibliotheque.entity.Coordonnee;
import fr.lusseau.bibliotheque.entity.Editeur;
import fr.lusseau.bibliotheque.service.GestionEditeur;

/**
 * Classe en charge de
 * @Version Bibliotheque -v1,0
 * @date  21 août 2020 - 14:11:25
 * @author Claude LUSSEAU
 *
 */
@Controller
public class EditeurController {

	@Autowired
	GestionEditeur ge;
	
	@PostConstruct
	private void init() {
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/listeEditeurs")
	public ModelAndView listerEditeurs() {
		List<Editeur> listeE = ge.listeEditeurs();
		return new ModelAndView("/admin/listes/listeEditeurs", "listeE", listeE);
	}
	
	@RequestMapping(value = "/gestionEditeurs", method = RequestMethod.GET)
	public ModelAndView gererEditeurs() {
		List<Editeur> listeE = ge.listeEditeurs();
		Editeur editeur = new Editeur();
		ModelAndView mav = new ModelAndView("/admin/gestion/gestionEditeurs", "listeE", listeE);
		mav.getModelMap().addAttribute("editeur", editeur);
		return mav;
	}
	
	@RequestMapping( value = "/ajoutEditeur", method = RequestMethod.GET)
	public ModelAndView ajoutEditeur() {
		Editeur editeur = new Editeur();
		ModelAndView mav = new ModelAndView("/admin/ajouts/ajoutEditeur", "editeur", editeur);
		mav.getModelMap().addAttribute("editeur", editeur);
		return mav;
	}
	
	@RequestMapping( value = "/validEditeur", method = RequestMethod.POST)
	public String ajoutEditeurValid(@Valid @ModelAttribute("editeur, coordonnee") Editeur editeur, Coordonnee coordonee, BindingResult result) {
		if (result.hasErrors()) 
			return "/admin/ajouts/ajoutEditeur";
		 else
			ge.ajouterEditeur(editeur);
			return "redirect:/gestionEditeurs";
	}
	
	@RequestMapping(value = "/detailsEditeur", method = RequestMethod.GET)
	public ModelAndView detailsEditeur(String index) {
		int i = Integer.parseInt(index.substring(1));
		Editeur editeur;
		Coordonnee coordonnee = null;
		editeur = ge.trouverEditeur(i);
		ModelAndView mav = new ModelAndView("/admin/details/detailsEditeur", "editeur", editeur);
		mav.getModelMap().addAttribute(index, coordonnee);
		return mav;

	}
	
	@RequestMapping(value="/modifierEditeur", method=RequestMethod.GET)
	public ModelAndView modifEditeur(String index){
		int i = Integer.parseInt(index.substring(1));
		return new ModelAndView("/admin/modifs/modifEditeur", "editeur", ge.trouverEditeur(i));
	}
	
	@RequestMapping(value="/modifierEditeurValid", method=RequestMethod.POST)
	public ModelAndView listeStyleValid(Editeur editeur){	
		ge.modifierEditeur(editeur);
		return gererEditeurs();
	}
	
	@RequestMapping(value="/supprimerEditeur", method=RequestMethod.GET)
	public ModelAndView supprimerEditeur(String index){
		int i = Integer.parseInt(index.substring(1));
		Editeur editeur = ge.trouverEditeur(i);
		try {
			ge.supprimerEditeur(editeur);
		} catch (Exception e) {			
		}
		
		return gererEditeurs();
	}
	
}
