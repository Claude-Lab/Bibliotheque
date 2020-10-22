/**
 * 
 */
package fr.lusseau.bibliotheque.controller;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import fr.lusseau.bibliotheque.entity.Emprunt;
import fr.lusseau.bibliotheque.entity.EmpruntStatus;
import fr.lusseau.bibliotheque.service.impl.EmpruntServiceImpl;
import io.swagger.annotations.Api;

/**
 * Classe en charge de
 * 
 * @Version Bibliotheque -v1,0
 * @date 7 sept. 2020 - 15:12:33
 * @author Claude LUSSEAU
 *
 */
@RestController
@Api(value = "Emprunt Rest Controller: Contient toute les opération pour la gestion des emprunts")
@RequestMapping("/rest/api/v1")
public class EmpruntController {

	public static final Logger LOGGER = LoggerFactory.getLogger(EmpruntController.class);
	
	@Autowired
	EmpruntServiceImpl empruntService;

	/**
     * Retourne l'historique des prêts en cours dans la bibliothèque jusqu'à une certaine date maximale. 
     * @param maxEndDateStr
     * @return
     */
    @GetMapping("/maxEndDate")
    public ResponseEntity<List<Emprunt>> searchAllBooksLoanBeforeThisDate(@RequestParam("date") String  maxEndDateStr) {
        List<Emprunt> emprunts = empruntService.findAllEmpruntsByEndDateBefore(LocalDate.parse(maxEndDateStr));
        // on retire tous les élts null que peut contenir cette liste => pour éviter les NPE par la suite
        emprunts.removeAll(Collections.singleton(null));
        return new ResponseEntity<List<Emprunt>>(emprunts, HttpStatus.OK);
    }
    
    /**
     * Retourne la liste des prêts en cours d'un client. 
     * @param email
     * @return
     */
    @GetMapping("/customerLoans")
    public ResponseEntity<List<Emprunt>> searchAllOpenedEmpruntsOfThisPersonne(@RequestParam("email") String email) {
        List<Emprunt> emprunts = empruntService.getAllOpenEmpruntsOfThisPersonne(email, EmpruntStatus.OPEN);
        // on retire tous les élts null que peut contenir cette liste => pour éviter les NPE par la suite
        emprunts.removeAll(Collections.singleton(null));
        return new ResponseEntity<List<Emprunt>>(emprunts, HttpStatus.OK);
    }
    
    /**
     * Ajoute un nouveau prêt dans la base de données H2.
     * @param simpleLoanDTORequest
     * @param uriComponentBuilder
     * @return
     */
    @PostMapping("/addEmprunt")
    public ResponseEntity<Boolean> createNewEmprunt(@RequestBody Emprunt emprunt,
            UriComponentsBuilder uriComponentBuilder) {
        boolean isEmpruntExists = empruntService.checkIfEmpruntExists(emprunt);
        if (isEmpruntExists) {
            return new ResponseEntity<Boolean>(false, HttpStatus.CONFLICT);
        }
       
        emprunt = empruntService.saveEmprunt(emprunt);
        if (emprunt != null) {
            return new ResponseEntity<Boolean>(true, HttpStatus.CREATED);
        }
        return new ResponseEntity<Boolean>(false, HttpStatus.NOT_MODIFIED);
    }
    
    /**
     * Clôture le prêt de livre d'un client.
     * @param simpleLoanDTORequest
     * @param uriComponentBuilder
     * @return
     */
    @PostMapping("/closeEmprunt")
    public ResponseEntity<Boolean> closeLoan(@RequestBody Emprunt emprunt,
            UriComponentsBuilder uriComponentBuilder) {
    	Emprunt existingEmprunt = empruntService.getOpenedEmprunt(emprunt);
        if (existingEmprunt == null) {
            return new ResponseEntity<Boolean>(false, HttpStatus.NO_CONTENT);
        }
        existingEmprunt.setStatus(EmpruntStatus.CLOSE);
        emprunt = empruntService.saveEmprunt(existingEmprunt);
        if (emprunt != null) {
            return new ResponseEntity<Boolean>(true, HttpStatus.OK);
        }
        return new ResponseEntity<Boolean>(HttpStatus.NOT_MODIFIED);
    }

    
}
