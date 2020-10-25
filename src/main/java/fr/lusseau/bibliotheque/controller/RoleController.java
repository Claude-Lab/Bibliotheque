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

import fr.lusseau.bibliotheque.dto.RoleRequestDTO;
import fr.lusseau.bibliotheque.entity.Role;
import fr.lusseau.bibliotheque.service.impl.RoleServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * 
 * Classe en charge de la gestion et de la synchronisation des événements à la
 * classe Role.
 * 
 * @Version Bibliotheque -v1,0
 * @date 15 août 2020 - 10:35:22
 * @Role Claude LUSSEAU
 *
 */
@RestController
@RequestMapping("/rest/api/v1/roles")
@Api(value = "Role Rest Controller: contient toutes les operations pour la gestion des auteurs")
public class RoleController {

//	public static final Logger LOGGER = LoggerFactory.getLogger(AuteurController.class);

	@Autowired
	private RoleServiceImpl roleService;

	/**
	 * Methode en charge d'ajouter un.e nouvel.le auteur.trice dans la base de
	 * données.
	 * 
	 * @param auteur
	 * @return
	 */
	@PostMapping("/addRole")
	@ApiOperation(value = "Ajouter un nouveau role", response = RoleRequestDTO.class)
	@ApiResponses(value = { @ApiResponse(code = 409, message = "Erreur : le role existe déjà"),
			@ApiResponse(code = 201, message = "Création : le role a été correctement créé"),
			@ApiResponse(code = 304, message = "Non modifiée : le role n'a pas été créé") })
	public ResponseEntity<RoleRequestDTO> createNewRole(@RequestBody RoleRequestDTO roleDTORequest) {
		Role existingRole = roleService.findByLabel(roleDTORequest.getLabel());
		if (existingRole != null) {
			return new ResponseEntity<RoleRequestDTO>(HttpStatus.CONFLICT);
		}
		Role roleRequest = mapRoleDTOToRole(roleDTORequest);
		Role roleResponse = roleService.saveRole(roleRequest);
		if (roleResponse != null) {
			RoleRequestDTO roleDTO = mapRoleToRoleDTO(roleResponse);
			return new ResponseEntity<RoleRequestDTO>(roleDTO, HttpStatus.CREATED);
		}
		return new ResponseEntity<RoleRequestDTO>(HttpStatus.NOT_MODIFIED);
	}

	/**
	 * Methode en charge de lister tout.e.s les auteur.trice.s de la base de
	 * données.
	 * 
	 * @return
	 */
	@GetMapping("")
	@ApiOperation(value = "Liste tout.e.s les auteur.trice.s", response = RoleRequestDTO.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Ok: liste réussie"),
			@ApiResponse(code = 204, message = "Pas de donnée: pas de résultat") })
	public ResponseEntity<List<RoleRequestDTO>> RolesList() {

		List<Role> roles = roleService.findAll();
		if (roles != null && !CollectionUtils.isEmpty(roles)) {
			List<RoleRequestDTO> roleDTOs = roles.stream().map(role -> {
				return mapRoleToRoleDTO(role);
			}).collect(Collectors.toList());

			return new ResponseEntity<List<RoleRequestDTO>>(roleDTOs, HttpStatus.OK);
		}
		return new ResponseEntity<List<RoleRequestDTO>>(HttpStatus.NO_CONTENT);
	}

	/**
	 * Methode en charge de supprimer un.e auteur.trice.s de la base de données.
	 * 
	 * @param idRole
	 * @return
	 */
	@DeleteMapping("/deleteRole/{idRole}")
	@ApiOperation(value = "Supprimer un.e auteur.trice. Si l'auteur.trice n'existe pas, rien ne se passe", response = String.class)
	@ApiResponse(code = 204, message = "Pas de donnée: auteur.trice correctement supprimée")
	public ResponseEntity<String> deleteRole(@PathVariable Integer idRole) {
		roleService.deleteRole(idRole);
		return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
	}

	/**
	 * Methode en charge de la mise à jour d'un.e auteur.trice.
	 * 
	 * @param auteurRequest
	 * @return
	 */
	@PutMapping("/updateRole")
	@ApiOperation(value = "Modifie un.e auteur.trice existant.e", response = Role.class)
	@ApiResponses(value = { @ApiResponse(code = 404, message = "Not Found : L'auteur.trice n'existe pas"),
			@ApiResponse(code = 200, message = "Ok: L'auteur.trice a été mis à jour"),
			@ApiResponse(code = 304, message = "Non modifié: L'auteur.trice N'A PAS ETE MIS A JOUR !") })
	public ResponseEntity<Role> updateAuteur(@RequestBody Role roleRequest) {
		if (!roleService.checkIfIdExists(roleRequest.getIdRole())) {
			return new ResponseEntity<Role>(HttpStatus.NOT_FOUND);
		}
		Role role = roleService.updateRole(roleRequest);
		if (role != null) {

			return new ResponseEntity<Role>(role, HttpStatus.OK);
		}
		return new ResponseEntity<Role>(HttpStatus.NOT_MODIFIED);
	}

	/**
	 * Transforme un entity Customer en un POJO CustomerDTO
	 * 
	 * @param customer
	 * @return
	 */
	private RoleRequestDTO mapRoleToRoleDTO(Role role) {
		ModelMapper mapper = new ModelMapper();
		RoleRequestDTO roleDTO = mapper.map(role, RoleRequestDTO.class);
		return roleDTO;
	}

	/**
	 * Transforme un POJO CustomerDTO en en entity Customer
	 * 
	 * @param customerDTO
	 * @return
	 */
	private Role mapRoleDTOToRole(RoleRequestDTO roleDTO) {
		ModelMapper mapper = new ModelMapper();
		Role role = mapper.map(roleDTO, Role.class);
		return role;
	}

}
