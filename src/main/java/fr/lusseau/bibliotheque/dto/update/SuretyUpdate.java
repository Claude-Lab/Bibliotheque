/**
 * 
 */
package fr.lusseau.bibliotheque.dto.update;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.hateoas.server.core.Relation;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Class in charge of defining .
 * @Version Bibliotheque -v1,0
 * @date  23 déc. 2020 - 14:27:18
 * @author Claude LUSSEAU
 *
 */
@Relation(value = "surety", collectionRelation = "sureties")
@ApiModel(value = "Update Surety Model")
public class SuretyUpdate {

	private Integer id;
	
	@ApiModelProperty(value = "Surety value")
	@NotNull
	private double value;
	
	@ApiModelProperty(value = "Surety number of books")
	@NotNull
	private int nbBooks;
	
	/**
	 * Constructor.
	 */
	public SuretyUpdate() {
		super();
	}

	/**
	 * Constructor.
	 * @param value
	 * @param nbBooks
	 */
	public SuretyUpdate(@NotBlank double value, @NotBlank int nbBooks) {
		super();
		this.value = value;
		this.nbBooks = nbBooks;
	}

	/**
	 * Method in charge of getting id's value .
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Method in charge of setting id's value.
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Method in charge of getting value's value .
	 * @return the value
	 */
	public double getValue() {
		return value;
	}

	/**
	 * Method in charge of setting value's value.
	 * @param value the value to set
	 */
	public void setValue(double value) {
		this.value = value;
	}

	/**
	 * Method in charge of getting nbBooks's value .
	 * @return the nbBooks
	 */
	public int getNbBooks() {
		return nbBooks;
	}

	/**
	 * Method in charge of setting nbBooks's value.
	 * @param nbBooks the nbBooks to set
	 */
	public void setNbBooks(int nbBooks) {
		this.nbBooks = nbBooks;
	}
	
	
}
