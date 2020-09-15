/**
 * 
 */
package fr.lusseau.bibliotheque.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
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

/**
 * Classe en charge de definir le bean Editeur.
 * @Version Bibliotheque -v1,0
 * @date  14 août 2020 - 10:24:58
 * @author Claude LUSSEAU
 *
 */
@Entity
public class Editeur implements Serializable {

	private static final long serialVersionUID = 8814187156805386282L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idEditeur;
	
	@Column(unique = true)
	private String nom;
	
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	@JoinColumn( name="idCoordonnee", nullable=false )
	private Coordonnee coordonnee;
	
	@OneToMany(targetEntity = Livre.class, mappedBy = "editeur", fetch = FetchType.LAZY )
	private Set<Livre> livres;
	
	/**
	 * Constructeur sans parametre.
	 */
	public Editeur() {
		this(0, "", new Coordonnee(), new HashSet<Livre>());
	}

	/**
	 * Constructeur.
	 * @param nom
	 * @param coordonnees
	 * @param livres
	 */
	public Editeur(String nom, Coordonnee coordonnee, Set<Livre> livres) {
		super();
		this.nom = nom;
		this.coordonnee = coordonnee;
		this.livres = livres;
	}

	/**
	 * Constructeur.
	 * @param idEditeur
	 * @param nom
	 * @param coordonnees
	 * @param livres
	 */
	public Editeur(int idEditeur, String nom, Coordonnee coordonnee, Set<Livre> livres) {
		super();
		this.idEditeur = idEditeur;
		this.nom = nom;
		this.coordonnee = coordonnee;
		this.livres = livres;
	}

	/**
	 * Méthode en charge de récupérer la valeur de idEditeur.
	 * @return the idEditeur
	 */
	public int getIdEditeur() {
		return idEditeur;
	}

	/**
	 * Méthode en charge de définir la valeur de idEditeur.
	 * @param idEditeur the idEditeur to set
	 */
	public void setIdEditeur(int idEditeur) {
		this.idEditeur = idEditeur;
	}

	/**
	 * Méthode en charge de récupérer la valeur de nom.
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Méthode en charge de définir la valeur de nom.
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Méthode en charge de récupérer la valeur de coordonnees.
	 * @return the coordonnees
	 */
	public Coordonnee getCoordonnee() {
		return coordonnee;
	}

	/**
	 * Méthode en charge de définir la valeur de coordonnees.
	 * @param coordonnees the coordonnees to set
	 */
	public void setCoordonnee(Coordonnee coordonnee) {
		this.coordonnee = coordonnee;
	}

	/**
	 * Méthode en charge de récupérer la valeur de livres.
	 * @return the livres
	 */
	public Set<Livre> getLivres() {
		return livres;
	}

	/**
	 * Méthode en charge de définir la valeur de livres.
	 * @param livres the livres to set
	 */
	public void setLivres(Set<Livre> livres) {
		this.livres = livres;
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
	public int hashCode() {
		return Objects.hash(coordonnee, idEditeur, livres, nom);
	}

	/**
	 * @{inheritDoc}
	*/
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Editeur other = (Editeur) obj;
		return Objects.equals(coordonnee, other.coordonnee) && idEditeur == other.idEditeur
				&& Objects.equals(livres, other.livres) && Objects.equals(nom, other.nom);
	}

	/**
	 * @{inheritDoc}
	*/
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Editeur [idEditeur=");
		builder.append(idEditeur);
		builder.append(", nom=");
		builder.append(nom);
		builder.append("]");
		return builder.toString();
	}

	
}
