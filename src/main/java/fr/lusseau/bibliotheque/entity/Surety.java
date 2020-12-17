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
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Class in charge of defining Surety entity.
 * @Version Bibliotheque -v1,0
 * @date  23 oct. 2020 - 12:24:24
 * @author Claude LUSSEAU
 *
 */
@Entity
@Table(name = "Surety")
public class Surety {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idSurety")
	private int idSurety;
	
	@Column(unique = true, name = "value")
	private double value;
	
	@Column(name = "nbBooks", unique = true)
	private int nbBooks;
		
	/**
	 * Constructor.
	 */
	public Surety() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor.
	 * @param value
	 * @param nbBooks
	 * @param users
	 */
	public Surety(@NotNull @Min(0) double value, @NotNull @Min(0) int nbBooks) {
		this.value = value;
		this.nbBooks = nbBooks;
	}

	/**
	 * Constructor.
	 * @param idSurety
	 * @param value
	 * @param nbBooks
	 * @param users
	 */
	public Surety(int idSurety, @NotNull @Min(0) double value, @NotNull @Min(0) int nbBooks) {
		this.idSurety = idSurety;
		this.value = value;
		this.nbBooks = nbBooks;
	}

	/**
	 * Method in charge of getting idSurety's value .
	 * @return the idSurety
	 */
	public int getIdSurety() {
		return idSurety;
	}

	/**
	 * Method in charge of setting idSurety's value.
	 * @param idSurety the idSurety to set
	 */
	public void setIdSurety(int idSurety) {
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


}
