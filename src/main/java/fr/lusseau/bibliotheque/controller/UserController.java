/**
 * 
 */
package fr.lusseau.bibliotheque.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fr.lusseau.bibliotheque.configuration.security.JwtTokenProvider;
import fr.lusseau.bibliotheque.dto.registration.UserRegistration;
import fr.lusseau.bibliotheque.entity.User;
import fr.lusseau.bibliotheque.payload.JwtAuthenticationResponse;
import fr.lusseau.bibliotheque.payload.LoginRequest;
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
@Api(value = "User Rest Controller: contains all operations for managing persons")
public class UserController {

	@Autowired
	UserService userService;
	
	@Autowired
	RoleService roleService;
	
	@Autowired
    AuthenticationManager authenticationManager;
	
	@Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtTokenProvider tokenProvider;

	
    /**
     * Method in charge of login user.
     * @param loginRequest
     * @return
     */
    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsernameOrEmail(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = tokenProvider.generateToken(authentication);
        return ResponseEntity.ok(new JwtAuthenticationResponse(jwt));
    }

	/**
	 * Ajoute une nouvelle personne dans la base de données. Si la personne existe
	 * déjà, on retourne un code indiquant que la création n'a pas abouti.
	 * 
	 * @param UserRegistration
	 * @return
	 */
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value = "Ajouter une nouvelle personne à la Bibliotheque", response = UserRegistration.class)
	@ApiResponses(value = { @ApiResponse(code = 409, message = "Erreur: la personne existe déjà en base"),
        @ApiResponse(code = 201, message = "Création: le compte de la personne à été correctement enregistrée en base"),
        @ApiResponse(code = 304, message = "Nom modifié: la personne n'a pas été correctement insérée") })
	@PostMapping("/signup")
	public ResponseEntity<UserRegistration> create(@RequestBody UserRegistration newUser, String email, String username) {
		User existingEmail = userService.findByEmail(email);
		User existingUsername = userService.findByUsername(username);
		if ((existingEmail != null) || (existingUsername != null)) {
			return new ResponseEntity<UserRegistration>(HttpStatus.CONFLICT);
		}
		User userRequest = convertToEntity(newUser);
		User userResponse = userService.saveUser(userRequest);
		if (userResponse != null) {
			UserRegistration userDTO = convertToDto(userRequest);
			return new ResponseEntity<UserRegistration>(userDTO, HttpStatus.CREATED);
		}
		return new ResponseEntity<UserRegistration>(HttpStatus.NOT_MODIFIED);
	}

	/**
	 * Methode en charge de lister toutes les personnes de la base de données.
	 * 
	 * @return
	 */
	@GetMapping("users")
	@Secured("ROLE_ADMIN")
	@ApiOperation(value = "List all users of the Libraries", response = List.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Ok: liste réussie"),
			@ApiResponse(code = 204, message = "Pas de donnée: pas de résultat"), })

	/**
	 * Supprime une Personne dans la base de données. Si la personne n'est pas
	 * retrouvée, on retourne le Statut HTTP NO_CONTENT.
	 * 
	 * @param idUser
	 * @return
	 */
	@DeleteMapping("/deleteUser/{idUser}")
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_EMPLOYE')")
	public ResponseEntity<String> deletePersonne(@PathVariable Long idUser) {
		userService.deleteUser(idUser);
		return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
	}

	/**
	 * Transforme un entity User en un POJO UserDTO.
	 * 
	 * @param User
	 * @return
	 */
	protected UserRegistration convertToDto(User user) {
		UserRegistration dto = new UserRegistration(user.getId(), user.getFirstname(), user.getLastname(),
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
	protected User convertToEntity(UserRegistration dto) {
		User user = new User(dto.getFirstname(), dto.getLastname(), dto.getUsername(), dto.getEmail(),
				dto.getPassword(), dto.getPhone(), dto.getAddress(), dto.getZip(), dto.getCity(), dto.getCreatedAt(),
				dto.getUpdatedAt(), dto.getSurety(), dto.getLoans(), dto.getRoles());
		if (!StringUtils.isEmpty(dto.getId())) {
			user.setId(dto.getId());
		}
		return user;
	}

}