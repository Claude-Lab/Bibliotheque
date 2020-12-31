/**
 * 
 */
package fr.lusseau.bibliotheque.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * Class in charge of defining Library entity.
 * @Version Bibliotheque -v1,0
 * @date  23 oct. 2020 - 12:10:29
 * @author Claude LUSSEAU
 *
 */
@Entity
@Table(name = "Library")
public class Library {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@NotBlank
	@Column(unique = true, name = "name")
	private String name;
	
	@NotBlank
	@Email
	@Column(unique = true, name = "email")
	private String email;
	
	@NotNull
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	@JoinColumn( name="idContact", nullable=false )
	private Contact contact;
		
	/**
	 * Constructor.
	 */
	public Library() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor.
	 * @param name
	 * @param contact
	 * @param books
	 */
	public Library(String name, String email, Contact contact) {
		this.name = name;
		this.contact = contact;
		this.email = email;
	}

	/**
	 * Constructor.
	 * @param id
	 * @param name
	 * @param contact
	 * @param books
	 */
	public Library(int id, String name, Contact contact, String email) {
		this.id = id;
		this.name = name;
		this.contact = contact;
		this.email = email;
	}

	/**
	 * Method in charge of getting idLibrary's value .
	 * @return the idLibrary
	 */
	public int getId() {
		return id;
	}

	/**
	 * Method in charge of setting idLibrary's value.
	 * @param idLibrary the idLibrary to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Method in charge of getting name's value .
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Method in charge of setting name's value.
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
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

	
}
