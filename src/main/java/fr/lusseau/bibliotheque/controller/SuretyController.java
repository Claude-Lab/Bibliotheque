/**
 * 
 */
package fr.lusseau.bibliotheque.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.lusseau.bibliotheque.dto.update.SuretyUpdate;
import fr.lusseau.bibliotheque.entity.Surety;
import fr.lusseau.bibliotheque.payload.RestApiResponse;
import fr.lusseau.bibliotheque.service.SuretyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * Classe en charge de la gestion et de la synchronisation des événements liés à la classe Caution.
 * @Version Bibliotheque -v1,0
 * @date  15 août 2020 - 10:35:13
 * @author Claude LUSSEAU
 *
 */
@CrossOrigin("*")
@RestController
@RequestMapping("/admin/surety")
@Api(value = "Surety REST Controller: contient toutes les operations pour la gestion des cautions")
public class SuretyController {
	
	@Autowired
	SuretyService service;
	
	/**
	 * Methode en charge de d'ajouter une nouvelle caution dans la base de données.
	 * @param suretyDTORequest
	 * @return
	 */
	@PostMapping("/addSurety")
	@ApiOperation(value = "Ajouter une nouvelle caution", response = Surety.class)
	@ApiResponses(value = { @ApiResponse(code = 409, message = "Erreur : la caution existe déjà"),
			@ApiResponse(code = 201, message = "Création : la caution a été correctement créée"),
			@ApiResponse(code = 304, message = "Non modifiée : la caution n'a pas été créée") })
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<?> createNewSurety(@RequestBody Surety surety) {
		
		if (service.existsByNbBooks(surety.getNbBooks())) {
			return new ResponseEntity<Object>(new RestApiResponse(false, "Surety whith this number of books is already taken!"),
					HttpStatus.CONFLICT);
		}
		if (service.existsByValue(surety.getValue())) {
			return new ResponseEntity<Object>(new RestApiResponse(false, "Surety whith this value is already taken!"),
					HttpStatus.CONFLICT);
		}
		
		surety = new Surety(surety.getValue(), surety.getNbBooks());
		Surety suretyResponse = service.save(surety);
		if (suretyResponse == null) {
			
			return new ResponseEntity<Surety>(surety, HttpStatus.NOT_IMPLEMENTED);
		}
		
		return new ResponseEntity<Object>(new RestApiResponse(true, "Surety registered successfully"),
				HttpStatus.CREATED);
		
	}

	
	/**
	 * Methode en charge de lister toutes les cautions de la base de données.
	 * @return
	 */
	@GetMapping("/allSureties")
	@ApiOperation(value="List all sureties of Libraries", response = List.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Ok: liste réussie"),
			@ApiResponse(code = 204, message = "Pas de donnée: pas de résultat") })
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_EMPLOYE') or hasRole('ROLE_USER')")
	public ResponseEntity<List<Surety>> SuretysList() {
		
		List<Surety> sureties = service.findAll();
		if (!CollectionUtils.isEmpty(sureties)) {
			return new ResponseEntity<List<Surety>>(sureties, HttpStatus.OK);
		}
		return new ResponseEntity<List<Surety>>(HttpStatus.NO_CONTENT);
	}
	
	/**
	 * Methode en charge de supprimer une Caution dans la base de données.
	 * 
	 * @param idSurety
	 * @return
	 */
	@DeleteMapping("/delete/{id}")
	@ApiOperation(value = "Supprimer une caution. Si la caution n'existe pas, rien ne se passe", response = Surety.class)
	@ApiResponse(code = 204, message = "Pas de donnée: état correctement supprimé")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<?> deleteSurety(@PathVariable Integer id) {
		Surety surety = service.getOne(id);
		if (surety != null) {
			service.deleteSurety(id);
			return new ResponseEntity<Object>(new RestApiResponse(true, "Surety has been successfully deleted !"),
					HttpStatus.OK);
		}
		return new ResponseEntity<Object>(new RestApiResponse(false, "Surety not found !"), HttpStatus.NOT_FOUND);
	}
	
	/**
	 * Methode en charge de la mise à jour d'une caution.
	 * @param suretyDTORequest
	 * @return
	 */
	@PutMapping("/update/{id}")
	@ApiOperation(value = "Modifie une caution existant", response = Surety.class)
	@ApiResponses(value = { @ApiResponse(code = 404, message = "Not Found : La caution n'existe pas"),
			@ApiResponse(code = 200, message = "Ok: La caution a été mis à jour"),
			@ApiResponse(code = 304, message = "Non modifié: La caution N'A PAS ETE MIS A JOUR !") })
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<?> updateSurety(@Valid @RequestBody SuretyUpdate update, Surety surety, @PathVariable("id") Integer id) {
		
		surety = service.getOne(id);
		
		if (service.existsByValue(update.getValue())) {
			return new ResponseEntity<Object>(new RestApiResponse(false, "Surety with this value is already taken!"),
					HttpStatus.CONFLICT);
		}
		
		if (service.existsByNbBooks(update.getNbBooks())) {
			return new ResponseEntity<Object>(new RestApiResponse(false, "Surety with this number of books is already taken!"),
					HttpStatus.CONFLICT);
		}
		
		if (surety != null) {
			surety.setValue(update.getValue());
			surety.setNbBooks(update.getNbBooks());
			
			Surety response = service.save(surety);
			if( response != null) {
				return new ResponseEntity<Surety>(response, HttpStatus.OK);
			}
		}
		return new ResponseEntity<Surety>(HttpStatus.NOT_MODIFIED);
		
	}
	
	/**
	 * Trouve une caution dans la base de données. Si la caution n'est pas
	 * retrouvée, on retourne le Statut HTTP NOT_FOUND.
	 * 
	 * @param idUser
	 * @return
	 */
	@GetMapping("/{id}")
	@ApiOperation(value = "affiche une caution", response = Surety.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Ok !"),
			@ApiResponse(code = 204, message = "Pas de donnée: pas de résultat"), })
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_EMPLOYE') or hasRole('ROLE_USER')")
	public ResponseEntity<?> getUser(@PathVariable Integer id) {
		if (service.getOne(id) != null) {
			Surety surety = service.getOne(id);
			return new ResponseEntity<Object>(surety, HttpStatus.OK);
		}
		return new ResponseEntity<Object>(new RestApiResponse(false, "Surety not found !"), HttpStatus.NOT_FOUND);

	}
	

}
