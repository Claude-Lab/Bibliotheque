/**
 * 
 */
package fr.lusseau.bibliotheque.dto;

import java.time.LocalDate;

import fr.lusseau.bibliotheque.entity.Contact;
import fr.lusseau.bibliotheque.entity.Role;
import fr.lusseau.bibliotheque.entity.Surety;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Class in charge of defining .
 * @Version Bibliotheque -v1,0
 * @date  25 oct. 2020 - 19:20:47
 * @author Claude LUSSEAU
 *
 */
@ApiModel(value = "Registration User Model")
public class UserRegistrationDTO implements Comparable<UserRegistrationDTO> {
	
	@ApiModelProperty(value = "User id")
	private int idUser;

	@ApiModelProperty(value = "User firstName")
	private String firstName;

	@ApiModelProperty(value = "User lastName")
	private String lastName;

	@ApiModelProperty(value = "User fullName")
	private String fullName = (firstName + " " + lastName);
	
	@ApiModelProperty(value = "User password")
	private String password;
	
	@ApiModelProperty(value = "User registrationDate")
	private LocalDate registrationDate;

	@ApiModelProperty(value = "User enabled")
	private boolean enabled;

	@ApiModelProperty(value = "User role")
	private Role role;

	@ApiModelProperty(value = "User contact")
	private Contact contact;

	@ApiModelProperty(value = "surety")
	private Surety surety;
	
	/**
	 * @{inheritDoc}
	*/
	@Override
	public int compareTo(UserRegistrationDTO o) {
		return o.getFullName().compareToIgnoreCase(this.fullName);
	}
	
	/**
	 * Constructor.
	 */
	public UserRegistrationDTO() {
	}

	/**
	 * Constructor.
	 * @param firstName
	 * @param lastName
	 * @param fullName
	 * @param password
	 * @param registrationDate
	 * @param enabled
	 * @param role
	 * @param contact
	 * @param surety
	 */
	public UserRegistrationDTO(String firstName, String lastName, String fullName, String password,
			LocalDate registrationDate, boolean enabled, Role role, Contact contact, Surety surety) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.fullName = fullName;
		this.password = password;
		this.registrationDate = registrationDate;
		this.enabled = enabled;
		this.role = role;
		this.contact = contact;
		this.surety = surety;
	}

	/**
	 * Constructor.
	 * @param idUser
	 * @param firstName
	 * @param lastName
	 * @param fullName
	 * @param password
	 * @param registrationDate
	 * @param enabled
	 * @param role
	 * @param contact
	 * @param surety
	 */
	public UserRegistrationDTO(int idUser, String firstName, String lastName, String fullName, String password,
			LocalDate registrationDate, boolean enabled, Role role, Contact contact, Surety surety) {
		super();
		this.idUser = idUser;
		this.firstName = firstName;
		this.lastName = lastName;
		this.fullName = fullName;
		this.password = password;
		this.registrationDate = registrationDate;
		this.enabled = enabled;
		this.role = role;
		this.contact = contact;
		this.surety = surety;
	}

	/**
	 * Method in charge of getting idUser's value .
	 * @return the idUser
	 */
	public int getIdUser() {
		return idUser;
	}

	/**
	 * Method in charge of setting idUser's value.
	 * @param idUser the idUser to set
	 */
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	/**
	 * Method in charge of getting firstName's value .
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Method in charge of setting firstName's value.
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Method in charge of getting lastName's value .
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Method in charge of setting lastName's value.
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Method in charge of getting fullName's value .
	 * @return the fullName
	 */
	public String getFullName() {
		return fullName;
	}

	/**
	 * Method in charge of setting fullName's value.
	 * @param fullName the fullName to set
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	/**
	 * Method in charge of getting password's value .
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Method in charge of setting password's value.
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Method in charge of getting registrationDate's value .
	 * @return the registrationDate
	 */
	public LocalDate getRegistrationDate() {
		return registrationDate;
	}

	/**
	 * Method in charge of setting registrationDate's value.
	 * @param registrationDate the registrationDate to set
	 */
	public void setRegistrationDate(LocalDate registrationDate) {
		this.registrationDate = registrationDate;
	}

	/**
	 * Method in charge of getting enabled's value .
	 * @return the enabled
	 */
	public boolean isEnabled() {
		return enabled;
	}

	/**
	 * Method in charge of setting enabled's value.
	 * @param enabled the enabled to set
	 */
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	/**
	 * Method in charge of getting role's value .
	 * @return the role
	 */
	public Role getRole() {
		return role;
	}

	/**
	 * Method in charge of setting role's value.
	 * @param role the role to set
	 */
	public void setRole(Role role) {
		this.role = role;
	}

	/**
	 * Method in charge of getting contact's value .
	 * @return the contact
	 */
	public Contact getContact() {
		return contact;
	}

	/**
	 * Method in charge of setting contact's value.
	 * @param contact the contact to set
	 */
	public void setContact(Contact contact) {
		this.contact = contact;
	}

	/**
	 * Method in charge of getting surety's value .
	 * @return the surety
	 */
	public Surety getSurety() {
		return surety;
	}

	/**
	 * Method in charge of setting surety's value.
	 * @param surety the surety to set
	 */
	public void setSurety(Surety surety) {
		this.surety = surety;
	}

	/**
	 * @{inheritDoc}
	*/
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contact == null) ? 0 : contact.hashCode());
		result = prime * result + (enabled ? 1231 : 1237);
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((fullName == null) ? 0 : fullName.hashCode());
		result = prime * result + idUser;
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((registrationDate == null) ? 0 : registrationDate.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		result = prime * result + ((surety == null) ? 0 : surety.hashCode());
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
		if (!(obj instanceof UserRegistrationDTO)) {
			return false;
		}
		UserRegistrationDTO other = (UserRegistrationDTO) obj;
		if (contact == null) {
			if (other.contact != null) {
				return false;
			}
		} else if (!contact.equals(other.contact)) {
			return false;
		}
		if (enabled != other.enabled) {
			return false;
		}
		if (firstName == null) {
			if (other.firstName != null) {
				return false;
			}
		} else if (!firstName.equals(other.firstName)) {
			return false;
		}
		if (fullName == null) {
			if (other.fullName != null) {
				return false;
			}
		} else if (!fullName.equals(other.fullName)) {
			return false;
		}
		if (idUser != other.idUser) {
			return false;
		}
		if (lastName == null) {
			if (other.lastName != null) {
				return false;
			}
		} else if (!lastName.equals(other.lastName)) {
			return false;
		}
		if (password == null) {
			if (other.password != null) {
				return false;
			}
		} else if (!password.equals(other.password)) {
			return false;
		}
		if (registrationDate == null) {
			if (other.registrationDate != null) {
				return false;
			}
		} else if (!registrationDate.equals(other.registrationDate)) {
			return false;
		}
		if (role == null) {
			if (other.role != null) {
				return false;
			}
		} else if (!role.equals(other.role)) {
			return false;
		}
		if (surety == null) {
			if (other.surety != null) {
				return false;
			}
		} else if (!surety.equals(other.surety)) {
			return false;
		}
		return true;
	}
	
	

}
