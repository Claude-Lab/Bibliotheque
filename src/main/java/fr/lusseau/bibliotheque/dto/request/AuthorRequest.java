/**
 * 
 */
package fr.lusseau.bibliotheque.dto.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Class in charge of defining .
 * @Version Bibliotheque -v1,0
 * @date  24 oct. 2020 - 12:12:59
 * @author Claude LUSSEAU
 *
 */
@ApiModel(value = "Request Author Model")
public class AuthorRequest {

	@ApiModelProperty(value = "Author id")
	private Integer id;

	@ApiModelProperty(value = "Author firstname")
	private String firstname;

	@ApiModelProperty(value = "Author lastname")
	private String lastname;

	@ApiModelProperty(value = "Author fullname")
	private String fullname;

	/**
	 * Constructor.
	 */
	public AuthorRequest() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor.
	 * 
	 * @param firstName
	 * @param lastName
	 * @param fullName
	 */
	public AuthorRequest(String firstname, String lastname, String fullname) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.fullname = fullname;
	}
	
	

	/**
	 * Constructor.
	 * @param idAuthor
	 * @param firstName
	 * @param lastName
	 * @param fullName
	 */
	public AuthorRequest(Integer id, String firstname, String lastname, String fullname) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.fullname = fullname;
	}

	/**
	 * Method in charge of getting idAuthor's value .
	 * 
	 * @return the idAuthor
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Method in charge of setting idAuthor's value.
	 * 
	 * @param idAuthor the idAuthor to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Method in charge of getting firstName's value .
	 * 
	 * @return the firstName
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * Method in charge of setting firstName's value.
	 * 
	 * @param firstName the firstName to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 * Method in charge of getting lastName's value .
	 * 
	 * @return the lastName
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * Method in charge of setting lastName's value.
	 * 
	 * @param lastName the lastName to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * Method in charge of getting fullName's value .
	 * 
	 * @return the fullName
	 */
	public String getFullname() {
		return this.firstname + " " + this.lastname;
	}

	/**
	 * Method in charge of setting fullName's value.
	 * 
	 * @param fullName the fullName to set
	 */
	public void setFullname(String fullname) {
		this.fullname = this.firstname + " " + this.lastname;
	}

	
}
