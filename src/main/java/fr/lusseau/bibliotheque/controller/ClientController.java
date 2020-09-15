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
import fr.lusseau.bibliotheque.entity.Client;
import fr.lusseau.bibliotheque.entity.Coordonnee;
import fr.lusseau.bibliotheque.entity.Personne;
import fr.lusseau.bibliotheque.service.GestionCaution;
import fr.lusseau.bibliotheque.service.GestionClient;
import fr.lusseau.bibliotheque.service.GestionCoordonnee;
import fr.lusseau.bibliotheque.service.GestionEmprunt;

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
public class ClientController {

	@Autowired
	GestionClient gcl;
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
		List<Client> liste = gcl.listeClients();
		return new ModelAndView("/admin/listes/listeSalaries", "liste", liste);
	}

	@RequestMapping(path = "/gestionClients", method = RequestMethod.GET)
	public ModelAndView gererClients() {
		List<Client> listeP = gcl.listeClients();
		Personne pers = new Client();
		ModelAndView mav = new ModelAndView("/admin/gestion/gestionClients", "listeP", listeP);
		mav.getModelMap().addAttribute("pers", pers);
		return mav;
	}

	@RequestMapping(value = "/ajoutClient", method = RequestMethod.GET)
	public ModelAndView ajouterClient() {
		Personne pers = new Client();
		List<Caution> listeCautions = gc.listeCautions();
		ModelAndView mav = new ModelAndView("/admin/ajouts/ajoutClient", "pers", pers);
		mav.getModelMap().addAttribute("listeCautions", listeCautions);
		return mav;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/validClient")
	public ModelAndView ajoutClientValid(@Valid @ModelAttribute("pers, coordonnee, caution, role") Client pers,
			Coordonnee coordonnee, BindingResult result) {
		if (result.hasErrors()) {
			return new ModelAndView("/admin/ajouts/ajoutClient");
		} else {
			gcl.ajouterClient(pers);
			return new ModelAndView("redirect:/gestionClients");
		}
	}


	@RequestMapping(value = "/modifierClient", method = RequestMethod.GET)
	public ModelAndView modifClient(String index) {
		int i = Integer.parseInt(index.substring(1));
		List<Caution> listeCautions = gc.listeCautions();
		ModelAndView mav = new ModelAndView("/admin/modifs/modifClient", "pers", gcl.trouverClient(i));
		mav.getModelMap().addAttribute("listeCautions", listeCautions);
		return mav;
	}

	@RequestMapping(value = "/modifierClientValid", method = RequestMethod.POST)
	public ModelAndView modifClientValid(Client pers) {
		gcl.modifierClient(pers);
		return new ModelAndView("redirect:/gestionClients");
	}
	

	@RequestMapping(value = "/supprimerClient", method = RequestMethod.GET)
	public ModelAndView supprimerClient(String index) {
		int i = Integer.parseInt(index.substring(1));
		Client personne = gcl.trouverClient(i);
		try {
			gcl.supprimerClient(personne);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return gererClients();
	}

}
