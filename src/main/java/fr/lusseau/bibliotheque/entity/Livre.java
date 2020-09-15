/**
 * 
 */
package fr.lusseau.bibliotheque.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * Classe en charge de definir le bean Livre.
 * @Version Bibliotheque -v1,0
 * @date  Aug 28, 2020 - 10:46:55 AM
 * @author Claude LUSSEAU
 *
 */
@Entity
@JsonIdentityInfo(  generator = ObjectIdGenerators.PropertyGenerator.class, property = "idLivre")
public class Livre implements Serializable {

	private static final long serialVersionUID = 1245945350515863196L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idLivre;
	private String titre;
	
	@Column(unique = true)
	private String isbn;
	
	@Lob
	private String description;
	
	@ManyToMany(targetEntity= Style.class, cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@JoinTable(  name = "Livre_Style",
            joinColumns = @JoinColumn( name = "idLivre", referencedColumnName = "idLivre"),
            inverseJoinColumns = @JoinColumn( name = "idStyle", referencedColumnName = "idStyle" ) )
	private Set<Style> styles = new HashSet<Style>();
	

	@ManyToMany(targetEntity= Auteur.class, cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinTable( name = "Livre_Auteur",
                joinColumns = @JoinColumn( name = "idLivre", referencedColumnName = "idLivre" ),
                inverseJoinColumns = @JoinColumn( name = "idAuteur", referencedColumnName = "idAuteur" ) )
	private Set<Auteur> auteurs = new HashSet<Auteur>();
	
	@ManyToOne(targetEntity = Editeur.class, cascade = CascadeType.REFRESH, fetch = FetchType.LAZY) 
	@JoinColumn(name="idEditeur", nullable=false)
	private Editeur editeur;
	
	@ManyToOne(targetEntity = Bibliotheque.class, fetch = FetchType.LAZY )
	@JoinColumn(name="idBibliotheque", nullable=false)
	private Bibliotheque bibliotheque;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="idEtat", nullable=false)
	private Etat etat;
	
	@OneToMany( targetEntity=Emprunt.class, mappedBy="livre", fetch = FetchType.LAZY)
	private List<Emprunt> emprunts;
	
	
	/**
	 * Constructeur sans parametre.
	 */
	public Livre() {
		this("", "","", new HashSet<Style>(), new HashSet<Auteur>(), new Editeur(), new Bibliotheque(), new Etat(), new ArrayList<Emprunt>() );
	}


	/**
	 * Constructeur.
	 * @param titre
	 * @param isbn
	 * @param description
	 * @param styles
	 * @param auteurs
	 * @param editeur
	 * @param bibliotheque
	 * @param etat
	 * @param emprunts
	 */
	public Livre(String titre, String isbn, String description, Set<Style> styles, Set<Auteur> auteurs, Editeur editeur,
			Bibliotheque bibliotheque, Etat etat, List<Emprunt> emprunts) {
		super();
		this.titre = titre;
		this.isbn = isbn;
		this.description = description;
		this.styles = styles;
		this.auteurs = auteurs;
		this.editeur = editeur;
		this.bibliotheque = bibliotheque;
		this.etat = etat;
		this.emprunts = emprunts;
	}


	/**
	 * Constructeur.
	 * @param idLivre
	 * @param titre
	 * @param isbn
	 * @param description
	 * @param styles
	 * @param auteurs
	 * @param editeur
	 * @param bibliotheque
	 * @param etat
	 * @param emprunts
	 */
	public Livre(int idLivre, String titre, String isbn, String description, Set<Style> styles, Set<Auteur> auteurs,
			Editeur editeur, Bibliotheque bibliotheque, Etat etat, List<Emprunt> emprunts) {
		super();
		this.idLivre = idLivre;
		this.titre = titre;
		this.isbn = isbn;
		this.description = description;
		this.styles = styles;
		this.auteurs = auteurs;
		this.editeur = editeur;
		this.bibliotheque = bibliotheque;
		this.etat = etat;
		this.emprunts = emprunts;
	}


	/**
	 * Méthode en charge de récupérer la valeur de idLivre.
	 * @return the idLivre
	 */
	public int getIdLivre() {
		return idLivre;
	}


	/**
	 * Méthode en charge de définir la valeur de idLivre.
	 * @param idLivre the idLivre to set
	 */
	public void setIdLivre(int idLivre) {
		this.idLivre = idLivre;
	}


	/**
	 * Méthode en charge de récupérer la valeur de titre.
	 * @return the titre
	 */
	public String getTitre() {
		return titre;
	}


	/**
	 * Méthode en charge de définir la valeur de titre.
	 * @param titre the titre to set
	 */
	public void setTitre(String titre) {
		this.titre = titre;
	}


	/**
	 * Méthode en charge de récupérer la valeur de isbn.
	 * @return the isbn
	 */
	public String getIsbn() {
		return isbn;
	}


	/**
	 * Méthode en charge de définir la valeur de isbn.
	 * @param isbn the isbn to set
	 */
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}


