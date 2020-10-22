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
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Classe en charge de definir le bean Editeur.
 * @Version Bibliotheque -v1,0
 * @date  14 août 2020 - 10:24:58
 * @author Claude LUSSEAU
 *
 */
@Entity
@Table(name = "Editeur")
public class Editeur {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idEditeur")
	private int idEditeur;
	
	@Column(name = "nom", unique = true, nullable = false)
	private String nom;
	

	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	@JoinColumn(name="idCoordonnee", nullable=false )
	private Coordonnee coordonnee;
	
	@OneToMany(targetEntity = Livre.class, mappedBy = "editeur", fetch = FetchType.LAZY )
	private Set<Livre> livres = new HashSet<Livre>();
	
	/**
	 * Constructeur sans parametre.
	 */
	public Editeur() {
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
	@JsonValue
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
	 * @{inheritDoc}
	*/
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((coordonnee == null) ? 0 : coordonnee.hashCode());
		result = prime * result + idEditeur;
		result = prime * result + ((livres == null) ? 0 : livres.hashCode());
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
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
		if (!(obj instanceof Editeur)) {
			return false;
		}
		Editeur other = (Editeur) obj;
		if (coordonnee == null) {
			if (other.coordonnee != null) {
				return false;
			}
		} else if (!coordonnee.equals(other.coordonnee)) {
			return false;
		}
		if (idEditeur != other.idEditeur) {
			return false;
		}
		if (livres == null) {
			if (other.livres != null) {
				return false;
			}
		} else if (!livres.equals(other.livres)) {
			return false;
		}
		if (nom == null) {
			if (other.nom != null) {
				return false;
			}
		} else if (!nom.equals(other.nom)) {
			return false;
		}
		return true;
	}

	
}
