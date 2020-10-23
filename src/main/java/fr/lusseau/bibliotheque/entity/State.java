/**
 * 
 */
package fr.lusseau.bibliotheque.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Class in charge of defining State entity.
 * @Version Bibliotheque -v1,0
 * @date  23 oct. 2020 - 12:14:25
 * @author Claude LUSSEAU
 *
 */
@Entity
@Table(name = "State")
public class State {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idState")
	private int idState;

	@Column(name = "label", nullable = false)
	private String label;

	@OneToMany(targetEntity = Book.class, mappedBy = "state", fetch = FetchType.LAZY)
	private Set<Book> books = new HashSet<Book>();
	
	/**
	 * Constructor.
	 */
	public State() {
		
	}

	/**
	 * Constructor.
	 * @param label
	 * @param books
	 */
	public State(String label, Set<Book> books) {
		this.label = label;
		this.books = books;
	}

	/**
	 * Constructor.
	 * @param idState
	 * @param label
	 * @param books
	 */
	public State(int idState, String label, Set<Book> books) {
		this.idState = idState;
		this.label = label;
		this.books = books;
	}

	/**
	 * Method in charge of getting idState's value .
	 * @return the idState
	 */
	public int getIdState() {
		return idState;
	}

	/**
	 * Method in charge of setting idState's value.
	 * @param idState the idState to set
	 */
	public void setIdState(int idState) {
		this.idState = idState;
	}

	/**
	 * Method in charge of getting label's value .
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * Method in charge of setting label's value.
	 * @param label the label to set
	 */
	public void setLabel(String label) {
		this.label = label;
	}

	/**
	 * Method in charge of getting books's value .
	 * @return the books
	 */
	public Set<Book> getBooks() {
		return books;
	}

	/**
	 * Method in charge of setting books's value.
	 * @param books the books to set
	 */
	public void setBooks(Set<Book> books) {
		this.books = books;
	}

	/**
	 * @{inheritDoc}
	*/
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((books == null) ? 0 : books.hashCode());
		result = prime * result + idState;
		result = prime * result + ((label == null) ? 0 : label.hashCode());
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
		if (!(obj instanceof State)) {
			return false;
		}
		State other = (State) obj;
		if (books == null) {
			if (other.books != null) {
				return false;
			}
		} else if (!books.equals(other.books)) {
			return false;
		}
		if (idState != other.idState) {
			return false;
		}
		if (label == null) {
			if (other.label != null) {
				return false;
			}
		} else if (!label.equals(other.label)) {
			return false;
		}
		return true;
	}

}
