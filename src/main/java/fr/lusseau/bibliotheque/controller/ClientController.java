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
import fr.lusseau.bibliotheque.entity.Client;
import fr.lusseau.bibliotheque.entity.Coordonnee;
import fr.lusseau.bibliotheque.entity.Emprunt;
import fr.lusseau.bibliotheque.service.GestionCaution;
import fr.lusseau.bibliotheque.service.GestionClient;
import fr.lusseau.bibliotheque.service.GestionCoordonnee;
import fr.lusseau.bibliotheque.service.GestionEmprunt;
import fr.lusseau.bibliotheque.service.GestionRole;
import fr.lusseau.bibliotheque.utils.DateToString;

/**
 * Classe en charge de
 * @Version Bibliotheque -v1,0
 * @date  4 sept. 2020 - 16:37:40
 * @author Claude LUSSEAU
 *
 */
@RestController
public class ClientController {
	
	@Autowired
	static DateToString dts = new DateToString();
	@Autowired
	GestionClient gs;
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
	

	@RequestMapping(path = "/listeClients", method = RequestMethod.GET)
	public ModelAndView listerClients() {
		List<Client> listeP = gs.listeClients();
		return new ModelAndView("/admin/listes/listeClients", "listeP", listeP);
	}

	@RequestMapping(path = "/gestionClients", method = RequestMethod.GET)
	public ModelAndView gererClients() {
		List<Client> listeP = gs.listeClients();
		Client pers = new Client();
		ModelAndView mav = new ModelAndView("/admin/gestion/gestionClients", "listeP", listeP);
		mav.getModelMap().addAttribute("pers", pers);
		return mav;
	}

	@RequestMapping(value = "/ajoutClient", method = RequestMethod.GET)
	public ModelAndView ajouterClient() {
		Client pers = new Client();
		List<Caution> listeCautions = gc.listeCautions();
		ModelAndView mav = new ModelAndView("/admin/ajouts/ajoutClient", "pers", pers);
		mav.getModelMap().addAttribute("listeCautions", listeCautions);
		return mav;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/validClient")
	public ModelAndView ajoutClientValid(@Valid @ModelAttribute("pers, coordonnee, caution") Client pers,
			Coordonnee coordonnee, BindingResult result) {
		if (result.hasErrors()) {
			return new ModelAndView("/admin/ajouts/ajoutClient");
		} else {
			gs.ajouterClient(pers);
			return new ModelAndView("redirect:/gestionClients");
		}
	}

	@RequestMapping(value = "/detailsClient", method = RequestMethod.GET)
	public ModelAndView detailsClient(String index, @RequestParam(value="pers.getDateInscription()", required = false) String date)  {
		int i = Integer.parseInt(index.substring(1));
		Client pers;
		Caution caution = null;
		Coordonnee coordonnee = null;
		List<Emprunt> emprunts = null;
		pers = gs.trouverClient(i);
		date = dts.convert(pers.getDateInscription());
		ModelAndView mav = new ModelAndView("/admin/details/detailsClient", "pers", pers);
		
		mav.getModelMap().addAttribute(index, caution);
		mav.getModelMap().addAttribute(index, coordonnee);
		mav.getModelMap().addAttribute(index, emprunts);
		mav.addObject("date", date);
		
		return mav;

	}

	@RequestMapping(value = "/modifierClient", method = RequestMethod.GET)
	public ModelAndView modifClient(String index) {
		int i = Integer.parseInt(index.substring(1));
		List<Caution> listeCautions = gc.listeCautions();
		ModelAndView mav = new ModelAndView("/admin/modifs/modifClient", "pers", gs.trouverClient(i));
		mav.getModelMap().addAttribute("listeCautions", listeCautions);
		return mav;
	}

	@RequestMapping(value = "/modifierClientValid", method = RequestMethod.POST)
	public ModelAndView listeClientValid(Client pers) {
		gs.modifierClient(pers);
		return new ModelAndView ("redirect:/gestionClients");
	}

	@RequestMapping(value = "/supprimerClient", method = RequestMethod.GET)
	public ModelAndView supprimerClient(String index) {
		int i = Integer.parseInt(index.substring(1));
		Client personne = gs.trouverClient(i);
		try {
			gs.supprimerClient(personne);
		} catch (Exception e) {
		}

		return gererClients();
	}

}
