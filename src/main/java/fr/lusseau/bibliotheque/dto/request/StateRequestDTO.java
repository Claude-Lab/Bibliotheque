/**
 * 
 */
package fr.lusseau.bibliotheque.dto.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Class in charge of defining .
 * @Version Bibliotheque -v1,0
 * @date  25 oct. 2020 - 15:01:05
 * @author Claude LUSSEAU
 *
 */
@ApiModel(value = "Request State Model")
public class StateRequestDTO implements Comparable<StateRequestDTO> {
	
	@ApiModelProperty(value = "State id")
	private int idState;

	@ApiModelProperty(value = "State label")
	private String label;
	
	/**
	 * @{inheritDoc}
	*/
	@Override
	public int compareTo(StateRequestDTO o) {
		return o.getLabel().compareToIgnoreCase(this.label);
	}
	
	/**
	 * Constructor.
	 */
	public StateRequestDTO() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor.
	 * @param label
	 */
	public StateRequestDTO(String label) {
		super();
		this.label = label;
	}

	/**
	 * Constructor.
	 * @param idState
	 * @param label
	 */
	public StateRequestDTO(int idState, String label) {
		super();
		this.idState = idState;
		this.label = label;
	}

	/**
	 * Method in charge of getting idState's value .
	 * @return the idState
	 */
	public int getIdState() {
		return idState;
	}

	/**
	 * Method in charge of setting idState's value.
	 * @param idState the idState to set
	 */
	public void setIdState(int idState) {
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
	
	

}
