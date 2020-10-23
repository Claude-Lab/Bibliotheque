/**
 * 
 */
package fr.lusseau.bibliotheque.dto.request;

import java.time.LocalDate;
import java.util.List;

import fr.lusseau.bibliotheque.entity.State;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Class in charge of defining .
 * @Version Bibliotheque -v1,0
 * @date  23 oct. 2020 - 18:41:25
 * @author Claude LUSSEAU
 *
 */
@ApiModel(value = "Create Book Model")
public class CreateBookRequest implements Comparable<CreateBookRequest> {
	
	@ApiModelProperty(value = "Book id")
	private Integer id;

	@ApiModelProperty(value = "Book title")
	private String title;
	
	@ApiModelProperty(value = "Book isbn")
	private String isbn;
	
	@ApiModelProperty(value = "Book release date by the editor")
	private LocalDate releaseDate;
	
	@ApiModelProperty(value = "Book register date in the library")
	private LocalDate registerDate;
	
	@ApiModelProperty(value = "Book total number of copies")
	private Integer nbOfCopies;
	
	@ApiModelProperty(value = "Book description")
	private String description;
	
	@ApiModelProperty(value = "Book author")
	private List<AuthorResponse> authors;
	
	@ApiModelProperty(value = "Book categories")
	private List<CategoryResponse> categories;
	
	@ApiModelProperty(value = "Book editor")
	private EditorResponse editor;
	
	@ApiModelProperty(value = "Book library")
	private LibraryResponse library;
	
	@ApiModelProperty(value = "Book state")
	private State state;

	/**
	 * Constructor.
	 */
	public CreateBookRequest() {
	}
	
	/**
	 * Constructor.
	 * @param title
	 * @param isbn
	 * @param releaseDate
	 * @param registerDate
	 * @param nbOfCopies
	 * @param description
	 * @param authors
	 * @param categories
	 * @param editor
	 * @param library
	 * @param state
	 */
	public CreateBookRequest(String title, String isbn, LocalDate releaseDate, LocalDate registerDate,
			Integer nbOfCopies, String description, List<AuthorResponse> authors, List<CategoryResponse> categories,
			EditorResponse editor, LibraryResponse library, State state) {
		super();
		this.title = title;
		this.isbn = isbn;
		this.releaseDate = releaseDate;
		this.registerDate = registerDate;
		this.nbOfCopies = nbOfCopies;
		this.description = description;
		this.authors = authors;
		this.categories = categories;
		this.editor = editor;
		this.library = library;
		this.state = state;
	}




	/**
	 * Method in charge of getting id's value .
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}



	/**
	 * Method in charge of setting id's value.
	 * @param id the id to set
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
	 * Method in charge of getting authors's value .
	 * @return the authors
	 */
	public List<AuthorResponse> getAuthors() {
		return authors;
	}



	/**
	 * Method in charge of setting authors's value.
	 * @param authors the authors to set
	 */
	public void setAuthors(List<AuthorResponse> authors) {
		this.authors = authors;
	}



	/**
	 * Method in charge of getting categories's value .
	 * @return the categories
	 */
	public List<CategoryResponse> getCategories() {
		return categories;
	}



	/**
	 * Method in charge of setting categories's value.
	 * @param categories the categories to set
	 */
	public void setCategories(List<CategoryResponse> categories) {
		this.categories = categories;
	}



	/**
	 * Method in charge of getting editor's value .
	 * @return the editor
	 */
	public EditorResponse getEditor() {
		return editor;
	}



	/**
	 * Method in charge of setting editor's value.
	 * @param editor the editor to set
	 */
	public void setEditor(EditorResponse editor) {
		this.editor = editor;
	}



	/**
	 * Method in charge of getting library's value .
	 * @return the library
	 */
	public LibraryResponse getLibrary() {
		return library;
	}



	/**
	 * Method in charge of setting library's value.
	 * @param library the library to set
	 */
	public void setLibrary(LibraryResponse library) {
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
	 * @{inheritDoc}
	*/
	@Override
	public int compareTo(CreateBookRequest o) {
		// TODO Auto-generated method stub
		return (o.getTitle() + o.getIsbn()).compareTo(this.title + this.isbn);
	}
	
	



}
