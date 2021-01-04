/**
 * 
 */
package fr.lusseau.bibliotheque.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fr.lusseau.bibliotheque.dto.registration.BookRegister;
import fr.lusseau.bibliotheque.dto.request.BookRequest;
import fr.lusseau.bibliotheque.entity.Book;
import fr.lusseau.bibliotheque.payload.RestApiResponse;
import fr.lusseau.bibliotheque.service.BookService;
import fr.lusseau.bibliotheque.utils.BookMapper;
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

	BookMapper mapper;
	

	/**
	 * Methode en charge de d'ajouter un nouveau livre dans la base de données.
	 * 
	 * @param newBook
	 * @return
	 */
	@PostMapping("/addBook")
	@ApiOperation(value = "Ajouter un nouveau livre", response = BookRegister.class)
	@ApiResponses(value = { @ApiResponse(code = 409, message = "Erreur : le livre existe déjà"),
			@ApiResponse(code = 201, message = "Création : le livre a été correctement créé"),
			@ApiResponse(code = 304, message = "Non modifiée : le livre n'a pas été créé") })
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_EMPLOYE')")
	public ResponseEntity<?> createNewBook(@Valid @RequestBody BookRegister newBook) {

		if (service.existsByIsbn(newBook.getIsbn())) {
			return new ResponseEntity<Object>(new RestApiResponse(false, "ISBN is already taken!"),
					HttpStatus.CONFLICT);
		}

		// create book.
		BookRegister bookDto = new BookRegister(newBook.getTitle(), newBook.getIsbn(), newBook.getReleaseDate(), newBook.getRegisterDate(),
				newBook.getNbOfCopies(), newBook.getDescription(), newBook.getEditor(), newBook.getState(),
				newBook.getLibrary(), newBook.getCategories(), newBook.getAuthors());

		Book book = mapper.BookDtoRegistrationToEntity(bookDto);
		Book bookResponse = service.save(book);
		if (bookResponse != null) {
			return new ResponseEntity<Object>(new RestApiResponse(true, "Book registered successfully"),
					HttpStatus.CREATED);
		}
		return new ResponseEntity<Object>(new RestApiResponse(false, "Book not registered"),
				HttpStatus.NOT_IMPLEMENTED);
	}

	/**
	 * Methode en charge de lister toutes les catégories de la base de données.
	 * 
	 * @return
	 */
	@GetMapping(value = "/allBooks", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "List all books of the Libraries", response = BookRequest.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Ok: liste réussie"),
			@ApiResponse(code = 204, message = "Pas de donnée: pas de résultat"), })
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_EMPLOYE') or hasRole('ROLE_USER')")
	public ResponseEntity<List<BookRequest>> booksList() {

		List<Book> books = service.findAll();
		if (!CollectionUtils.isEmpty(books)) {
			List<BookRequest> bookDTOs = books.stream().map(book -> {
				return mapper.entityToBookDto(book);
			}).collect(Collectors.toList());

			return new ResponseEntity<List<BookRequest>>(bookDTOs, HttpStatus.OK);
		}
		return new ResponseEntity<List<BookRequest>>(HttpStatus.NO_CONTENT);
	}

	/**
	 * Methode en charge de d'afficher un auteur de la base de données.
	 * 
	 * @return
	 */
	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value = "affiche un livre", response = Book.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Ok !", response = Book.class),
			@ApiResponse(code = 204, message = "Pas de donnée: pas de résultat", response = Book.class), })
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_EMPLOYE') or hasRole('ROLE_USER')")
	public ResponseEntity<?> getAuthor(@PathVariable Integer id) {

		if (service.getOne(id) == null) {
			return new ResponseEntity<Object>(new RestApiResponse(false, "Book not found !"), HttpStatus.NOT_FOUND);
		}

		Book book = service.getOne(id);
		return new ResponseEntity<Object>(book, HttpStatus.OK);

	}

	/**
	 * Methode en charge de supprimer une catégorie dans la base de données.
	 * 
	 * @param idCategorie
	 * @return
	 */
	@DeleteMapping("/delete/{id}")
	@ApiOperation(value = "Supprimer un livre. Si le livre n'existe pas, rien ne se passe", response = Book.class)
	@ApiResponse(code = 204, message = "Pas de donnée: livre correctement supprimée")
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_EMPLOYE')")
	public ResponseEntity<?> deleteBook(@PathVariable Integer id) {
		Book book = service.getOne(id);
		if (book != null) {
			service.delete(id);
			return new ResponseEntity<Object>(new RestApiResponse(true, "Book has been successfully deleted !"),
					HttpStatus.OK);
		}
		return new ResponseEntity<Object>(new RestApiResponse(false, "Book not found !"), HttpStatus.NOT_FOUND);
	}

	/**
	 * Methode en charge de la mise à jour d'une catégorie.
	 * 
	 * @param categorieRequest
	 * @return
	 */
	@PutMapping("/update/{id}")
	@ApiOperation(value = "Modifie un livre existant", response = Book.class)
	@ApiResponses(value = { @ApiResponse(code = 404, message = "Not Found : le livre n'existe pas"),
			@ApiResponse(code = 200, message = "Ok: le livre a été mis à jour"),
			@ApiResponse(code = 304, message = "Non modifié: le livre N'A PAS ETE MIS A JOUR !") })
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_EMPLOYE')")
	public ResponseEntity<?> updateBook(@RequestBody BookRequest update, Book book, @PathVariable("id") Integer id) {

		book = service.getOne(id);

		if (service.existsByIsbn(update.getIsbn())) {
			return new ResponseEntity<Object>(new RestApiResponse(false, "Book with this ISBN is already taken!"),
					HttpStatus.CONFLICT);
		}

		if (book != null) {
			book.setTitle(update.getTitle());

			Book response = service.save(book);
			if (response != null) {
				return new ResponseEntity<Book>(response, HttpStatus.CREATED);
			}
		}
		return new ResponseEntity<BookRequest>(HttpStatus.NOT_MODIFIED);

	}

}
