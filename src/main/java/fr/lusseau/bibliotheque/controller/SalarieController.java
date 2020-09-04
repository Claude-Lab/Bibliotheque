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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import fr.lusseau.bibliotheque.entity.Caution;
import fr.lusseau.bibliotheque.entity.Coordonnee;
import fr.lusseau.bibliotheque.entity.Emprunt;
import fr.lusseau.bibliotheque.entity.Role;
import fr.lusseau.bibliotheque.entity.Salarie;
import fr.lusseau.bibliotheque.service.GestionCaution;
import fr.lusseau.bibliotheque.service.GestionCoordonnee;
import fr.lusseau.bibliotheque.service.GestionEmprunt;
import fr.lusseau.bibliotheque.service.GestionRole;
import fr.lusseau.bibliotheque.service.GestionSalarie;
import fr.lusseau.bibliotheque.utils.DateToString;

/**
 * Classe en charge de
 * @Version Bibliotheque -v1,0
 * @date  4 sept. 2020 - 16:37:29
 * @author Claude LUSSEAU
 *
 */
@RestController
public class SalarieController {
	
	@Autowired
	static DateToString dts = new DateToString();
	@Autowired
	GestionSalarie gs;
	@Autowired
	GestionRole gr;
	@Autowired
	GestionCaution gc;
	@Autowired
	GestionCoordonnee ga;
	@Autowired
	GestionEmprunt ge;

	@PostConstruct
	private void init() {
	}
	

	@RequestMapping(path = "/listeSalaries", method = RequestMethod.GET)
	public ModelAndView listerSalaries() {
		List<Salarie> listeP = gs.listeSalaries();
		return new ModelAndView("/admin/listes/listeSalaries", "listeP", listeP);
	}

	@RequestMapping(path = "/gestionSalaries", method = RequestMethod.GET)
	public ModelAndView gererSalaries() {
		List<Salarie> listeP = gs.listeSalaries();
		Salarie pers = new Salarie();
		ModelAndView mav = new ModelAndView("/admin/gestion/gestionSalaries", "listeP", listeP);
		mav.getModelMap().addAttribute("pers", pers);
		return mav;
	}

	@RequestMapping(value = "/ajoutSalarie", method = RequestMethod.GET)
	public ModelAndView ajouterSalarie() {
		Salarie pers = new Salarie();
		List<Role> listeRoles = gr.listeRoles();
		List<Caution> listeCautions = gc.listeCautions();
		ModelAndView mav = new ModelAndView("/admin/ajouts/ajoutSalarie", "pers", pers);
		mav.getModelMap().addAttribute("listeRoles", listeRoles);
		mav.getModelMap().addAttribute("listeCautions", listeCautions);
		return mav;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/validSalarie")
	public ModelAndView ajoutSalarieValid(@Valid @ModelAttribute("pers, coordonnee, caution, role") Salarie pers,
			Coordonnee coordonnee, BindingResult result) {
		if (result.hasErrors()) {
			return new ModelAndView("/admin/ajouts/ajoutSalarie");
		} else {
			gs.ajouterSalarie(pers);
			return new ModelAndView("redirect:/gestionSalaries");
		}
	}

	@RequestMapping(value = "/detailsSalarie", method = RequestMethod.GET)
	public ModelAndView detailsSalarie(String index, @RequestParam(value="pers.getDateInscription()", required = false) String date)  {
		int i = Integer.parseInt(index.substring(1));
		Salarie pers;
		Role role = null;
		Caution caution = null;
		Coordonnee coordonnee = null;
		List<Emprunt> emprunts = null;
		pers = gs.trouverSalarie(i);
		date = dts.convert(pers.getDateInscription());
		ModelAndView mav = new ModelAndView("/admin/details/detailsSalarie", "pers", pers);
		
		mav.getModelMap().addAttribute(index, role);
		mav.getModelMap().addAttribute(index, caution);
		mav.getModelMap().addAttribute(index, coordonnee);
		mav.getModelMap().addAttribute(index, emprunts);
		mav.addObject("date", date);
		
		return mav;

	}

	@RequestMapping(value = "/modifierSalarie", method = RequestMethod.GET)
	public ModelAndView modifSalarie(String index) {
		int i = Integer.parseInt(index.substring(1));
		List<Role> listeRoles = gr.listeRoles();
		List<Caution> listeCautions = gc.listeCautions();
		ModelAndView mav = new ModelAndView("/admin/modifs/modifSalarie", "pers", gs.trouverSalarie(i));
		mav.getModelMap().addAttribute("listeRoles", listeRoles);
		mav.getModelMap().addAttribute("listeCautions", listeCautions);
		return mav;
	}

	@RequestMapping(value = "/modifierSalarieValid", method = RequestMethod.POST)
	public ModelAndView listePersonneValid(Salarie pers) {
		gs.modifierSalarie(pers);
		return new ModelAndView ("redirect:/gestionSalaries");
	}

	@RequestMapping(value = "/supprimerSalarie", method = RequestMethod.GET)
	public ModelAndView supprimerSalarie(String index) {
		int i = Integer.parseInt(index.substring(1));
		Salarie personne = gs.trouverSalarie(i);
		try {
			gs.supprimerSalarie(personne);
		} catch (Exception e) {
		}

		return gererSalaries();
	}


}
