/**
 * 
 */
package fr.lusseau.bibliotheque.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * Classe en charge de definir la classe Client.
 * @Version Bibliotheque -v1,0
 * @date  14 août 2020 - 09:59:53
 * @author Claude LUSSEAU
 *
 */
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idPersonne")
public class Client extends Personne {

	private static final long serialVersionUID = 5583248516979540804L;
	
	/**
	 * Constructeur sans parametre.
	 */
	public Client() {
		super();
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
	public Client(int idPersonne,String nom, String prenom, String username, String password, String confirmPassword, Coordonnee coordonnee, Caution caution,
			List<Emprunt> emprunts, LocalDateTime dateInscription) {
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
	public Client(String nom, String prenom, String password, String username, String confirmPassword, Coordonnee coordonnee, Caution caution,
			List<Emprunt> emprunts, LocalDateTime dateInscription) {
		setPrenom(prenom);
		setPrenom(prenom);
		setPassword(password);
		setConfirmPassword(confirmPassword);
		setCoordonnee(coordonnee);
		setCaution(caution);
		setUsername(username);
		setEmprunts(emprunts);
		setDateInscription(dateInscription);
	}



	/**
	 * Méthode en charge de récupérer la valeur de serialversionuid.
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	



	
}
