/**
 * 
 */
package fr.lusseau.bibliotheque.entity;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Class in charge of defining User entity.
 * 
 * @Version Bibliotheque -v1,0
 * @date 23 oct. 2020 - 12:32:19
 * @author Claude LUSSEAU
 *
 */
@Entity
@Table(name = "User", uniqueConstraints = { @UniqueConstraint(columnNames = { "username" }),
		@UniqueConstraint(columnNames = { "email" }) })
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Size(max = 20)
	private String firstname;

	@NotBlank
	@Size(max = 20)
	private String lastname;

	@NotBlank
	private String username;

	@NotBlank
	@Size(max = 50)
	@Email
	private String email;

	@NotBlank
	@Size(max = 120)
	@JsonIgnore
	private String password;

	@NotBlank
	@Size(max = 10)
	private String phone;

	@NotBlank
	@Size(max = 120)
	private String address;

	@NotBlank
	@Size(min = 5, max = 5)
	private String zip;

	@NotBlank
	@Size(max = 60)
	private String city;

	
	@DateTimeFormat
	private LocalDateTime createdAt = LocalDateTime.now();

	
	@DateTimeFormat
	private LocalDateTime updatedAt = LocalDateTime.now();

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
	@JoinColumn(name = "idSurety", nullable = false)
	private Surety surety;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "user", cascade = CascadeType.ALL)
	private Set<Loan> loans = new HashSet<Loan>();

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	@NotNull
	private Set<Role> roles = new HashSet<>();

	/**
	 * Constructor without parameter.
	 */
	public User() {
	}

	/**
	 * Constructor for registration.
	 * 
	 * @param firstname
	 * @param lastname
	 * @param username
	 * @param email
	 * @param password
	 * @param phone
	 * @param address
	 * @param zip
	 * @param city
	 * @param createdAt
	 * @param updatedAt
	 * @param surety
	 * @param loans
	 * @param roles
	 */
	public User(@NotBlank @Size(max = 20) String firstname, @NotBlank @Size(max = 20) String lastname,
			@NotBlank String username, @NotBlank @Size(max = 50) @Email String email,
			@NotBlank @Size(max = 120) String password, @NotBlank @Size(max = 10) String phone,
			@NotBlank @Size(max = 120) String address, @NotBlank @Size(min = 5, max = 5) String zip,
			@NotBlank @Size(max = 60) String city, @NotBlank LocalDateTime createdAt, LocalDateTime updatedAt, @NotNull Set<Role> roles,
			Surety surety, Set<Loan> loans) {
		super();
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
		this.surety = surety;
		this.loans = loans;
		this.roles = roles;
	}

	/**
	 * Constructor.
	 * 
	 * @param id
	 * @param firstname
	 * @param lastname
	 * @param username
	 * @param email
	 * @param password
	 * @param phone
	 * @param address
	 * @param zip
	 * @param city
	 * @param createdAt
	 * @param updatedAt
	 * @param surety
	 * @param loans
	 * @param roles
	 */
	public User(Long id, @NotBlank @Size(max = 20) String firstname, @NotBlank @Size(max = 20) String lastname,
			@NotBlank String username, @NotBlank @Size(max = 50) @Email String email,
			@NotBlank @Size(max = 120) String password, @NotBlank @Size(max = 10) String phone,
			@NotBlank @Size(max = 120) String address, @NotBlank @Size(min = 5, max = 5) String zip,
			@NotBlank @Size(max = 60) String city, @NotBlank LocalDateTime createdAt, @NotBlank LocalDateTime updatedAt,
			Surety surety, Set<Loan> loans, @NotNull Set<Role> roles) {
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
		this.surety = surety;
		this.loans = loans;
		this.roles = roles;
	}

	/**
	 * Method in charge of getting id's value.
	 * 
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Method in charge of setting id's value.
	 * 
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Method in charge of getting firstname's value .
	 * 
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * Method in charge of setting firstname's value.
	 * 
	 * @param firstname the firstname to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 * Method in charge of getting lastname's value .
	 * 
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * Method in charge of setting lastname's value.
	 * 
	 * @param lastname the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * Method in charge of getting username's value .
	 * 
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Method in charge of setting username's value.
	 * 
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Method in charge of getting email's value .
	 * 
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Method in charge of setting email's value.
	 * 
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Method in charge of getting password's value .
	 * 
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Method in charge of setting password's value.
	 * 
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Method in charge of getting phone's value .
	 * 
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * Method in charge of setting phone's value.
	 * 
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * Method in charge of getting address's value .
	 * 
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Method in charge of setting address's value.
	 * 
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * Method in charge of getting zip's value .
	 * 
	 * @return the zip
	 */
	public String getZip() {
		return zip;
	}

	/**
	 * Method in charge of setting zip's value.
	 * 
	 * @param zip the zip to set
	 */
	public void setZip(String zip) {
		this.zip = zip;
	}

	/**
	 * Method in charge of getting city's value .
	 * 
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * Method in charge of setting city's value.
	 * 
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * Method in charge of getting createdAt's value .
	 * 
	 * @return the createdAt
	 */
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	/**
	 * Method in charge of setting createdAt's value.
	 * 
	 * @param createdAt the createdAt to set
	 */
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	/**
	 * Method in charge of getting updatedAt's value .
	 * 
	 * @return the updatedAt
	 */
	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	/**
	 * Method in charge of setting updatedAt's value.
	 * 
	 * @param updatedAt the updatedAt to set
	 */
	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	/**
	 * Method in charge of getting surety's value .
	 * 
	 * @return the surety
	 */
	public Surety getSurety() {
		return surety;
	}

	/**
	 * Method in charge of setting surety's value.
	 * 
	 * @param surety the surety to set
	 */
	public void setSurety(Surety surety) {
		this.surety = surety;
	}

	/**
	 * Method in charge of getting loans's value .
	 * 
	 * @return the loans
	 */
	public Set<Loan> getLoans() {
		return loans;
	}

	/**
	 * Method in charge of setting loans's value.
	 * 
	 * @param loans the loans to set
	 */
	public void setLoans(Set<Loan> loans) {
		this.loans = loans;
	}

	/**
	 * Method in charge of getting roles's value .
	 * 
	 * @return the roles
	 */
	public Set<Role> getRoles() {
		return roles;
	}

	/**
	 * Method in charge of setting roles's value.
	 * 
	 * @param roles the roles to set
	 */
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

}
