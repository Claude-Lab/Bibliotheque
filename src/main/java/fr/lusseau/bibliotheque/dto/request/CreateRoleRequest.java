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
 * @date 23 oct. 2020 - 18:56:31
 * @author Claude LUSSEAU
 *
 */
@ApiModel(value = "Create Role Model")
public class CreateRoleRequest implements Comparable<CreateRoleRequest> {

	@ApiModelProperty(value = "Role idRole")
	private Integer idRole;

	@ApiModelProperty(value = "Role label")
	private String label;

	/**
	 * Constructor.
	 */
	public CreateRoleRequest() {
	}
	
	/**
	 * Constructor.
	 * @param label
	 */
	public CreateRoleRequest(String label) {
		super();
		this.label = label;
	}
	
	/**
	 * Method in charge of getting idRole's value .
	 * @return the idRole
	 */
	public Integer getIdRole() {
		return idRole;
	}


	/**
	 * Method in charge of setting idRole's value.
	 * @param idRole the idRole to set
	 */
	public void setIdRole(Integer idRole) {
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


	/**
	 * @{inheritDoc}
	 */
	@Override
	public int compareTo(CreateRoleRequest o) {

		return o.getLabel().compareTo(this.label);
	}

}
