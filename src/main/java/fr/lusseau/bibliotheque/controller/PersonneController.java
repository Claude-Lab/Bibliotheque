/**
 * 
 */
package fr.lusseau.bibliotheque.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import fr.lusseau.bibliotheque.entity.Caution;
import fr.lusseau.bibliotheque.entity.Client;
import fr.lusseau.bibliotheque.entity.Coordonnee;
import fr.lusseau.bibliotheque.entity.Emprunt;
import fr.lusseau.bibliotheque.entity.Personne;
import fr.lusseau.bibliotheque.entity.Role;
import fr.lusseau.bibliotheque.entity.Salarie;
import fr.lusseau.bibliotheque.service.GestionCaution;
import fr.lusseau.bibliotheque.service.GestionCoordonnee;
import fr.lusseau.bibliotheque.service.GestionEmprunt;
import fr.lusseau.bibliotheque.service.GestionPersonne;
import fr.lusseau.bibliotheque.service.GestionRole;
import fr.lusseau.bibliotheque.service.GestionSalarie;
import fr.lusseau.bibliotheque.utils.DateToString;

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
public class PersonneController {
	
	@Autowired
	static DateToString dts = new DateToString();
	@Autowired
	GestionPersonne gp;
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
	
	
	@RequestMapping(path = "/listePersonnes", method = RequestMethod.GET)
	public ModelAndView listerPersonnes() {
		List<Salarie> listeP = gs.listeSalaries();
		return new ModelAndView("/admin/listes/listePersonnes", "listeP", listeP);
	}
	
	
	@RequestMapping(value = "/detailsPersonne", method = RequestMethod.GET)
	public ModelAndView detailsPersonne(String index, @RequestParam(value="pers.getDateInscription()", required = false) String date)  {
		int i = Integer.parseInt(index.substring(1));
		Personne pers;
		Role role = null;
		Caution caution = null;
		Coordonnee coordonnee = null;
		List<Emprunt> emprunts = null;
		pers = gp.trouverPersonne(i);
		date = dts.convert(pers.getDateInscription());
		ModelAndView mav = new ModelAndView("/admin/details/detailsPersonne", "pers", pers);
		
		if (pers instanceof Salarie) {
				mav.getModelMap().addAttribute(index, role);
				mav.getModelMap().addAttribute(index, caution);
				mav.getModelMap().addAttribute(index, coordonnee);
				mav.getModelMap().addAttribute(index, emprunts);
				mav.addObject("date", date);
		} if (pers instanceof Client) {
			mav.getModelMap().addAttribute(index, caution);
			mav.getModelMap().addAttribute(index, coordonnee);
			mav.getModelMap().addAttribute(index, emprunts);
			mav.addObject("date", date);
		}
		
		return mav;

	}

}
