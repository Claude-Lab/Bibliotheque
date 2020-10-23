/**
 * 
 */
package fr.lusseau.bibliotheque.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
	
	@NotNull
	@Min(value=0)
	@Column(unique = true, name = "value")
	private double value;
	
	@NotNull
	@Min(value=0)
	@Column(name = "nbBooks")
	private int nbBooks;
	
	@OneToMany( targetEntity=User.class, mappedBy="surety", fetch = FetchType.LAZY )
	private List<User> users;
	
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
	public Surety(@NotNull @Min(0) double value, @NotNull @Min(0) int nbBooks, List<User> users) {
		this.value = value;
		this.nbBooks = nbBooks;
		this.users = users;
	}

	/**
	 * Constructor.
	 * @param idSurety
	 * @param value
	 * @param nbBooks
	 * @param users
	 */
	public Surety(int idSurety, @NotNull @Min(0) double value, @NotNull @Min(0) int nbBooks, List<User> users) {
		this.idSurety = idSurety;
		this.value = value;
		this.nbBooks = nbBooks;
		this.users = users;
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

	/**
	 * Method in charge of getting users's value .
	 * @return the users
	 */
	public List<User> getUsers() {
		return users;
	}

	/**
	 * Method in charge of setting users's value.
	 * @param users the users to set
	 */
	public void setUsers(List<User> users) {
		this.users = users;
	}

	/**
	 * @{inheritDoc}
	*/
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idSurety;
		result = prime * result + nbBooks;
		long temp;
		temp = Double.doubleToLongBits(value);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		if (!(obj instanceof Surety)) {
			return false;
		}
		Surety other = (Surety) obj;
		if (idSurety != other.idSurety) {
			return false;
		}
		if (nbBooks != other.nbBooks) {
			return false;
		}
		if (Double.doubleToLongBits(value) != Double.doubleToLongBits(other.value)) {
			return false;
		}
		return true;
	}
	
	

}
