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
@ApiModel(value = "Create State Model")
public class CreateStateRequest implements Comparable<CreateStateRequest> {

	@ApiModelProperty(value = "State id")
	private Integer idState;

	@ApiModelProperty(value = "State label")
	private String label;
	
	/**
	 * Constructor.
	 */
	public CreateStateRequest() {
	}

	/**
	 * Constructor.
	 * @param label
	 */
	public CreateStateRequest(String label) {
		super();
		this.label = label;
	}
	
	/**
	 * Method in charge of getting idState's value .
	 * @return the idState
	 */
	public Integer getIdState() {
		return idState;
	}

	/**
	 * Method in charge of setting idState's value.
	 * @param idState the idState to set
	 */
	public void setIdState(Integer idState) {
		this.idState = idState;
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
	public int compareTo(CreateStateRequest o) {

		return o.getLabel().compareToIgnoreCase(this.label);
	}

}
