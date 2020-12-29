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
 * @date  25 oct. 2020 - 08:46:15
 * @author Claude LUSSEAU
 *
 */
@ApiModel(value = "Request Library Model")
public class LibraryRequest implements Comparable<LibraryRequest> {
	
	@ApiModelProperty(value = "Library id")
	private int idLibrary;
	
	@ApiModelProperty(value = "Library name")
	private String name;
	
	@ApiModelProperty(value = "Library contact")
	private Contact contact;
	

	/**
	 * Constructor.
	 */
	public LibraryRequest() {
	}


	/**
	 * Constructor.
	 * @param name
	 * @param contact
	 */
	public LibraryRequest(String name, Contact contact) {
		super();
		this.name = name;
		this.contact = contact;
	}


	/**
	 * Constructor.
	 * @param idLibrary
	 * @param name
	 * @param contact
	 */
	public LibraryRequest(int idLibrary, String name, Contact contact) {
		super();
		this.idLibrary = idLibrary;
		this.name = name;
		this.contact = contact;
	}


	/**
	 * Method in charge of getting idLibrary's value .
	 * @return the idLibrary
	 */
	public int getIdLibrary() {
		return idLibrary;
	}


	/**
	 * Method in charge of setting idLibrary's value.
	 * @param idLibrary the idLibrary to set
	 */
	public void setIdLibrary(int idLibrary) {
		this.idLibrary = idLibrary;
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
	 * @{inheritDoc}
	*/
	@Override
	public int compareTo(LibraryRequest o) {
		return o.getName().compareTo(this.name);
	}
	
	
}
