/**
 * 
 */
package fr.lusseau.bibliotheque.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 * Classe en charge de
 * @Version Bibliotheque -v1,0
 * @date  Aug 28, 2020 - 10:45:40 AM
 * @author Claude LUSSEAU
 *
 */
@Entity
public class Bibliotheque implements Serializable {

	private static final long serialVersionUID = 7887547268848737456L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idBibliotheque;
	
	@Column(unique = true)
	private String nom;
	
	@OneToOne( cascade = CascadeType.ALL )
	@JoinColumn( name="idCoordonnee", nullable=false )
	private Coordonnee coordonnee;
	
	@OneToMany( targetEntity=Livre.class, mappedBy="bibliotheque" )
	private List<Livre> livres;
	
	/**
	 * Constructeur.
	 */
	public Bibliotheque() {
		this(0, "", new Coordonnee(), new ArrayList<>());
	}

	/**
	 * Constructeur.
	 * @param nom
	 * @param coordonnees
	 * @param livres
	 */
	public Bibliotheque(String nom, Coordonnee coordonnee, List<Livre> livres) {
		super();
		this.nom = nom;
		this.coordonnee = coordonnee;
		this.livres = livres;
	}

	/**
	 * Constructeur.
	 * @param idBibliotheque
	 * @param nom
	 * @param coordonnees
	 * @param livres
	 */
	public Bibliotheque(int idBibliotheque, String nom, Coordonnee coordonnee, List<Livre> livres) {
		super();
		this.idBibliotheque = idBibliotheque;
		this.nom = nom;
		this.coordonnee = coordonnee;
		this.livres = livres;
	}

	/**
	 * Méthode en charge de récupérer la valeur de idBibliotheque.
	 * @return the idBibliotheque
	 */
	public int getIdBibliotheque() {
		return this.idBibliotheque;
	}

	/**
	 * Méthode en charge de définir la valeur de idBibliotheque.
	 * @param idBibliotheque the idBibliotheque to set
	 */
	public void setIdBibliotheque(int idBibliotheque) {
		this.idBibliotheque = idBibliotheque;
	}

	/**
	 * Méthode en charge de récupérer la valeur de nom.
	 * @return the nom
	 */
	public String getNom() {
		return this.nom;
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
		return this.coordonnee;
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
	public List<Livre> getLivres() {
		return this.livres;
	}

	/**
	 * Méthode en charge de définir la valeur de livres.
	 * @param livres the livres to set
	 */
	public void setLivres(List<Livre> livres) {
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
		final int prime = 31;
		int result = 1;
		result = prime * result + ((coordonnee == null) ? 0 : coordonnee.hashCode());
		result = prime * result + idBibliotheque;
		result = prime * result + ((livres == null) ? 0 : livres.hashCode());
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		return result;
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
		Bibliotheque other = (Bibliotheque) obj;
		if (coordonnee == null) {
			if (other.coordonnee != null)
				return false;
		} else if (!coordonnee.equals(other.coordonnee))
			return false;
		if (idBibliotheque != other.idBibliotheque)
			return false;
		if (livres == null) {
			if (other.livres != null)
				return false;
		} else if (!livres.equals(other.livres))
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		return true;
	}

	/**
	 * @{inheritDoc}
	*/
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Bibliotheque [idBibliotheque=");
		builder.append(idBibliotheque);
		builder.append(", nom=");
		builder.append(nom);
		builder.append("]");
		return builder.toString();
	}

	
}

