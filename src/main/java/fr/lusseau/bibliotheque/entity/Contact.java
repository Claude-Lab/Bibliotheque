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

/**
 * Class in charge of defining Contact entity.
 * @Version Bibliotheque -v1,0
 * @date  23 oct. 2020 - 12:29:16
 * @author Claude LUSSEAU
 *
 */
@Entity
@Table(name = "Contact")
public class Contact {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "street", nullable = false)
	private String street;
	
	@Column(name = "zip", nullable = false)
	private String zip;
	
	@Column(name = "city", nullable = false)
	private String city;
	
	@Column(name = "country", nullable = true)
	private String country;
		
	@Column(name = "phone", nullable = true)
	private String phone;
	
	/**
	 * Constructor.
	 */
	public Contact() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor.
	 * @param street
	 * @param zip
	 * @param city
	 * @param country
	 * @param phone
	 * @param email
	 */
	public Contact(String street, String zip, String city, String country, String phone) {
		this.street = street;
		this.zip = zip;
		this.city = city;
		this.country = country;
		this.phone = phone;
	}

	/**
	 * Constructor.
	 * @param idContact
	 * @param street
	 * @param zip
	 * @param city
	 * @param country
	 * @param phone
	 * @param email
	 */
	public Contact(int id, String street, String zip, String city, String country, String phone) {
		this.id = id;
		this.street = street;
		this.zip = zip;
		this.city = city;
		this.country = country;
		this.phone = phone;
	}

	/**
	 * Method in charge of getting idContact's value .
	 * @return the idContact
	 */
	public int getId() {
		return id;
	}

	/**
	 * Method in charge of setting idContact's value.
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Method in charge of getting street's value .
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * Method in charge of setting street's value.
	 * @param street the street to set
	 */
	public void setStreet(String street) {
		this.street = street;
	}

	/**
	 * Method in charge of getting zip's value .
	 * @return the zip
	 */
	public String getZip() {
		return zip;
	}

	/**
	 * Method in charge of setting zip's value.
	 * @param zip the zip to set
	 */
	public void setZip(String zip) {
		this.zip = zip;
	}

	/**
	 * Method in charge of getting city's value .
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * Method in charge of setting city's value.
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * Method in charge of getting country's value .
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * Method in charge of setting country's value.
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * Method in charge of getting phone's value .
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * Method in charge of setting phone's value.
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	
}
