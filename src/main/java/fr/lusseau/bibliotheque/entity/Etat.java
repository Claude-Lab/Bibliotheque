/**
 * 
 */
package fr.lusseau.bibliotheque.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * Classe en charge de definir le bean Etat.
 * @Version Bibliotheque -v1,0
 * @date  14 août 2020 - 10:46:34
 * @author Claude LUSSEAU
 *
 */
@Entity
public class Etat implements Serializable {

	private static final long serialVersionUID = 2594604817110521401L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idEtat;
	
	@NotBlank
	@Pattern(regexp = "^[a-zA-Z ]{3,20}$")
	private String libelle;
	
	@OneToMany(targetEntity = Livre.class, mappedBy = "etat", fetch = FetchType.LAZY)
	private List<Livre> livres;
	
	/**
	 * Constructeur.
	 */
	public Etat() {
		this(0, "", new ArrayList<>());
	}

	/**
	 * Constructeur.
	 * @param libelle
	 * @param livres
	 */
	public Etat(String libelle, List<Livre> livres) {
		super();
		this.libelle = libelle;
		this.livres = livres;
	}

	/**
	 * Constructeur.
	 * @param idEtat
	 * @param libelle
	 * @param livres
	 */
	public Etat(int idEtat, String libelle, List<Livre> livres) {
		super();
		this.idEtat = idEtat;
		this.libelle = libelle;
		this.livres = livres;
	}

	/**
	 * Méthode en charge de récupérer la valeur de idEtat.
	 * @return the idEtat
	 */
	public int getIdEtat() {
		return idEtat;
	}

	/**
	 * Méthode en charge de définir la valeur de idEtat.
	 * @param idEtat the idEtat to set
	 */
	public void setIdEtat(int idEtat) {
		this.idEtat = idEtat;
	}

	/**
	 * Méthode en charge de récupérer la valeur de libelle.
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}

	/**
	 * Méthode en charge de définir la valeur de libelle.
	 * @param libelle the libelle to set
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	/**
	 * Méthode en charge de récupérer la valeur de livres.
	 * @return the livres
	 */
	public List<Livre> getLivres() {
		return livres;
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
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Etat other = (Etat) obj;
		if (idEtat != other.idEtat)
			return false;
		if (libelle == null) {
			if (other.libelle != null)
				return false;
		} else if (!libelle.equals(other.libelle))
			return false;
		if (livres == null) {
			if (other.livres != null)
				return false;
		} else if (!livres.equals(other.livres))
			return false;
		return true;
	}

	/**
	 * @{inheritDoc}
	*/
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Etat [idEtat=");
		builder.append(idEtat);
		builder.append(", libelle=");
		builder.append(libelle);
		builder.append("]");
		return builder.toString();
	}

	
}
