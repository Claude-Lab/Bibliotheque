/**
 * 
 */
package fr.lusseau.bibliotheque.controller;

import java.util.List;
import java.util.Optional;
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

import fr.lusseau.bibliotheque.dto.request.EditorRequestDTO;
import fr.lusseau.bibliotheque.entity.Editor;
import fr.lusseau.bibliotheque.service.impl.EditorServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * Classe en charge de
 * @Version Bibliotheque -v1,0
 * @date  21 août 2020 - 14:11:25
 * @author Claude LUSSEAU
 *
 */
@CrossOrigin("*")
@RestController
@RequestMapping("editors")
@Api(value = "Editor Rest Controller: contient toutes les operations pour la gestion des éditeurs")
public class EditorController {

	@Autowired
	EditorServiceImpl editorService;
	
	/**
	 * Methode en charge d'ajouter une nouvelle Bibliotheque dans la base de données.
	 * 
	 * @param Editor
	 * @return
	 */
	@PostMapping("/addEditor")
	@ApiOperation(value = "Ajouter une nouvel éditeur", response = EditorRequestDTO.class)
	@ApiResponses(value = { @ApiResponse(code = 409, message = "Erreur : l'éditeur existe déjà"),
			@ApiResponse(code = 201, message = "Création : l'éditeur a été correctement créé"),
			@ApiResponse(code = 304, message = "Non modifiée : l'éditeur n'a pas été créé") })
	public ResponseEntity<EditorRequestDTO> createNewEditor(@RequestBody EditorRequestDTO editorRequestDTO) {
		Editor existingEditor = editorService.findByName(editorRequestDTO.getName());
		if (existingEditor != null) {
			return new ResponseEntity<EditorRequestDTO>(HttpStatus.CONFLICT);
		}
		Editor editorResquest = mapEditorDTOToEditor(editorRequestDTO);
		Editor editorResponse = editorService.saveEditor(editorResquest);
		if (editorResponse != null) {
			EditorRequestDTO editorDTO = mapEditorToEditorDTO(editorResponse);
			return new ResponseEntity<EditorRequestDTO>(editorDTO, HttpStatus.CREATED);
		}
		return new ResponseEntity<EditorRequestDTO>(HttpStatus.NOT_MODIFIED);
	}

	
	/**
	 * Methode en charge de lister toutes les Bibliotheques de la base de données.
	 * @return
	 */
	@GetMapping("")
	@ApiOperation(value="Liste toutes les Editeurs", response = EditorRequestDTO.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Ok: liste réussie"),
			@ApiResponse(code = 204, message = "Pas de donnée: pas de résultat"),
	})
	public ResponseEntity<List<EditorRequestDTO>> listEditor() {
		
		List<Editor> editors = editorService.findAll();
		if (editors != null &&  !CollectionUtils.isEmpty(editors)) {
			List<EditorRequestDTO> editorDTOs = editors.stream().map(editor -> { 
				return mapEditorToEditorDTO(editor);
			}).collect(Collectors.toList());
			return new ResponseEntity<List<EditorRequestDTO>>(editorDTOs, HttpStatus.OK);
		}
		return new ResponseEntity<List<EditorRequestDTO>>(HttpStatus.NO_CONTENT);
	}
	
	/**
	 * Methode en charge de supprimer une Bibliotheques de la base de données.
	 * 
	 * @param idBibliotheque
	 * @return
	 */
	@DeleteMapping("/deleteEditor/{idEditor}")
	@ApiOperation(value = "Supprimer une Bibliotheque. Si l'éditeur n'existe pas, rien ne se passe", response = String.class)
	@ApiResponse(code = 204, message = "Pas de donnée: Editeur correctement supprimée")
	public ResponseEntity<String> deleteEditor(@PathVariable Integer idEditor) {
		editorService.deleteEditor(idEditor);
		return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
	}
	
	
	
	/**
	 * Methode en charge de la mise à jour d'une Bibliotheque.
	 * @param BibliothequeRequest
	 * @return
	 */
	@PutMapping("/updateEditor")
	@ApiOperation(value = "Modifie une éditeur existante", response = Editor.class)
	@ApiResponses(value = { @ApiResponse(code = 404, message = "Not Found : L'éditeur n'existe pas"),
			@ApiResponse(code = 200, message = "Ok: L'éditeur a été mise à jour"),
			@ApiResponse(code = 304, message = "Non modifié: L'éditeur N'A PAS ETE MISE A JOUR !") })
	public ResponseEntity<Editor> updateEditor(@RequestBody Editor editorRequest) {
		if (!editorService.checkIfEditorExists(editorRequest.getIdEditor())) {
			return new ResponseEntity<Editor>(HttpStatus.NOT_FOUND);
		}
		Editor editor = editorService.updateEditor(editorRequest);
		if (editor != null) {
			
			return new ResponseEntity<Editor>(editor, HttpStatus.OK);
		}
		return new ResponseEntity<Editor>(HttpStatus.NOT_MODIFIED);
	}
	
	/**
	 * Methode en charge de d'afficher une Bibliothèques de la base de données.
	 * @return
	 */
	@GetMapping("/{idEditor}")
	@ApiOperation(value="affiche un éditeur", response = EditorRequestDTO.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Ok !"),
			@ApiResponse(code = 204, message = "Pas de donnée: pas de résultat"),
	})
	public ResponseEntity<Editor> findEditor(@PathVariable Integer idEditor) {
		Optional<Editor> editor = editorService.findById(idEditor);
		if (editor != null) {
			return new ResponseEntity<Editor>(HttpStatus.OK);
		}
		return new ResponseEntity<Editor>(HttpStatus.NO_CONTENT);
	}
	
	/**
	 * Transforme un entity Customer en un POJO CustomerDTO
	 * 
	 * @param customer
	 * @return
	 */
	private EditorRequestDTO mapEditorToEditorDTO(Editor editor) {
		ModelMapper mapper = new ModelMapper();
		EditorRequestDTO editorDTO = mapper.map(editor, EditorRequestDTO.class);
		return editorDTO;
	}

	/**
	 * Transforme un POJO CustomerDTO en en entity Customer
	 * 
	 * @param customerDTO
	 * @return
	 */
	private Editor mapEditorDTOToEditor(EditorRequestDTO editorDTO) {
		ModelMapper mapper = new ModelMapper();
		Editor editor = mapper.map(editorDTO, Editor.class);
		return editor;
	}
	
}
