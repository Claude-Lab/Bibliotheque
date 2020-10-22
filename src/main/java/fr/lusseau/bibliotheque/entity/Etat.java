/**
 * 
 */
package fr.lusseau.bibliotheque.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Classe en charge de definir le bean Etat.
 * 
 * @Version Bibliotheque -v1,0
 * @date 14 août 2020 - 10:46:34
 * @author Claude LUSSEAU
 *
 */
@Entity
@Table(name = "Etat")
public class Etat {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idEtat")
	private int idEtat;

	@Column(name = "libelle", nullable = false)
	private String libelle;

	@OneToMany(targetEntity = Livre.class, mappedBy = "etat", fetch = FetchType.LAZY)
	private Set<Livre> livres = new HashSet<Livre>();

	/**
	 * Constructeur.
	 */
	public Etat() {
	}


	/**
	 * Méthode en charge de récupérer la valeur de idEtat.
	 * 
	 * @return the idEtat
	 */
	public int getIdEtat() {
		return idEtat;
	}

	/**
	 * Méthode en charge de définir la valeur de idEtat.
	 * 
	 * @param idEtat the idEtat to set
	 */
	public void setIdEtat(int idEtat) {
		this.idEtat = idEtat;
	}

	/**
	 * Méthode en charge de récupérer la valeur de libelle.
	 * 
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}

	/**
	 * Méthode en charge de définir la valeur de libelle.
	 * 
	 * @param libelle the libelle to set
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	/**
	 * Méthode en charge de récupérer la valeur de livres.
	 * 
	 * @return the livres
	 */
	public Set<Livre> getLivres() {
		return livres;
	}

	/**
	 * Méthode en charge de définir la valeur de livres.
	 * 
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
		result = prime * result + idEtat;
		result = prime * result + ((libelle == null) ? 0 : libelle.hashCode());
		result = prime * result + ((livres == null) ? 0 : livres.hashCode());
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
		if (!(obj instanceof Etat)) {
			return false;
		}
		Etat other = (Etat) obj;
		if (idEtat != other.idEtat) {
			return false;
		}
		if (libelle == null) {
			if (other.libelle != null) {
				return false;
			}
		} else if (!libelle.equals(other.libelle)) {
			return false;
		}
		if (livres == null) {
			if (other.livres != null) {
				return false;
			}
		} else if (!livres.equals(other.livres)) {
			return false;
		}
		return true;
	}
	
	

}
