/**
 * 
 */
package fr.lusseau.bibliotheque.dto.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Class in charge of defining .
 * @Version Bibliotheque -v1,0
 * @date  23 oct. 2020 - 19:12:50
 * @author Claude LUSSEAU
 *
 */
@ApiModel(value = "Create Contact Model")
public class CreateContactRequest {

	@ApiModelProperty(value = "Contact id")
	private int idContact;
	
	@ApiModelProperty(value = "street")
	private String street;
	
	@ApiModelProperty(value = "Contact zip code")
	private String zip;
	
	@ApiModelProperty(value = "Contact city")
	private String city;
	
	@ApiModelProperty(value = "Contact country")
	private String country;
	
	@ApiModelProperty(value = "Contact mobile")
	private String mobile;
	
	@ApiModelProperty(value = "Contact phone")
	private String phone;
	
	@ApiModelProperty(value = "Contact email")
	private String email;
	
	/**
	 * Constructor.
	 */
	public CreateContactRequest() {
	}

	/**
	 * Constructor.
	 * @param street
	 * @param zip
	 * @param city
	 * @param country
	 * @param mobile
	 * @param phone
	 * @param email
	 */
	public CreateContactRequest(String street, String zip, String city, String country, String mobile,
			String phone, String email) {
		super();
		this.street = street;
		this.zip = zip;
		this.city = city;
		this.country = country;
		this.mobile = mobile;
		this.phone = phone;
		this.email = email;
	}



	/**
	 * Method in charge of getting idContact's value .
	 * @return the idContact
	 */
	public int getIdContact() {
		return idContact;
	}

	/**
	 * Method in charge of setting idContact's value.
	 * @param idContact the idContact to set
	 */
	public void setIdContact(int idContact) {
		this.idContact = idContact;
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
	 * Method in charge of getting mobile's value .
	 * @return the mobile
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * Method in charge of setting mobile's value.
	 * @param mobile the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
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

	/**
	 * Method in charge of getting email's value .
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Method in charge of setting email's value.
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
