/**
 * 
 */
package fr.lusseau.bibliotheque.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * Classe en charge de definir la classe Salarie.
 * @Version Bibliotheque -v1,0
 * @date  14 août 2020 - 09:57:12
 * @author Claude LUSSEAU
 *
 */
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idPersonne")
public class Salarie extends Personne {

	private static final long serialVersionUID = -3204398006575363591L;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idRole", nullable = false)
	private Role role;
	
	
	/**
	 * Constructeur sans parametre.
	 */
	public Salarie() {
	}

	/**
	 * Constructeur.
	 * @param idPersonne
	 * @param login
	 * @param nom
	 * @param prenom
	 * @param motDePasse
	 * @param confirmMotDePasse
	 * @param coordonnee
	 * @param caution
	 * @param role
	 * @param emprunts
	 * @param dateInscription
	 */
	public Salarie(int idPersonne, String nom, String prenom, String username, String password, String confirmPassword, Coordonnee coordonnee, Caution caution, Role role,
			List<Emprunt> emprunts, LocalDateTime dateInscription) {
		super();
		setIdPersonne(idPersonne);
		setPrenom(prenom);
		setPrenom(prenom);
		setPassword(password);
		setConfirmPassword(confirmPassword);
		setCoordonnee(coordonnee);
		setCaution(caution);
		setUsername(username);
		setEmprunts(emprunts);
		setDateInscription(dateInscription);
		setRole(role);
	}

	/**
	 * Constructeur.
	 * @param login
	 * @param nom
	 * @param prenom
	 * @param motDePasse
	 * @param confirmMotDePasse
	 * @param coordonnee
	 * @param caution
	 * @param role
	 * @param emprunts
	 * @param dateInscription
	 */
	public Salarie(String nom,  String prenom, String password, String username, String confirmPassword, Coordonnee coordonnee, Caution caution, Role role,
			List<Emprunt> emprunts, LocalDateTime dateInscription) {
		super();
		setPrenom(prenom);
		setPrenom(prenom);
		setPassword(password);
		setConfirmPassword(confirmPassword);
		setCoordonnee(coordonnee);
		setCaution(caution);
		setUsername(username);
		setEmprunts(emprunts);
		setDateInscription(dateInscription);
		setRole(role);
	}

	/**
	 * Méthode en charge de récupérer la valeur de serialversionuid.
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * Méthode en charge de récupérer la valeur de role.
	 * @return the role
	 */
	public Role getRole() {
		return role;
	}

	/**
	 * Méthode en charge de définir la valeur de role.
	 * @param role the role to set
	 */
	public void setRole(Role role) {
		this.role = role;
	}

	/**
	 * @{inheritDoc}
	*/
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		return result;
	}

	/**
	 * @{inheritDoc}
	*/
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Salarie other = (Salarie) obj;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		return true;
	}

	/**
	 * @{inheritDoc}
	*/
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Salarie [role=");
		builder.append(role);
		builder.append("]");
		return builder.toString();
	}
}
