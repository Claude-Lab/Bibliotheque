/**
 * 
 */
package fr.lusseau.bibliotheque.controller;

import java.util.Collections;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.lusseau.bibliotheque.configuration.security.JwtTokenProvider;
import fr.lusseau.bibliotheque.dto.registration.UserRegistration;
import fr.lusseau.bibliotheque.dto.request.LoginRequest;
import fr.lusseau.bibliotheque.entity.Role;
import fr.lusseau.bibliotheque.entity.RoleName;
import fr.lusseau.bibliotheque.entity.User;
import fr.lusseau.bibliotheque.exceptions.AppException;
import fr.lusseau.bibliotheque.payload.JwtAuthenticationResponse;
import fr.lusseau.bibliotheque.payload.RestApiResponse;
import fr.lusseau.bibliotheque.service.RoleService;
import fr.lusseau.bibliotheque.service.UserService;
import fr.lusseau.bibliotheque.utils.UserMapper;
import fr.lusseau.bibliotheque.utils.impl.UserMapperImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


/**
 * Class in charge of defining .
 * 
 * @Version Bibliotheque -v1,0
 * @date 17 déc. 2020 - 11:38:31
 * @author Claude LUSSEAU
 *
 */
@CrossOrigin("*")
@RestController
@RequestMapping
@Api(value = "Auth Rest Controller: contains operations for signin and signup")
public class AuthController {

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

	UserMapper mapper = new UserMapperImpl();

	/**
	 * Method in charge of login user.
	 * 
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
	@ApiOperation(value = "Register User", response = UserRegistration.class)
	@ApiResponses(value = { @ApiResponse(code = 409, message = "Erreur: Pseudonyme ou email déjà existant"),
			@ApiResponse(code = 201, message = "Création: le compte de la personne à été correctement enregistrée en base"),
			@ApiResponse(code = 304, message = "Non modifié: la personne n'a pas été correctement insérée") })
	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody UserRegistration newUser) {

		if (userService.existsByEmail(newUser.getEmail())) {
			return new ResponseEntity<Object>(new RestApiResponse(false, "Email is already taken!"),
					HttpStatus.CONFLICT);
		}

		if (userService.existsByUsername(newUser.getUsername())) {
			return new ResponseEntity<Object>(new RestApiResponse(false, "Username is already taken!"),
					HttpStatus.CONFLICT);
		}

		// create user.
		User user = new User(newUser.getFirstname(), newUser.getLastname(), newUser.getUsername(), newUser.getEmail(),
				newUser.getPassword(), newUser.getPhone(), newUser.getAddress(), newUser.getZip(), newUser.getCity(),
				newUser.getCreatedAt(), newUser.getUpdatedAt(), newUser.getRoles(), newUser.getSurety(),
				newUser.getLoans());

		user.setPassword(passwordEncoder.encode(newUser.getPassword()));

		Role userRole = roleService.findByName(RoleName.ROLE_USER)
				.orElseThrow(() -> new AppException("User Role not set."));

		user.setRoles(Collections.singleton(userRole));

		User userResponse = userService.saveUser(user);
		if (userResponse != null) {
			UserRegistration userDTO = mapper.entityToUserRegistration(user);
			return new ResponseEntity<UserRegistration>(userDTO, HttpStatus.CREATED);
		}
		return new ResponseEntity<Object>(new RestApiResponse(true, "User registered successfully"),
				HttpStatus.CREATED);
	}
}
