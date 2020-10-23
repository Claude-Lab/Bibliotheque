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

import fr.lusseau.bibliotheque.entity.Loan;
import fr.lusseau.bibliotheque.entity.LoanStatus;
import fr.lusseau.bibliotheque.service.impl.LoanServiceImpl;
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
public class LoanController {

	public static final Logger LOGGER = LoggerFactory.getLogger(LoanController.class);
	
	@Autowired
	LoanServiceImpl loanService;

	/**
     * Retourne l'historique des prêts en cours dans la bibliothèque jusqu'à une certaine date maximale. 
     * @param maxEndDateStr
     * @return
     */
    @GetMapping("/loan/maxEndDate")
    public ResponseEntity<List<Loan>> searchAllLoansBeforeThisDate(@RequestParam("date") String  maxEndDateStr) {
        List<Loan> loans = loanService.findAllLoansByEndDateBefore(LocalDate.parse(maxEndDateStr));
        // on retire tous les élts null que peut contenir cette liste => pour éviter les NPE par la suite
        loans.removeAll(Collections.singleton(null));
        return new ResponseEntity<List<Loan>>(loans, HttpStatus.OK);
    }
    
    /**
     * Retourne la liste des prêts en cours d'un client. 
     * @param email
     * @return
     */
    @GetMapping("/loan/userLoans")
    public ResponseEntity<List<Loan>> searchAllOpenedLoansOfThisUser(@RequestParam("email") String email) {
        List<Loan> loans = loanService.getAllOpenLoansOfThisUser(email, LoanStatus.OPEN);
        // on retire tous les élts null que peut contenir cette liste => pour éviter les NPE par la suite
        loans.removeAll(Collections.singleton(null));
        return new ResponseEntity<List<Loan>>(loans, HttpStatus.OK);
    }
    
    /**
     * Ajoute un nouveau prêt dans la base de données H2.
     * @param simpleLoanDTORequest
     * @param uriComponentBuilder
     * @return
     */
    @PostMapping("/loan/addLoan")
    public ResponseEntity<Boolean> createNewLoan(@RequestBody Loan loan,
            UriComponentsBuilder uriComponentBuilder) {
        boolean isLoanExists = loanService.checkIfLoanExists(loan);
        if (isLoanExists) {
            return new ResponseEntity<Boolean>(false, HttpStatus.CONFLICT);
        }
       
        loan = loanService.saveLoan(loan);
        if (loan != null) {
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
    @PostMapping("/loan/closeLoan")
    public ResponseEntity<Boolean> closeLoan(@RequestBody Loan loanRequest,
            UriComponentsBuilder Loan) {
    	Loan existingLoan = loanService.getOpenedLoan(loanRequest);
        if (existingLoan == null) {
            return new ResponseEntity<Boolean>(false, HttpStatus.NO_CONTENT);
        }
        existingLoan.setStatus(LoanStatus.CLOSE);
        Loan loan = loanService.saveLoan(existingLoan);
        if (loan != null) {
            return new ResponseEntity<Boolean>(true, HttpStatus.OK);
        }
        return new ResponseEntity<Boolean>(HttpStatus.NOT_MODIFIED);
    }

    
}
