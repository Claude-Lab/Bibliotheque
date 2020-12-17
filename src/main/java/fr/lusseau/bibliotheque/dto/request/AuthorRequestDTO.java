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
public class AuthorRequestDTO implements Comparable<AuthorRequestDTO> {

	@ApiModelProperty(value = "Author id")
	private Integer idAuthor;

	@ApiModelProperty(value = "Author firstName")
	private String firstName;

	@ApiModelProperty(value = "Author lastName")
	private String lastName;

	@ApiModelProperty(value = "Author fullName")
	private String fullName = firstName + " " + lastName;

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

	/**
	 * @{inheritDoc}
	*/
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((fullName == null) ? 0 : fullName.hashCode());
		result = prime * result + ((idAuthor == null) ? 0 : idAuthor.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
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
		if (!(obj instanceof AuthorRequestDTO)) {
			return false;
		}
		AuthorRequestDTO other = (AuthorRequestDTO) obj;
		if (firstName == null) {
			if (other.firstName != null) {
				return false;
			}
		} else if (!firstName.equals(other.firstName)) {
			return false;
		}
		if (fullName == null) {
			if (other.fullName != null) {
				return false;
			}
		} else if (!fullName.equals(other.fullName)) {
			return false;
		}
		if (idAuthor == null) {
			if (other.idAuthor != null) {
				return false;
			}
		} else if (!idAuthor.equals(other.idAuthor)) {
			return false;
		}
		if (lastName == null) {
			if (other.lastName != null) {
				return false;
			}
		} else if (!lastName.equals(other.lastName)) {
			return false;
		}
		return true;
	}
	
	

}
