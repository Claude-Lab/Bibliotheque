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
@ApiModel(value = "Create Surety Model")
public class CreateSuretyRequest implements Comparable<CreateSuretyRequest> {

	@ApiModelProperty(value = "Surety id")
	private Integer idSurety;

	@ApiModelProperty(value = "Surety value")
	private double value;
	
	@ApiModelProperty(value = "Surety number of books")
	private int nbBooks;
	
	/**
	 * Constructor.
	 */
	public CreateSuretyRequest() {
	}

	
	/**
	 * Constructor.
	 * @param value
	 * @param nbBooks
	 */
	public CreateSuretyRequest(double value, int nbBooks) {
		super();
		this.value = value;
		this.nbBooks = nbBooks;
	}


	/**
	 * Method in charge of getting idSurety's value .
	 * @return the idSurety
	 */
	public Integer getIdSurety() {
		return idSurety;
	}


	/**
	 * Method in charge of setting idSurety's value.
	 * @param idSurety the idSurety to set
	 */
	public void setIdSurety(Integer idSurety) {
		this.idSurety = idSurety;
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


	/**
	 * @{inheritDoc}
	 */
	@Override
	public int compareTo(CreateSuretyRequest o) {

		return o.getValue().compareTo(this.value);
	}

}
