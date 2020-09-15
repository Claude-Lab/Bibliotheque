/**
 * 
 */
package fr.lusseau.bibliotheque.entity;

import java.io.Serializable;
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
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * Classe en charge de definir le bean Auteur.
 * @Version Bibliotheque -v1,0
 * @date  Aug 28, 2020 - 10:45:24 AM
 * @author Claude LUSSEAU
 *
 */
@Entity
@JsonIdentityInfo(  generator = ObjectIdGenerators.PropertyGenerator.class, property = "idAuteur")
public class Auteur implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false)
	private int idAuteur;
	
	private String prenom;
	private String nom;
	
	@Transient
	@JsonIgnore
	private String prenomNom = prenom + " " + nom;
	
	@JsonIgnore 
	@ManyToMany(cascade = {CascadeType.REFRESH}, mappedBy = "auteurs",targetEntity = Livre.class, fetch = FetchType.LAZY)
	private Set<Livre> livres = new HashSet<Livre>();
	
	/**
	 * Constructeur.
	 */
	public Auteur() {
		this("", "", new HashSet<Livre>());
	}

	/**
	 * Constructeur.
	 * @param prenom
	 * @param nom
	 * @param prenomNom
	 * @param livres
	 */
	public Auteur(String prenom, String nom, Set<Livre> livres) {
		super();
		this.prenom = prenom;
		this.nom = nom;
		this.livres = livres;
	}

	/**
	 * Constructeur.
	 * @param idAuteur
	 * @param prenom
	 * @param nom
	 * @param prenomNom
	 * @param livres
	 */
	public Auteur(int idAuteur, String prenom, String nom, Set<Livre> livres) {
		super();
		this.idAuteur = idAuteur;
		this.prenom = prenom;
		this.nom = nom;
		this.livres = livres;
	}

	/**
	 * Méthode en charge de récupérer la valeur de idAuteur.
	 * @return the idAuteur
	 */
	public int getIdAuteur() {
		return idAuteur;
	}

	/**
	 * Méthode en charge de définir la valeur de idAuteur.
	 * @param idAuteur the idAuteur to set
	 */
	public void setIdAuteur(int idAuteur) {
		this.idAuteur = idAuteur;
	}

	/**
	 * Méthode en charge de récupérer la valeur de prenom.
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * Méthode en charge de définir la valeur de prenom.
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
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
	 * Méthode en charge de récupérer la valeur de prenomNom.
	 * @return the prenomNom
	 */
	public String getPrenomNom() {
		prenomNom = this.prenom + " " + this.nom;
		return prenomNom;
	}

	/**
	 * Méthode en charge de définir la valeur de prenomNom.
	 * @param prenomNom the prenomNom to set
	 */
	public void setPrenomNom(String prenomNom) {
		this.prenomNom = prenomNom;
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
		final int prime = 31;
		int result = 1;
		result = prime * result + idAuteur;
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((prenom == null) ? 0 : prenom.hashCode());
		result = prime * result + ((prenomNom == null) ? 0 : prenomNom.hashCode());
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
		Auteur other = (Auteur) obj;
		if (idAuteur != other.idAuteur)
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
		if (prenom == null) {
			if (other.prenom != null)
				return false;
		} else if (!prenom.equals(other.prenom))
			return false;
		if (prenomNom == null) {
			if (other.prenomNom != null)
				return false;
		} else if (!prenomNom.equals(other.prenomNom))
			return false;
		return true;
	}

	/**
	 * @{inheritDoc}
	*/
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Auteur [idAuteur=");
		builder.append(idAuteur);
		builder.append(", prenom=");
		builder.append(prenom);
		builder.append(", nom=");
		builder.append(nom);
		builder.append(", prenomNom=");
		builder.append(prenomNom);
		builder.append("]");
		return builder.toString();
	}

}
