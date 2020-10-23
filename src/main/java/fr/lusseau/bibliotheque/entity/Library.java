/**
 * 
 */
package fr.lusseau.bibliotheque.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Class in charge of defining Library entity.
 * @Version Bibliotheque -v1,0
 * @date  23 oct. 2020 - 12:10:29
 * @author Claude LUSSEAU
 *
 */
@Entity
@Table(name = "Library")
public class Library {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idLibrary")
	private int idLibrary;
	
	@Column(unique = true, name = "name")
	private String name;
	
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	@JoinColumn( name="idContact", nullable=false )
	private Contact contact;
	
	@OneToMany( targetEntity=Book.class, mappedBy="library", fetch = FetchType.LAZY)
	private Set<Book> books;
	
	/**
	 * Constructor.
	 */
	public Library() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor.
	 * @param name
	 * @param contact
	 * @param books
	 */
	public Library(String name, Contact contact, Set<Book> books) {
		this.name = name;
		this.contact = contact;
		this.books = books;
	}

	/**
	 * Constructor.
	 * @param idLibrary
	 * @param name
	 * @param contact
	 * @param books
	 */
	public Library(int idLibrary, String name, Contact contact, Set<Book> books) {
		this.idLibrary = idLibrary;
		this.name = name;
		this.contact = contact;
		this.books = books;
	}

	/**
	 * Method in charge of getting idLibrary's value .
	 * @return the idLibrary
	 */
	public int getIdLibrary() {
		return idLibrary;
	}

	/**
	 * Method in charge of setting idLibrary's value.
	 * @param idLibrary the idLibrary to set
	 */
	public void setIdLibrary(int idLibrary) {
		this.idLibrary = idLibrary;
	}

	/**
	 * Method in charge of getting name's value .
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Method in charge of setting name's value.
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Method in charge of getting contact's value .
	 * @return the contact
	 */
	public Contact getContact() {
		return contact;
	}

	/**
	 * Method in charge of setting contact's value.
	 * @param contact the contact to set
	 */
	public void setContact(Contact contact) {
		this.contact = contact;
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
		result = prime * result + idLibrary;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		if (!(obj instanceof Library)) {
			return false;
		}
		Library other = (Library) obj;
		if (books == null) {
			if (other.books != null) {
				return false;
			}
		} else if (!books.equals(other.books)) {
			return false;
		}
		if (idLibrary != other.idLibrary) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		return true;
	}
	
	
}
