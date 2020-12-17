/**
 * 
 */
package fr.lusseau.bibliotheque.dto.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Class in charge of defining .
 * @Version Bibliotheque -v1,0
 * @date  25 oct. 2020 - 14:28:16
 * @author Claude LUSSEAU
 *
 */
@ApiModel(value = "Request Role Model")
public class RoleRequestDTO implements Comparable<RoleRequestDTO> {
	
	@ApiModelProperty(value = "Role id")
	private int idRole;
	
	@ApiModelProperty(value = "Role label")
	private String label;
	
	/**
	 * @{inheritDoc}
	*/
	@Override
	public int compareTo(RoleRequestDTO o) {
		return o.getLabel().compareToIgnoreCase(this.label);
	}
	
	/**
	 * Constructor.
	 */
	public RoleRequestDTO() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor.
	 * @param label
	 */
	public RoleRequestDTO(String label) {
		super();
		this.label = label;
	}

	/**
	 * Constructor.
	 * @param idRole
	 * @param label
	 */
	public RoleRequestDTO(int idRole, String label) {
		super();
		this.idRole = idRole;
		this.label = label;
	}

	/**
	 * Method in charge of getting idRole's value .
	 * @return the idRole
	 */
	public int getIdRole() {
		return idRole;
	}

	/**
	 * Method in charge of setting idRole's value.
	 * @param idRole the idRole to set
	 */
	public void setIdRole(int idRole) {
		this.idRole = idRole;
	}

	/**
	 * Method in charge of getting label's value .
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * Method in charge of setting label's value.
	 * @param label the label to set
	 */
	public void setLabel(String label) {
		this.label = label;
	}
	
	

}
