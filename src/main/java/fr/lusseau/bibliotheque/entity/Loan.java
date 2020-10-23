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
	@Column(name = "idLoan")
	private Integer idLoan;
    
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
		// TODO Auto-generated constructor stub
	}

	/**
	 * Method in charge of getting idLoan's value .
	 * @return the idLoan
	 */
	public Integer getIdLoan() {
		return idLoan;
	}

	/**
	 * Method in charge of setting idLoan's value.
	 * @param idLoan the idLoan to set
	 */
	public void setIdLoan(Integer idLoan) {
		this.idLoan = idLoan;
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
	public EmpruntStatus getStatus() {
		return status;
	}

	/**
	 * Method in charge of setting status's value.
	 * @param status the status to set
	 */
	public void setStatus(EmpruntStatus status) {
		this.status = status;
	}

	/**
	 * Method in charge of getting book's value .
	 * @return the book
	 */
	public Book getBook() {
		return book;
	}

	/**
	 * Method in charge of setting book's value.
	 * @param book the book to set
	 */
	public void setBook(Book book) {
		this.book = book;
	}

	/**
	 * Method in charge of getting user's value .
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * Method in charge of setting user's value.
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @{inheritDoc}
	*/
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((beginDate == null) ? 0 : beginDate.hashCode());
		result = prime * result + ((book == null) ? 0 : book.hashCode());
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + ((idLoan == null) ? 0 : idLoan.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	/**
	 * @{inheritDoc}
	*/
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Loan)) {
			return false;
		}
		Loan other = (Loan) obj;
		if (beginDate == null) {
			if (other.beginDate != null) {
				return false;
			}
		} else if (!beginDate.equals(other.beginDate)) {
			return false;
		}
		if (book == null) {
			if (other.book != null) {
				return false;
			}
		} else if (!book.equals(other.book)) {
			return false;
		}
		if (endDate == null) {
			if (other.endDate != null) {
				return false;
			}
		} else if (!endDate.equals(other.endDate)) {
			return false;
		}
		if (idLoan == null) {
			if (other.idLoan != null) {
				return false;
			}
		} else if (!idLoan.equals(other.idLoan)) {
			return false;
		}
		if (status != other.status) {
			return false;
		}
		if (user == null) {
			if (other.user != null) {
				return false;
			}
		} else if (!user.equals(other.user)) {
			return false;
		}
		return true;
	}
	
	

}
