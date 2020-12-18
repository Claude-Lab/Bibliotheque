///**
// * 
// */
//package fr.lusseau.bibliotheque.controller;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//import org.modelmapper.ModelMapper;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.annotation.Secured;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.util.CollectionUtils;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RestController;
//
//import fr.lusseau.bibliotheque.configuration.security.CurrentUser;
//import fr.lusseau.bibliotheque.configuration.security.UserPrincipal;
//import fr.lusseau.bibliotheque.dto.request.UserRequestDTO;
//import fr.lusseau.bibliotheque.entity.User;
//import fr.lusseau.bibliotheque.service.UserService;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import io.swagger.annotations.ApiResponse;
//import io.swagger.annotations.ApiResponses;
//
///**
// * Classe en charge de la gestion et de la synchronisation des événements liés à
// * la classe User.
// * 
// * @Version Bibliotheque -v1,0
// * @date 14 août 2020 - 14:50:43
// * @author Claude LUSSEAU
// *
// */
//@CrossOrigin("*")
//@RestController
//@Api(value = "User Rest Controller: contains all operations for managing persons")
//public class UserControllerCopy {
//
//	public static final Logger LOGGER = LoggerFactory.getLogger(UserControllerCopy.class);
//
//	@Autowired
//	UserService userService;
//
//	/**
//	 * Methode en charge de lister toutes les personnes de la base de données.
//	 * @return
//	 */
//	@GetMapping("users")
//	@Secured("ROLE_ADMIN")
//	@ApiOperation(value="List all users of the Libraries", response = List.class)
//	@ApiResponses(value = {
//			@RestApiResponse(code = 200, message = "Ok: liste réussie"),
//			@RestApiResponse(code = 204, message = "Pas de donnée: pas de résultat"),
//	})
//	public ResponseEntity<List<UserRequestDTO>> getAllUsers() {
//		
//		List<User> allUsers = userService.findAll();
//		if (!CollectionUtils.isEmpty(allUsers)) {
//			List<UserRequestDTO> userDTOs = allUsers.stream().map(user -> { 
//				return mapUserToUserDTORequest(user);
//			}).collect(Collectors.toList());
//			
//			return new ResponseEntity<List<UserRequestDTO>>(userDTOs, HttpStatus.OK);
//		}
//		return new ResponseEntity<List<UserRequestDTO>>(HttpStatus.NO_CONTENT);
//	}
//	
//	@GetMapping("/user/me")
//    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_EMPLOYE') or hasRole('ROLE_USER')")
//    public UserRequestDTO getCurrentUser(@CurrentUser UserPrincipal currentUser) {
//    	UserRequestDTO userDTO = new UserRequestDTO(currentUser.getId(), currentUser.getFirstname(),
//    			currentUser.getLastname(), currentUser.getUsername(), currentUser.getEmail(), currentUser.getPassword(), currentUser.getPhone(), currentUser.getAddress(), currentUser.getZip(), currentUser.getCity(),
//    			currentUser.getRoles(), currentUser.getSurety(), currentUser.getLoans());
//        return userDTO;
//    }
//
//	
////	/**
////     * Ajoute une nouvelle personne dans la base de données. Si la personne existe déjà, on retourne un code indiquant que la création n'a pas abouti.
////     * @param personneDTORequest
////     * @return
////     */
////    @PostMapping("/addUser")
////    @ResponseStatus(code = HttpStatus.CREATED)
////    @ApiOperation(value = "Ajouter une nouvelle personne à la Bibliotheque", response = UserRegistrationDTO.class)
////    @ApiResponses(value = { @RestApiResponse(code = 409, message = "Erreur: la personne existe déjà en base"),
////            @RestApiResponse(code = 201, message = "Création: le compte de la personne à été correctement enregistrée en base"),
////            @RestApiResponse(code = 304, message = "Nom modifié: la personne n'a pas été correctement insérée") })
////    public ResponseEntity<UserRequestDTO> createNewUser(@RequestBody UserRequestDTO userRegistration, String email, String username) {
////    	
////    	User existingEmail = userService.findByEmail(email);
////    	User existingUsername = userService.findByUsername(username);
////        if ((existingEmail != null) || (existingUsername != null)) {
////            return new ResponseEntity<UserRequestDTO>(HttpStatus.CONFLICT);
////        }
////        User userRequest = mapUserDTOToUser(userRegistration);
////        User userResponse = userService.saveUser(userRequest);
////        if (userResponse != null) {
////        	UserRequestDTO userDTO = mapUserToUserDTO(userRequest);
////            return new ResponseEntity<UserRequestDTO>(userDTO, HttpStatus.CREATED);
////        }
////        return new ResponseEntity<UserRequestDTO>(HttpStatus.NOT_MODIFIED);
////    }
//    
//    
//    
//    /**
//     * Met à jour les données d'une personne dans la base de données. Si la personne n'est pas retrouvée, on retourne un code indiquant que la mise à jour n'a pas abouti.
//     * @param personneDTORequest
//     * @return
//     */
////    @PutMapping("/updateUser")
////    public ResponseEntity<User> updateUser(@RequestBody User userRequest) {
////        //, UriComponentsBuilder uriComponentBuilder
////        if (!userService.getUserById(userRequest.getId())) {
////            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
////        }
////        User userResponse = userService.updateUser(userRequest);
////        if (userResponse != null) {
////            return new ResponseEntity<User>(userResponse, HttpStatus.OK);
////        }
////        return new ResponseEntity<User>(HttpStatus.NOT_MODIFIED);
////    }
//    
//    
//    
//    /**
//     * Supprime une Personne dans la base de données. Si la personne n'est pas retrouvée, on retourne le Statut HTTP NO_CONTENT.
//     * @param idUser
//     * @return
//     */
//    @DeleteMapping("/deleteUser/{idUser}")
//    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_EMPLOYE')")
//    public ResponseEntity<String> deletePersonne(@PathVariable Long idUser) {
//    	userService.deleteUser(idUser);
//        return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
//    }
//    
//
//    /**
//	 * Transforme un entity Customer en un POJO CustomerDTO
//	 * 
//	 * @param customer
//	 * @return
//	 */
//	@SuppressWarnings("unused")
//	private UserRequestDTO mapUserToUserDTO(User user) {
//		ModelMapper mapper = new ModelMapper();
//		UserRequestDTO userDTO = mapper.map(user, UserRequestDTO.class);
//		return userDTO;
//	}
//
//	/**
//	 * Transforme un POJO CustomerDTO en en entity Customer
//	 * 
//	 * @param customerDTO
//	 * @return
//	 */
//	@SuppressWarnings("unused")
//	private User mapUserDTOToUser(UserRequestDTO userDTO) {
//		ModelMapper mapper = new ModelMapper();
//		User user = mapper.map(userDTO, User.class);
//		return user;
//	}
//	
//	/**
//	 * Transforme un entity Customer en un POJO CustomerDTO
//	 * 
//	 * @param customer
//	 * @return
//	 */
//	private UserRequestDTO mapUserToUserDTORequest(User user) {
//		ModelMapper mapper = new ModelMapper();
//		UserRequestDTO userDTO = mapper.map(user, UserRequestDTO.class);
//		return userDTO;
//	}
//
//	/**
//	 * Transforme un POJO CustomerDTO en en entity Customer
//	 * 
//	 * @param customerDTO
//	 * @return
//	 */
//	@SuppressWarnings("unused")
//	private User mapUserDTORequestToUser(UserRequestDTO userDTO) {
//		ModelMapper mapper = new ModelMapper();
//		User user = mapper.map(userDTO, User.class);
//		return user;
//	}
//
//}