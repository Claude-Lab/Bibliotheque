package fr.lusseau.bibliotheque.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.lusseau.bibliotheque.entity.Contact;
import fr.lusseau.bibliotheque.service.impl.ContactServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * Classe en charge de toutes les operations pour la gestion des coordonnees.
 * @Version Bibliotheque -v1,0
 * @date  22 oct. 2020 - 17:18:53
 * @author Claude LUSSEAU
 *
 */
@CrossOrigin("*")
@RestController
@RequestMapping("contact")
@Api(value = "Contact Rest Controller: contient toutes les operations pour la gestion des Coordonnées")
public class ContactController {

	@Autowired
	ContactServiceImpl contactService;
	
	/**
	 * Methode en charge d'ajouter une nouvelle coordonnee dans la base de données.
	 * 
	 * @param contact
	 * @return
	 */
	@PostMapping("/addContact")
	@ApiOperation(value = "Ajouter une nouvelle Coordonnee", response = Contact.class)
	@ApiResponses(value = { @ApiResponse(code = 409, message = "Erreur : la Coordonnee existe déjà"),
			@ApiResponse(code = 201, message = "Création : la Coordonnee a été correctement créée"),
			@ApiResponse(code = 304, message = "Non modifiée : la Coordonnee n'a pas été créée") })
	public ResponseEntity<Contact> createNewexistingContact(@RequestBody Contact contact) {
		Contact existingContact = contactService.findOne(contact.getIdContact());
		if (existingContact != null) {
			return new ResponseEntity<Contact>(HttpStatus.CONFLICT);
		}
		Contact contactResponse = contactService.saveContact(contact);
		if (contactResponse != null) {

			return new ResponseEntity<Contact>(contactResponse, HttpStatus.CREATED);
		}
		return new ResponseEntity<Contact>(HttpStatus.NOT_MODIFIED);
	}
	
	/**
	 * Methode en charge de la mise à jour d'une coordonnee.
	 * @param coordonneeRequest
	 * @return
	 */
	@PutMapping("/updateContact")
	@ApiOperation(value = "Modifie une coordonnee existante", response = Contact.class)
	@ApiResponses(value = { @ApiResponse(code = 404, message = "Not Found : L'Bibliotheque.trice n'existe pas"),
			@ApiResponse(code = 200, message = "Ok: La coordonnee a été mise à jour"),
			@ApiResponse(code = 304, message = "Non modifié: La coordonnee N'A PAS ETE MISE A JOUR !") })
	public ResponseEntity<Contact> updateContact(@RequestBody Contact contactRequest) {
		if (!contactService.checkIfContactExists(contactRequest.getIdContact())) {
			return new ResponseEntity<Contact>(HttpStatus.NOT_FOUND);
		}
		Contact coordonnee = contactService.updateContact(contactRequest);
		if (coordonnee != null) {
			
			return new ResponseEntity<Contact>(coordonnee, HttpStatus.OK);
		}
		return new ResponseEntity<Contact>(HttpStatus.NOT_MODIFIED);
	}
	
	/**
	 * Methode en charge de d'afficher une coordonnee de la base de données.
	 * @return
	 */
	@GetMapping("/{idContact}")
	@ApiOperation(value="affiche une coordonnee", response = Contact.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Ok !"),
			@ApiResponse(code = 204, message = "Pas de donnée: pas de résultat"),
	})
	public ResponseEntity<Contact> findContact(@PathVariable Integer idContact) {
		Contact contact = contactService.findOne(idContact);
		if (contact != null) {
			return new ResponseEntity<Contact>(contact, HttpStatus.OK);
		}
		return new ResponseEntity<Contact>(HttpStatus.NO_CONTENT);
	}

}
