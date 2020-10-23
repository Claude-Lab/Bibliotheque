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
@ApiModel(value = "Create Category Model")
public class CreateCategoryRequest implements Comparable<CreateCategoryRequest> {

	@ApiModelProperty(value = "Category id")
	private Integer idCategory;

	@ApiModelProperty(value = "Category code")
	private String code;

	@ApiModelProperty(value = "Category label")
	private String label;
	
	/**
	 * Constructor.
	 */
	public CreateCategoryRequest() {
	}

	/**
	 * Constructor.
	 * @param code
	 * @param label
	 */
	public CreateCategoryRequest(String code, String label) {
		super();
		this.code = code;
		this.label = label;
	}


	/**
	 * Method in charge of getting idCategory's value .
	 * 
	 * @return the idCategory
	 */
	public Integer getIdCategory() {
		return idCategory;
	}

	/**
	 * Method in charge of setting idCategory's value.
	 * 
	 * @param idCategory the idCategory to set
	 */
	public void setIdCategory(Integer idCategory) {
		this.idCategory = idCategory;
	}

	/**
	 * Method in charge of getting code's value .
	 * 
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Method in charge of setting code's value.
	 * 
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * Method in charge of getting label's value .
	 * 
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * Method in charge of setting label's value.
	 * 
	 * @param label the label to set
	 */
	public void setLabel(String label) {
		this.label = label;
	}

	/**
	 * @{inheritDoc}
	 */
	@Override
	public int compareTo(CreateCategoryRequest o) {

		return (o.getCode().compareTo(this.code)) + (o.getLabel().compareTo(this.label));
	}

}
