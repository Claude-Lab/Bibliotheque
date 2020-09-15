/**
 * 
 */
package fr.lusseau.bibliotheque.controller;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import fr.lusseau.bibliotheque.entity.Client;
import fr.lusseau.bibliotheque.entity.Emprunt;
import fr.lusseau.bibliotheque.entity.Personne;
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
public class PersonneController {

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

	@RequestMapping(value = "/detailsPersonne", method = RequestMethod.GET)
	public ModelAndView detailsPersonne(String index) {
		int i = Integer.parseInt(index.substring(1));
		ModelAndView mav = null;
		Personne pers = gp.trouverPersonne(i);
		List<Emprunt> listeEmprunt = ge.listEmpruntPersonneEnCoursEtAVenir(i);
		mav = new ModelAndView("/admin/details/detailsPersonne", "pers", pers);
		mav.addObject("localDateTimeFormat",
				DateTimeFormatter.ofPattern("EEEE dd MMMM yyyy 'à' HH'H'mm", Locale.FRANCE));
		mav.addObject("localDateFormat", DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		mav.addObject("listeEmprunt", listeEmprunt);
		return mav;

	}

	@RequestMapping(value = "/supprimerPersonne", method = RequestMethod.GET)
	public ModelAndView supprimerSalarie(String index) {
		int i = Integer.parseInt(index.substring(1));
		Personne personne = gp.trouverPersonne(i);
		try {
			gp.supprimerPersonne(personne);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (personne instanceof Client)
			return new ModelAndView("redirect:/gestionClients");
		else
			return new ModelAndView("redirect:/gestionSalaries");

	}
}
