/**
 * 
 */
package fr.lusseau.bibliotheque.entity;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;

/**
 * Classe en charge de definir la classe Salarie.
 * @Version Bibliotheque -v1,0
 * @date  14 août 2020 - 09:57:12
 * @author Claude LUSSEAU
 *
 */
@Entity
public class Salarie extends Personne {

	private static final long serialVersionUID = -3204398006575363591L;
	
	/**
	 * Constructeur sans parametre.
	 */
	public Salarie() {
		super(0,"","","","",new Coordonnee(), new Caution(), new Role(), new ArrayList<>(), LocalDateTime.now(ZoneId.of("Europe/Paris")));
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
	public Salarie(int idPersonne, String nom, String prenom, String password, String confirmPassword, Coordonnee coordonnee, Caution caution, Role role,
			List<Emprunt> emprunts, LocalDateTime dateInscription) {
		super(idPersonne, nom, prenom, password, confirmPassword, coordonnee, caution, role, emprunts,
				dateInscription);
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
	public Salarie(String nom,  String prenom, String password, String confirmPassword, Coordonnee coordonnee, Caution caution, Role role,
			List<Emprunt> emprunts, LocalDateTime dateInscription) {
		super(nom, prenom, password, confirmPassword, coordonnee, caution, role, emprunts, dateInscription);
	}

	/**
	 * Méthode en charge de récupérer la valeur de serialversionuid.
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	

	

	
}
