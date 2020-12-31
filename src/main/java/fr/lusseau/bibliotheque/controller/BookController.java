/**
 * 
 */
package fr.lusseau.bibliotheque.controller;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

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

import fr.lusseau.bibliotheque.dto.registration.BookRegister;
import fr.lusseau.bibliotheque.dto.registration.UserRegistration;
import fr.lusseau.bibliotheque.dto.request.BookRequest;
import fr.lusseau.bibliotheque.entity.Book;
import fr.lusseau.bibliotheque.entity.Role;
import fr.lusseau.bibliotheque.entity.RoleName;
import fr.lusseau.bibliotheque.entity.User;
import fr.lusseau.bibliotheque.exceptions.AppException;
import fr.lusseau.bibliotheque.payload.RestApiResponse;
import fr.lusseau.bibliotheque.service.BookService;
import fr.lusseau.bibliotheque.service.impl.BookServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * Classe en charge du controle DAO RESTFULL.
 * 
 * @Version Bibliotheque -v1,0
 * @date 14 août 2020 - 14:50:43
 * @author Claude LUSSEAU
 *
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/admin/book")
@Api(value = "Category Book Controller: Contient toute les opération pour la gestion des livres")
public class BookController {

	@Autowired
	BookService service;

	/**
	 * Methode en charge de d'ajouter une nouvelle catégorie dans la base de
	 * données.
	 * 
	 * @param categorie
	 * @return
	 */
	@PostMapping("/addBook")
	@ApiOperation(value = "Ajouter un nouveau livre", response = BookRegister.class)
	@ApiResponses(value = { @ApiResponse(code = 409, message = "Erreur : le livre existe déjà"),
			@ApiResponse(code = 201, message = "Création : le livre a été correctement créé"),
			@ApiResponse(code = 304, message = "Non modifiée : le livre n'a pas été créé") })
	public ResponseEntity<?> createNewBook(@Valid @RequestBody BookRegister newBook) {
		
		if (service.existsByIsbn(newBook.getIsbn())) {
			return new ResponseEntity<Object>(new RestApiResponse(false, "ISBN is already taken!"),
					HttpStatus.CONFLICT);
		}
		
		// create user.
		Book book = new Book(null, newBook.getTitle(), null, null, null, null, null, null, null, null, null, null, null);

		

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

	/**
	 * Methode en charge de lister toutes les catégories de la base de données.
	 * 
	 * @return
	 */
	@GetMapping("")
	@ApiOperation(value = "List all books of the Libraries", response = List.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Ok: liste réussie"),
			@ApiResponse(code = 204, message = "Pas de donnée: pas de résultat"), })
	public ResponseEntity<List<BookRequest>> BooksList() {

		List<Book> books = service.findAll();
		if (!CollectionUtils.isEmpty(books)) {
			List<BookRequest> bookDTOs = books.stream().map(book -> {
				return mapBookToBookDTO(book);
			}).collect(Collectors.toList());

			return new ResponseEntity<List<BookRequest>>(bookDTOs, HttpStatus.OK);
		}
		return new ResponseEntity<List<BookRequest>>(HttpStatus.NO_CONTENT);
	}

	/**
	 * Methode en charge de supprimer une catégorie dans la base de données.
	 * 
	 * @param idCategorie
	 * @return
	 */
	@DeleteMapping("/deleteBook/{idBook}")
	@ApiOperation(value = "Supprimer une catégorie. Si la categorie n'existe pas, rien ne se passe", response = String.class)
	@ApiResponse(code = 204, message = "Pas de donnée: catégorie correctement supprimée")
	public ResponseEntity<String> deleteBook(@PathVariable Integer idBook) {
		service.deleteBook(idBook);
		return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
	}

	/**
	 * Methode en charge de la mise à jour d'une catégorie.
	 * 
	 * @param categorieRequest
	 * @return
	 */
	@PutMapping("/updatebook")
	@ApiOperation(value = "Modifie une categorie existante", response = BookRequest.class)
	@ApiResponses(value = { @ApiResponse(code = 404, message = "Not Found : L'auteur.trice n'existe pas"),
			@ApiResponse(code = 200, message = "Ok: L'auteur.trice a été mis à jour"),
			@ApiResponse(code = 304, message = "Non modifié: L'auteur.trice N'A PAS ETE MIS A JOUR !") })
	public ResponseEntity<BookRequest> updateBook(@RequestBody BookRequest bookDTORequest) {
		if (!service.checkIfIdExists(bookDTORequest.getIdBook())) {
			return new ResponseEntity<BookRequest>(HttpStatus.NOT_FOUND);
		}

		Book bookRequest = mapBookDTOToBook(bookDTORequest);
		Book bookResponse = service.updateBook(bookRequest);
		if (bookResponse != null) {
			BookRequest bookDTO = mapBookToBookDTO(bookRequest);
			return new ResponseEntity<BookRequest>(bookDTO, HttpStatus.CREATED);
		}
		return new ResponseEntity<BookRequest>(HttpStatus.NOT_MODIFIED);
	}

	/**
	 * Transforme un entity Customer en un POJO CustomerDTO
	 * 
	 * @param customer
	 * @return
	 */
	private BookRequest mapBookToBookDTO(Book book) {
		ModelMapper mapper = new ModelMapper();
		BookRequest bookDTO = mapper.map(book, BookRequest.class);
		return bookDTO;
	}

	/**
	 * Transforme un POJO CustomerDTO en en entity Customer
	 * 
	 * @param customerDTO
	 * @return
	 */
	private Book mapBookDTOToBook(BookRequest bookDTO) {
		ModelMapper mapper = new ModelMapper();
		Book book = mapper.map(bookDTO, Book.class);
		return book;
	}

	/**
	 * Transforme un entity Customer en un POJO CustomerDTO
	 * 
	 * @param customer
	 * @return
	 */
	private BookRegister mapBookToBookDTOReg(Book book) {
		ModelMapper mapper = new ModelMapper();
		BookRegister bookDTO = mapper.map(book, BookRegister.class);
		return bookDTO;
	}

	/**
	 * Transforme un POJO CustomerDTO en en entity Customer
	 * 
	 * @param customerDTO
	 * @return
	 */
	private Book mapBookDTOToBookReg(BookRegister bookDTO) {
		ModelMapper mapper = new ModelMapper();
		Book book = mapper.map(bookDTO, Book.class);
		return book;
	}

}
