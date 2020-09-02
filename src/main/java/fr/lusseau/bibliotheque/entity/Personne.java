/**
 * 
 */
package fr.lusseau.bibliotheque.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * Classe en charge de definir le bean Personne.
 * 
 * @Version Bibliotheque -v1,0
 * @date 14 août 2020 - 09:44:43
 * @author Claude LUSSEAU
 *
 */
@Entity
@Component
@Inheritance(strategy = InheritanceType.JOINED)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idPersonne")
public class Personne implements Serializable, UserDetails {

	private static final long serialVersionUID = 5259404382419783534L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPersonne;

	@NotBlank
//	@Pattern(regexp = "[a-zA-Z- ]")
	private String nom;

	@NotBlank
//	@Pattern(regexp = "[a-zA-Z- ]")
	private String prenom;

	@Column(name = "username")
	private String username;

	@NotBlank
	private String password;

	@NotBlank
	private String confirmPassword;

	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	@JoinColumn(name = "idCoordonnee", nullable = false)
	private Coordonnee coordonnee;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idCaution", nullable = false)
	private Caution caution;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idRole", nullable = false)
	private Role role;

	@OneToMany(targetEntity = Emprunt.class, mappedBy = "personne", fetch = FetchType.LAZY)
	private List<Emprunt> emprunts;

	@JsonFormat(pattern = "dd-MM-yyy HH:mm", timezone = "UTC")
	@Column(columnDefinition = "DATETIME")
	@NotNull
	private LocalDateTime dateInscription;


	/**
	 * Constructeur.
	 */
	public Personne() {
		this(0, "", "", "", "", new Coordonnee(), new Caution(), new Role(), new ArrayList<Emprunt>(),
				LocalDateTime.now(ZoneId.of("Europe/Paris")));

	}

