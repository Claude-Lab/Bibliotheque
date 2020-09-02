/**
 * 
 */
package fr.lusseau.bibliotheque.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import fr.lusseau.bibliotheque.entity.Auteur;
import fr.lusseau.bibliotheque.entity.Bibliotheque;
import fr.lusseau.bibliotheque.entity.Editeur;
import fr.lusseau.bibliotheque.entity.Etat;
import fr.lusseau.bibliotheque.entity.Livre;
import fr.lusseau.bibliotheque.entity.Style;
import fr.lusseau.bibliotheque.service.GestionAuteur;
import fr.lusseau.bibliotheque.service.GestionBibliotheque;
import fr.lusseau.bibliotheque.service.GestionEditeur;
import fr.lusseau.bibliotheque.service.GestionEmprunt;
import fr.lusseau.bibliotheque.service.GestionEtat;
import fr.lusseau.bibliotheque.service.GestionLivre;
import fr.lusseau.bibliotheque.service.GestionStyle;

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
public class LivreController {

	@Autowired
	GestionLivre gl;
	@Autowired
	GestionAuteur ga;
	@Autowired
	GestionEditeur ge;
	@Autowired
	GestionBibliotheque gb;
	@Autowired
	GestionEmprunt gd;
	@Autowired
	GestionStyle gs;
	@Autowired
	GestionEtat gt;

	/**
	 * Constructeur.
	 * 
	 * @param gl
	 * @param ga
	 * @param ge
	 * @param gb
	 * @param gd
	 * @param gs
	 * @param gt
	 */
	public LivreController(GestionLivre gl, GestionAuteur ga, GestionEditeur ge, GestionBibliotheque gb,
			GestionEmprunt gd, GestionStyle gs, GestionEtat gt) {
		this.gl = gl;
		this.ga = ga;
		this.ge = ge;
		this.gb = gb;
		this.gd = gd;
		this.gs = gs;
		this.gt = gt;
	}

	@PostConstruct
	private void init() {
	}

	@RequestMapping(path = "/listeLivres", method = RequestMethod.GET)
	public ModelAndView listerLivres() {
		List<Livre> listeL = gl.listeLivres();
		return new ModelAndView("/admin/listes/listeLivres", "listeL", listeL);
	}

	@RequestMapping(path = "/gestionLivres", method = RequestMethod.GET)
	public ModelAndView gererLivres() {
		List<Livre> listeL = gl.listeLivres();
		Livre livre = new Livre();
		ModelAndView mav = new ModelAndView("/admin/gestion/gestionLivres", "listeL", listeL);
		mav.getModelMap().addAttribute("livre", livre);
		return mav;
	}

	@RequestMapping(value = "/ajoutLivre", method = RequestMethod.GET)
	public ModelAndView ajouterLivre() {
		Livre livre = new Livre();
		List<Bibliotheque> listeBibliotheques = gb.listeBibliotheques();
		List<Etat> listeEtats = gt.listeEtats();
		List<Editeur> listeEditeurs = ge.listeEditeurs();
		List<Auteur> listeAuteurs = ga.listeAuteurs();
		List<Style> listeStyles = gs.listeStyles();
		ModelAndView mav = new ModelAndView("/admin/ajouts/ajoutLivre", "livre", livre);
		mav.addObject("listeStyles", listeStyles);
		mav.addObject("listeAuteurs", listeAuteurs);
		mav.getModelMap().addAttribute("listeBibliotheques", listeBibliotheques);
		mav.getModelMap().addAttribute("listeEtats", listeEtats);
		mav.getModelMap().addAttribute("listeEditeurs", listeEditeurs);
		return mav;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/validLivre")
	public ModelAndView ajoutLivreValid(
			@ModelAttribute Livre livre, BindingResult result) {
		if (result.hasErrors()) {
			return new ModelAndView("/admin/ajouts/ajoutLivre");
		} else {

			gl.saveLivre(livre);

			return gererLivres();
		}
	}

	@RequestMapping(value = "/detailsLivre", method = RequestMethod.GET)
	public ModelAndView detailsLivre(String index) {
		int i = Integer.parseInt(index.substring(1));
		Livre livre;
		livre = gl.trouverLivre(i);
		Bibliotheque bibliotheque = null;
		Editeur editeur = null;
		Etat etat = null;
		List<Auteur> listeAuteurs =  ga.trouverAuteurLivre(i);
		List<Style> listeStyles = gs.trouverStyleLivre(i);
		
		ModelAndView mav = new ModelAndView("/admin/details/detailsLivre", "livre", livre);
		mav.getModelMap().addAttribute(index, bibliotheque);
		mav.getModelMap().addAttribute(index, editeur);
		mav.getModelMap().addAttribute(index, etat);
		mav.addObject("listeStyles", listeStyles);
		mav.addObject("listeAuteurs", listeAuteurs);
		return mav;

	}

	@RequestMapping(value = "/modifierLivre", method = RequestMethod.GET)
	public ModelAndView modifLivre(String index) {
		int i = Integer.parseInt(index.substring(1));
		List<Bibliotheque> listeBibliotheques = gb.listeBibliotheques();
		List<Etat> listeEtats = gt.listeEtats();
		List<Editeur> listeEditeurs = ge.listeEditeurs();
		List<Auteur> listeAuteurs = ga.listeAuteurs();
		List<Style> listeStyles = gs.listeStyles();
		ModelAndView mav = new ModelAndView("/admin/modifs/modifLivre", "livre", gl.trouverLivre(i));
		mav.addObject("listeStyles", listeStyles);
		mav.addObject("listeAuteurs", listeAuteurs);
		mav.getModelMap().addAttribute("listeBibliotheques", listeBibliotheques);
		mav.getModelMap().addAttribute("listeEtats", listeEtats);
		mav.getModelMap().addAttribute("listeEditeurs", listeEditeurs);
		return mav;
	}

	@RequestMapping(value = "/modifierLivreValid", method = RequestMethod.POST)
	public ModelAndView listeLivreValid(Livre livre) {
		gl.modifierLivre(livre);
		;
		return gererLivres();
	}

	@RequestMapping(value = "/supprimerLivre", method = RequestMethod.GET)
	public ModelAndView supprimerLivre(String index) {
		int i = Integer.parseInt(index.substring(1));
		Livre livre = gl.trouverLivre(i);
		try {
			gl.supprimerLivre(livre);
		} catch (Exception e) {
		}

		return gererLivres();
	}

}
