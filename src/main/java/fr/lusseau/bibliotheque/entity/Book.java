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
	@Column(name = "idBook")
	private Integer idBook;
	
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
		// TODO Auto-generated constructor stub
	}

	/**
	 * Method in charge of getting idBook's value .
	 * @return the idBook
	 */
	public Integer getIdBook() {
		return idBook;
	}

	/**
	 * Method in charge of setting idBook's value.
	 * @param idBook the idBook to set
	 */
	public void setIdBook(Integer idBook) {
		this.idBook = idBook;
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

	/**
	 * @{inheritDoc}
	*/
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((authors == null) ? 0 : authors.hashCode());
		result = prime * result + ((categories == null) ? 0 : categories.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((editor == null) ? 0 : editor.hashCode());
		result = prime * result + ((idBook == null) ? 0 : idBook.hashCode());
		result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
		result = prime * result + ((library == null) ? 0 : library.hashCode());
		result = prime * result + ((loans == null) ? 0 : loans.hashCode());
		result = prime * result + ((nbOfCopies == null) ? 0 : nbOfCopies.hashCode());
		result = prime * result + ((registerDate == null) ? 0 : registerDate.hashCode());
		result = prime * result + ((releaseDate == null) ? 0 : releaseDate.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		if (!(obj instanceof Book)) {
			return false;
		}
		Book other = (Book) obj;
		if (authors == null) {
			if (other.authors != null) {
				return false;
			}
		} else if (!authors.equals(other.authors)) {
			return false;
		}
		if (categories == null) {
			if (other.categories != null) {
				return false;
			}
		} else if (!categories.equals(other.categories)) {
			return false;
		}
		if (description == null) {
			if (other.description != null) {
				return false;
			}
		} else if (!description.equals(other.description)) {
			return false;
		}
		if (editor == null) {
			if (other.editor != null) {
				return false;
			}
		} else if (!editor.equals(other.editor)) {
			return false;
		}
		if (idBook == null) {
			if (other.idBook != null) {
				return false;
			}
		} else if (!idBook.equals(other.idBook)) {
			return false;
		}
		if (isbn == null) {
			if (other.isbn != null) {
				return false;
			}
		} else if (!isbn.equals(other.isbn)) {
			return false;
		}
		if (library == null) {
			if (other.library != null) {
				return false;
			}
		} else if (!library.equals(other.library)) {
			return false;
		}
		if (loans == null) {
			if (other.loans != null) {
				return false;
			}
		} else if (!loans.equals(other.loans)) {
			return false;
		}
		if (nbOfCopies == null) {
			if (other.nbOfCopies != null) {
				return false;
			}
		} else if (!nbOfCopies.equals(other.nbOfCopies)) {
			return false;
		}
		if (registerDate == null) {
			if (other.registerDate != null) {
				return false;
			}
		} else if (!registerDate.equals(other.registerDate)) {
			return false;
		}
		if (releaseDate == null) {
			if (other.releaseDate != null) {
				return false;
			}
		} else if (!releaseDate.equals(other.releaseDate)) {
			return false;
		}
		if (state == null) {
			if (other.state != null) {
				return false;
			}
		} else if (!state.equals(other.state)) {
			return false;
		}
		if (title == null) {
			if (other.title != null) {
				return false;
			}
		} else if (!title.equals(other.title)) {
			return false;
		}
		return true;
	}
	
	

}
