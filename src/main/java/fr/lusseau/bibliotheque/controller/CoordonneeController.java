/**
 * 
 */
package fr.lusseau.bibliotheque.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.lusseau.bibliotheque.entity.Coordonnee;
import fr.lusseau.bibliotheque.service.impl.CoordonneeServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * Classe en charge de toutes les operations pour la gestion des coordonnees.
 * @Version Bibliotheque -v1,0
 * @date  22 oct. 2020 - 17:18:53
 * @author Claude LUSSEAU
 *
 */
@RestController
@RequestMapping("/rest/api/v1")
@Api(value = "Coordonnee Rest Controller: contient toutes les operations pour la gestion des Coordonnées")
public class CoordonneeController {
	
	@Autowired
	CoordonneeServiceImpl coordonneeService;
	
	/**
	 * Methode en charge d'ajouter une nouvelle coordonnee dans la base de données.
	 * 
	 * @param coordonnee
	 * @return
	 */
	@PostMapping("/addCoordonnee")
	@ApiOperation(value = "Ajouter une nouvelle Coordonnee", response = Coordonnee.class)
	@ApiResponses(value = { @ApiResponse(code = 409, message = "Erreur : la Coordonnee existe déjà"),
			@ApiResponse(code = 201, message = "Création : la Coordonnee a été correctement créée"),
			@ApiResponse(code = 304, message = "Non modifiée : la Coordonnee n'a pas été créée") })
	public ResponseEntity<Coordonnee> createNewCoordonnee(@RequestBody Coordonnee coordonnee) {
		Coordonnee existingCoordonnee = coordonneeService.findOne(coordonnee.getIdCoordonnee());
		if (existingCoordonnee != null) {
			return new ResponseEntity<Coordonnee>(HttpStatus.CONFLICT);
		}
		Coordonnee coordonneeResponse = coordonneeService.saveCoordonnee(coordonnee);
		if (coordonneeResponse != null) {

			return new ResponseEntity<Coordonnee>(coordonneeResponse, HttpStatus.CREATED);
		}
		return new ResponseEntity<Coordonnee>(HttpStatus.NOT_MODIFIED);
	}
	
	/**
	 * Methode en charge de la mise à jour d'une coordonnee.
	 * @param coordonneeRequest
	 * @return
	 */
	@PutMapping("/updateCoordonnee")
	@ApiOperation(value = "Modifie une coordonnee existante", response = Coordonnee.class)
	@ApiResponses(value = { @ApiResponse(code = 404, message = "Not Found : L'Bibliotheque.trice n'existe pas"),
			@ApiResponse(code = 200, message = "Ok: La coordonnee a été mise à jour"),
			@ApiResponse(code = 304, message = "Non modifié: La coordonnee N'A PAS ETE MISE A JOUR !") })
	public ResponseEntity<Coordonnee> updateCoordonnee(@RequestBody Coordonnee coordonneeRequest) {
		if (!coordonneeService.checkIfCoordonneeExists(coordonneeRequest.getIdCoordonnee())) {
			return new ResponseEntity<Coordonnee>(HttpStatus.NOT_FOUND);
		}
		Coordonnee coordonnee = coordonneeService.updateCoordonnee(coordonneeRequest);
		if (coordonnee != null) {
			
			return new ResponseEntity<Coordonnee>(coordonnee, HttpStatus.OK);
		}
		return new ResponseEntity<Coordonnee>(HttpStatus.NOT_MODIFIED);
	}
	
	/**
	 * Methode en charge de d'afficher une coordonnee de la base de données.
	 * @return
	 */
	@GetMapping("/coordonnee/{idCoordonnee}")
	@ApiOperation(value="affiche une coordonnee", response = Coordonnee.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Ok !"),
			@ApiResponse(code = 204, message = "Pas de donnée: pas de résultat"),
	})
	public ResponseEntity<Coordonnee> findCoordonnee(@PathVariable Integer idCoordonnee) {
		Coordonnee coordonnee = coordonneeService.findOne(idCoordonnee);
		if (coordonnee != null) {
			return new ResponseEntity<Coordonnee>(coordonnee, HttpStatus.OK);
		}
		return new ResponseEntity<Coordonnee>(HttpStatus.NO_CONTENT);
	}

}
