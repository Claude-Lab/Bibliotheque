/**
 * 
 */
package fr.lusseau.bibliotheque.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.lusseau.bibliotheque.entity.Personne;
import fr.lusseau.bibliotheque.service.impl.PersonneServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * Classe en charge de la gestion et de la synchronisation des événements liés à
 * la classe Personne.
 * 
 * @Version Bibliotheque -v1,0
 * @date 14 août 2020 - 14:50:43
 * @author Claude LUSSEAU
 *
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/rest/api/v1")
@Api(value = "Person Rest Controller: contains all operations for managing persons")
public class PersonneController {
	
	public static final Logger LOGGER = LoggerFactory.getLogger(PersonneController.class);

	@Autowired
	PersonneServiceImpl personneService;
	
//	@Autowired
//	private JavaMailSender mailSender;
	
	/**
     * Ajoute une nouvelle personne dans la base de données. Si la personne existe déjà, on retourne un code indiquant que la création n'a pas abouti.
     * @param personneDTORequest
     * @return
     */
    @PostMapping("/addPersonne")
    @ApiOperation(value = "Ajouter une nouvelle personne à la Bibliotheque", response = Personne.class)
    @ApiResponses(value = { @ApiResponse(code = 409, message = "Erreur: la personne existe déjà en base"),
            @ApiResponse(code = 201, message = "Création: le compte de la personne à été correctement enregistrée en base"),
            @ApiResponse(code = 304, message = "Nom modifié: la personne n'a pas été correctement insérée") })
    public ResponseEntity<Personne> createNewPersonne(@RequestBody Personne personneRequest, String email) {
        //, UriComponentsBuilder uriComponentBuilder
    	Personne existingPersonne = personneService.findPersonneByCoordonneeEmail(email);
        if (existingPersonne != null) {
            return new ResponseEntity<Personne>(HttpStatus.CONFLICT);
        }
        personneRequest.setDateInscription(LocalDate.now());
        Personne personneResponse = personneService.savePersonne(personneRequest);
        if (personneResponse != null) {
            return new ResponseEntity<Personne>(personneResponse, HttpStatus.CREATED);
        }
        return new ResponseEntity<Personne>(HttpStatus.NOT_MODIFIED);
    }
    
    /**
     * Met à jour les données d'une personne dans la base de données. Si la personne n'est pas retrouvée, on retourne un code indiquant que la mise à jour n'a pas abouti.
     * @param personneDTORequest
     * @return
     */
    @PutMapping("/updatePersonne")
    public ResponseEntity<Personne> updatePersonne(@RequestBody Personne personneRequest) {
        //, UriComponentsBuilder uriComponentBuilder
        if (!personneService.checkIfIdExists(personneRequest.getIdPersonne())) {
            return new ResponseEntity<Personne>(HttpStatus.NOT_FOUND);
        }
        Personne personneResponse = personneService.updatePersonne(personneRequest);
        if (personneResponse != null) {
            return new ResponseEntity<Personne>(personneResponse, HttpStatus.OK);
        }
        return new ResponseEntity<Personne>(HttpStatus.NOT_MODIFIED);
    }
    
    /**
     * Supprime une Personne dans la base de données. Si la personne n'est pas retrouvée, on retourne le Statut HTTP NO_CONTENT.
     * @param personneId
     * @return
     */
    @DeleteMapping("/deletePersonne/{personneId}")
    public ResponseEntity<String> deletePersonne(@PathVariable Integer personneId) {
    	personneService.deletePersonne(personneId);
        return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
    }
    
    /**
     * Retourne la personne ayant l'adresse email passée en paramètre.
     * @param email
     * @return
     */
    @GetMapping("/findByEmail")
    public ResponseEntity<Personne> searchPersonneByEmail(@RequestParam("email") String email) {
        Personne personne = personneService.findPersonneByCoordonneeEmail(email);
        if (personne != null) {
            return new ResponseEntity<Personne>(personne, HttpStatus.OK);
        }
        return new ResponseEntity<Personne>(HttpStatus.NO_CONTENT);
    }

    /**
     * Retourne la liste des personne ayant le nom passé en paramètre.
     * @param nom
     * @return
     */
    @GetMapping("/searchByLastName")
    public ResponseEntity<List<Personne>> searchPersonneByNom(@RequestParam("nom") String nom) {
        //,    UriComponentsBuilder uriComponentBuilder
        List<Personne> personnes = personneService.findPersonneByNomIgnoreCase(nom);
        if (personnes != null && !CollectionUtils.isEmpty(personnes)) {
            List<Personne> listPersonnes = personnes.stream().map(personne ->  personne
            ).collect(Collectors.toList());
            return new ResponseEntity<List<Personne>>(listPersonnes, HttpStatus.OK);
        }
        return new ResponseEntity<List<Personne>>(HttpStatus.NO_CONTENT);
    }
	
    /**
     * Envoie un mail à une personne. L'objet MailDTO contient l'identifiant et l'email de la personne concernée, l'objet du mail et le contenu du message.
     * @param empruntMailDto
     * @return
     */
    
	
//	@PutMapping("/sendEmailToPersonne")
//    public ResponseEntity<Boolean> sendMailToPersonne(@RequestBody MailSend empruntMail) {
//
//		Personne personne = personneService.findPersonneById(empruntMail.getPersonneId());
//        if (personne == null) {
//            String errorMessage = "La personne destinataire du mail n'a pas été trouvé";
//            LOGGER.info(errorMessage);
//            return new ResponseEntity<Boolean>(false, HttpStatus.NOT_FOUND);
//        } else if (personne != null && StringUtils.isEmpty(personne.getCoordonnee().getEmail())) {
//            String errorMessage = "Il n'y a pas de mail pour la personne selectionnée";
//            LOGGER.info(errorMessage);
//            return new ResponseEntity<Boolean>(false, HttpStatus.NOT_FOUND);
//        }
//
//        SimpleMailMessage mail = new SimpleMailMessage();
//        mail.setFrom(empruntMail.MAIL_FROM);
//        mail.setTo(personne.getCoordonnee().getEmail());
//        mail.setSentDate(new Date());
//        mail.setSubject(empruntMail.getEmailSubject());
//        mail.setText(empruntMail.getEmailContent());
//
//        try {
//            mailSender.send(mail);
//        } catch (MailException e) {
//            return new ResponseEntity<Boolean>(false, HttpStatus.FORBIDDEN);
//        }
//
//        return new ResponseEntity<Boolean>(true, HttpStatus.OK);
//    }

	
}
