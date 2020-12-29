/**
 * 
 */
package fr.lusseau.bibliotheque.dto.request;

import fr.lusseau.bibliotheque.entity.Contact;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Class in charge of defining .
 * @Version Bibliotheque -v1,0
 * @date  25 oct. 2020 - 16:31:37
 * @author Claude LUSSEAU
 *
 */
@ApiModel(value = "Request Editor Model")
public class EditorRequest  {
	
	@ApiModelProperty(value = "Editor id")
	private int id;
	
	@ApiModelProperty(value = "Editor name")
	private String name;
	
	@ApiModelProperty(value = "Editor email")
	private String email;
	
	@ApiModelProperty(value = "Editor contact")
	private Contact contact;
	
	
	/**
	 * Constructor.
	 */
	public EditorRequest() {
	}


	/**
	 * Constructor.
	 * @param name
	 * @param email
	 * @param contact
	 */
	public EditorRequest(String name, String email, Contact contact) {
		this.name = name;
		this.email = email;
		this.contact = contact;
	}


	/**
	 * Constructor.
	 * @param id
	 * @param name
	 * @param email
	 * @param contact
	 */
	public EditorRequest(int id, String name, String email, Contact contact) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.contact = contact;
	}


	/**
	 * Method in charge of getting id's value .
	 * @return the id
	 */
	public int getId() {
		return id;
	}


	/**
	 * Method in charge of setting id's value.
	 * @param id the id to set
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

	
}