	/**
	 * Méthode en charge de récupérer la valeur de description.
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}


	/**
	 * Méthode en charge de définir la valeur de description.
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}


	/**
	 * Méthode en charge de récupérer la valeur de styles.
	 * @return the styles
	 */
	public Set<Style> getStyles() {
		return styles;
	}


	/**
	 * Méthode en charge de définir la valeur de styles.
	 * @param styles the styles to set
	 */
	public void setStyles(Set<Style> styles) {
		this.styles = styles;
	}


	/**
	 * Méthode en charge de récupérer la valeur de auteurs.
	 * @return the auteurs
	 */
	public Set<Auteur> getAuteurs() {
		return auteurs;
	}


	/**
	 * Méthode en charge de définir la valeur de auteurs.
	 * @param auteurs the auteurs to set
	 */
	public void setAuteurs(Set<Auteur> auteurs) {
		this.auteurs = auteurs;
	}


	/**
	 * Méthode en charge de récupérer la valeur de editeur.
	 * @return the editeur
	 */
	public Editeur getEditeur() {
		return editeur;
	}


	/**
	 * Méthode en charge de définir la valeur de editeur.
	 * @param editeur the editeur to set
	 */
	public void setEditeur(Editeur editeur) {
		this.editeur = editeur;
	}


	/**
	 * Méthode en charge de récupérer la valeur de bibliotheque.
	 * @return the bibliotheque
	 */
	public Bibliotheque getBibliotheque() {
		return bibliotheque;
	}


	/**
	 * Méthode en charge de définir la valeur de bibliotheque.
	 * @param bibliotheque the bibliotheque to set
	 */
	public void setBibliotheque(Bibliotheque bibliotheque) {
		this.bibliotheque = bibliotheque;
	}


	/**
	 * Méthode en charge de récupérer la valeur de etat.
	 * @return the etat
	 */
	public Etat getEtat() {
		return etat;
	}


	/**
	 * Méthode en charge de définir la valeur de etat.
	 * @param etat the etat to set
	 */
	public void setEtat(Etat etat) {
		this.etat = etat;
	}


	/**
	 * Méthode en charge de récupérer la valeur de emprunts.
	 * @return the emprunts
	 */
	public List<Emprunt> getEmprunts() {
		return emprunts;
	}


	/**
	 * Méthode en charge de définir la valeur de emprunts.
	 * @param emprunts the emprunts to set
	 */
	public void setEmprunts(List<Emprunt> emprunts) {
		this.emprunts = emprunts;
	}


	/**
	 * Méthode en charge de récupérer la valeur de serialversionuid.
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	/**
	 * @{inheritDoc}
	*/
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Livre [idLivre=");
		builder.append(idLivre);
		builder.append(", titre=");
		builder.append(titre);
		builder.append(", isbn=");
		builder.append(isbn);
		builder.append(", description=");
		builder.append(description);
		return builder.toString();
	}
	
}
