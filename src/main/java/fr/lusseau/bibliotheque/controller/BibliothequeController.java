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

import fr.lusseau.bibliotheque.entity.Bibliotheque;
import fr.lusseau.bibliotheque.service.impl.BibliothequeServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * Classe en charge de
 * @Version Bibliotheque -v1,0
 * @date  21 août 2020 - 14:11:15
 * @author Claude LUSSEAU
 *
 */
@RestController
@RequestMapping("/rest/api/v1")
@Api(value = "Bibliotheque Rest Controller: contient toutes les operations pour la gestion des bibliotheques")
public class BibliothequeController {

	@Autowired
	BibliothequeServiceImpl bibliothequeService;
	
	/**
	 * Methode en charge d'ajouter une nouvelle Bibliotheque dans la base de données.
	 * 
	 * @param Bibliotheque
	 * @return
	 */
	@PostMapping("/addBibliotheque")
	@ApiOperation(value = "Ajouter un.e nouvel.le Bibliotheque.trice", response = Bibliotheque.class)
	@ApiResponses(value = { @ApiResponse(code = 409, message = "Erreur : la Bibliotheque existe déjà"),
			@ApiResponse(code = 201, message = "Création : l'Bibliotheque a été correctement créée"),
			@ApiResponse(code = 304, message = "Non modifiée : l'Bibliotheque n'a pas été créée") })
	public ResponseEntity<Bibliotheque> createNewBibliotheque(@RequestBody Bibliotheque bibliotheques) {
		Bibliotheque existingBibliotheque = bibliothequeService.findByNom(bibliotheques.getNom());
		if (existingBibliotheque != null) {
			return new ResponseEntity<Bibliotheque>(HttpStatus.CONFLICT);
		}
		Bibliotheque bibliothequeResponse = bibliothequeService.saveBibliotheque(bibliotheques);
		if (bibliothequeResponse != null) {

			return new ResponseEntity<Bibliotheque>(bibliothequeResponse, HttpStatus.CREATED);
		}
		return new ResponseEntity<Bibliotheque>(HttpStatus.NOT_MODIFIED);
	}

	
	/**
	 * Methode en charge de lister toutes les Bibliotheques de la base de données.
	 * @return
	 */
	@GetMapping("/listBibliotheques")
	@ApiOperation(value="Liste toutes les Bibliotheques", response = Bibliotheque.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Ok: liste réussie"),
			@ApiResponse(code = 204, message = "Pas de donnée: pas de résultat"),
	})
	public ResponseEntity<List<Bibliotheque>> listBibliotheque() {
		List<Bibliotheque> bibliotheques = bibliothequeService.findAllBibliotheque();
		if (!CollectionUtils.isEmpty(bibliotheques)) {
			bibliotheques.removeAll(Collections.singleton(null));
			return new ResponseEntity<List<Bibliotheque>>(bibliotheques, HttpStatus.OK);
		}
		return new ResponseEntity<List<Bibliotheque>>(HttpStatus.NO_CONTENT);
	}
	
	/**
	 * Methode en charge de supprimer une Bibliotheques de la base de données.
	 * 
	 * @param idBibliotheque
	 * @return
	 */
	@DeleteMapping("/deleteBibliotheque/{idBibliotheque}")
	@ApiOperation(value = "Supprimer une Bibliotheque. Si la Bibliotheque n'existe pas, rien ne se passe", response = String.class)
	@ApiResponse(code = 204, message = "Pas de donnée: Bibliotheque correctement supprimée")
	public ResponseEntity<String> deleteBook(@PathVariable Integer idBibliotheque) {
		bibliothequeService.deleteBibliotheque(idBibliotheque);
		return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
	}
	
	
	
	/**
	 * Methode en charge de la mise à jour d'une Bibliotheque.
	 * @param BibliothequeRequest
	 * @return
	 */
	@PutMapping("/updateBibliotheque")
	@ApiOperation(value = "Modifie une Bibliotheque existante", response = Bibliotheque.class)
	@ApiResponses(value = { @ApiResponse(code = 404, message = "Not Found : L'Bibliotheque.trice n'existe pas"),
			@ApiResponse(code = 200, message = "Ok: La Bibliotheque a été mise à jour"),
			@ApiResponse(code = 304, message = "Non modifié: La Bibliotheque N'A PAS ETE MISE A JOUR !") })
	public ResponseEntity<Bibliotheque> updateBibliotheque(@RequestBody Bibliotheque BibliothequeRequest) {
		if (!bibliothequeService.checkIsBibliothequExists(BibliothequeRequest.getIdBibliotheque())) {
			return new ResponseEntity<Bibliotheque>(HttpStatus.NOT_FOUND);
		}
		Bibliotheque Bibliotheque = bibliothequeService.updateBibliotheque(BibliothequeRequest);
		if (Bibliotheque != null) {
			
			return new ResponseEntity<Bibliotheque>(Bibliotheque, HttpStatus.OK);
		}
		return new ResponseEntity<Bibliotheque>(HttpStatus.NOT_MODIFIED);
	}
	
	/**
	 * Methode en charge de d'afficher une Bibliothèques de la base de données.
	 * @return
	 */
	@GetMapping("/bibliotheque/{idBibliotheque}")
	@ApiOperation(value="affiche une Bibliotheques", response = Bibliotheque.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Ok !"),
			@ApiResponse(code = 204, message = "Pas de donnée: pas de résultat"),
	})
	public ResponseEntity<Bibliotheque> findBibliotheque(@PathVariable Integer idBibliotheque) {
		Bibliotheque bibliotheque = bibliothequeService.findOne(idBibliotheque);
		if (bibliotheque != null) {
			return new ResponseEntity<Bibliotheque>(bibliotheque, HttpStatus.OK);
		}
		return new ResponseEntity<Bibliotheque>(HttpStatus.NO_CONTENT);
	}
	
	
}
