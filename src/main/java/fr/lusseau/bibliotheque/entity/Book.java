/**
 * 
 */
package fr.lusseau.bibliotheque.entity;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Class in charge of defining Book entity.
 * @Version Bibliotheque -v1,0
 * @date  23 oct. 2020 - 11:39:40
 * @author Claude LUSSEAU
 *
 */
@Entity
@Table(name = "Book")
public class Book  {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "title", nullable = false)
	private String title;
	
	@Column(unique = true, name = "isbn", nullable = false)
	private String isbn;
	
	@Column(name = "releaseDate", nullable = false)
	private LocalDate releaseDate;
	
	@Column(name = "registerDate", nullable = false)
	private LocalDate registerDate;
	
	@Column(name = "nbOfCopies")
	private Integer nbOfCopies;
	
	@ManyToMany(fetch = FetchType.LAZY)
    @JoinTable( name = "book_Author",
                joinColumns = @JoinColumn( name = "idBook"),
                inverseJoinColumns = @JoinColumn( name = "idAuthor"))
	private Set<Author> authors = new HashSet<Author>();
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(  name = "book_Category",
            joinColumns = @JoinColumn( name = "idBook"),
            inverseJoinColumns = @JoinColumn( name = "idCategory"))
	private Set<Category> categories = new HashSet<Category>();
	
	@Lob
	@Column(name = "description", nullable = false)
	private String description;
	
	
	@ManyToOne(optional = false) 
	@JoinColumn(name="idEditor", nullable=false)
	private Editor editor;
	
	@ManyToOne(optional = false)
	@JoinColumn(name="idLibrary", nullable=false)
	private Library library;
	
	@ManyToOne(optional = false)
	@JoinColumn(name="idState", nullable=false)
	private State state;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "book", cascade = CascadeType.ALL)
	Set<Loan> loans = new HashSet<Loan>();
	
	/**
	 * Constructor.
	 */
	public Book() {
		super();
	}
	

	/**
	 * Constructor.
	 * @param title
	 * @param isbn
	 * @param releaseDate
	 * @param registerDate
	 * @param nbOfCopies
	 * @param authors
	 * @param categories
	 * @param description
	 * @param editor
	 * @param library
	 * @param state
	 * @param loans
	 */
	public Book(String title, String isbn, LocalDate releaseDate, LocalDate registerDate, Integer nbOfCopies,
			Set<Author> authors, Set<Category> categories, String description, Editor editor, Library library,
			State state, Set<Loan> loans) {
		super();
		this.title = title;
		this.isbn = isbn;
		this.releaseDate = releaseDate;
		this.registerDate = registerDate;
		this.nbOfCopies = nbOfCopies;
		this.authors = authors;
		this.categories = categories;
		this.description = description;
		this.editor = editor;
		this.library = library;
		this.state = state;
		this.loans = loans;
	}


	/**
	 * Constructor.
	 * @param id
	 * @param title
	 * @param isbn
	 * @param releaseDate
	 * @param registerDate
	 * @param nbOfCopies
	 * @param authors
	 * @param categories
	 * @param description
	 * @param editor
	 * @param library
	 * @param state
	 * @param loans
	 */
	public Book(Integer id, String title, String isbn, LocalDate releaseDate, LocalDate registerDate,
			Integer nbOfCopies, Set<Author> authors, Set<Category> categories, String description, Editor editor,
			Library library, State state, Set<Loan> loans) {
		super();
		this.id = id;
		this.title = title;
		this.isbn = isbn;
		this.releaseDate = releaseDate;
		this.registerDate = registerDate;
		this.nbOfCopies = nbOfCopies;
		this.authors = authors;
		this.categories = categories;
		this.description = description;
		this.editor = editor;
		this.library = library;
		this.state = state;
		this.loans = loans;
	}


	/**
	 * Method in charge of getting idBook's value .
	 * @return the idBook
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Method in charge of setting idBook's value.
	 * @param idBook the idBook to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Method in charge of getting title's value .
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Method in charge of setting title's value.
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Method in charge of getting isbn's value .
	 * @return the isbn
	 */
	public String getIsbn() {
		return isbn;
	}

	/**
	 * Method in charge of setting isbn's value.
	 * @param isbn the isbn to set
	 */
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	/**
	 * Method in charge of getting releaseDate's value .
	 * @return the releaseDate
	 */
	public LocalDate getReleaseDate() {
		return releaseDate;
	}

	/**
	 * Method in charge of setting releaseDate's value.
	 * @param releaseDate the releaseDate to set
	 */
	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}

	/**
	 * Method in charge of getting registerDate's value .
	 * @return the registerDate
	 */
	public LocalDate getRegisterDate() {
		return registerDate;
	}

	/**
	 * Method in charge of setting registerDate's value.
	 * @param registerDate the registerDate to set
	 */
	public void setRegisterDate(LocalDate registerDate) {
		this.registerDate = registerDate;
	}

	/**
	 * Method in charge of getting nbOfCopies's value .
	 * @return the nbOfCopies
	 */
	public Integer getNbOfCopies() {
		return nbOfCopies;
	}

	/**
	 * Method in charge of setting nbOfCopies's value.
	 * @param nbOfCopies the nbOfCopies to set
	 */
	public void setNbOfCopies(Integer nbOfCopies) {
		this.nbOfCopies = nbOfCopies;
	}

	/**
	 * Method in charge of getting authors's value .
	 * @return the authors
	 */
	public Set<Author> getAuthors() {
		return authors;
	}

	/**
	 * Method in charge of setting authors's value.
	 * @param authors the authors to set
	 */
	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}

	/**
	 * Method in charge of getting categories's value .
	 * @return the categories
	 */
	public Set<Category> getCategories() {
		return categories;
	}

	/**
	 * Method in charge of setting categories's value.
	 * @param categories the categories to set
	 */
	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}

	/**
	 * Method in charge of getting description's value .
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Method in charge of setting description's value.
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Method in charge of getting editor's value .
	 * @return the editor
	 */
	public Editor getEditor() {
		return editor;
	}

	/**
	 * Method in charge of setting editor's value.
	 * @param editor the editor to set
	 */
	public void setEditor(Editor editor) {
		this.editor = editor;
	}

	/**
	 * Method in charge of getting library's value .
	 * @return the library
	 */
	public Library getLibrary() {
		return library;
	}

	/**
	 * Method in charge of setting library's value.
	 * @param library the library to set
	 */
	public void setLibrary(Library library) {
		this.library = library;
	}

	/**
	 * Method in charge of getting state's value .
	 * @return the state
	 */
	public State getState() {
		return state;
	}

	/**
	 * Method in charge of setting state's value.
	 * @param state the state to set
	 */
	public void setState(State state) {
		this.state = state;
	}

	/**
	 * Method in charge of getting loans's value .
	 * @return the loans
	 */
	public Set<Loan> getLoans() {
		return loans;
	}

	/**
	 * Method in charge of setting loans's value.
	 * @param loans the loans to set
	 */
	public void setLoans(Set<Loan> loans) {
		this.loans = loans;
	}

	
}
