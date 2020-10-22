/**
 * 
 */
package fr.lusseau.bibliotheque.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.lusseau.bibliotheque.dao.StyleDAO;
import fr.lusseau.bibliotheque.entity.Categorie;
import fr.lusseau.bibliotheque.exception.ResourceNotFoundException;
import io.swagger.annotations.ApiOperation;

/**
 * Classe en charge de
 * 
 * @Version Bibliotheque -v1,0
 * @date 21 août 2020 - 14:11:04
 * @author Claude LUSSEAU
 *
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class StyleController {

	@Autowired
	StyleDAO dao;

	@PostConstruct
	private void init() {
	}

	// get all auteurs
	@ApiOperation(value = "Récupère la liste des auteurs")
	@GetMapping(value = "styles")
	public List<Categorie> listStyles() {
		return dao.findAll();
	}

	// get a livre by id rest api
	@ApiOperation(value = "Récupère un style selon son ID")
	@GetMapping(value = "styles/{idStyle}")
	public ResponseEntity<Categorie> getStyleById(@PathVariable int idStyle) {
		Categorie style = dao.findById(idStyle)
				.orElseThrow(() -> new ResourceNotFoundException("Le style avec l'id " + idStyle + " n'existe pas."));
		return ResponseEntity.ok(style);
	}

	// create style rest api
	@ApiOperation(value = "Enregistre un nouveau style")
	@PostMapping(value = "styles", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public Categorie addStyle(@RequestBody Categorie style) {
		return dao.save(style);
	}

	// delete style rest api
	@DeleteMapping("styles/{idStyle}")
	public ResponseEntity<Map<String, Boolean>> deleteStyle(@PathVariable int idStyle) {

		Categorie style = dao.findById(idStyle)
				.orElseThrow(() -> new ResourceNotFoundException("l'id : " + idStyle + " n'existe pas"));
		dao.delete(style);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

}
