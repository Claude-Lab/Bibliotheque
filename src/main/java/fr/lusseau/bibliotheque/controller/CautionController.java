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

import fr.lusseau.bibliotheque.entity.Caution;
import fr.lusseau.bibliotheque.service.GestionCaution;

/**
 * Classe en charge de la gestion et de la synchronisation des événements liés à la classe Caution.
 * @Version Bibliotheque -v1,0
 * @date  15 août 2020 - 10:35:13
 * @author Claude LUSSEAU
 *
 */
@Controller
public class CautionController {
	
	@Autowired
	GestionCaution gc;
	
	@PostConstruct
	private void init() {
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/listeCautions")
	public ModelAndView listerCautions() {
		List<Caution> listeC = gc.listeCautions();
		return new ModelAndView("/admin/listes/listeCautions", "listeC", listeC);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/gestionCautions")
	public ModelAndView gererCautions() {
		List<Caution> listeC = gc.listeCautions();
		Caution caution = new Caution();
		ModelAndView mav = new ModelAndView("/admin/gestion/gestionCautions", "listeC", listeC);
		mav.getModelMap().addAttribute("caution", caution);
		return mav;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/ajouterCautions")
	public ModelAndView ajouterCaution() {
		Caution caution = new Caution();
		ModelAndView mav = new ModelAndView("/admin/gestions/ajouterCaution", "caution", caution);
		mav.getModelMap().addAttribute("caution", caution);
		return mav;
	}
	
	@RequestMapping(method = RequestMethod.POST,  value = "/validCaution")
	public String ajoutCautionValid(@ModelAttribute("caution") @Valid Caution caution, BindingResult result) {
		if (result.hasErrors())
			return "/admin/ajouts/ajoutCaution";
		else
			gc.ajouterCaution(caution);
			return "redirect:/gestionCautions";
	}
	
	
	
	@RequestMapping(value="/modifierCaution", method=RequestMethod.GET)
	public ModelAndView modifCautions(String index){
		int i = Integer.parseInt(index.substring(1));
		ModelAndView mav = new ModelAndView("/admin/modifs/modifCaution", "caution", gc.trouverCaution(i));
		return mav;
	}
	
	@RequestMapping(value="/modifierCautionValid", method=RequestMethod.POST)
	public ModelAndView listeCautionValid(Caution c){	
		gc.modifierCaution(c);
		return gererCautions();
	}
	
	@RequestMapping(value="/supprimerCaution", method=RequestMethod.GET)
	public ModelAndView supprimerRole(String index){
		int i = Integer.parseInt(index.substring(1));
		Caution caution = gc.trouverCaution(i);
		try {
			gc.supprimerCaution(caution);
		} catch (Exception e) {			
		}
		
		return gererCautions();
	}

}
