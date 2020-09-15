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

import fr.lusseau.bibliotheque.entity.Caution;
import fr.lusseau.bibliotheque.entity.Coordonnee;
import fr.lusseau.bibliotheque.entity.Personne;
import fr.lusseau.bibliotheque.entity.Role;
import fr.lusseau.bibliotheque.entity.Salarie;
import fr.lusseau.bibliotheque.service.GestionCaution;
import fr.lusseau.bibliotheque.service.GestionClient;
import fr.lusseau.bibliotheque.service.GestionCoordonnee;
import fr.lusseau.bibliotheque.service.GestionEmprunt;
import fr.lusseau.bibliotheque.service.GestionPersonne;
import fr.lusseau.bibliotheque.service.GestionRole;
import fr.lusseau.bibliotheque.service.GestionSalarie;

/**
 * Classe en charge de la gestion et de la synchronisation des événements liés à
 * la classe Personne.
 * 
 * @Version Bibliotheque -v1,0
 * @date 14 août 2020 - 14:50:43
 * @author Claude LUSSEAU
 *
 */
@RestController
public class SalarieController {

	@Autowired
	GestionPersonne gp;
	@Autowired
	GestionSalarie gs;
	@Autowired
	GestionClient gcl;
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
		List<Salarie> liste = gs.listeSalaries();
		return new ModelAndView("/admin/listes/listeSalaries", "liste", liste);
	}	
	
	@RequestMapping(path = "/gestionSalaries", method = RequestMethod.GET)
	public ModelAndView gererSalaries() {
		List<Salarie> listeP = gs.listeSalaries();
		Personne salairie = new Salarie();
		ModelAndView mav = new ModelAndView("/admin/gestion/gestionSalaries", "listeP", listeP);
		mav.getModelMap().addAttribute("salairie", salairie);
		return mav;
	}

	@RequestMapping(value = "/ajoutSalarie", method = RequestMethod.GET)
	public ModelAndView ajouterSalarie() {
		Personne pers = new Salarie();
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

	@RequestMapping(value = "/modifierSalarie", method = RequestMethod.GET)
	public ModelAndView modifSalarie(String index) {
		int i = Integer.parseInt(index.substring(1));
		List<Role> listeRoles = gr.listeRoles();
		List<Caution> listeCautions = gc.listeCautions();
		ModelAndView mav = new ModelAndView("/admin/modifs/modifSalarie", "pers", gp.trouverPersonne(i));
		mav.getModelMap().addAttribute("listeRoles", listeRoles);
		mav.getModelMap().addAttribute("listeCautions", listeCautions);
		return mav;
	}
	
	@RequestMapping(value = "/modifierSalarieValid", method = RequestMethod.POST)
	public ModelAndView modifSalarieValid(Salarie pers) {
		gs.modifierSalarie(pers);
		return new ModelAndView("redirect:/gestionSalaries");
	}
	
	@RequestMapping(value = "/supprimerSalarie", method = RequestMethod.GET)
	public ModelAndView supprimerSalarie(String index) {
		int i = Integer.parseInt(index.substring(1));
		Salarie personne = gs.trouverSalarie(i);
		try {
			gs.supprimerSalarie(personne);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return gererSalaries();
	}
}
