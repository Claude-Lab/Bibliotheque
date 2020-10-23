/**
 * 
 */
package fr.lusseau.bibliotheque.controller;

import java.util.Collections;
import java.util.List;

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

import fr.lusseau.bibliotheque.entity.Author;
import fr.lusseau.bibliotheque.service.impl.AuthorServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * Classe en charge de la gestion des auteurs.
 * 
 * @Version Bibliotheque -v1,0
 * @date 21 août 2020 - 14:11:38
 * @author Claude LUSSEAU
 *
 */
@RestController
@RequestMapping("/rest/api/v1")
@Api(value = "Author Rest Controller: contient toutes les operations pour la gestion des auteurs")
public class AuthorController {

//	public static final Logger LOGGER = LoggerFactory.getLogger(AuteurController.class);

	@Autowired
	private AuthorServiceImpl authorService;

	
	/**
	 * Methode en charge d'ajouter un.e nouvel.le auteur.trice dans la base de données.
	 * 
	 * @param auteur
	 * @return
	 */
	@PostMapping("/author/addAuthor")
	@ApiOperation(value = "Ajouter un.e nouvel.le auteur.trice", response = Author.class)
	@ApiResponses(value = { @ApiResponse(code = 409, message = "Erreur : la auteur.trice existe déjà"),
			@ApiResponse(code = 201, message = "Création : l'auteur.trice a été correctement créée"),
			@ApiResponse(code = 304, message = "Non modifiée : l'auteur.trice n'a pas été créée") })
	public ResponseEntity<Author> createNewAuthor(@RequestBody Author author) {
		Author existingAuthor = authorService.findByFullName(author.getFullName());
		if (existingAuthor != null) {
			return new ResponseEntity<Author>(HttpStatus.CONFLICT);
		}
		Author authorResponse = authorService.saveAuthor(author);
		if (authorResponse != null) {

			return new ResponseEntity<Author>(authorResponse, HttpStatus.CREATED);
		}
		return new ResponseEntity<Author>(HttpStatus.NOT_MODIFIED);
	}

	
	/**
	 * Methode en charge de lister tout.e.s les auteur.trice.s de la base de données.
	 * @return
	 */
	@GetMapping("/author/AuthorsList")
	@ApiOperation(value="Liste tout.e.s les auteur.trice.s", response = Author.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Ok: liste réussie"),
			@ApiResponse(code = 204, message = "Pas de donnée: pas de résultat"),
	})
	public ResponseEntity<List<Author>> AuthorsList() {
		List<Author> authors = authorService.findAllAuthor();
		if (!CollectionUtils.isEmpty(authors)) {
			authors.removeAll(Collections.singleton(null));
			return new ResponseEntity<List<Author>>(authors, HttpStatus.OK);
		}
		return new ResponseEntity<List<Author>>(HttpStatus.NO_CONTENT);
	}
	
	/**
	 * Methode en charge de supprimer un.e auteur.trice.s de la base de données.
	 * 
	 * @param idAuthor
	 * @return
	 */
	@DeleteMapping("/author/deleteAuthor/{idAuthor}")
	@ApiOperation(value = "Supprimer un.e auteur.trice. Si l'auteur.trice n'existe pas, rien ne se passe", response = String.class)
	@ApiResponse(code = 204, message = "Pas de donnée: auteur.trice correctement supprimée")
	public ResponseEntity<String> deleteAuthor(@PathVariable Integer idAuthor) {
		authorService.deleteAuthor(idAuthor);
		return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
	}
	
	
	
	/**
	 * Methode en charge de la mise à jour d'un.e auteur.trice.
	 * @param auteurRequest
	 * @return
	 */
	@PutMapping("/author/updateAuthor")
	@ApiOperation(value = "Modifie un.e auteur.trice existant.e", response = Author.class)
	@ApiResponses(value = { @ApiResponse(code = 404, message = "Not Found : L'auteur.trice n'existe pas"),
			@ApiResponse(code = 200, message = "Ok: L'auteur.trice a été mis à jour"),
			@ApiResponse(code = 304, message = "Non modifié: L'auteur.trice N'A PAS ETE MIS A JOUR !") })
	public ResponseEntity<Author> updateAuteur(@RequestBody Author authorRequest) {
		if (!authorService.checkIfIdexists(authorRequest.getIdAuthor())) {
			return new ResponseEntity<Author>(HttpStatus.NOT_FOUND);
		}
		Author author = authorService.updateAuthor(authorRequest);
		if (author != null) {
			
			return new ResponseEntity<Author>(author, HttpStatus.OK);
		}
		return new ResponseEntity<Author>(HttpStatus.NOT_MODIFIED);
	}



}