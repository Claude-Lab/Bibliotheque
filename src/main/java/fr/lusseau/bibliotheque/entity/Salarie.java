/**
 * 
 */
package fr.lusseau.bibliotheque.entity;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * Classe en charge de
 * @Version Bibliotheque -v1,0
 * @date  10 sept. 2020 - 14:05:40
 * @author Claude LUSSEAU
 *
 */
@Entity
public class Salarie extends Personne {

	private static final long serialVersionUID = 3769065787259294183L;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idRole", nullable = false)
	private Role role;

	/**
	 * Constructeur sans parametre.
	 * @param role 
	 */
	public Salarie() {
		super(0, "", "", "", "", "", new Coordonnee(), new Caution(), new ArrayList<Emprunt>(),
				LocalDateTime.now(ZoneId.of("Europe/Paris")), false);
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
	public Salarie(@NotBlank String nom, @NotBlank String prenom, String username, @NotBlank String password,
			@NotBlank String confirmPassword, Coordonnee coordonnee, Caution caution, List<Emprunt> emprunts,
			@NotNull LocalDateTime dateInscription, Role role, boolean enabled)  {
		super(nom, prenom, username, password, confirmPassword, coordonnee, caution, emprunts,
				dateInscription, enabled);
		this.role = role;
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
	public Salarie(int idPersonne,@NotBlank String nom, @NotBlank String prenom, String username, @NotBlank String password,
			@NotBlank String confirmPassword, Coordonnee coordonnee, Caution caution, List<Emprunt> emprunts,
			@NotNull LocalDateTime dateInscription, Role role, boolean enabled)  {
		super(idPersonne, nom, prenom, username, password, confirmPassword, coordonnee, caution, emprunts,
				dateInscription, enabled);
		this.role = role;
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
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof Salarie)) {
			return false;
		}
		Salarie other = (Salarie) obj;
		if (role == null) {
			if (other.role != null) {
				return false;
			}
		} else if (!role.equals(other.role)) {
			return false;
		}
		return true;
	}
	
	

	
}
