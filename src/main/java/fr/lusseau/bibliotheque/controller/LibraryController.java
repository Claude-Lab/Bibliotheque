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

import fr.lusseau.bibliotheque.entity.Library;
import fr.lusseau.bibliotheque.service.impl.LibraryServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * Classe en charge de
 * @Version Bibliotheque -v1,0
 * @date  21 août 2020 - 14:11:15
 * @author Claude LUSSEAU
 *
 */
@RestController
@RequestMapping("/rest/api/v1")
@Api(value = "Bibliotheque Rest Controller: contient toutes les operations pour la gestion des bibliotheques")
public class LibraryController {

	@Autowired
	LibraryServiceImpl libraryService;
	
	/**
	 * Methode en charge d'ajouter une nouvelle Bibliotheque dans la base de données.
	 * 
	 * @param Library
	 * @return
	 */
	@PostMapping("/library/addlibrary")
	@ApiOperation(value = "Ajouter une nouvelle Bibliotheque", response = Library.class)
	@ApiResponses(value = { @ApiResponse(code = 409, message = "Erreur : la Bibliotheque existe déjà"),
			@ApiResponse(code = 201, message = "Création : l'Bibliotheque a été correctement créée"),
			@ApiResponse(code = 304, message = "Non modifiée : la Bibliotheque n'a pas été créée") })
	public ResponseEntity<Library> createNewLibrary(@RequestBody Library library) {
		Library existingLibrary = libraryService.findByName(library.getName());
		if (existingLibrary != null) {
			return new ResponseEntity<Library>(HttpStatus.CONFLICT);
		}
		Library libraryResponse = libraryService.saveLibrary(library);
		if (libraryResponse != null) {

			return new ResponseEntity<Library>(libraryResponse, HttpStatus.CREATED);
		}
		return new ResponseEntity<Library>(HttpStatus.NOT_MODIFIED);
	}

	
	/**
	 * Methode en charge de lister toutes les Bibliotheques de la base de données.
	 * @return
	 */
	@GetMapping("/library/listLibraries")
	@ApiOperation(value="Liste toutes les Bibliotheques", response = Library.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Ok: liste réussie"),
			@ApiResponse(code = 204, message = "Pas de donnée: pas de résultat"),
	})
	public ResponseEntity<List<Library>> listLibrary() {
		List<Library> libraries = libraryService.findAllLibrary();
		if (!CollectionUtils.isEmpty(libraries)) {
			libraries.removeAll(Collections.singleton(null));
			return new ResponseEntity<List<Library>>(libraries, HttpStatus.OK);
		}
		return new ResponseEntity<List<Library>>(HttpStatus.NO_CONTENT);
	}
	
	/**
	 * Methode en charge de supprimer une Bibliotheques de la base de données.
	 * 
	 * @param idBibliotheque
	 * @return
	 */
	@DeleteMapping("/library/deleteLibrary/{idLibrary}")
	@ApiOperation(value = "Supprimer une Bibliotheque. Si la Bibliotheque n'existe pas, rien ne se passe", response = String.class)
	@ApiResponse(code = 204, message = "Pas de donnée: Bibliotheque correctement supprimée")
	public ResponseEntity<String> deleteLibrary(@PathVariable Integer idLibrary) {
		libraryService.deleteLibrary(idLibrary);
		return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
	}
	
	
	
	/**
	 * Methode en charge de la mise à jour d'une Bibliotheque.
	 * @param BibliothequeRequest
	 * @return
	 */
	@PutMapping("/library/updateLibrary")
	@ApiOperation(value = "Modifie une Bibliotheque existante", response = Library.class)
	@ApiResponses(value = { @ApiResponse(code = 404, message = "Not Found : L'Bibliotheque.trice n'existe pas"),
			@ApiResponse(code = 200, message = "Ok: La Bibliotheque a été mise à jour"),
			@ApiResponse(code = 304, message = "Non modifié: La Bibliotheque N'A PAS ETE MISE A JOUR !") })
	public ResponseEntity<Library> updateLibrary(@RequestBody Library libraryRequest) {
		if (!libraryService.checkIsLibraryExists(libraryRequest.getIdLibrary())) {
			return new ResponseEntity<Library>(HttpStatus.NOT_FOUND);
		}
		Library library = libraryService.updateLibrary(libraryRequest);
		if (library != null) {
			
			return new ResponseEntity<Library>(library, HttpStatus.OK);
		}
		return new ResponseEntity<Library>(HttpStatus.NOT_MODIFIED);
	}
	
	/**
	 * Methode en charge de d'afficher une Bibliothèques de la base de données.
	 * @return
	 */
	@GetMapping("/library/{idLibrary}")
	@ApiOperation(value="affiche une Bibliotheques", response = Library.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Ok !"),
			@ApiResponse(code = 204, message = "Pas de donnée: pas de résultat"),
	})
	public ResponseEntity<Library> findLibrary(@PathVariable Integer idLibrary) {
		Library library = libraryService.findOne(idLibrary);
		if (library != null) {
			return new ResponseEntity<Library>(library, HttpStatus.OK);
		}
		return new ResponseEntity<Library>(HttpStatus.NO_CONTENT);
	}
	
	
}
