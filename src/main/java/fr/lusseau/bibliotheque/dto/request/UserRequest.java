/**
 * 
 */
package fr.lusseau.bibliotheque.dto.request;

import java.time.LocalDateTime;
import java.util.Set;

import org.springframework.hateoas.server.core.Relation;

import fr.lusseau.bibliotheque.entity.Loan;
import fr.lusseau.bibliotheque.entity.Role;
import fr.lusseau.bibliotheque.entity.Surety;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Class in charge of defining .
 * 
 * @Version Bibliotheque -v1,0
 * @date 25 oct. 2020 - 19:17:04
 * @author Claude LUSSEAU
 *
 */
@Relation(value = "user", collectionRelation = "users")
@ApiModel(value = "Request User Model")
public class UserRequest {

	@ApiModelProperty(value = "User is")
	private Long id;

	@ApiModelProperty(value = "User firstname")
	private String firstname;

	@ApiModelProperty(value = "User lastname")
	private String lastname;

	@ApiModelProperty(value = "User username")
	private String username;

	@ApiModelProperty(value = "User email")
	private String email;
	
	@ApiModelProperty(value = "User password")
	private String password;

	@ApiModelProperty(value = "User phone")
	private String phone;

	@ApiModelProperty(value = "User address")
	private String address;

	@ApiModelProperty(value = "User zip code")
	private String zip;

	@ApiModelProperty(value = "User city")
	private String city;
	
	@ApiModelProperty(value = "User role(s)")
	private Set<Role> roles;
	
	@ApiModelProperty(value = "User surety")
	private Surety surety;
	
	@ApiModelProperty(value = "User loans")
	private Set<Loan> loans;
	
	@ApiModelProperty(value = "User create")
	private LocalDateTime createdAt;

	@ApiModelProperty(value = "User update")
	private LocalDateTime updatedAt;
	

	/**
	 * Constructor.
	 */
	public UserRequest() {
	}
	

	/**
	 * Constructor.
	 * @param firstName
	 * @param lastName
	 * @param username
	 * @param email
	 * @param phone
	 * @param address
	 * @param zip
	 * @param city
	 * @param roles
	 * @param surety
	 * @param loans
	 */
	public UserRequest(String firstname, String lastname, String username, String email, String phone,
			String address, String zip, String city, LocalDateTime createdAt, LocalDateTime updatedAt, Set<Role> roles, Surety surety, Set<Loan> loans) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.zip = zip;
		this.city = city;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.roles = roles;
		this.surety = surety;
		this.loans = loans;
	}

	
	/**
	 * Constructor.
	 * @param id
	 * @param firstName
	 * @param lastName
	 * @param username
	 * @param email
	 * @param password
	 * @param phone
	 * @param address
	 * @param zip
	 * @param city
	 * @param roles
	 * @param surety
	 * @param loans
	 */
	public UserRequest(Long id, String firstname, String lastname, String username, String email, String password,
			String phone, String address, String zip, String city, LocalDateTime createdAt, LocalDateTime updatedAt, Set<Role> roles, Surety surety, Set<Loan> loans) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.address = address;
		this.zip = zip;
		this.city = city;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.roles = roles;
		this.surety = surety;
		this.loans = loans;
	}



	/**
	 * Method in charge of getting id's value .
	 * @return the id
	 */
	public Long getId() {
		return id;
	}



	/**
	 * Method in charge of setting id's value.
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}



	/**
	 * Method in charge of getting firstName's value .
	 * @return the firstName
	 */
	public String getFirstname() {
		return firstname;
	}
	


	/**
	 * Method in charge of setting firstname's value.
	 * @param firstname the firstname to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	


	/**
	 * Method in charge of getting lastName's value .
	 * @return the lastName
	 */
	public String getLastname() {
		return lastname;
	}



	/**
	 * Method in charge of setting lastName's value.
	 * @param lastName the lastName to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}



	/**
	 * Method in charge of getting username's value .
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}



	/**
	 * Method in charge of setting username's value.
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}



	/**
	 * Method in charge of getting email's value .
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}



	/**
	 * Method in charge of setting email's value.
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
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
	 * Method in charge of getting phone's value .
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}



	/**
	 * Method in charge of setting phone's value.
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}



	/**
	 * Method in charge of getting address's value .
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}



	/**
	 * Method in charge of setting address's value.
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}



	/**
	 * Method in charge of getting zip's value .
	 * @return the zip
	 */
	public String getZip() {
		return zip;
	}



	/**
	 * Method in charge of setting zip's value.
	 * @param zip the zip to set
	 */
	public void setZip(String zip) {
		this.zip = zip;
	}



	/**
	 * Method in charge of getting city's value .
	 * @return the city
	 */
	public String getCity() {
		return city;
	}



	/**
	 * Method in charge of setting city's value.
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}



	/**
	 * Method in charge of getting roles's value .
	 * @return the roles
	 */
	public Set<Role> getRoles() {
		return roles;
	}



	/**
	 * Method in charge of setting roles's value.
	 * @param roles the roles to set
	 */
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
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
	 * Method in charge of getting loans's value .
	 * @return the loans
	 */
	public Set<Loan> getLoans() {
		return loans;
	}



	/**
	 * Method in charge of setting loans's value.
	 * @param loans the loans to set
	 */
	public void setLoans(Set<Loan> loans) {
		this.loans = loans;
	}



	/**
	 * Method in charge of getting createdAt's value .
	 * @return the createdAt
	 */
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}



	/**
	 * Method in charge of setting createdAt's value.
	 * @param createdAt the createdAt to set
	 */
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}



	/**
	 * Method in charge of getting updatedAt's value .
	 * @return the updatedAt
	 */
	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}



	/**
	 * Method in charge of setting updatedAt's value.
	 * @param updatedAt the updatedAt to set
	 */
	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}



}
