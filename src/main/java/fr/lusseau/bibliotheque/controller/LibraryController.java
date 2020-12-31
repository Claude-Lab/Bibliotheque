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

import fr.lusseau.bibliotheque.dto.request.LibraryRequest;
import fr.lusseau.bibliotheque.entity.Library;
import fr.lusseau.bibliotheque.payload.RestApiResponse;
import fr.lusseau.bibliotheque.service.LibraryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * Classe en charge de
 * 
 * @Version Bibliotheque -v1,0
 * @date 21 août 2020 - 14:11:15
 * @author Claude LUSSEAU
 *
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/admin/library")
@Api(value = "Library Rest Controller: contient toutes les operations pour la gestion des bibliotheques")
public class LibraryController {

	@Autowired
	LibraryService service;

	/**
	 * Methode en charge d'ajouter une nouvelle Bibliotheque dans la base de
	 * données.
	 * 
	 * @param Library
	 * @return
	 */
	@PostMapping("/addLibrary")
	@ApiOperation(value = "Ajouter une nouvelle Bibliotheque", response = Library.class)
	@ApiResponses(value = { @ApiResponse(code = 409, message = "Erreur : la Bibliotheque existe déjà"),
			@ApiResponse(code = 201, message = "Création : l'Bibliotheque a été correctement créée"),
			@ApiResponse(code = 304, message = "Non modifiée : la Bibliotheque n'a pas été créée") })
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<?> createNewLibrary(@RequestBody Library library) {

		if (service.existsByName(library.getName())) {
			return new ResponseEntity<Object>(new RestApiResponse(false, "Library with this name is already taken!"),
					HttpStatus.CONFLICT);
		}

		library = new Library(library.getName(), library.getEmail(), library.getContact());
		Library libraryResponse = service.save(library);
		if (libraryResponse == null) {
			return new ResponseEntity<Library>(library, HttpStatus.NOT_IMPLEMENTED);
		}
		return new ResponseEntity<Object>(new RestApiResponse(true, "Library registered successfully"),
				HttpStatus.CREATED);
	}

	/**
	 * Methode en charge de lister toutes les Bibliotheques de la base de données.
	 * 
	 * @return
	 */
	@GetMapping("/allLibraries")
	@ApiOperation(value = "Liste toutes les Bibliotheques", response = List.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Ok: liste réussie"),
			@ApiResponse(code = 204, message = "Pas de donnée: pas de résultat"), })
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_EMPLOYE') or hasRole('ROLE_USER')")
	public ResponseEntity<List<Library>> librariesList() {

		List<Library> libraries = service.findAll();
		if (!CollectionUtils.isEmpty(libraries)) {
			return new ResponseEntity<List<Library>>(libraries, HttpStatus.OK);

		}
		return new ResponseEntity<List<Library>>(HttpStatus.NO_CONTENT);
	}

	/**
	 * Methode en charge de d'afficher une Bibliothèques de la base de données.
	 * 
	 * @return
	 */
	@GetMapping("/{id}")
	@ApiOperation(value = "affiche une Bibliotheques", response = Library.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Ok !"),
			@ApiResponse(code = 204, message = "Pas de donnée: pas de résultat"), })
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_EMPLOYE') or hasRole('ROLE_USER')")
	public ResponseEntity<?> getLibrary(@PathVariable Integer id) {

		if (service.getOne(id) == null) {
			return new ResponseEntity<Object>(new RestApiResponse(false, "Library not found !"), HttpStatus.NOT_FOUND);
		}
		Library library = service.getOne(id);
		return new ResponseEntity<Object>(library, HttpStatus.OK);
	}

	/**
	 * Methode en charge de supprimer une Bibliotheques de la base de données.
	 * 
	 * @param idBibliotheque
	 * @return
	 */
	@DeleteMapping("/delete/{id}")
	@ApiOperation(value = "Supprimer une Bibliotheque. Si la Bibliotheque n'existe pas, rien ne se passe", response = String.class)
	@ApiResponse(code = 204, message = "Pas de donnée: Bibliotheque correctement supprimée")
	public ResponseEntity<?> deleteLibrary(@PathVariable Integer id) {

		Library library = service.getOne(id);
		if (library != null) {
			service.delete(id);
			return new ResponseEntity<Object>(new RestApiResponse(true, "Library has been successfully deleted !"),
					HttpStatus.OK);
		}
		return new ResponseEntity<Object>(new RestApiResponse(false, "Library not found !"), HttpStatus.NOT_FOUND);
	}

	/**
	 * Methode en charge de la mise à jour d'une Bibliotheque.
	 * 
	 * @param BibliothequeRequest
	 * @return
	 */
	@PutMapping("/update/{id}")
	@ApiOperation(value = "Modifie une Bibliotheque existante", response = Library.class)
	@ApiResponses(value = { @ApiResponse(code = 404, message = "Not Found : L'Bibliotheque.trice n'existe pas"),
			@ApiResponse(code = 200, message = "Ok: La Bibliotheque a été mise à jour"),
			@ApiResponse(code = 304, message = "Non modifié: La Bibliotheque N'A PAS ETE MISE A JOUR !") })
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_EMPLOYE')")
	public ResponseEntity<?> updateLibrary(@RequestBody LibraryRequest update, Library library,
			@PathVariable("id") Integer id) {
		
		if (service.existsByName(update.getName())) {
			return new ResponseEntity<Object>(new RestApiResponse(false, "Library with this name is already taken!"),
					HttpStatus.CONFLICT);
		}
		library = service.getOne(id);
		if (library != null) {
			library.setName(update.getName());
			library.setEmail(update.getEmail());
			library.setContact(update.getContact());
			
			Library response = service.update(library);
			if (response != null) {
				return new ResponseEntity<Object>(response, HttpStatus.OK);
			}

		}
		return new ResponseEntity<Object>(HttpStatus.NOT_MODIFIED);
	}

}
