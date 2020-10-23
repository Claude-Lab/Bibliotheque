/**
 * 
 */
package fr.lusseau.bibliotheque.dto.request;

import java.time.LocalDate;

import fr.lusseau.bibliotheque.entity.Contact;
import fr.lusseau.bibliotheque.entity.Role;
import fr.lusseau.bibliotheque.entity.Surety;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Class in charge of defining .
 * 
 * @Version Bibliotheque -v1,0
 * @date 23 oct. 2020 - 18:56:31
 * @author Claude LUSSEAU
 *
 */
@ApiModel(value = "Create User Model")
public class CreateUserRequest implements Comparable<CreateUserRequest> {

	@ApiModelProperty(value = "User id")
	private int idUser;

	@ApiModelProperty(value = "User firstName")
	private String firstName;

	@ApiModelProperty(value = "User lastName")
	private String lastName;

	@ApiModelProperty(value = "User fullName")
	private String fullName = firstName + " " + lastName;

	@ApiModelProperty(value = "User password")
	private String password;

	@ApiModelProperty(value = "User role")
	private Role role;

	@ApiModelProperty(value = "User contact")
	private Contact contact;

	@ApiModelProperty(value = "User surety")
	private Surety surety;

	@ApiModelProperty(value = "User registrationDate")
	private LocalDate registrationDate;

	@ApiModelProperty(value = "User enabled")
	private boolean enabled;
	
	/**
	 * Constructor.
	 */
	public CreateUserRequest() {
	}

	/**
	 * Constructor.
	 * @param firstName
	 * @param lastName
	 * @param fullName
	 * @param password
	 * @param role
	 * @param contact
	 * @param surety
	 * @param registrationDate
	 * @param enabled
	 */
	public CreateUserRequest(String firstName, String lastName, String fullName, String password, Role role,
			Contact contact, Surety surety, LocalDate registrationDate, boolean enabled) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.fullName = fullName;
		this.password = password;
		this.role = role;
		this.contact = contact;
		this.surety = surety;
		this.registrationDate = registrationDate;
		this.enabled = enabled;
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
	 * @{inheritDoc}
	 */
	@Override
	public int compareTo(CreateUserRequest o) {

		return o.getFullName().compareToIgnoreCase(this.fullName);
	}

}
