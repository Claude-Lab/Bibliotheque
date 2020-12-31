/**
 * 
 */
package fr.lusseau.bibliotheque.controller;

import java.util.List;

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

import fr.lusseau.bibliotheque.dto.request.StateRequest;
import fr.lusseau.bibliotheque.entity.State;
import fr.lusseau.bibliotheque.payload.RestApiResponse;
import fr.lusseau.bibliotheque.service.StateService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * Classe en charge de
 * 
 * @Version Bibliotheque -v1,0
 * @date 18 août 2020 - 18:36:01
 * @author Claude LUSSEAU
 *
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/admin/state")
@Api(value = "State Rest Controller: contient toutes les operations pour la gestion des états")
public class StateController {

	@Autowired
	StateService service;

	/**
	 * Methode en charge de d'ajouter un nouvel état dans la base de données.
	 * 
	 * @param state
	 * @return
	 */
	@PostMapping("/addState")
	@ApiOperation(value = "Ajouter un nouvel état", response = State.class)
	@ApiResponses(value = { @ApiResponse(code = 409, message = "Erreur : le livre existe déjà"),
			@ApiResponse(code = 201, message = "Création : l'état a été correctement créé"),
			@ApiResponse(code = 304, message = "Non modifiée : l'état n'a pas été créé") })
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_EMPLOYE')")
	public ResponseEntity<?> createNewState(@RequestBody State state) {

		if (service.existsByLabel(state.getLabel())) {
			return new ResponseEntity<Object>(new RestApiResponse(false, "State with this label is already taken!"), HttpStatus.CONFLICT);
		}
		state = new State(state.getLabel());
		State response = service.save(state);
		if (response == null) {
			return new ResponseEntity<State>(state, HttpStatus.NOT_IMPLEMENTED);
		}
		return new ResponseEntity<Object>(new RestApiResponse(true, "State registered successfully"),
				HttpStatus.CREATED);
	}

	/**
	 * Methode en charge de lister tous les etats de la base de données.
	 * 
	 * @return
	 */
	@GetMapping(value = "/allStates")
	@ApiOperation(value = "List all states of Books", response = RestApiResponse.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Ok: liste réussie"),
							@ApiResponse(code = 204, message = "Pas de donnée: pas de résultat"), })
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_EMPLOYE') or hasRole('ROLE_USER')")
	public ResponseEntity<List<State>> statesList() {

		List<State> states = service.findAll();
		if (!CollectionUtils.isEmpty(states)) {
			return new ResponseEntity<List<State>>(states, HttpStatus.OK);
		}
		return new ResponseEntity<List<State>>(HttpStatus.NO_CONTENT);
	}

	/**
	 * Methode en charge de d'afficher un etat de la base de données.
	 * 
	 * @return
	 */
	@GetMapping("/{id}")
	@ApiOperation(value = "affiche un état", response = State.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Ok !"),
			@ApiResponse(code = 204, message = "Pas de donnée: pas de résultat") })
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_EMPLOYE') or hasRole('ROLE_USER')")
	public ResponseEntity<?> getState(@PathVariable Integer id) {
		if (service.getOne(id) == null) {
			return new ResponseEntity<Object>(new RestApiResponse(false, "State not found !"), HttpStatus.NOT_FOUND);
		}
		State state = service.getOne(id);
		return new ResponseEntity<Object>(state, HttpStatus.OK);

	}

	/**
	 * Methode en charge de supprimer un etat dans la base de données.
	 * 
	 * @param id
	 * @return
	 */
	@DeleteMapping("/delete/{id}")
	@ApiOperation(value = "Supprimer un état. Si l'état n'existe pas, rien ne se passe", response = String.class)
	@ApiResponse(code = 204, message = "Pas de donnée: état correctement supprimé")
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_EMPLOYE')")
	public ResponseEntity<?> deleteState(@PathVariable Integer id) {
		State state = service.getOne(id);
		if (state != null) {
			service.delete(id);
			return new ResponseEntity<Object>(new RestApiResponse(true, "State has been successfully deleted !"),
					HttpStatus.OK);
		}
		return new ResponseEntity<Object>(new RestApiResponse(false, "State not found !"), HttpStatus.NOT_FOUND);
	}

	/**
	 * Methode en charge de la mise à jour d'un état.
	 * 
	 * @param state
	 * @return
	 */
	@PutMapping("/update/{id}")
	@ApiOperation(value = "Modifie un état existant", response = State.class)
	@ApiResponses(value = { @ApiResponse(code = 404, message = "Not Found : L'état n'existe pas"),
			@ApiResponse(code = 200, message = "Ok: L'état a été mis à jour"),
			@ApiResponse(code = 304, message = "Non modifié: L'état N'A PAS ETE MIS A JOUR !") })
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_EMPLOYE')")
	public ResponseEntity<?> updateState(@RequestBody StateRequest update, State state,
			@PathVariable("id") Integer id) {
		state = service.getOne(id);

		if (service.existsByLabel(update.getLabel())) {
			return new ResponseEntity<Object>(new RestApiResponse(false, "State with this label is already taken!"),
					HttpStatus.CONFLICT);
		}

		if (state != null) {
			state.setLabel(update.getLabel());

			State response = service.save(state);
			if (response != null) {
				return new ResponseEntity<State>(response, HttpStatus.OK);
			}
		}
		return new ResponseEntity<State>(HttpStatus.NOT_MODIFIED);
	}

}
