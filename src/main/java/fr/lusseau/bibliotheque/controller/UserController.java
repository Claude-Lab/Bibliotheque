/**
 * 
 */
package fr.lusseau.bibliotheque.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.lusseau.bibliotheque.dto.registration.UserUpdate;
import fr.lusseau.bibliotheque.dto.request.UserRequestDTO;
import fr.lusseau.bibliotheque.entity.User;
import fr.lusseau.bibliotheque.service.RoleService;
import fr.lusseau.bibliotheque.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * Classe en charge de la gestion et de la synchronisation des événements liés à
 * la classe User.
 * 
 * @Version Bibliotheque -v1,0
 * @date 14 août 2020 - 14:50:43
 * @author Claude LUSSEAU
 *
 */
@CrossOrigin("*")
@RestController
@RequestMapping("/admin")
@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_EMPLOYE')")
@Api(value = "User Rest Controller: contains all operations for managing users")
public class UserController {

	@Autowired
	UserService userService;

	@Autowired
	RoleService roleService;

	/**
	 * Methode en charge de lister toutes les personnes de la base de données.
	 * 
	 * @return
	 */
	@GetMapping("/users")
	@ApiOperation(value = "List all users of the Libraries", response = List.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Ok: liste réussie"),
			@ApiResponse(code = 204, message = "Pas de donnée: pas de résultat"), })
	public ResponseEntity<List<UserRequestDTO>> listUsers() {

		List<User> users = userService.findAll();
		if (!CollectionUtils.isEmpty(users)) {
			List<UserRequestDTO> userDTOs = users.stream().map(user -> {
				return convertToDto(user);
			}).collect(Collectors.toList());

			return new ResponseEntity<List<UserRequestDTO>>(userDTOs, HttpStatus.OK);
		}
		return new ResponseEntity<List<UserRequestDTO>>(HttpStatus.NO_CONTENT);
	}
	
	/**
	 * Methode en charge de mettre à jour un utilisateur de la base de données.
	 * 
	 * @return
	 */
	@PutMapping("/updateUser")
	@ApiOperation(value = "Update user", response = List.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Ok: liste réussie"),
			@ApiResponse(code = 204, message = "Pas de donnée: pas de résultat"), })
	public ResponseEntity<User> updateUser(@RequestBody User userUpdate) {
        //, UriComponentsBuilder uriComponentBuilder
        if (!userService.existsById(userUpdate.getId())) {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        User userResponse = userService.saveUser(userUpdate);
        if (userResponse != null) {
            return new ResponseEntity<User>(userResponse, HttpStatus.OK);
        }
        return new ResponseEntity<User>(HttpStatus.NOT_MODIFIED);
    }

	/**
	 * Supprime une Personne dans la base de données. Si la personne n'est pas
	 * retrouvée, on retourne le Statut HTTP NO_CONTENT.
	 * 
	 * @param idUser
	 * @return
	 */
	@DeleteMapping("/deleteUser/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable Long id) {
		userService.deleteUser(id);
		return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
	}
	
	/**
	 * Supprime une Personne dans la base de données. Si la personne n'est pas
	 * retrouvée, on retourne le Statut HTTP NO_CONTENT.
	 * 
	 * @param idUser
	 * @return
	 */
	@GetMapping("/user/{id}")
	public ResponseEntity<User> findUser(@PathVariable Long id) {
		User user = userService.findById(id);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	

	/**
	 * Transforme un entity User en un POJO UserDTO.
	 * 
	 * @param User
	 * @return
	 */
	protected UserRequestDTO convertToDto(User user) {
		UserRequestDTO dto = new UserRequestDTO(user.getId(), user.getFirstname(), user.getLastname(),
				user.getUsername(), user.getEmail(), user.getPassword(), user.getPhone(), user.getAddress(),
				user.getZip(), user.getCity(), user.getCreatedAt(), user.getUpdatedAt(), user.getRoles(),
				user.getSurety(), user.getLoans());

		return dto;
	}
	
	/**
	 * Transforme un entity User en un POJO UserDTO.
	 * 
	 * @param User
	 * @return
	 */
	protected UserUpdate convertToDto2(User user) {
		UserUpdate dto = new UserUpdate(user.getId(), user.getFirstname(), user.getLastname(),
				user.getUsername(), user.getEmail(), user.getPassword(), user.getPhone(), user.getAddress(),
				user.getZip(), user.getCity(), user.getCreatedAt(), user.getUpdatedAt(), user.getRoles(),
				user.getSurety(), user.getLoans());

		return dto;
	}

	/**
	 * Transforme un POJO UserDTO en en entity User.
	 * 
	 * @param UserRegistration
	 * @return
	 */
	protected User convertToEntity(UserRequestDTO dto) {
		User user = new User(dto.getFirstname(), dto.getLastname(), dto.getUsername(), dto.getEmail(),
				dto.getPassword(), dto.getPhone(), dto.getAddress(), dto.getZip(), dto.getCity(), dto.getCreatedAt(),
				dto.getUpdatedAt(), dto.getSurety(), dto.getLoans(), dto.getRoles());
		if (!StringUtils.isEmpty(dto.getId())) {
			user.setId(dto.getId());
		}
		return user;
	}
	
	/**
	 * Transforme un POJO UserDTO en en entity User.
	 * 
	 * @param UserRegistration
	 * @return
	 */
	protected User convertToEntity2(UserUpdate dto) {
		User user = new User(dto.getFirstname(), dto.getLastname(), dto.getUsername(), dto.getEmail(),
				dto.getPassword(), dto.getPhone(), dto.getAddress(), dto.getZip(), dto.getCity(), dto.getCreatedAt(),
				dto.getUpdatedAt(), dto.getSurety(), dto.getLoans(), dto.getRoles());
		if (!StringUtils.isEmpty(dto.getId())) {
			user.setId(dto.getId());
		}
		return user;
	}

}