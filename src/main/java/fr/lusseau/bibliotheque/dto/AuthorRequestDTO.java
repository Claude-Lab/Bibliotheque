/**
 * 
 */
package fr.lusseau.bibliotheque.dto;

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
public class AuthorRequestDTO implements Comparable<AuthorRequestDTO> {

	@ApiModelProperty(value = "Author id")
	private Integer idAuthor;

	@ApiModelProperty(value = "Author firstName")
	private String firstName;

	@ApiModelProperty(value = "Author lastName")
	private String lastName;

	@ApiModelProperty(value = "Author fullName")
	private String fullName;

	/**
	 * Constructor.
	 */
	public AuthorRequestDTO() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor.
	 * 
	 * @param firstName
	 * @param lastName
	 * @param fullName
	 */
	public AuthorRequestDTO(String firstName, String lastName, String fullName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.fullName = fullName;
	}
	
	

	/**
	 * Constructor.
	 * @param idAuthor
	 * @param firstName
	 * @param lastName
	 * @param fullName
	 */
	public AuthorRequestDTO(Integer idAuthor, String firstName, String lastName, String fullName) {
		super();
		this.idAuthor = idAuthor;
		this.firstName = firstName;
		this.lastName = lastName;
		this.fullName = fullName;
	}

	/**
	 * Method in charge of getting idAuthor's value .
	 * 
	 * @return the idAuthor
	 */
	public Integer getIdAuthor() {
		return idAuthor;
	}

	/**
	 * Method in charge of setting idAuthor's value.
	 * 
	 * @param idAuthor the idAuthor to set
	 */
	public void setIdAuthor(Integer idAuthor) {
		this.idAuthor = idAuthor;
	}

	/**
	 * Method in charge of getting firstName's value .
	 * 
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Method in charge of setting firstName's value.
	 * 
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Method in charge of getting lastName's value .
	 * 
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Method in charge of setting lastName's value.
	 * 
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Method in charge of getting fullName's value .
	 * 
	 * @return the fullName
	 */
	public String getFullName() {
		String name = this.firstName + " " + this.lastName;
		return name;
	}

	/**
	 * Method in charge of setting fullName's value.
	 * 
	 * @param fullName the fullName to set
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	/**
	 * @{inheritDoc}
	 */
	@Override
	public int compareTo(AuthorRequestDTO o) {
		return o.getFullName().compareToIgnoreCase(this.fullName);
	}

}
