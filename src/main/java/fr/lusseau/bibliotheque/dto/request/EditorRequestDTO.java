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
public class EditorRequestDTO implements Comparable<EditorRequestDTO> {
	
	@ApiModelProperty(value = "Editor id")
	private int idEditor;
	
	@ApiModelProperty(value = "Editor name")
	private String name;
	
	@ApiModelProperty(value = "Editor contact")
	private Contact contact;
	
	/**
	 * @{inheritDoc}
	*/
	@Override
	public int compareTo(EditorRequestDTO o) {
		return o.getName().compareToIgnoreCase(this.name);
	}
	
	/**
	 * Constructor.
	 */
	public EditorRequestDTO() {
	}

	/**
	 * Constructor.
	 * @param name
	 * @param contact
	 */
	public EditorRequestDTO(String name, Contact contact) {
		super();
		this.name = name;
		this.contact = contact;
	}

	/**
	 * Constructor.
	 * @param idEditor
	 * @param name
	 * @param contact
	 */
	public EditorRequestDTO(int idEditor, String name, Contact contact) {
		super();
		this.idEditor = idEditor;
		this.name = name;
		this.contact = contact;
	}

	/**
	 * Method in charge of getting idEditor's value .
	 * @return the idEditor
	 */
	public int getIdEditor() {
		return idEditor;
	}

	/**
	 * Method in charge of setting idEditor's value.
	 * @param idEditor the idEditor to set
	 */
	public void setIdEditor(int idEditor) {
		this.idEditor = idEditor;
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
	
	

}
