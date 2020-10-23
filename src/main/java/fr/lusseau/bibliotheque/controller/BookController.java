/**
 * 
 */
package fr.lusseau.bibliotheque.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.lusseau.bibliotheque.dao.AuthorDAO;
import fr.lusseau.bibliotheque.dao.BookDAO;
import fr.lusseau.bibliotheque.dao.CategoryDAO;
import fr.lusseau.bibliotheque.dao.EditorDAO;
import fr.lusseau.bibliotheque.dao.LibraryDAO;
import fr.lusseau.bibliotheque.dao.StateDAO;
import fr.lusseau.bibliotheque.entity.Author;
import fr.lusseau.bibliotheque.entity.Book;
import fr.lusseau.bibliotheque.entity.Category;
import fr.lusseau.bibliotheque.entity.Editor;
import fr.lusseau.bibliotheque.entity.Library;
import fr.lusseau.bibliotheque.entity.State;
import fr.lusseau.bibliotheque.exception.ResourceNotFoundException;
import io.swagger.annotations.ApiOperation;

/**
 * Classe en charge du controle DAO RESTFULL.
 * 
 * @Version Bibliotheque -v1,0
 * @date 14 août 2020 - 14:50:43
 * @author Claude LUSSEAU
 *
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class BookController {

	@Autowired
	private BookDAO bookDAO;
	@Autowired
	private AuthorDAO authorDAO;
	@Autowired
	private EditorDAO editorDAO;
	@Autowired
	private LibraryDAO libraryDAO;
	@Autowired
	private CategoryDAO categoryDAO;
	@Autowired
	private StateDAO stateDAO;

	@PostConstruct
	private void init() {
	}

	// get all books
	@ApiOperation(value = "Récupère la liste des livres")
	@GetMapping(value = "books")
	public List<Book> booksList() {
		return bookDAO.findAll();
	}

	// get a book by id rest api
	@ApiOperation(value = "Récupère un livre selon son ID")
	@GetMapping(value = "books/{idBook}")
	public ResponseEntity<Book> getBookById(@PathVariable int idBook) {
		Book book = bookDAO.findById(idBook)
				.orElseThrow(() -> new ResourceNotFoundException("Le livre avec l'id " + idBook + " n'existe pas."));
		return ResponseEntity.ok(book);
	}

	// create book rest api
	@PostMapping("books")
	public void createLivre(@RequestBody Book book, List<Library> librariesList, List<State> statesList,
			List<Editor> editorsList, List<Author> AutorsList, List<Category> categoriesList) {
		book = new Book();
		librariesList = libraryDAO.findAll();
		statesList = stateDAO.findAll();
		editorsList = editorDAO.findAll();
		AutorsList = authorDAO.findAll();
		categoriesList = categoryDAO.findAll();
		bookDAO.save(book);
	}

}
