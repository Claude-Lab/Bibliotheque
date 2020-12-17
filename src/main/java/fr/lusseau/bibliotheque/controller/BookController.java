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

import fr.lusseau.bibliotheque.dto.request.BookRegisterDTO;
import fr.lusseau.bibliotheque.dto.request.BookRequestDTO;
import fr.lusseau.bibliotheque.entity.Book;
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
@CrossOrigin("*")
@RestController
@Api(value = "Category Book Controller: Contient toute les opération pour la gestion des livres")
@RequestMapping("books")
public class BookController {


	@Autowired
	BookServiceImpl bookService;

	/**
	 * Methode en charge de d'ajouter une nouvelle catégorie dans la base de données.
	 * 
	 * @param categorie
	 * @return
	 */
	@PostMapping("/addBook")
	@ApiOperation(value = "Ajouter un nouveau livre", response = BookRegisterDTO.class)
	@ApiResponses(value = { @ApiResponse(code = 409, message = "Erreur : le livre existe déjà"),
			@ApiResponse(code = 201, message = "Création : le livre a été correctement créé"),
			@ApiResponse(code = 304, message = "Non modifiée : le livre n'a pas été créé") })
	public ResponseEntity<BookRegisterDTO> createNewBook(@RequestBody BookRegisterDTO bookDTOReg) {
		Book existingBook = bookService.findByTitle(bookDTOReg.getTitle());
		if (existingBook != null) {
			return new ResponseEntity<BookRegisterDTO>(HttpStatus.CONFLICT);
		}
		Book bookRequest = mapBookDTOToBookReg(bookDTOReg);
		Book bookResponse = bookService.saveBook(bookRequest);
		if (bookResponse != null) {
			BookRegisterDTO bookDTO = mapBookToBookDTOReg(bookRequest);
			return new ResponseEntity<BookRegisterDTO>(bookDTO, HttpStatus.CREATED);
		}
		return new ResponseEntity<BookRegisterDTO>(HttpStatus.NOT_MODIFIED);
	}

	/**
	 * Methode en charge de lister toutes les catégories de la base de données.
	 * @return
	 */
	@GetMapping("")
	@ApiOperation(value="List all books of the Libraries", response = List.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Ok: liste réussie"),
			@ApiResponse(code = 204, message = "Pas de donnée: pas de résultat"),
	})
	public ResponseEntity<List<BookRequestDTO>> BooksList() {
		
		List<Book> books = bookService.findAll();
		if (!CollectionUtils.isEmpty(books)) {
			List<BookRequestDTO> bookDTOs = books.stream().map(book -> { 
				return mapBookToBookDTO(book);
			}).collect(Collectors.toList());
			
			return new ResponseEntity<List<BookRequestDTO>>(bookDTOs, HttpStatus.OK);
		}
		return new ResponseEntity<List<BookRequestDTO>>(HttpStatus.NO_CONTENT);
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
		bookService.deleteBook(idBook);
		return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
	}
	
	/**
	 * Methode en charge de la mise à jour d'une catégorie.
	 * @param categorieRequest
	 * @return
	 */
	@PutMapping("/updatebook")
	@ApiOperation(value = "Modifie une categorie existante", response = BookRequestDTO.class)
	@ApiResponses(value = { @ApiResponse(code = 404, message = "Not Found : L'auteur.trice n'existe pas"),
			@ApiResponse(code = 200, message = "Ok: L'auteur.trice a été mis à jour"),
			@ApiResponse(code = 304, message = "Non modifié: L'auteur.trice N'A PAS ETE MIS A JOUR !") })
	public ResponseEntity<BookRequestDTO> updateBook(@RequestBody BookRequestDTO bookDTORequest) {
		if (!bookService.checkIfIdExists(bookDTORequest.getIdBook())) {
			return new ResponseEntity<BookRequestDTO>(HttpStatus.NOT_FOUND);
		}
		
		Book bookRequest = mapBookDTOToBook(bookDTORequest);
		Book bookResponse = bookService.updateBook(bookRequest);
		if (bookResponse != null) {
			BookRequestDTO bookDTO = mapBookToBookDTO(bookRequest);
			return new ResponseEntity<BookRequestDTO>(bookDTO, HttpStatus.CREATED);
		}
		return new ResponseEntity<BookRequestDTO>(HttpStatus.NOT_MODIFIED);
	}
	
	/**
	 * Transforme un entity Customer en un POJO CustomerDTO
	 * 
	 * @param customer
	 * @return
	 */
	private BookRequestDTO mapBookToBookDTO(Book book) {
		ModelMapper mapper = new ModelMapper();
		BookRequestDTO bookDTO = mapper.map(book, BookRequestDTO.class);
		return bookDTO;
	}

	/**
	 * Transforme un POJO CustomerDTO en en entity Customer
	 * 
	 * @param customerDTO
	 * @return
	 */
	private Book mapBookDTOToBook(BookRequestDTO bookDTO) {
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
	private BookRegisterDTO mapBookToBookDTOReg(Book book) {
		ModelMapper mapper = new ModelMapper();
		BookRegisterDTO bookDTO = mapper.map(book, BookRegisterDTO.class);
		return bookDTO;
	}
	
	/**
	 * Transforme un POJO CustomerDTO en en entity Customer
	 * 
	 * @param customerDTO
	 * @return
	 */
	private Book mapBookDTOToBookReg(BookRegisterDTO bookDTO) {
		ModelMapper mapper = new ModelMapper();
		Book book = mapper.map(bookDTO, Book.class);
		return book;
	}

}
