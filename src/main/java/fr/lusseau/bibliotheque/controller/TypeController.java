/**
 * 
 */
package fr.lusseau.bibliotheque.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import fr.lusseau.bibliotheque.entity.Type;
import fr.lusseau.bibliotheque.service.GestionType;

/**
 * Classe en charge de la gestion et de la synchronisation des événements liés à la classe Type.
 * @Version Bibliotheque -v1,0
 * @date  15 août 2020 - 10:35:13
 * @author Claude LUSSEAU
 *
 */
@RestController
public class TypeController {
	
	@Autowired
	GestionType gt;
	
	@PostConstruct
	private void init() {
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/listeTypes")
	public ModelAndView listerTypes() {
		List<Type> liste = gt.listeTypes();
		return new ModelAndView("/admin/listes/listeTypes", "liste", liste);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/gestionTypes")
	public ModelAndView gererTypes() {
		List<Type> liste = gt.listeTypes();
		Type type = new Type();
		ModelAndView mav = new ModelAndView("/admin/gestion/gestionTypes", "liste", liste);
		mav.getModelMap().addAttribute("type", type);
		return mav;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/ajouterTypes")
	public ModelAndView ajouterType() {
		Type type = new Type();
		ModelAndView mav = new ModelAndView("/admin/gestions/ajouterType", "type", type);
		mav.getModelMap().addAttribute("type", type);
		return mav;
	}
	
	@RequestMapping(method = RequestMethod.POST,  value = "/validType")
	public ModelAndView ajoutTypeValid(@ModelAttribute("type") @Valid Type type, BindingResult result) {
		if (result.hasErrors())
			return new ModelAndView("/admin/ajouts/ajoutType");
		else
			gt.ajouterType(type);
			return new ModelAndView("redirect:/gestionTypes");
	}
	
	
	
	@RequestMapping(value="/modifierType", method=RequestMethod.GET)
	public ModelAndView modifTypes(String index){
		int i = Integer.parseInt(index.substring(1));
		ModelAndView mav = new ModelAndView("/admin/modifs/modifType", "type", gt.trouverType(i));
		return mav;
	}
	
	@RequestMapping(value="/modifierTypeValid", method=RequestMethod.POST)
	public ModelAndView listeTypeValid(Type type){	
		gt.modifierType(type);
		return gererTypes();
	}
	
	@RequestMapping(value="/supprimerType", method=RequestMethod.GET)
	public ModelAndView supprimerType(String index){
		int i = Integer.parseInt(index.substring(1));
		Type type = gt.trouverType(i);
		try {
			gt.supprimerType(type);
		} catch (Exception e) {			
		}
		
		return gererTypes();
	}

}
