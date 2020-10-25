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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.lusseau.bibliotheque.dto.SuretyRequestDTO;
import fr.lusseau.bibliotheque.entity.Surety;
import fr.lusseau.bibliotheque.service.impl.SuretyServiceImpl;
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
@RestController
@RequestMapping("/rest/api/v1/sureties")
@Api(value = "State Surety Controller: contient toutes les operations pour la gestion des cautions")
public class SuretyController {
	
	@Autowired
	SuretyServiceImpl suretyService;
	
	/**
	 * Methode en charge de d'ajouter une nouvelle catégorie dans la base de données.
	 * 
	 * @param categorie
	 * @return
	 */
	@PostMapping("/addSurety")
	@ApiOperation(value = "Ajouter une nouvelle caution", response = SuretyRequestDTO.class)
	@ApiResponses(value = { @ApiResponse(code = 409, message = "Erreur : la caution existe déjà"),
			@ApiResponse(code = 201, message = "Création : la caution a été correctement créée"),
			@ApiResponse(code = 304, message = "Non modifiée : la caution n'a pas été créée") })
	public ResponseEntity<SuretyRequestDTO> createNewSurety(@RequestBody SuretyRequestDTO suretyDTORequest) {
		Surety existingSurety = suretyService.findByNbBooks(suretyDTORequest.getNbBooks());
		if (existingSurety != null) {
			return new ResponseEntity<SuretyRequestDTO>(HttpStatus.CONFLICT);
		}
		Surety suretyRequest = mapSuretyDTOToSurety(suretyDTORequest);
		Surety suretyResponse = suretyService.saveSurety(suretyRequest);
		if (suretyResponse != null) {
			SuretyRequestDTO suretyDTO = mapSuretyToSuretyDTO(suretyRequest);
			return new ResponseEntity<SuretyRequestDTO>(suretyDTO, HttpStatus.CREATED);
		}
		return new ResponseEntity<SuretyRequestDTO>(HttpStatus.NOT_MODIFIED);
	}

	/**
	 * Methode en charge de lister toutes les catégories de la base de données.
	 * @return
	 */
	@GetMapping("")
	@ApiOperation(value="List all sureties of Libraries", response = List.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Ok: liste réussie"),
			@ApiResponse(code = 204, message = "Pas de donnée: pas de résultat"),
	})
	public ResponseEntity<List<SuretyRequestDTO>> SuretysList() {
		
		List<Surety> suretys = suretyService.findAll();
		if (!CollectionUtils.isEmpty(suretys)) {
			List<SuretyRequestDTO> suretyDTOs = suretys.stream().map(surety -> { 
				return mapSuretyToSuretyDTO(surety);
			}).collect(Collectors.toList());
			
			return new ResponseEntity<List<SuretyRequestDTO>>(suretyDTOs, HttpStatus.OK);
		}
		return new ResponseEntity<List<SuretyRequestDTO>>(HttpStatus.NO_CONTENT);
	}
	
	/**
	 * Methode en charge de supprimer une catégorie dans la base de données.
	 * 
	 * @param idCategorie
	 * @return
	 */
	@DeleteMapping("/deleteSurety/{idSurety}")
	@ApiOperation(value = "Supprimer un état. Si l'état n'existe pas, rien ne se passe", response = String.class)
	@ApiResponse(code = 204, message = "Pas de donnée: état correctement supprimé")
	public ResponseEntity<String> deleteSurety(@PathVariable Integer idSurety) {
		suretyService.deleteSurety(idSurety);
		return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
	}
	
	/**
	 * Methode en charge de la mise à jour d'une catégorie.
	 * @param categorieRequest
	 * @return
	 */
	@PutMapping("/updatesurety")
	@ApiOperation(value = "Modifie un état existant", response = SuretyRequestDTO.class)
	@ApiResponses(value = { @ApiResponse(code = 404, message = "Not Found : L'état n'existe pas"),
			@ApiResponse(code = 200, message = "Ok: L'état a été mis à jour"),
			@ApiResponse(code = 304, message = "Non modifié: L'état N'A PAS ETE MIS A JOUR !") })
	public ResponseEntity<SuretyRequestDTO> updateSurety(@RequestBody SuretyRequestDTO suretyDTORequest) {
		if (!suretyService.checkIfSuretyExists(suretyDTORequest.getIdSurety())) {
			return new ResponseEntity<SuretyRequestDTO>(HttpStatus.NOT_FOUND);
		}
		
		Surety suretyRequest = mapSuretyDTOToSurety(suretyDTORequest);
		Surety suretyResponse = suretyService.updateSurety(suretyRequest);
		if (suretyResponse != null) {
			SuretyRequestDTO suretyDTO = mapSuretyToSuretyDTO(suretyRequest);
			return new ResponseEntity<SuretyRequestDTO>(suretyDTO, HttpStatus.CREATED);
		}
		return new ResponseEntity<SuretyRequestDTO>(HttpStatus.NOT_MODIFIED);
	}
	
	/**
	 * Transforme un entity Customer en un POJO CustomerDTO
	 * 
	 * @param customer
	 * @return
	 */
	private SuretyRequestDTO mapSuretyToSuretyDTO(Surety surety) {
		ModelMapper mapper = new ModelMapper();
		SuretyRequestDTO suretyDTO = mapper.map(surety, SuretyRequestDTO.class);
		return suretyDTO;
	}

	/**
	 * Transforme un POJO CustomerDTO en en entity Customer
	 * 
	 * @param customerDTO
	 * @return
	 */
	private Surety mapSuretyDTOToSurety(SuretyRequestDTO suretyDTO) {
		ModelMapper mapper = new ModelMapper();
		Surety surety = mapper.map(suretyDTO, Surety.class);
		return surety;
	}

}
