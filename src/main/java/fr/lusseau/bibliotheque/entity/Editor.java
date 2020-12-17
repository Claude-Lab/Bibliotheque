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

/**
 * Class in charge of defining Editor entity.
 * @Version Bibliotheque -v1,0
 * @date  23 oct. 2020 - 12:26:32
 * @author Claude LUSSEAU
 *
 */
@Entity
@Table(name = "Editor")
public class Editor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idEditor")
	private int idEditor;
	
	@Column(name = "name", unique = true, nullable = false)
	private String name;
	
	@Column(name = "email", unique = true, nullable = true)
	private String email;
	

	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	@JoinColumn(name="idContact", nullable=false )
	private Contact contact;
	
	/**
	 * Constructor.
	 */
	public Editor() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor.
	 * @param name
	 * @param contact
	 * @param books
	 */
	public Editor(String name, String email, Contact contact) {
		this.name = name;
		this.contact = contact;
		this.email = email;
	}

	/**
	 * Constructor.
	 * @param idEditor
	 * @param name
	 * @param contact
	 * @param books
	 */
	public Editor(int idEditor, String name, String email, Contact contact) {
		this.idEditor = idEditor;
		this.name = name;
		this.email = email;
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
	 * @{inheritDoc}
	*/
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contact == null) ? 0 : contact.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + idEditor;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		if (!(obj instanceof Editor)) {
			return false;
		}
		Editor other = (Editor) obj;
		if (contact == null) {
			if (other.contact != null) {
				return false;
			}
		} else if (!contact.equals(other.contact)) {
			return false;
		}
		if (email == null) {
			if (other.email != null) {
				return false;
			}
		} else if (!email.equals(other.email)) {
			return false;
		}
		if (idEditor != other.idEditor) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		return true;
	}

	
	
}
