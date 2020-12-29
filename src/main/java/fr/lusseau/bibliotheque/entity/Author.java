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
	@Column(name = "id")
	private Integer id;
	
	@Column(nullable = false, name = "firstname")
	private String firstname;
	
	@Column(nullable = false, name = "lastname")
	private String lastname;
	
	@Column(nullable = false, name = "fullname")
	private String fullname = (firstname + " " + lastname);

	@ManyToMany(cascade = CascadeType.MERGE, mappedBy = "authors", fetch = FetchType.LAZY)
	private Set<Book> books = new HashSet<Book>();
	
	/**
	 * Constructor.
	 */
	public Author() {
	}
	
	/**
	 * Constructor.
	 * @param firstname
	 * @param lastname
	 * @param fullname
	 */
	public Author(String firstname, String lastname, String fullname) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.fullname = fullname;
	}

	
	/**
	 * Constructor.
	 * @param firstname
	 * @param lastname
	 * @param fullname
	 * @param books
	 */
	public Author(String firstname, String lastname, String fullname, Set<Book> books) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.fullname = fullname;
		this.books = books;
	}

	
	/**
	 * Constructor.
	 * @param id
	 * @param firstname
	 * @param lastname
	 * @param fullname
	 * @param books
	 */
	public Author(Integer id, String firstname, String lastname, String fullname, Set<Book> books) {
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.fullname = fullname;
		this.books = books;
	}

	
	/**
	 * Method in charge of 
	 * @return
	 */
	public Integer getId() {
		return id;
	}

	
	/**
	 * Method in charge of 
	 * @param id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Method in charge of getting the value of firstname.
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * Method in charge of setting the value of firstname.
	 * @param firstname the firstname to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 * Method in charge of getting the value of lastname.
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * Method in charge of setting the value of lastname.
	 * @param lastname the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * Method in charge of getting the value of fullname.
	 * @return the fullname
	 */
	public String getFullname() {
		return new String(this.firstname + " " + this.lastname);
	}

	/**
	 * Method in charge of setting the value of fullname.
	 * @param fullname the fullname to set
	 */
	public void setFullname(String fullname) {
		this.fullname = fullname;
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

}
