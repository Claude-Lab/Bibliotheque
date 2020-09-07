/**
 * 
 */
package fr.lusseau.bibliotheque.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

/**
 * Classe en charge de
 * @Version Bibliotheque -v1,0
 * @date  7 sept. 2020 - 08:59:13
 * @author Claude LUSSEAU
 *
 */
@Entity
public class Type implements Serializable {

	private static final long serialVersionUID = 8350639088866797309L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idType;
	
	@NotNull
	private String libelle;
	
	@OneToMany( targetEntity=Personne.class, mappedBy="type" )
	private List<Personne> personne;
	
	/**
	 * Constructeur.
	 */
	public Type() {
		this(0, "", new ArrayList<>());
	}

	/**
	 * Constructeur.
	 * @param libelle
	 * @param personne
	 */
	public Type(@NotNull String libelle, List<Personne> personne) {
		super();
		this.libelle = libelle;
		this.personne = personne;
	}

	/**
	 * Constructeur.
	 * @param idType
	 * @param libelle
	 * @param personne
	 */
	public Type(int idType, @NotNull String libelle, List<Personne> personne) {
		super();
		this.idType = idType;
		this.libelle = libelle;
		this.personne = personne;
	}

	/**
	 * Méthode en charge de récupérer la valeur de idType.
	 * @return the idType
	 */
	public int getIdType() {
		return idType;
	}

	/**
	 * Méthode en charge de définir la valeur de idType.
	 * @param idType the idType to set
	 */
	public void setIdType(int idType) {
		this.idType = idType;
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
	 * Méthode en charge de récupérer la valeur de personne.
	 * @return the personne
	 */
	public List<Personne> getPersonne() {
		return personne;
	}

	/**
	 * Méthode en charge de définir la valeur de personne.
	 * @param personne the personne to set
	 */
	public void setPersonne(List<Personne> personne) {
		this.personne = personne;
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
		result = prime * result + idType;
		result = prime * result + ((libelle == null) ? 0 : libelle.hashCode());
		result = prime * result + ((personne == null) ? 0 : personne.hashCode());
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
		Type other = (Type) obj;
		if (idType != other.idType)
			return false;
		if (libelle == null) {
			if (other.libelle != null)
				return false;
		} else if (!libelle.equals(other.libelle))
			return false;
		if (personne == null) {
			if (other.personne != null)
				return false;
		} else if (!personne.equals(other.personne))
			return false;
		return true;
	}

	/**
	 * @{inheritDoc}
	*/
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Type [idType=");
		builder.append(idType);
		builder.append(", libelle=");
		builder.append(libelle);
		builder.append(", personne=");
		builder.append(personne);
		builder.append("]");
		return builder.toString();
	}

	
	

}
