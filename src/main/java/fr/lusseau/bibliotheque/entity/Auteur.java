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

/**
 * Classe en charge de definir le bean Auteur.
 * @Version Bibliotheque -v1,0
 * @date  Aug 28, 2020 - 10:45:24 AM
 * @author Claude LUSSEAU
 *
 */
@Entity
@Table(name = "Auteur")
public class Auteur {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false, name = "idAuteur")
	private Integer idAuteur;
	
	@Column(nullable = false, name = "prenom")
	private String prenom;
	
	@Column(nullable = false, name = "nom")
	private String nom;
	
	@Column(nullable = false, name = "prenomNom")
	private String prenomNom = prenom + " " + nom;

	@ManyToMany(cascade = CascadeType.REFRESH, mappedBy = "auteurs", fetch = FetchType.LAZY)
	private Set<Livre> livres = new HashSet<Livre>();
	
	/**
	 * Constructeur.
	 */
	public Auteur() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Méthode en charge de récupérer la valeur de idAuteur.
	 * @return the idAuteur
	 */
	public Integer getIdAuteur() {
		return idAuteur;
	}

	/**
	 * Méthode en charge de définir la valeur de idAuteur.
	 * @param idAuteur the idAuteur to set
	 */
	public void setIdAuteur(Integer idAuteur) {
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
		prenomNom = this.prenom + " " + this.nom;
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
	 * @{inheritDoc}
	*/
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idAuteur;
		result = prime * result + ((livres == null) ? 0 : livres.hashCode());
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
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Auteur)) {
			return false;
		}
		Auteur other = (Auteur) obj;
		if (idAuteur != other.idAuteur) {
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
		if (prenom == null) {
			if (other.prenom != null) {
				return false;
			}
		} else if (!prenom.equals(other.prenom)) {
			return false;
		}
		if (prenomNom == null) {
			if (other.prenomNom != null) {
				return false;
			}
		} else if (!prenomNom.equals(other.prenomNom)) {
			return false;
		}
		return true;
	}
	
	
}
