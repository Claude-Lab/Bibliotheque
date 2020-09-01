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

import fr.lusseau.bibliotheque.entity.Style;
import fr.lusseau.bibliotheque.service.GestionStyle;

/**
 * Classe en charge de
 * @Version Bibliotheque -v1,0
 * @date  21 août 2020 - 14:11:04
 * @author Claude LUSSEAU
 *
 */
@Controller
public class StyleController {
	
	@Autowired
	GestionStyle gs;

	@PostConstruct
	private void init() {
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/listeStyles")
	public ModelAndView listerStyles() {
		List<Style> listeS = gs.listeStyles();
		return new ModelAndView("/admin/listes/listeStyles", "listeS", listeS);
	}
	
	@RequestMapping(value = "/gestionStyles", method = RequestMethod.GET)
	public ModelAndView gererStyles() {
		List<Style> listeS = gs.listeStyles();
		Style style = new Style();
		ModelAndView mav = new ModelAndView("/admin/gestion/gestionStyles", "listeS", listeS);
		mav.getModelMap().addAttribute("style", style);
		return mav;
	}
	
	@RequestMapping( value = "/ajouterStyles", method = RequestMethod.GET)
	public ModelAndView ajoutStyle() {
		Style style = new Style();
		ModelAndView mav = new ModelAndView("/admin/ajouts/ajoutStyle", "style", style);
		mav.getModelMap().addAttribute("style", style);
		return mav;
	}
	
	@RequestMapping( value = "/validStyle", method = RequestMethod.POST)
	public String ajoutStyleValid(@ModelAttribute("style") @Valid Style style, BindingResult result) {
		if (result.hasErrors()) 
			return "/admin/ajouts/ajoutStyle";
		 else
			gs.ajouterStyle(style);
			return "redirect:/gestionStyles";
	}
	
	@RequestMapping(value="/modifierStyle", method=RequestMethod.GET)
	public ModelAndView modifStyle(String index){
		int i = Integer.parseInt(index.substring(1));
		return new ModelAndView("/admin/modifs/modifStyle", "style", gs.trouverStyle(i));
	}
	
	@RequestMapping(value="/modifierStyleValid", method=RequestMethod.POST)
	public ModelAndView listeStyleValid(Style style){	
		gs.modifierStyle(style);
		return gererStyles();
	}
	
	@RequestMapping(value="/supprimerStyle", method=RequestMethod.GET)
	public ModelAndView supprimerRole(String index){
		int i = Integer.parseInt(index.substring(1));
		Style style = gs.trouverStyle(i);
		try {
			gs.supprimerStyle(style);
		} catch (Exception e) {			
		}
		
		return gererStyles();
	}
	
}
