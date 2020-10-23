/**
 * 
 */
package fr.lusseau.bibliotheque.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.lusseau.bibliotheque.dao.LoanDAO;
import fr.lusseau.bibliotheque.entity.Loan;
import fr.lusseau.bibliotheque.service.LoanService;

/**
 * Classe en charge de
 * @Version Bibliotheque -v1,0
 * @date  18 oct. 2020 - 07:36:43
 * @author Claude LUSSEAU
 *
 */
@Service("LoanService")
@Transactional
public class LoanServiceImpl implements LoanService {

	@Autowired
	LoanDAO dao;
	
	/**
	 * @{inheritDoc}
	*/
	@Override
	public List<Loan> findAllLoansByEndDateBefore(LocalDate maxEndDate) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @{inheritDoc}
	*/
	@Override
	public List<Loan> getAllOpenLoansOfThisPersonne(String email, LoanStatus status) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @{inheritDoc}
	*/
	@Override
	public Loan getOpenedLoan(Loan loan) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @{inheritDoc}
	*/
	@Override
	public boolean checkIfLoanExists(Loan loan) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * @{inheritDoc}
	*/
	@Override
	public Loan saveLoan(Loan loan) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @{inheritDoc}
	*/
	@Override
	public void closeLoan(Loan loan) {
		// TODO Auto-generated method stub
		
	}

}
