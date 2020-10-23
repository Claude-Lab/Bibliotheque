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
public class Book {
	
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
	
	@ManyToMany(targetEntity= Author.class, cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinTable( name = "book_Author",
                joinColumns = @JoinColumn( name = "idBook", referencedColumnName = "idBook" ),
                inverseJoinColumns = @JoinColumn( name = "idAuthor", referencedColumnName = "idAuthor" ))
	private Set<Author> authors = new HashSet<Author>();
	
	@ManyToMany(targetEntity= Category.class, cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@JoinTable(  name = "book__Category",
            joinColumns = @JoinColumn( name = "idBook", referencedColumnName = "idBook"),
            inverseJoinColumns = @JoinColumn( name = "code", referencedColumnName = "code" ))
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
	

}
