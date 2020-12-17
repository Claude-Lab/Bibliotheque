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
 * @date 25 oct. 2020 - 17:26:19
 * @author Claude LUSSEAU
 *
 */
@ApiModel(value = "Request Surety Model")
public class SuretyRequestDTO implements Comparable<SuretyRequestDTO> {

	@ApiModelProperty(value = "Surety id")
	private int idSurety;

	@ApiModelProperty(value = "Surety value")
	private double value;

	@ApiModelProperty(value = "Surety nbBooks")
	private int nbBooks;

	/**
	 * @{inheritDoc}
	 */
	@Override
	public int compareTo(SuretyRequestDTO o) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Constructor.
	 */
	public SuretyRequestDTO() {
	}

	/**
	 * Constructor.
	 * 
	 * @param value
	 * @param nbBooks
	 */
	public SuretyRequestDTO(double value, int nbBooks) {
		super();
		this.value = value;
		this.nbBooks = nbBooks;
	}

	/**
	 * Constructor.
	 * 
	 * @param idSurety
	 * @param value
	 * @param nbBooks
	 */
	public SuretyRequestDTO(int idSurety, double value, int nbBooks) {
		super();
		this.idSurety = idSurety;
		this.value = value;
		this.nbBooks = nbBooks;
	}

	/**
	 * Method in charge of getting idSurety's value .
	 * 
	 * @return the idSurety
	 */
	public int getIdSurety() {
		return idSurety;
	}

	/**
	 * Method in charge of setting idSurety's value.
	 * 
	 * @param idSurety the idSurety to set
	 */
	public void setIdSurety(int idSurety) {
		this.idSurety = idSurety;
	}

	/**
	 * Method in charge of getting value's value .
	 * 
	 * @return the value
	 */
	public double getValue() {
		return value;
	}

	/**
	 * Method in charge of setting value's value.
	 * 
	 * @param value the value to set
	 */
	public void setValue(double value) {
		this.value = value;
	}

	/**
	 * Method in charge of getting nbBooks's value .
	 * 
	 * @return the nbBooks
	 */
	public int getNbBooks() {
		return nbBooks;
	}

	/**
	 * Method in charge of setting nbBooks's value.
	 * 
	 * @param nbBooks the nbBooks to set
	 */
	public void setNbBooks(int nbBooks) {
		this.nbBooks = nbBooks;
	}

}