	/**
	 * Constructeur.
	 * 
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
	public Personne(String nom, String prenom, String password, String confirmPassword,
			Coordonnee coordonnee, Caution caution, Role role, List<Emprunt> emprunts, LocalDateTime dateInscription) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.username = (prenom + nom).toLowerCase();
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.coordonnee = coordonnee;
		this.caution = caution;
		this.role = role;
		this.emprunts = emprunts;
		this.dateInscription = dateInscription;
	}

	/**
	 * Constructeur.
	 * 
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
	public Personne(int idPersonne, String nom, String prenom, String password, String confirmPassword,
			Coordonnee coordonnee, Caution caution, Role role, List<Emprunt> emprunts, LocalDateTime dateInscription) {
		super();
		this.idPersonne = idPersonne;
		this.nom = nom;
		this.prenom = prenom;
		this.username = (prenom + nom).toLowerCase();
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.coordonnee = coordonnee;
		this.caution = caution;
		this.role = role;
		this.emprunts = emprunts;
		this.dateInscription = dateInscription;
	}

	/**
	 * @{inheritDoc}
	 */
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @{inheritDoc}
	 */
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.password;
	}

	/**
	 * @{inheritDoc}
	 */
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return (this.prenom + this.nom).toLowerCase();
	}

	/**
	 * @{inheritDoc}
	 */
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * @{inheritDoc}
	 */
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * @{inheritDoc}
	 */
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * @{inheritDoc}
	 */
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Méthode en charge de récupérer la valeur de idPersonne.
	 * 
	 * @return the idPersonne
	 */
	public int getIdPersonne() {
		return this.idPersonne;
	}

	/**
	 * Méthode en charge de définir la valeur de idPersonne.
	 * 
	 * @param idPersonne the idPersonne to set
	 */
	public void setIdPersonne(int idPersonne) {
		this.idPersonne = idPersonne;
	}

	/**
	 * Méthode en charge de récupérer la valeur de nom.
	 * 
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Méthode en charge de définir la valeur de nom.
	 * 
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Méthode en charge de récupérer la valeur de prenom.
	 * 
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * Méthode en charge de définir la valeur de prenom.
	 * 
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * Méthode en charge de récupérer la valeur de confirmPassword.
	 * 
	 * @return the confirmPassword
	 */
	public String getConfirmPassword() {
		return confirmPassword;
	}

	/**
	 * Méthode en charge de définir la valeur de confirmPassword.
	 * 
	 * @param confirmPassword the confirmPassword to set
	 */
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	/**
	 * Méthode en charge de récupérer la valeur de coordonnee.
	 * 
	 * @return the coordonnee
	 */
	public Coordonnee getCoordonnee() {
		return coordonnee;
	}

	/**
	 * Méthode en charge de définir la valeur de coordonnee.
	 * 
	 * @param coordonnee the coordonnee to set
	 */
	public void setCoordonnee(Coordonnee coordonnee) {
		this.coordonnee = coordonnee;
	}

	/**
	 * Méthode en charge de récupérer la valeur de caution.
	 * 
	 * @return the caution
	 */
	public Caution getCaution() {
		return caution;
	}

	/**
	 * Méthode en charge de définir la valeur de caution.
	 * 
	 * @param caution the caution to set
	 */
	public void setCaution(Caution caution) {
		this.caution = caution;
	}

	/**
	 * Méthode en charge de récupérer la valeur de role.
	 * 
	 * @return the role
	 */
	public Role getRole() {
		return role;
	}

	/**
	 * Méthode en charge de définir la valeur de role.
	 * 
	 * @param role the role to set
	 */
	public void setRole(Role role) {
		this.role = role;
	}

	/**
	 * Méthode en charge de récupérer la valeur de emprunts.
	 * 
	 * @return the emprunts
	 */
	public List<Emprunt> getEmprunts() {
		return emprunts;
	}

	/**
	 * Méthode en charge de définir la valeur de emprunts.
	 * 
	 * @param emprunts the emprunts to set
	 */
	public void setEmprunts(List<Emprunt> emprunts) {
		this.emprunts = emprunts;
	}

	/**
	 * Méthode en charge de récupérer la valeur de dateInscription.
	 * 
	 * @return the dateInscription
	 */
	public LocalDateTime getDateInscription() {
		return dateInscription;
	}

	/**
	 * Méthode en charge de définir la valeur de dateInscription.
	 * 
	 * @param dateInscription the dateInscription to set
	 */
	public void setDateInscription(LocalDateTime dateInscription) {
		this.dateInscription = dateInscription;
	}

	/**
	 * Méthode en charge de récupérer la valeur de serialversionuid.
	 * 
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * Méthode en charge de définir la valeur de username.
	 * 
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = (prenom + nom).toLowerCase();
	}
	
	

	/**
	 * Méthode en charge de définir la valeur de password.
	 * 
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @{inheritDoc}
	*/
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((caution == null) ? 0 : caution.hashCode());
		result = prime * result + ((confirmPassword == null) ? 0 : confirmPassword.hashCode());
		result = prime * result + ((coordonnee == null) ? 0 : coordonnee.hashCode());
		result = prime * result + ((dateInscription == null) ? 0 : dateInscription.hashCode());
		result = prime * result + ((emprunts == null) ? 0 : emprunts.hashCode());
		result = prime * result + idPersonne;
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((prenom == null) ? 0 : prenom.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		Personne other = (Personne) obj;
		if (caution == null) {
			if (other.caution != null)
				return false;
		} else if (!caution.equals(other.caution))
			return false;
		if (confirmPassword == null) {
			if (other.confirmPassword != null)
				return false;
		} else if (!confirmPassword.equals(other.confirmPassword))
			return false;
		if (coordonnee == null) {
			if (other.coordonnee != null)
				return false;
		} else if (!coordonnee.equals(other.coordonnee))
			return false;
		if (dateInscription == null) {
			if (other.dateInscription != null)
				return false;
		} else if (!dateInscription.equals(other.dateInscription))
			return false;
		if (emprunts == null) {
			if (other.emprunts != null)
				return false;
		} else if (!emprunts.equals(other.emprunts))
			return false;
		if (idPersonne != other.idPersonne)
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (prenom == null) {
			if (other.prenom != null)
				return false;
		} else if (!prenom.equals(other.prenom))
			return false;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	/**
	 * @{inheritDoc}
	*/
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Personne [idPersonne=");
		builder.append(idPersonne);
		builder.append(", nom=");
		builder.append(nom);
		builder.append(", prenom=");
		builder.append(prenom);
		builder.append(", username=");
		builder.append(username);
		builder.append(", password=");
		builder.append(password);
		builder.append(", confirmPassword=");
		builder.append(confirmPassword);
		builder.append(", coordonnee=");
		builder.append(coordonnee);
		builder.append(", caution=");
		builder.append(caution);
		builder.append(", role=");
		builder.append(role);
		builder.append(", emprunts=");
		builder.append(emprunts);
		builder.append(", dateInscription=");
		builder.append(dateInscription);
		builder.append("]");
		return builder.toString();
	}

	

}
