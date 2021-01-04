/**
 * 
 */
package fr.lusseau.bibliotheque.dto.request;

import java.time.LocalDate;

import org.springframework.hateoas.server.core.Relation;

import fr.lusseau.bibliotheque.entity.Editor;
import fr.lusseau.bibliotheque.entity.Library;
import fr.lusseau.bibliotheque.entity.State;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Class in charge of defining .
 * @Version Bibliotheque -v1,0
 * @date  25 oct. 2020 - 12:20:21
 * @author Claude LUSSEAU
 *
 */
@Relation(value = "book", collectionRelation = "books")
@ApiModel(value = "Request Book Model")
public class BookRequest  {

	@ApiModelProperty(value = "Book id")
	private Integer id;
	
	@ApiModelProperty(value = "Book title")
	private String title;
	
	@ApiModelProperty(value = "Book isbn")
	private String isbn;
	
	@ApiModelProperty(value = "Book releaseDate")
	private LocalDate releaseDate;
	
	@ApiModelProperty(value = "Book registerDate")
	private LocalDate registerDate;
	
	@ApiModelProperty(value = "Book nbOfCopies")
	private Integer nbOfCopies;
	
	@ApiModelProperty(value = "Book description")
	private String description;
	
	@ApiModelProperty(value = "Book editor")
	private Editor editor;
	
	@ApiModelProperty(value = "Book state")
	private State state;
	
	@ApiModelProperty(value = "Book library")
	private Library library;
	
	
	/**
	 * Constructor.
	 */
	public BookRequest() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor.
	 * @param title
	 * @param isbn
	 * @param releaseDate
	 * @param registerDate
	 * @param nbOfCopies
	 * @param description
	 * @param editor
	 * @param state
	 * @param library
	 */
	public BookRequest(String title, String isbn, LocalDate releaseDate, LocalDate registerDate, Integer nbOfCopies,
			String description, Editor editor, State state, Library library) {
		super();
		this.title = title;
		this.isbn = isbn;
		this.releaseDate = releaseDate;
		this.registerDate = registerDate;
		this.nbOfCopies = nbOfCopies;
		this.description = description;
		this.editor = editor;
		this.state = state;
		this.library = library;
	}

	/**
	 * Constructor.
	 * @param idBook
	 * @param title
	 * @param isbn
	 * @param releaseDate
	 * @param registerDate
	 * @param nbOfCopies
	 * @param description
	 * @param editor
	 * @param state
	 * @param library
	 */
	public BookRequest(Integer id, String title, String isbn, LocalDate releaseDate, LocalDate registerDate,
			Integer nbOfCopies, String description, Editor editor, State state, Library library) {
		super();
		this.id = id;
		this.title = title;
		this.isbn = isbn;
		this.releaseDate = releaseDate;
		this.registerDate = registerDate;
		this.nbOfCopies = nbOfCopies;
		this.description = description;
		this.editor = editor;
		this.state = state;
		this.library = library;
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

	
}
