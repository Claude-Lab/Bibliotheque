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
	@Column(name = "idContact")
	private int idContact;
	
	@Column(name = "street", nullable = false)
	private String street;
	
	@Column(name = "zip", nullable = false)
	private String zip;
	
	@Column(name = "city", nullable = false)
	private String city;
	
	@Column(name = "country", nullable = false)
	private String country;
	
	@Column(name = "mobile")
	private String mobile;
	
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "email", nullable = false)
	private String email;
	
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
	 * @param mobile
	 * @param phone
	 * @param email
	 */
	public Contact(String street, String zip, String city, String country, String mobile, String phone, String email) {
		this.street = street;
		this.zip = zip;
		this.city = city;
		this.country = country;
		this.mobile = mobile;
		this.phone = phone;
		this.email = email;
	}

	/**
	 * Constructor.
	 * @param idContact
	 * @param street
	 * @param zip
	 * @param city
	 * @param country
	 * @param mobile
	 * @param phone
	 * @param email
	 */
	public Contact(int idContact, String street, String zip, String city, String country, String mobile, String phone,
			String email) {
		this.idContact = idContact;
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

	/**
	 * @{inheritDoc}
	*/
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + idContact;
		result = prime * result + ((mobile == null) ? 0 : mobile.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + ((street == null) ? 0 : street.hashCode());
		result = prime * result + ((zip == null) ? 0 : zip.hashCode());
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
		if (!(obj instanceof Contact)) {
			return false;
		}
		Contact other = (Contact) obj;
		if (city == null) {
			if (other.city != null) {
				return false;
			}
		} else if (!city.equals(other.city)) {
			return false;
		}
		if (country == null) {
			if (other.country != null) {
				return false;
			}
		} else if (!country.equals(other.country)) {
			return false;
		}
		if (email == null) {
			if (other.email != null) {
				return false;
			}
		} else if (!email.equals(other.email)) {
			return false;
		}
		if (idContact != other.idContact) {
			return false;
		}
		if (mobile == null) {
			if (other.mobile != null) {
				return false;
			}
		} else if (!mobile.equals(other.mobile)) {
			return false;
		}
		if (phone == null) {
			if (other.phone != null) {
				return false;
			}
		} else if (!phone.equals(other.phone)) {
			return false;
		}
		if (street == null) {
			if (other.street != null) {
				return false;
			}
		} else if (!street.equals(other.street)) {
			return false;
		}
		if (zip == null) {
			if (other.zip != null) {
				return false;
			}
		} else if (!zip.equals(other.zip)) {
			return false;
		}
		return true;
	}
	
	

}
