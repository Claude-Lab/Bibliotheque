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
 * Class in charge of defining Role entity.
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
	
	@Column(name = "label", unique = true)
	private String label;
	
	@OneToMany(targetEntity = User.class, mappedBy = "role", fetch = FetchType.LAZY)
	private Set<User> users = new HashSet<User>();
	
	/**
	 * Constructor.
	 */
	public Role() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Method in charge of getting idRole's value .
	 * @return the idRole
	 */
	public int getIdRole() {
		return idRole;
	}

	/**
	 * Method in charge of setting idRole's value.
	 * @param idRole the idRole to set
	 */
	public void setIdRole(int idRole) {
		this.idRole = idRole;
	}

	/**
	 * Method in charge of getting label's value .
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * Method in charge of setting label's value.
	 * @param label the label to set
	 */
	public void setLabel(String label) {
		this.label = label;
	}

	/**
	 * Method in charge of getting users's value .
	 * @return the users
	 */
	public Set<User> getUsers() {
		return users;
	}

	/**
	 * Method in charge of setting users's value.
	 * @param users the users to set
	 */
	public void setUsers(Set<User> users) {
		this.users = users;
	}

	/**
	 * @{inheritDoc}
	*/
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idRole;
		result = prime * result + ((label == null) ? 0 : label.hashCode());
		result = prime * result + ((users == null) ? 0 : users.hashCode());
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
		if (label == null) {
			if (other.label != null) {
				return false;
			}
		} else if (!label.equals(other.label)) {
			return false;
		}
		if (users == null) {
			if (other.users != null) {
				return false;
			}
		} else if (!users.equals(other.users)) {
			return false;
		}
		return true;
	}

}
