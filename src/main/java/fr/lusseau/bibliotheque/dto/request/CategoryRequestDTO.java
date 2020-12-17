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
public class CategoryRequestDTO implements Comparable<CategoryRequestDTO> {
	
	@ApiModelProperty(value = "Category id")
	private Integer idCategory;
	
	@ApiModelProperty(value = "Category id")
	private String code;
	
	@ApiModelProperty(value = "Category id")
	private String label;
	
	/**
	 * @{inheritDoc}
	*/
	@Override
	public int compareTo(CategoryRequestDTO o) {
		return ((o.getCode().compareToIgnoreCase(this.code)) & (o.getLabel().compareToIgnoreCase(this.label)));
	}

	/**
	 * Constructor.
	 */
	public CategoryRequestDTO() {
	}

	/**
	 * Constructor.
	 * @param code
	 * @param label
	 */
	public CategoryRequestDTO(String code, String label) {
		super();
		this.code = code;
		this.label = label;
	}

	/**
	 * Constructor.
	 * @param idCategory
	 * @param code
	 * @param label
	 */
	public CategoryRequestDTO(Integer idCategory, String code, String label) {
		super();
		this.idCategory = idCategory;
		this.code = code;
		this.label = label;
	}

	/**
	 * Method in charge of getting idCategory's value .
	 * @return the idCategory
	 */
	public Integer getIdCategory() {
		return idCategory;
	}

	/**
	 * Method in charge of setting idCategory's value.
	 * @param idCategory the idCategory to set
	 */
	public void setIdCategory(Integer idCategory) {
		this.idCategory = idCategory;
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

	/**
	 * @{inheritDoc}
	*/
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((idCategory == null) ? 0 : idCategory.hashCode());
		result = prime * result + ((label == null) ? 0 : label.hashCode());
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
		if (!(obj instanceof CategoryRequestDTO)) {
			return false;
		}
		CategoryRequestDTO other = (CategoryRequestDTO) obj;
		if (code == null) {
			if (other.code != null) {
				return false;
			}
		} else if (!code.equals(other.code)) {
			return false;
		}
		if (idCategory == null) {
			if (other.idCategory != null) {
				return false;
			}
		} else if (!idCategory.equals(other.idCategory)) {
			return false;
		}
		if (label == null) {
			if (other.label != null) {
				return false;
			}
		} else if (!label.equals(other.label)) {
			return false;
		}
		return true;
	}
	
	
	
}
