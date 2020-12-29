/**
 * 
 */
package fr.lusseau.bibliotheque.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import org.springframework.web.bind.annotation.RestController;

import fr.lusseau.bibliotheque.dto.request.AuthorRequest;
import fr.lusseau.bibliotheque.entity.Author;
import fr.lusseau.bibliotheque.payload.RestApiResponse;
import fr.lusseau.bibliotheque.service.AuthorService;
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
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/admin/author")
@Api(value = "Author Rest Controller: contient toutes les operations pour la gestion des auteurs via REST")
public class AuthorController {

	@Autowired
	AuthorService service;
	
	/**
	 * Methode en charge d'ajouter un.e nouvel.le auteur.trice dans la base de
	 * données.
	 * 
	 * @param auteur
	 * @return
	 */
	@PostMapping("/addAuthor")
	@ApiOperation(value = "Ajouter un.e nouvel.le auteur.trice", response = Author.class)
	@ApiResponses(value = { @ApiResponse(code = 409, message = "Erreur : la auteur.trice existe déjà"),
			@ApiResponse(code = 201, message = "Création : l'auteur.trice a été correctement créée"),
			@ApiResponse(code = 304, message = "Non modifiée : l'auteur.trice n'a pas été créée") })
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_EMPLOYE')")
	public ResponseEntity<?> createNewAuthor(@RequestBody Author author) {
		
		if (service.existsByFullname(author.getFullname())) {
			return new ResponseEntity<Object>(new RestApiResponse(false, "Author with this fullname is already taken!"),
					HttpStatus.CONFLICT);
		}
		author = new Author(author.getFirstname(), author.getLastname(), author.getFullname());
		Author authorResponse = service.save(author);
		if (authorResponse == null) {
			return new ResponseEntity<Author>(author, HttpStatus.NOT_IMPLEMENTED);
		}
		return new ResponseEntity<Object>(new RestApiResponse(true, "Author registered successfully"),
				HttpStatus.CREATED);
	}
	
	
	@GetMapping(value = "/allAuthors")
	@ApiOperation(value="List all book authors of the Library", response = List.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Ok: liste réussie"),
			@ApiResponse(code = 204, message = "Pas de donnée: pas de résultat"),
	})
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_EMPLOYE') or hasRole('ROLE_USER')")
	public ResponseEntity<List<Author>> authorsList() {
		List<Author> authors = service.findAll();
		if (!CollectionUtils.isEmpty(authors)) {
			return new ResponseEntity<List<Author>>(authors, HttpStatus.OK);
		}
		return new ResponseEntity<List<Author>>(HttpStatus.NO_CONTENT);
	}


	/**
	 * Methode en charge de d'afficher un auteur de la base de données.
	 * 
	 * @return
	 */
	@GetMapping("/{id}")
	@ApiOperation(value = "affiche un auteur", response = Author.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Ok !"),
			@ApiResponse(code = 204, message = "Pas de donnée: pas de résultat"), })
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_EMPLOYE') or hasRole('ROLE_USER')")
	public ResponseEntity<?> getAuthor(@PathVariable Integer id) {
		if (service.getOne(id) != null) {
			Author author = service.getOne(id);
			return new ResponseEntity<Object>(author, HttpStatus.OK);
		}
		return new ResponseEntity<Object>(new RestApiResponse(false, "Author not found !"), HttpStatus.NOT_FOUND);

	}
	

	/**
	 * Methode en charge de supprimer un.e auteur.trice.s de la base de données.
	 * 
	 * @param idAuthor
	 * @return
	 */
	@DeleteMapping("/delete/{id}")
	@ApiOperation(value = "Supprimer un.e auteur.trice. Si l'auteur.trice n'existe pas, rien ne se passe", response = String.class)
	@ApiResponse(code = 204, message = "Pas de donnée: auteur.trice correctement supprimée")
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_EMPLOYE')")
	public ResponseEntity<?> deleteAuthor(@PathVariable Integer id) {
		Author author = service.getOne(id);
		if (author != null) {
			service.delete(id);
			return new ResponseEntity<Object>(new RestApiResponse(true, "Author has been successfully deleted !"),
					HttpStatus.OK);
		}
		return new ResponseEntity<Object>(new RestApiResponse(false, "Author not found !"), HttpStatus.NOT_FOUND);
	}

	/**
	 * Methode en charge de la mise à jour d'un.e auteur.trice.
	 * 
	 * @param auteurRequest
	 * @return
	 */
	@PutMapping("/update/{id}")
	@ApiOperation(value = "Modifie un.e auteur.trice existant.e", response = Author.class)
	@ApiResponses(value = { @ApiResponse(code = 404, message = "Not Found : L'auteur.trice n'existe pas"),
			@ApiResponse(code = 200, message = "Ok: L'auteur.trice a été mis à jour"),
			@ApiResponse(code = 304, message = "Non modifié: L'auteur.trice N'A PAS ETE MIS A JOUR !") })
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_EMPLOYE')")
	public ResponseEntity<?> updateAuteur(@RequestBody AuthorRequest update, Author author, @PathVariable("id") Integer id) {
		
		author = service.getOne(id);
		
		if (service.existsByFullname(update.getFullname())) {
			return new ResponseEntity<Object>(new RestApiResponse(false, "Author with this fullname is already taken!"),
					HttpStatus.CONFLICT);
		}
		
		if (author != null) {
			author.setFirstname(update.getFirstname());
			author.setLastname(update.getLastname());
			author.setFullname(update.getFullname());
			
			Author response = service.save(author);
			if( response != null) {
				return new ResponseEntity<Author>(response, HttpStatus.OK);
			}
		}
		return new ResponseEntity<Author>(HttpStatus.NOT_MODIFIED);
		
	}


	

}
