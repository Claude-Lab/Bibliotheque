/**
 * 
 */
package fr.lusseau.bibliotheque.service;

import java.time.LocalDate;
import java.util.List;

import fr.lusseau.bibliotheque.entity.Loan;
import fr.lusseau.bibliotheque.entity.LoanStatus;

/**
 * Classe en charge de
 * @Version Bibliotheque -v1,0
 * @date  18 oct. 2020 - 07:38:12
 * @author Claude LUSSEAU
 *
 */
public interface LoanService {

public List<Loan> findAllLoansByEndDateBefore(LocalDate maxEndDate);
    
    public List<Loan> getAllOpenLoansOfThisUser(String email, LoanStatus status);
    
    public Loan getOpenedLoan(Loan loan);
    
    public boolean checkIfLoanExists(Loan loan);
    
    public Loan saveLoan(Loan loan);
    
    public void closeLoan(Loan loan);
}
