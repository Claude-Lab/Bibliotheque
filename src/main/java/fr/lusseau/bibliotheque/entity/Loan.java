/**
 * 
 */
package fr.lusseau.bibliotheque.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Class in charge of defining Loan entity.
 * @Version Bibliotheque -v1,0
 * @date  23 oct. 2020 - 12:38:32
 * @author Claude LUSSEAU
 *
 */
@Entity
@Table(name = "Loan")
public class Loan {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
    
	@Column(name = "beginDate", nullable = false)
    private LocalDate beginDate;
    
	@Column(name = "endDate", nullable = false)
    private LocalDate endDate;
    
	@Enumerated(EnumType.STRING)
	@Column(name = "status")
    private LoanStatus status;
	
	@ManyToOne(targetEntity = Book.class, fetch = FetchType.LAZY )
	@JoinColumn(name="idBook", nullable=false)
	private Book book;
	
	@ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY )
	@JoinColumn(name="idUser", nullable=false)
	private User user;
	
	
	/**
	 * Constructor.
	 */
	public Loan() {
		super();
	}
	
	

	/**
	 * Constructor.
	 * @param beginDate
	 * @param endDate
	 * @param status
	 * @param book
	 * @param user
	 */
	public Loan(LocalDate beginDate, LocalDate endDate, LoanStatus status, Book book, User user) {
		super();
		this.beginDate = beginDate;
		this.endDate = endDate;
		this.status = status;
		this.book = book;
		this.user = user;
	}

	/**
	 * Constructor.
	 * @param id
	 * @param beginDate
	 * @param endDate
	 * @param status
	 * @param book
	 * @param user
	 */
	public Loan(Integer id, LocalDate beginDate, LocalDate endDate, LoanStatus status, Book book, User user) {
		super();
		this.id = id;
		this.beginDate = beginDate;
		this.endDate = endDate;
		this.status = status;
		this.book = book;
		this.user = user;
	}



	/**
	 * Method in charge of getting idLoan's value .
	 * @return the idLoan
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Method in charge of setting idLoan's value.
	 * @param idLoan the idLoan to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Method in charge of getting beginDate's value .
	 * @return the beginDate
	 */
	public LocalDate getBeginDate() {
		return beginDate;
	}

	/**
	 * Method in charge of setting beginDate's value.
	 * @param beginDate the beginDate to set
	 */
	public void setBeginDate(LocalDate beginDate) {
		this.beginDate = beginDate;
	}

	/**
	 * Method in charge of getting endDate's value .
	 * @return the endDate
	 */
	public LocalDate getEndDate() {
		return endDate;
	}

	/**
	 * Method in charge of setting endDate's value.
	 * @param endDate the endDate to set
	 */
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	/**
	 * Method in charge of getting status's value .
	 * @return the status
	 */
	public LoanStatus getStatus() {
		return status;
	}

	/**
	 * Method in charge of setting status's value.
	 * @param status the status to set
	 */
	public void setStatus(LoanStatus status) {
		this.status = status;
	}

}
