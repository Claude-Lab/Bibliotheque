/**
 * 
 */
package fr.lusseau.bibliotheque.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.lusseau.bibliotheque.entity.Auteur;
import fr.lusseau.bibliotheque.service.impl.AuteurServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * Classe en charge de la gestion des auteurs.
 * 
 * @Version Bibliotheque -v1,0
 * @date 21 août 2020 - 14:11:38
 * @author Claude LUSSEAU
 *
 */
@RestController
@RequestMapping("/rest/api/v1")
@Api(value = "Auteur Rest Controller: contient toutes les operations pour la gestion des auteurs")
public class AuteurController {

//	public static final Logger LOGGER = LoggerFactory.getLogger(AuteurController.class);

	@Autowired
	private AuteurServiceImpl auteurService;

	
	/**
	 * Methode en charge d'ajouter un.e nouvel.le auteur.trice dans la base de données.
	 * 
	 * @param auteur
	 * @return
	 */
	@PostMapping("/addAuteur")
	@ApiOperation(value = "Ajouter un.e nouvel.le auteur.trice", response = Auteur.class)
	@ApiResponses(value = { @ApiResponse(code = 409, message = "Erreur : la auteur.trice existe déjà"),
			@ApiResponse(code = 201, message = "Création : l'auteur.trice a été correctement créée"),
			@ApiResponse(code = 304, message = "Non modifiée : l'auteur.trice n'a pas été créée") })
	public ResponseEntity<Auteur> createNewAuteur(@RequestBody Auteur auteur) {
		Auteur existingAuteur = auteurService.findAuteurByPrenomNom(auteur.getPrenomNom());
		if (existingAuteur != null) {
			return new ResponseEntity<Auteur>(HttpStatus.CONFLICT);
		}
		Auteur auteurResponse = auteurService.saveAuteur(auteur);
		if (auteurResponse != null) {

			return new ResponseEntity<Auteur>(auteurResponse, HttpStatus.CREATED);
		}
		return new ResponseEntity<Auteur>(HttpStatus.NOT_MODIFIED);
	}

	
	/**
	 * Methode en charge de lister tout.e.s les auteur.trice.s de la base de données.
	 * @return
	 */
	@GetMapping("/listAuteurs")
	@ApiOperation(value="Liste tout.e.s les auteur.trice.s", response = Auteur.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Ok: liste réussie"),
			@ApiResponse(code = 204, message = "Pas de donnée: pas de résultat"),
	})
	public ResponseEntity<List<Auteur>> listAuteur() {
		List<Auteur> auteurs = auteurService.findAllAuteur();
		if (!CollectionUtils.isEmpty(auteurs)) {
			auteurs.removeAll(Collections.singleton(null));
			return new ResponseEntity<List<Auteur>>(auteurs, HttpStatus.OK);
		}
		return new ResponseEntity<List<Auteur>>(HttpStatus.NO_CONTENT);
	}
	
	/**
	 * Methode en charge de supprimer un.e auteur.trice.s de la base de données.
	 * 
	 * @param idAuteur
	 * @return
	 */
	@DeleteMapping("/deleteAuteur/{idAuteur}")
	@ApiOperation(value = "Supprimer un.e auteur.trice. Si l'auteur.trice n'existe pas, rien ne se passe", response = String.class)
	@ApiResponse(code = 204, message = "Pas de donnée: auteur.trice correctement supprimée")
	public ResponseEntity<String> deleteBook(@PathVariable Integer idAuteur) {
		auteurService.deleteAuteur(idAuteur);
		return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
	}
	
	
	
	/**
	 * Methode en charge de la mise à jour d'un.e auteur.trice.
	 * @param auteurRequest
	 * @return
	 */
	@PutMapping("/updateAuteur")
	@ApiOperation(value = "Modifie un.e auteur.trice existant.e", response = Auteur.class)
	@ApiResponses(value = { @ApiResponse(code = 404, message = "Not Found : L'auteur.trice n'existe pas"),
			@ApiResponse(code = 200, message = "Ok: L'auteur.trice a été mis à jour"),
			@ApiResponse(code = 304, message = "Non modifié: L'auteur.trice N'A PAS ETE MIS A JOUR !") })
	public ResponseEntity<Auteur> updateAuteur(@RequestBody Auteur auteurRequest) {
		if (!auteurService.checkIfIdexists(auteurRequest.getIdAuteur())) {
			return new ResponseEntity<Auteur>(HttpStatus.NOT_FOUND);
		}
		Auteur auteur = auteurService.updateAuteur(auteurRequest);
		if (auteur != null) {
			
			return new ResponseEntity<Auteur>(auteur, HttpStatus.OK);
		}
		return new ResponseEntity<Auteur>(HttpStatus.NOT_MODIFIED);
	}



}
