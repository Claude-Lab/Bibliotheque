/**
 * 
 */
package fr.lusseau.bibliotheque.controller;

import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import fr.lusseau.bibliotheque.entity.Categorie;
import fr.lusseau.bibliotheque.service.impl.CategorieServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


/**
 * Classe en charge de la gestion des catégories.
 * 
 * @Version Bibliotheque -v1,0
 * @date 21 oct. 2020 - 13:55:29
 * @author Claude LUSSEAU
 *
 */
@RestController
@Api(value = "Categorie Rest Controller: Contient toute les opération pour la gestion des categories")
@RequestMapping("/rest/api/v1")
public class CategorieController {

	public static final Logger LOGGER = LoggerFactory.getLogger(CategorieController.class);

	@Autowired
	CategorieServiceImpl categorieService;

	/**
	 * Methode en charge de d'ajouter une nouvelle catégorie dans la base de données.
	 * 
	 * @param categorie
	 * @return
	 */
	@PostMapping("/addCategorie")
	@ApiOperation(value = "Ajouter une nouvelle catégorie", response = Categorie.class)
	@ApiResponses(value = { @ApiResponse(code = 409, message = "Erreur : la catégorie existe déjà"),
			@ApiResponse(code = 201, message = "Création : la catégorie a été correctement créée"),
			@ApiResponse(code = 304, message = "Non modifiée : la catégorie n'a pas été créée") })
	public ResponseEntity<Categorie> createNewCategorie(@RequestBody Categorie categorie) {
		Categorie existingCategorie = categorieService.findCategorieByLibelleIgnoreCase(categorie.getLibelle());
		if (existingCategorie != null) {
			return new ResponseEntity<Categorie>(HttpStatus.CONFLICT);
		}
		Categorie categorieResponse = categorieService.saveCategorie(categorie);
		if (categorieResponse != null) {

			return new ResponseEntity<Categorie>(categorieResponse, HttpStatus.CREATED);
		}
		return new ResponseEntity<Categorie>(HttpStatus.NOT_MODIFIED);
	}

	/**
	 * Methode en charge de lister toutes les catégories de la base de données.
	 * @return
	 */
	@GetMapping("/listCategories")
	@ApiOperation(value="List all book categories of the Library", response = List.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Ok: liste réussie"),
			@ApiResponse(code = 204, message = "Pas de donnée: pas de résultat"),
	})
	public ResponseEntity<List<Categorie>> listCategorie() {
		List<Categorie> categories = categorieService.findAllCategorie();
		if (!CollectionUtils.isEmpty(categories)) {
			categories.removeAll(Collections.singleton(null));
			return new ResponseEntity<List<Categorie>>(categories, HttpStatus.OK);
		}
		return new ResponseEntity<List<Categorie>>(HttpStatus.NO_CONTENT);
	}
	
	/**
	 * Methode en charge de supprimer une catégorie dans la base de données.
	 * 
	 * @param idCategorie
	 * @return
	 */
	@DeleteMapping("/deleteCategorie/{idCategorie}")
	@ApiOperation(value = "Supprimer une catégorie. Si la categorie n'existe pas, rien ne se passe", response = String.class)
	@ApiResponse(code = 204, message = "Pas de donnée: catégorie correctement supprimée")
	public ResponseEntity<String> deleteBook(@PathVariable Integer idCategorie) {
		categorieService.deleteCategorie(idCategorie);
		return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
	}
	
	/**
	 * Methode en charge de la mise à jour d'une catégorie.
	 * @param categorieRequest
	 * @return
	 */
	@PutMapping("/updateCategorie")
	@ApiOperation(value = "Modifie une categorie existante", response = Categorie.class)
	@ApiResponses(value = { @ApiResponse(code = 404, message = "Not Found : L'auteur.trice n'existe pas"),
			@ApiResponse(code = 200, message = "Ok: L'auteur.trice a été mis à jour"),
			@ApiResponse(code = 304, message = "Non modifié: L'auteur.trice N'A PAS ETE MIS A JOUR !") })
	public ResponseEntity<Categorie> updateCategorie(@RequestBody Categorie categorieRequest) {
		if (!categorieService.checkIfIdExists(categorieRequest.getIdCategorie())) {
			return new ResponseEntity<Categorie>(HttpStatus.NOT_FOUND);
		}
		Categorie categorie = categorieService.updateCategorie(categorieRequest);
		if (categorie != null) {
			
			return new ResponseEntity<Categorie>(categorie, HttpStatus.OK);
		}
		return new ResponseEntity<Categorie>(HttpStatus.NOT_MODIFIED);
	}


}
