/**
 * 
 */
package fr.lusseau.bibliotheque.dto.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Class in charge of defining .
 * @Version Bibliotheque -v1,0
 * @date  25 oct. 2020 - 11:14:23
 * @author Claude LUSSEAU
 *
 */
@ApiModel(value = "Request Category Model")
public class CategoryRequest {
	
	@ApiModelProperty(value = "Category id")
	private Integer id;
	
	@ApiModelProperty(value = "Category code")
	private String code;
	
	@ApiModelProperty(value = "Category label")
	private String label;
	

	/**
	 * Constructor.
	 */
	public CategoryRequest() {
	}

	/**
	 * Constructor.
	 * @param code
	 * @param label
	 */
	public CategoryRequest(String code, String label) {
		super();
		this.label = label;
		this.code = code;
	}

	/**
	 * Constructor.
	 * @param idCategory
	 * @param code
	 * @param label
	 */
	public CategoryRequest(Integer id, String code, String label) {
		super();
		this.id = id;
		this.code = code;
		this.label = label;
	}

	/**
	 * Method in charge of getting idCategory's value .
	 * @return the idCategory
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Method in charge of setting idCategory's value.
	 * @param idCategory the idCategory to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Method in charge of getting code's value .
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Method in charge of setting code's value.
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
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
