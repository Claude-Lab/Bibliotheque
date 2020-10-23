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
 * @date  23 oct. 2020 - 19:00:35
 * @author Claude LUSSEAU
 *
 */
@ApiModel(value = "Create Library Model")
public class CreateLibraryRequest implements Comparable<CreateLibraryRequest> {
	
	@ApiModelProperty(value = "Library id")
	private int idLibrary;

	@ApiModelProperty(value = "Library name")
	private String name;
	
	@ApiModelProperty(value = "Library Contact")
	private ContactResponse contact;
	
	/**
	 * Constructor.
	 */
	public CreateLibraryRequest() {
	}

	/**
	 * Constructor.
	 * @param name
	 * @param contact
	 */
	public CreateLibraryRequest(String name, ContactResponse contact) {
		super();
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
	public ContactResponse getContact() {
		return contact;
	}

	/**
	 * Method in charge of setting contact's value.
	 * @param contact the contact to set
	 */
	public void setContact(ContactResponse contact) {
		this.contact = contact;
	}

	/**
	 * @{inheritDoc}
	*/
	@Override
	public int compareTo(CreateLibraryRequest o) {
		return o.getName().compareTo(this.name);
	}
	
	
}
