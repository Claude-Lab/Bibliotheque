/**
 * 
 */
package fr.lusseau.bibliotheque.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

import fr.lusseau.bibliotheque.dto.request.StateRequestDTO;
import fr.lusseau.bibliotheque.entity.State;
import fr.lusseau.bibliotheque.service.impl.StateServiceImpl;
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
@CrossOrigin("*")
@RestController
@RequestMapping("states")
@Api(value = "State Rest Controller: contient toutes les operations pour la gestion des états")
public class StateController {

	@Autowired
	StateServiceImpl stateService;

	/**
	 * Methode en charge de d'ajouter une nouvelle catégorie dans la base de données.
	 * 
	 * @param categorie
	 * @return
	 */
	@PostMapping("/addState")
	@ApiOperation(value = "Ajouter un nouvel état", response = StateRequestDTO.class)
	@ApiResponses(value = { @ApiResponse(code = 409, message = "Erreur : le livre existe déjà"),
			@ApiResponse(code = 201, message = "Création : l'état a été correctement créé"),
			@ApiResponse(code = 304, message = "Non modifiée : l'état n'a pas été créé") })
	public ResponseEntity<StateRequestDTO> createNewState(@RequestBody StateRequestDTO stateDTORequest) {
		State existingCategory = stateService.findStateByLabel(stateDTORequest.getLabel());
		if (existingCategory != null) {
			return new ResponseEntity<StateRequestDTO>(HttpStatus.CONFLICT);
		}
		State stateRequest = mapStateDTOToState(stateDTORequest);
		State stateResponse = stateService.saveState(stateRequest);
		if (stateResponse != null) {
			StateRequestDTO stateDTO = mapStateToStateDTO(stateRequest);
			return new ResponseEntity<StateRequestDTO>(stateDTO, HttpStatus.CREATED);
		}
		return new ResponseEntity<StateRequestDTO>(HttpStatus.NOT_MODIFIED);
	}

	/**
	 * Methode en charge de lister toutes les catégories de la base de données.
	 * @return
	 */
	@GetMapping("")
	@ApiOperation(value="List all states of the Libraries", response = List.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Ok: liste réussie"),
			@ApiResponse(code = 204, message = "Pas de donnée: pas de résultat"),
	})
	public ResponseEntity<List<StateRequestDTO>> StatesList() {
		
		List<State> states = stateService.findAll();
		if (!CollectionUtils.isEmpty(states)) {
			List<StateRequestDTO> stateDTOs = states.stream().map(state -> { 
				return mapStateToStateDTO(state);
			}).collect(Collectors.toList());
			
			return new ResponseEntity<List<StateRequestDTO>>(stateDTOs, HttpStatus.OK);
		}
		return new ResponseEntity<List<StateRequestDTO>>(HttpStatus.NO_CONTENT);
	}
	
	/**
	 * Methode en charge de supprimer une catégorie dans la base de données.
	 * 
	 * @param idCategorie
	 * @return
	 */
	@DeleteMapping("/deleteState/{idState}")
	@ApiOperation(value = "Supprimer un état. Si l'état n'existe pas, rien ne se passe", response = String.class)
	@ApiResponse(code = 204, message = "Pas de donnée: état correctement supprimé")
	public ResponseEntity<String> deleteState(@PathVariable Integer idState) {
		stateService.deleteState(idState);
		return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
	}
	
	/**
	 * Methode en charge de la mise à jour d'une catégorie.
	 * @param categorieRequest
	 * @return
	 */
	@PutMapping("/states/updatestate")
	@ApiOperation(value = "Modifie un état existant", response = StateRequestDTO.class)
	@ApiResponses(value = { @ApiResponse(code = 404, message = "Not Found : L'état n'existe pas"),
			@ApiResponse(code = 200, message = "Ok: L'état a été mis à jour"),
			@ApiResponse(code = 304, message = "Non modifié: L'état N'A PAS ETE MIS A JOUR !") })
	public ResponseEntity<StateRequestDTO> updateState(@RequestBody StateRequestDTO stateDTORequest) {
		if (!stateService.checkIfIdExists(stateDTORequest.getIdState())) {
			return new ResponseEntity<StateRequestDTO>(HttpStatus.NOT_FOUND);
		}
		
		State stateRequest = mapStateDTOToState(stateDTORequest);
		State stateResponse = stateService.updateState(stateRequest);
		if (stateResponse != null) {
			StateRequestDTO stateDTO = mapStateToStateDTO(stateRequest);
			return new ResponseEntity<StateRequestDTO>(stateDTO, HttpStatus.CREATED);
		}
		return new ResponseEntity<StateRequestDTO>(HttpStatus.NOT_MODIFIED);
	}
	
	/**
	 * Transforme un entity Customer en un POJO CustomerDTO
	 * 
	 * @param customer
	 * @return
	 */
	private StateRequestDTO mapStateToStateDTO(State state) {
		ModelMapper mapper = new ModelMapper();
		StateRequestDTO stateDTO = mapper.map(state, StateRequestDTO.class);
		return stateDTO;
	}

	/**
	 * Transforme un POJO CustomerDTO en en entity Customer
	 * 
	 * @param customerDTO
	 * @return
	 */
	private State mapStateDTOToState(StateRequestDTO stateDTO) {
		ModelMapper mapper = new ModelMapper();
		State state = mapper.map(stateDTO, State.class);
		return state;
	}

}
