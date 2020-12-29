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
import javax.validation.constraints.NotBlank;

/**
 * Class in charge of defining Category entity.
 * @Version Bibliotheque -v1,0
 * @date  23 oct. 2020 - 12:21:04
 * @author Claude LUSSEAU
 *
 */
@Entity
@Table(name = "Category")
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@NotBlank
	@Column(unique = true, nullable = false, name = "code")
	private String code;
	
	@NotBlank
	@Column(unique = true, nullable = false, name = "label")
	private String label;
	
	@ManyToMany(cascade = CascadeType.MERGE, mappedBy = "categories", fetch = FetchType.LAZY)
	private Set<Book> books = new HashSet<Book>();
	
	/**
	 * Constructor.
	 */
	public Category() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor.
	 * @param code
	 * @param label
	 */
	public Category(@NotBlank String code, @NotBlank String label) {
		this.label = label;
		this.code = code;
	}



	/**
	 * Constructor.
	 * @param code
	 * @param label
	 * @param books
	 */
	public Category(String code, @NotBlank String label, Set<Book> books) {
		super();
		this.code = code;
		this.label = label;
		this.books = books;
	}

	/**
	 * Constructor.
	 * @param idCategory
	 * @param code
	 * @param label
	 * @param books
	 */
	public Category(Integer id, String code, @NotBlank String label, Set<Book> books) {
		super();
		this.id = id;
		this.code = code;
		this.label = label;
		this.books = books;
	}

	/**
	 * Method in charge of getting idCategory's value .
	 * @return the idCategory
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Method in charge of setting idCategory's value.
	 * @param idCategory the idCategory to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Method in charge of getting code's value .
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Method in charge of setting code's value.
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
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
}
