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

import fr.lusseau.bibliotheque.entity.Bibliotheque;
import fr.lusseau.bibliotheque.entity.Coordonnee;
import fr.lusseau.bibliotheque.service.GestionBibliotheque;

/**
 * Classe en charge de
 * @Version Bibliotheque -v1,0
 * @date  21 août 2020 - 14:11:15
 * @author Claude LUSSEAU
 *
 */
@RestController
public class BibliothequeController {

	@Autowired
	GestionBibliotheque gb;
	
	@PostConstruct
	private void init() {
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/listeBibliotheques")
	public ModelAndView listerBibliotheques() {
		List<Bibliotheque> liste = gb.listeBibliotheques();
		return new ModelAndView("/admin/listes/listeBibliotheques", "liste", liste);
	}
	
	@RequestMapping(value = "/gestionBibliotheques", method = RequestMethod.GET)
	public ModelAndView gererBibliotheques() {
		List<Bibliotheque> liste = gb.listeBibliotheques();
		Bibliotheque bibliotheque = new Bibliotheque();
		ModelAndView mav = new ModelAndView("/admin/gestion/gestionBibliotheques", "liste", liste);
		mav.getModelMap().addAttribute("bibliotheque", bibliotheque);
		return mav;
	}
	
	@RequestMapping( value = "/ajoutBibliotheque", method = RequestMethod.GET)
	public ModelAndView ajoutBibliotheque() {
		Bibliotheque bibliotheque = new Bibliotheque();
		ModelAndView mav = new ModelAndView("/admin/ajouts/ajoutBibliotheque", "bibliotheque", bibliotheque);
		mav.getModelMap().addAttribute("bibliotheque", bibliotheque);
		return mav;
	}
	
	@RequestMapping( value = "/validBibliotheque", method = RequestMethod.POST)
	public ModelAndView ajoutBibliothequeValid(@Valid @ModelAttribute("bibliotheque") Bibliotheque bibliotheque, BindingResult result) {
		if (result.hasErrors()) 
			return new ModelAndView("/admin/ajouts/ajoutBibliotheque");
		 else
			gb.ajouterBibliotheque(bibliotheque);
			return new ModelAndView("redirect:/gestionBibliotheques");
	}
	
	@RequestMapping(value = "/detailsBibliotheque", method = RequestMethod.GET)
	public ModelAndView detailsBibliotheque(String index) {
		int i = Integer.parseInt(index.substring(1));
		Bibliotheque bibliotheque;
		Coordonnee coordonnee = null;
		bibliotheque = gb.trouverBibliotheque(i);
		ModelAndView mav = new ModelAndView("/admin/details/detailsBibliotheque", "bibliotheque", bibliotheque);
		mav.getModelMap().addAttribute(index, coordonnee);
		return mav;

	}
	
	@RequestMapping(value="/modifierBibliotheque", method=RequestMethod.GET)
	public ModelAndView modifBibliotheque(String index){
		int i = Integer.parseInt(index.substring(1));
		return new ModelAndView("/admin/modifs/modifBibliotheque", "bibliotheque", gb.trouverBibliotheque(i));
	}
	
	@RequestMapping(value="/modifierBibliothequeValid", method=RequestMethod.POST)
	public ModelAndView listeBibliothequeValid(Bibliotheque bibliotheque){	
		gb.modifierBibliotheque(bibliotheque);
		return gererBibliotheques();
	}
	
	@RequestMapping(value="/supprimerBibliotheque", method=RequestMethod.GET)
	public ModelAndView supprimerBibliotheque(String index){
		int i = Integer.parseInt(index.substring(1));
		Bibliotheque bibliotheque = gb.trouverBibliotheque(i);
		try {
			gb.supprimerBibliotheque(bibliotheque);
		} catch (Exception e) {			
		}
		
		return gererBibliotheques();
	}
}
