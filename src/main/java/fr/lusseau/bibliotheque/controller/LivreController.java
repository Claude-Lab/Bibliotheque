/**
 * 
 */
package fr.lusseau.bibliotheque.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.lusseau.bibliotheque.dao.AuteurDAO;
import fr.lusseau.bibliotheque.dao.BibliothequeDAO;
import fr.lusseau.bibliotheque.dao.EditeurDAO;
import fr.lusseau.bibliotheque.dao.EtatDAO;
import fr.lusseau.bibliotheque.dao.LivreDAO;
import fr.lusseau.bibliotheque.dao.StyleDAO;
import fr.lusseau.bibliotheque.entity.Auteur;
import fr.lusseau.bibliotheque.entity.Bibliotheque;
import fr.lusseau.bibliotheque.entity.Editeur;
import fr.lusseau.bibliotheque.entity.Etat;
import fr.lusseau.bibliotheque.entity.Livre;
import fr.lusseau.bibliotheque.entity.Categorie;
import fr.lusseau.bibliotheque.exception.ResourceNotFoundException;
import io.swagger.annotations.ApiOperation;

/**
 * Classe en charge du controle DAO RESTFULL.
 * 
 * @Version Bibliotheque -v1,0
 * @date 14 août 2020 - 14:50:43
 * @author Claude LUSSEAU
 *
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class LivreController {

	@Autowired
	private LivreDAO livreDAO;
	@Autowired
	private AuteurDAO auteurDAO;
	@Autowired
	private EditeurDAO editeurDAO;
	@Autowired
	private BibliothequeDAO biblioDAO;
	@Autowired
	private StyleDAO styleDAO;
	@Autowired
	private EtatDAO etatDAO;

	@PostConstruct
	private void init() {
	}

	// get all livres
	@ApiOperation(value = "Récupère la liste des livres")
	@GetMapping(value = "livres")
	public List<Livre> listLivres() {
		return livreDAO.findAll();
	}

	// get a livre by id rest api
	@ApiOperation(value = "Récupère un livre selon son ID")
	@GetMapping(value = "livres/{idLivre}")
	public ResponseEntity<Livre> getLivreById(@PathVariable int idLivre) {
		Livre livre = livreDAO.findById(idLivre)
				.orElseThrow(() -> new ResourceNotFoundException("Le livre avec l'id " + idLivre + " n'existe pas."));
		return ResponseEntity.ok(livre);
	}

	// create livre rest api
	@PostMapping("livres")
	public void createLivre(@RequestBody Livre livre, List<Bibliotheque> listeBibliotheques, List<Etat> listeEtats,
			List<Editeur> listeEditeurs, List<Auteur> listeAuteurs, List<Categorie> listeStyles) {
		livre = new Livre();
		listeBibliotheques = biblioDAO.findAll();
		listeEtats = etatDAO.findAll();
		listeEditeurs = editeurDAO.findAll();
		listeAuteurs = auteurDAO.findAll();
		listeStyles = styleDAO.findAll();
		livreDAO.save(livre);
	}

}
