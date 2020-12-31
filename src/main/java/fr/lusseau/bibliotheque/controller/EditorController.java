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

import fr.lusseau.bibliotheque.dto.request.EditorRequest;
import fr.lusseau.bibliotheque.entity.Editor;
import fr.lusseau.bibliotheque.payload.RestApiResponse;
import fr.lusseau.bibliotheque.service.EditorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * Classe en charge de
 * 
 * @Version Bibliotheque -v1,0
 * @date 21 août 2020 - 14:11:25
 * @author Claude LUSSEAU
 *
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/admin/editor")
@Api(value = "Editor Rest Controller: contient toutes les operations pour la gestion des éditeurs")
public class EditorController {

	@Autowired
	EditorService service;

	/**
	 * Methode en charge d'ajouter une nouvelle Editeurs dans la base de données.
	 * 
	 * @param Editor
	 * @return
	 */
	@PostMapping("/addEditor")
	@ApiOperation(value = "Ajouter une nouvel éditeur", response = Editor.class)
	@ApiResponses(value = { @ApiResponse(code = 409, message = "Erreur : l'éditeur existe déjà"),
			@ApiResponse(code = 201, message = "Création : l'éditeur a été correctement créé"),
			@ApiResponse(code = 304, message = "Non modifiée : l'éditeur n'a pas été créé") })
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_EMPLOYE')")
	public ResponseEntity<?> createNewEditor(@RequestBody Editor editor) {

		if (service.existsByName(editor.getName())) {
			return new ResponseEntity<Object>(new RestApiResponse(false, "Editor with this name is already taken!"),
					HttpStatus.CONFLICT);
		}
		editor = new Editor(editor.getName(), editor.getEmail(), editor.getContact());
		Editor editorResponse = service.save(editor);
		if (editorResponse == null) {
			return new ResponseEntity<Editor>(editor, HttpStatus.NOT_IMPLEMENTED);
		}
		return new ResponseEntity<Object>(new RestApiResponse(true, "Editor registered successfully"),
				HttpStatus.CREATED);
	}

	/**
	 * Methode en charge de lister toutes les Editeurs de la base de données.
	 * 
	 * @return
	 */
	@GetMapping(value = "/allEditors")
	@ApiOperation(value = "Liste toutes les Editeurs", response = List.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Ok: liste réussie"),
			@ApiResponse(code = 204, message = "Pas de donnée: pas de résultat"), })
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_EMPLOYE') or hasRole('ROLE_USER')")
	public ResponseEntity<List<Editor>> editorsList() {
		List<Editor> editors = service.findAll();
		if (!CollectionUtils.isEmpty(editors)) {
			return new ResponseEntity<List<Editor>>(editors, HttpStatus.OK);
		}
		return new ResponseEntity<List<Editor>>(HttpStatus.NO_CONTENT);
	}

	/**
	 * Methode en charge de d'afficher un editeur de la base de données.
	 * 
	 * @return
	 */
	@GetMapping("/{id}")
	@ApiOperation(value = "affiche un editeur", response = Editor.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Ok !"),
			@ApiResponse(code = 204, message = "Pas de donnée: pas de résultat"), })
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_EMPLOYE') or hasRole('ROLE_USER')")
	public ResponseEntity<?> getEditor(@PathVariable Integer id) {
		if (service.getOne(id) == null) {
			return new ResponseEntity<Object>(new RestApiResponse(false, "Editor not found !"), HttpStatus.NOT_FOUND);
		}
		Editor editor = service.getOne(id);
		return new ResponseEntity<Object>(editor, HttpStatus.OK);

	}

	/**
	 * Methode en charge de supprimer une Editeur de la base de données.
	 * 
	 * @param idBibliotheque
	 * @return
	 */
	@DeleteMapping("/delete/{id}")
	@ApiOperation(value = "Supprimer un Editeur. Si l'éditeur n'existe pas, rien ne se passe", response = String.class)
	@ApiResponse(code = 204, message = "Pas de donnée: Editeur correctement supprimée")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<?> deleteEditor(@PathVariable Integer id) {
		Editor editor = service.getOne(id);
		if (editor != null) {
			service.delete(id);
			return new ResponseEntity<Object>(new RestApiResponse(true, "Editor has been successfully deleted !"),
					HttpStatus.OK);
		}
		return new ResponseEntity<Object>(new RestApiResponse(false, "Editor not found !"), HttpStatus.NOT_FOUND);
	}

	/**
	 * Methode en charge de la mise à jour d'une Editeur.
	 * 
	 * @param update
	 * @param editor
	 * @param id
	 */
	@PutMapping(value = "/update/{id}")
	@ApiOperation(value = "Modifie une éditeur existante", response = Editor.class)
	@ApiResponses(value = { @ApiResponse(code = 404, message = "Not Found : L'éditeur n'existe pas"),
			@ApiResponse(code = 200, message = "Ok: L'éditeur a été mise à jour"),
			@ApiResponse(code = 304, message = "Non modifié: L'éditeur N'A PAS ETE MISE A JOUR !") })
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_EMPLOYE')")
	public ResponseEntity<?> updateEditor(@RequestBody EditorRequest update, Editor editor,
			@PathVariable("id") Integer id) {
		editor = service.getOne(id);

		if (service.existsByName(update.getName())) {
			return new ResponseEntity<Object>(new RestApiResponse(false, "Editor with this name is already taken!"),
					HttpStatus.CONFLICT);
		}

		if (editor != null) {
			editor.setName(update.getName());
			editor.setEmail(update.getEmail());
			editor.setContact(update.getContact());

			Editor response = service.save(editor);
			if (response != null) {
				return new ResponseEntity<Editor>(response, HttpStatus.OK);
			}
		}
		return new ResponseEntity<Editor>(HttpStatus.NOT_MODIFIED);
	}

}
