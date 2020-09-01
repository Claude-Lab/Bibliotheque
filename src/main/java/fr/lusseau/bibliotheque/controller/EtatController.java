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

import fr.lusseau.bibliotheque.entity.Etat;
import fr.lusseau.bibliotheque.service.GestionEtat;

/**
 * Classe en charge de
 * @Version Bibliotheque -v1,0
 * @date  18 août 2020 - 18:36:01
 * @author Claude LUSSEAU
 *
 */
@Controller
public class EtatController {

	@Autowired
	GestionEtat ge;
	
	@PostConstruct
	private void init() {
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/listeEtats")
	public ModelAndView listerEtats() {
		List<Etat> listeE = ge.listeEtats();
		return new ModelAndView("/admin/listes/listeEtats", "listeE", listeE);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/gestionEtats")
	public ModelAndView gererEtats() {
		List<Etat> listeE = ge.listeEtats();
		Etat etat = new Etat();
		ModelAndView mav = new ModelAndView("/admin/gestion/gestionEtats", "listeE", listeE);
		mav.getModelMap().addAttribute("etat", etat);
		return mav;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/ajouterEtats")
	public ModelAndView ajouterEtat() {
		Etat etat = new Etat();
		ModelAndView mav = new ModelAndView("/admin/gestions/ajouterEtat", "etat", etat);
		mav.getModelMap().addAttribute("etat", etat);
		return mav;
	}
	
	@RequestMapping(method = RequestMethod.POST,  value = "/validEtat")
	public String ajoutEtatValid(@ModelAttribute("etat") @Valid Etat etat, BindingResult result) {
		if (result.hasErrors())
			return "/admin/ajouts/ajoutEtat";
		else
			ge.ajouterEtat(etat);
			return "redirect:/gestionEtats";
	}
	
	@RequestMapping(value="/modifierEtat", method=RequestMethod.GET)
	public ModelAndView modifEtats(String index){
		int i = Integer.parseInt(index.substring(1));
		ModelAndView mav = new ModelAndView("/admin/modifs/modifEtat", "etat", ge.trouverEtat(i));
		return mav;
	}
	
	@RequestMapping(value="/modifierEtatValid", method=RequestMethod.POST)
	public ModelAndView listeEtatValid(Etat etat){	
		ge.modifierEtat(etat);
		return gererEtats();
	}
	
	@RequestMapping(value="/supprimerEtat", method=RequestMethod.GET)
	public ModelAndView supprimerEtat(String index){
		int i = Integer.parseInt(index.substring(1));
		Etat etat = ge.trouverEtat(i);
		try {
			ge.supprimerEtat(etat);
		} catch (Exception e) {			
		}
		
		return gererEtats();
	}

}
