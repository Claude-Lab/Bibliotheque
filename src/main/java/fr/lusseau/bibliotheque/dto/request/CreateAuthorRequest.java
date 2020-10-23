/**
 * 
 */
package fr.lusseau.bibliotheque.dto.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Class in charge of defining .
 * 
 * @Version Bibliotheque -v1,0
 * @date 23 oct. 2020 - 18:46:25
 * @author Claude LUSSEAU
 *
 */
@ApiModel(value = "Create Author Model")
public class CreateAuthorRequest implements Comparable<CreateAuthorRequest> {

	@ApiModelProperty(value = "Author id")
	private Integer idAuthor;

	@ApiModelProperty(value = "Author firstName")
	private String firstName;

	@ApiModelProperty(value = "Author lastName")
	private String lastName;

	@ApiModelProperty(value = "Author fullName")
	private String fullName = (firstName + lastName);

	/**
	 * Constructor.
	 */
	public CreateAuthorRequest() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor.
	 * 
	 * @param firstName
	 * @param lastName
	 * @param fullName
	 */
	public CreateAuthorRequest(String firstName, String lastName, String fullName) {
		super();
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
		return fullName;
	}

	/**
	 * Method in charge of setting fullName's value.
	 * 
	 * @param fullName the fullName to set
	 */
	public void setFullName(String fullName) {
		this.fullName = (firstName + " " + lastName);
	}

	/**
	 * @{inheritDoc}
	 */
	@Override
	public int compareTo(CreateAuthorRequest o) {
		return o.getFullName().compareToIgnoreCase(this.fullName);
	}

}
