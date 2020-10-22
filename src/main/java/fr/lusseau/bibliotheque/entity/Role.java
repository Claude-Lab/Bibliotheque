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
 * Classe en charge de definir le bean Role.
 * @Version Bibliotheque -v1,0
 * @date  14 août 2020 - 09:49:04
 * @author Claude LUSSEAU
 *
 */
@Entity
@Table(name = "Role")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idRole")
	private int idRole;
	
	@Column(name = "libelle", unique = true)
	private String libelle;
	
	@OneToMany(targetEntity = Personne.class, mappedBy = "role", fetch = FetchType.LAZY)
	private Set<Personne> personnes = new HashSet<Personne>();
	
	/**
	 * Constructeur.
	 */
	public Role() {
	}

	/**
	 * Méthode en charge de récupérer la valeur de idRole.
	 * @return the idRole
	 */
	public int getIdRole() {
		return idRole;
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
	 * Méthode en charge de récupérer la valeur de personnes.
	 * @return the personnes
	 */
	public Set<Personne> getPersonnes() {
		return personnes;
	}

	/**
	 * Méthode en charge de définir la valeur de personnes.
	 * @param personnes the personnes to set
	 */
	public void setPersonnes(Set<Personne> personnes) {
		this.personnes = personnes;
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
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Role)) {
			return false;
		}
		Role other = (Role) obj;
		if (idRole != other.idRole) {
			return false;
		}
		if (libelle == null) {
			if (other.libelle != null) {
				return false;
			}
		} else if (!libelle.equals(other.libelle)) {
			return false;
		}
		if (personnes == null) {
			if (other.personnes != null) {
				return false;
			}
		} else if (!personnes.equals(other.personnes)) {
			return false;
		}
		return true;
	}

	

}
