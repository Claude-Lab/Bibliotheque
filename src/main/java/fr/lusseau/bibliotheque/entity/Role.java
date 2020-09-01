/**
 * 
 */
package fr.lusseau.bibliotheque.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * Classe en charge de definir le bean Role.
 * @Version Bibliotheque -v1,0
 * @date  14 août 2020 - 09:49:04
 * @author Claude LUSSEAU
 *
 */
@Entity
public class Role implements Serializable {

	private static final long serialVersionUID = -1206324468919735945L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idRole;
	
	@NotBlank
	@Pattern(regexp = "^[a-zA-Z]{3,15}$")
	@Column(unique = true)
	private String libelle;
	
	@OneToMany(targetEntity = Personne.class, mappedBy = "role")
	private List<Personne> personnes;
	
	/**
	 * Constructeur.
	 */
	public Role() {
	}

	/**
	 * Constructeur.
	 * @param libelle
	 * @param personnes
	 */
	public Role(String libelle, List<Personne> personnes) {
		super();
		this.libelle = libelle;
		this.personnes = personnes;
	}

	/**
	 * Constructeur.
	 * @param idRole
	 * @param libelle
	 * @param personnes
	 */
	public Role(int idRole, String libelle, List<Personne> personnes) {
		super();
		this.idRole = idRole;
		this.libelle = libelle;
		this.personnes = personnes;
	}

	/**
	 * Méthode en charge de récupérer la valeur de idRole.
	 * @return the idRole
	 */
	public int getIdRole() {
		return this.idRole;
	}

	/**
	 * Méthode en charge de définir la valeur de idRole.
	 * @param idRole the idRole to set
	 */
	public void setIdRole(int idRole) {
		this.idRole = idRole;
	}

	/**
	 * Méthode en charge de récupérer la valeur de libelle.
	 * @return the libelle
	 */
	public String getLibelle() {
		return this.libelle;
	}

	/**
	 * Méthode en charge de définir la valeur de libelle.
	 * @param libelle the libelle to set
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	/**
	 * Méthode en charge de récupérer la valeur de personnes.
	 * @return the personnes
	 */
	public List<Personne> getPersonnes() {
		return personnes;
	}

	/**
	 * Méthode en charge de définir la valeur de personnes.
	 * @param personnes the personnes to set
	 */
	public void setPersonnes(List<Personne> personnes) {
		this.personnes = personnes;
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
		result = prime * result + idRole;
		result = prime * result + ((libelle == null) ? 0 : libelle.hashCode());
		result = prime * result + ((personnes == null) ? 0 : personnes.hashCode());
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
		Role other = (Role) obj;
		if (idRole != other.idRole)
			return false;
		if (libelle == null) {
			if (other.libelle != null)
				return false;
		} else if (!libelle.equals(other.libelle))
			return false;
		if (personnes == null) {
			if (other.personnes != null)
				return false;
		} else if (!personnes.equals(other.personnes))
			return false;
		return true;
	}

	/**
	 * @{inheritDoc}
	*/
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Role [idRole=");
		builder.append(idRole);
		builder.append(", libelle=");
		builder.append(libelle);
		builder.append("]");
		return builder.toString();
	}
	
	

	
}
