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
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.lusseau.bibliotheque.dto.registration.UserUpdate;
import fr.lusseau.bibliotheque.entity.User;
import fr.lusseau.bibliotheque.payload.RestApiResponse;
import fr.lusseau.bibliotheque.payload.UserIdentityAvailability;
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
@Api(value = "User Rest Controller: contains all operations for managing users")
public class UserController {

	@Autowired
	UserService userService;

	@Autowired
	RoleService roleService;

	@Autowired
	PasswordEncoder passwordEncoder;

	/**
	 * Methode en charge de lister toutes les personnes de la base de données.
	 * 
	 * @return
	 */
	@GetMapping("/users")
	@ApiOperation(value = "List all users of the Libraries", response = List.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Ok: liste réussie"),
			@ApiResponse(code = 204, message = "Pas de donnée: pas de résultat"), })
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_EMPLOYE')")
	public ResponseEntity<List<User>> listUsers() {

		List<User> users = userService.findAll();
		if (!CollectionUtils.isEmpty(users)) {
			List<User> listUsers = users.stream().map(user -> {
				return user;
			}).collect(Collectors.toList());

			return new ResponseEntity<List<User>>(listUsers, HttpStatus.OK);
		}
		return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
	}

	/**
	 * Methode en charge de mettre à jour un utilisateur de la base de données.
	 * 
	 * @return
	 */
	@PutMapping("/updateUser/{id}")
	@ApiOperation(value = "Update user", response = List.class)
	@ApiResponses(value = { 
			@ApiResponse(code = 500, message = "Erreur: Pseudonyme ou email déjà existant"),
			@ApiResponse(code = 200, message = "Ok: liste réussie"),
			@ApiResponse(code = 204, message = "Pas de donnée: pas de résultat"), })
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_EMPLOYE') or hasRole('ROLE_USER')")
	public ResponseEntity<?> updateUser(@RequestBody UserUpdate userUpdate, User user, @PathVariable("id") Long id) {

		if (userService.existsByEmail(user.getEmail())) {
			return new ResponseEntity<Object>(new RestApiResponse(false, "Email is already taken!"),
					HttpStatus.CONFLICT);
		}
		if (userService.existsByUsername(user.getUsername())) {
			return new ResponseEntity<Object>(new RestApiResponse(false, "Username is already taken!"),
					HttpStatus.CONFLICT);
		}
		user = userService.findById(id);
		if (user != null) {
			user.setFirstname(userUpdate.getFirstname());
			user.setLastname(userUpdate.getLastname());
			user.setUsername(userUpdate.getUsername());
			user.setEmail(userUpdate.getEmail());
			user.setPassword(userUpdate.getPassword());
			user.setPhone(userUpdate.getPhone());
			user.setAddress(userUpdate.getAddress());
			user.setZip(userUpdate.getZip());
			user.setCity(userUpdate.getCity());
			user.setUpdatedAt(userUpdate.getUpdatedAt());
			user.setRoles(userUpdate.getRoles());
			user.setSurety(userUpdate.getSurety());
			user.setLoans(userUpdate.getLoans());
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			
			User userResponse = userService.updateUser(user);
			if (userResponse != null) {
				return new ResponseEntity<User>(userResponse, HttpStatus.OK);
			}
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
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_EMPLOYE')")
	public ResponseEntity<?> deleteUser(@PathVariable Long id) {
		User user = userService.findById(id);
		if (user != null) {
			userService.deleteUser(id);
			return new ResponseEntity<Object>(new RestApiResponse(true, "User has been successfully deleted !"),
					HttpStatus.OK);
		}
		return new ResponseEntity<Object>(new RestApiResponse(false, "User not found !"), HttpStatus.NOT_FOUND);
	}

	/**
	 * Supprime une Personne dans la base de données. Si la personne n'est pas
	 * retrouvée, on retourne le Statut HTTP NO_CONTENT.
	 * 
	 * @param idUser
	 * @return
	 */
	@GetMapping("/user/{username}")
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_EMPLOYE')")
	public ResponseEntity<?> findUser(@PathVariable String username) {
		if (userService.findByUsername(username) != null) {
			User user = userService.findByUsername(username);
			return new ResponseEntity<User>(user, HttpStatus.OK);
		}
		return new ResponseEntity<Object>(new RestApiResponse(false, "User not found !"), HttpStatus.NOT_FOUND);

	}

	/**
	 * Method in charge of
	 * 
	 * @param username
	 * @return
	 */
	@GetMapping("/user/checkUsernameAvailability")
	public UserIdentityAvailability checkUsernameAvailability(@RequestParam(value = "username") String username) {
		Boolean isAvailable = !userService.existsByUsername(username);
		return new UserIdentityAvailability(isAvailable);
	}

	/**
	 * Method in charge of
	 * 
	 * @param email
	 * @return
	 */
	@GetMapping("/user/checkEmailAvailability")
	public UserIdentityAvailability checkEmailAvailability(@RequestParam(value = "email") String email) {
		Boolean isAvailable = !userService.existsByEmail(email);
		return new UserIdentityAvailability(isAvailable);
	}

}