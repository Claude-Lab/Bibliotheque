/**
 * 
 */
package fr.lusseau.bibliotheque.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

/**
 * Class in charge of defining Category entity.
 * @Version Bibliotheque -v1,0
 * @date  23 oct. 2020 - 12:21:04
 * @author Claude LUSSEAU
 *
 */
@Entity
@Table(name = "Category")
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idCategory")
	private Integer idCategory;
	
	@Column(name = "code")
	private String code;
	
	@NotBlank
	@Column(unique = true, nullable = false, name = "label")
	private String label;
	
	/**
	 * Constructor.
	 */
	public Category() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor.
	 * @param code
	 * @param label
	 */
	public Category(String code, @NotBlank String label) {
		this.code = code;
		this.label = label;
	}

	/**
	 * Constructor.
	 * @param idCategory
	 * @param code
	 * @param label
	 */
	public Category(Integer idCategory, String code, @NotBlank String label) {
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
		if (!(obj instanceof Category)) {
			return false;
		}
		Category other = (Category) obj;
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
