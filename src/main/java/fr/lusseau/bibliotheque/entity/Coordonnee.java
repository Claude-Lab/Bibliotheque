/**
 * 
 */
package fr.lusseau.bibliotheque.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

/**
 * Classe en charge de definir le bean Coordonnee.
 * @Version Bibliotheque -v1,0
 * @date  14 août 2020 - 09:50:19
 * @author Claude LUSSEAU
 *
 */
@Entity
public class Coordonnee implements Serializable{

	private static final long serialVersionUID = 1247279989921730214L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCoordonnee;
	
	@NotBlank
//	@Pattern(regexp = "[0-9a-zA-Z-\\s]")
	private String rue;
	
	@NotBlank
//	@Pattern(regexp = "[0-9]{5}")
	private String cp;
	
	@NotBlank
//	@Pattern(regexp = "[a-zA-Z-\\s]")
	private String ville;
	
	
//	@Pattern(regexp = "[a-zA-Z ]")
	private String pays;
	
//	@Pattern(regexp = "[0-9]{10}")
	private String mobile;
	
//	@Pattern(regexp = "[0-9]{10}")
	private String fixe;
	
	@NotBlank
	@Email
	private String email;
	
	/**
	 * Constructeur.
	 */
	public Coordonnee() {
		this(0, "", "", "", "", "", "", "");
	}

	/**
	 * Constructeur.
	 * @param rue
	 * @param cp
	 * @param ville
	 * @param pays
	 * @param mobile
	 * @param fixe
	 * @param email
	 */
	public Coordonnee(String rue, String cp, String ville, String pays, String mobile, String fixe, String email) {
		super();
		this.rue = rue;
		this.cp = cp;
		this.ville = ville;
		this.pays = pays;
		this.mobile = mobile;
		this.fixe = fixe;
		this.email = email;
	}

	/**
	 * Constructeur.
	 * @param idCoordonnee
	 * @param rue
	 * @param cp
	 * @param ville
	 * @param pays
	 * @param mobile
	 * @param fixe
	 * @param email
	 */
	public Coordonnee(int idCoordonnee, String rue, String cp, String ville, String pays, String mobile, String fixe, String email) {
		super();
		this.idCoordonnee = idCoordonnee;
		this.rue = rue;
		this.cp = cp;
		this.ville = ville;
		this.pays = pays;
		this.mobile = mobile;
		this.fixe = fixe;
		this.email = email;
	}

	/**
	 * Méthode en charge de récupérer la valeur de idCoordonnee.
	 * @return the idCoordonnee
	 */
	public int getIdCoordonnee() {
		return idCoordonnee;
	}

	/**
	 * Méthode en charge de définir la valeur de idCoordonnee.
	 * @param idCoordonnee the idCoordonnee to set
	 */
	public void setIdCoordonnee(int idCoordonnee) {
		this.idCoordonnee = idCoordonnee;
	}

	/**
	 * Méthode en charge de récupérer la valeur de rue.
	 * @return the rue
	 */
	public String getRue() {
		return rue;
	}

	/**
	 * Méthode en charge de définir la valeur de rue.
	 * @param rue the rue to set
	 */
	public void setRue(String rue) {
		this.rue = rue;
	}

	/**
	 * Méthode en charge de récupérer la valeur de cp.
	 * @return the cp
	 */
	public String getCp() {
		return cp;
	}

	/**
	 * Méthode en charge de définir la valeur de cp.
	 * @param cp the cp to set
	 */
	public void setCp(String cp) {
		this.cp = cp;
	}

	/**
	 * Méthode en charge de récupérer la valeur de ville.
	 * @return the ville
	 */
	public String getVille() {
		return ville;
	}

	/**
	 * Méthode en charge de définir la valeur de ville.
	 * @param ville the ville to set
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}

	/**
	 * Méthode en charge de récupérer la valeur de pays.
	 * @return the pays
	 */
	public String getPays() {
		return pays;
	}

	/**
	 * Méthode en charge de définir la valeur de pays.
	 * @param pays the pays to set
	 */
	public void setPays(String pays) {
		this.pays = pays;
	}

	/**
	 * Méthode en charge de récupérer la valeur de mobile.
	 * @return the mobile
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * Méthode en charge de définir la valeur de mobile.
	 * @param mobile the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * Méthode en charge de récupérer la valeur de fixe.
	 * @return the fixe
	 */
	public String getFixe() {
		return fixe;
	}

	/**
	 * Méthode en charge de définir la valeur de fixe.
	 * @param fixe the fixe to set
	 */
	public void setFixe(String fixe) {
		this.fixe = fixe;
	}

	/**
	 * Méthode en charge de récupérer la valeur de email.
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Méthode en charge de définir la valeur de email.
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Méthode en charge de récupérer la valeur de serialversionuid.
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * @{inheritDoc}
	*/
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cp == null) ? 0 : cp.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((fixe == null) ? 0 : fixe.hashCode());
		result = prime * result + idCoordonnee;
		result = prime * result + ((mobile == null) ? 0 : mobile.hashCode());
		result = prime * result + ((pays == null) ? 0 : pays.hashCode());
		result = prime * result + ((rue == null) ? 0 : rue.hashCode());
		result = prime * result + ((ville == null) ? 0 : ville.hashCode());
		return result;
	}

	/**
	 * @{inheritDoc}
	*/
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coordonnee other = (Coordonnee) obj;
		if (cp == null) {
			if (other.cp != null)
				return false;
		} else if (!cp.equals(other.cp))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (fixe == null) {
			if (other.fixe != null)
				return false;
		} else if (!fixe.equals(other.fixe))
			return false;
		if (idCoordonnee != other.idCoordonnee)
			return false;
		if (mobile == null) {
			if (other.mobile != null)
				return false;
		} else if (!mobile.equals(other.mobile))
			return false;
		if (pays == null) {
			if (other.pays != null)
				return false;
		} else if (!pays.equals(other.pays))
			return false;
		if (rue == null) {
			if (other.rue != null)
				return false;
		} else if (!rue.equals(other.rue))
			return false;
		if (ville == null) {
			if (other.ville != null)
				return false;
		} else if (!ville.equals(other.ville))
			return false;
		return true;
	}

	/**
	 * @{inheritDoc}
	*/
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Coordonnee [idCoordonnee=");
		builder.append(idCoordonnee);
		builder.append(", rue=");
		builder.append(rue);
		builder.append(", cp=");
		builder.append(cp);
		builder.append(", ville=");
		builder.append(ville);
		builder.append(", pays=");
		builder.append(pays);
		builder.append(", mobile=");
		builder.append(mobile);
		builder.append(", fixe=");
		builder.append(fixe);
		builder.append(", email=");
		builder.append(email);
		builder.append("]");
		return builder.toString();
	}

	
	
}
