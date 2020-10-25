/**
 * 
 */
package fr.lusseau.bibliotheque.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Class in charge of defining Author entity.
 * @Version Bibliotheque -v1,0
 * @date  23 oct. 2020 - 11:47:24
 * @author Claude LUSSEAU
 *
 */
@Entity
@Table(name = "Author")
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false, name = "idAuthor")
	private Integer idAuthor;
	
	@Column(nullable = false, name = "firstName")
	private String firstName;
	
	@Column(nullable = false, name = "lastName")
	private String lastName;
	
	@Transient
	private String fullName = firstName + " " + lastName;

	@ManyToMany(cascade = CascadeType.REFRESH, mappedBy = "authors", fetch = FetchType.LAZY)
	private Set<Book> books = new HashSet<Book>();
	
	/**
	 * Constructor.
	 */
	public Author() {
	}

	/**
	 * Constructor.
	 * @param firstName
	 * @param lastName
	 * @param firstLastName
	 * @param books
	 */
	public Author(String firstName, String lastName, String fullName, Set<Book> books) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.fullName = fullName;
		this.books = books;
	}

	/**
	 * Constructeur.
	 * @param idAuthor
	 * @param firstName
	 * @param lastName
	 * @param firstLastName
	 * @param books
	 */
	public Author(Integer idAuthor, String firstName, String lastName, String fullName, Set<Book> books) {
		this.idAuthor = idAuthor;
		this.firstName = firstName;
		this.lastName = lastName;
		this.fullName = fullName;
		this.books = books;
	}

	/**
	 * Method in charge of getting the value of idAuthor.
	 * @return the idAuthor
	 */
	public Integer getIdAuthor() {
		return idAuthor;
	}

	/**
	 * Method in charge of setting the value of idAuthor.
	 * @param idAuthor the idAuthor to set
	 */
	public void setIdAuthor(Integer idAuthor) {
		this.idAuthor = idAuthor;
	}

	/**
	 * Method in charge of getting the value of firstName.
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Method in charge of setting the value of firstName.
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Method in charge of getting the value of lastName.
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Method in charge of setting the value of lastName.
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Method in charge of getting the value of fullName.
	 * @return the fullName
	 */
	public String getFullName() {
		fullName = this.firstName + " " + this.lastName;
		return fullName;
	}

	/**
	 * Method in charge of setting the value of fullName.
	 * @param fullName the fullName to set
	 */
	public void setFullName(String fullName) {
		fullName = this.firstName + " " + this.lastName;
		this.fullName = fullName;
	}

	/**
	 * Method in charge of getting the value of books.
	 * @return the books
	 */
	public Set<Book> getBooks() {
		return books;
	}

	/**
	 * Method in charge of setting the value of books.
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
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((fullName == null) ? 0 : fullName.hashCode());
		result = prime * result + ((idAuthor == null) ? 0 : idAuthor.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
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
		if (!(obj instanceof Author)) {
			return false;
		}
		Author other = (Author) obj;
		if (books == null) {
			if (other.books != null) {
				return false;
			}
		} else if (!books.equals(other.books)) {
			return false;
		}
		if (firstName == null) {
			if (other.firstName != null) {
				return false;
			}
		} else if (!firstName.equals(other.firstName)) {
			return false;
		}
		if (fullName == null) {
			if (other.fullName != null) {
				return false;
			}
		} else if (!fullName.equals(other.fullName)) {
			return false;
		}
		if (idAuthor == null) {
			if (other.idAuthor != null) {
				return false;
			}
		} else if (!idAuthor.equals(other.idAuthor)) {
			return false;
		}
		if (lastName == null) {
			if (other.lastName != null) {
				return false;
			}
		} else if (!lastName.equals(other.lastName)) {
			return false;
		}
		return true;
	}

	
}
