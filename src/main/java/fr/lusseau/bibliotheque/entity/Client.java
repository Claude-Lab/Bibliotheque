/**
 * 
 */
package fr.lusseau.bibliotheque.entity;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * Classe en charge de
 * @Version Bibliotheque -v1,0
 * @date  10 sept. 2020 - 14:06:13
 * @author Claude LUSSEAU
 *
 */
@Entity
public class Client extends Personne {

	private static final long serialVersionUID = 2549271970437244382L;
	
	/**
	 * Constructeur sans parametre.
	 */
	public Client() {
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
	 * @param emprunts
	 * @param dateInscription
	 */
	public Client(@NotBlank String nom, @NotBlank String prenom, String username, @NotBlank String password,
			@NotBlank String confirmPassword, Coordonnee coordonnee, Caution caution, List<Emprunt> emprunts,
			@NotNull LocalDateTime dateInscription, boolean enabled)  {
		super(nom, prenom, username, password, confirmPassword, coordonnee, caution, emprunts,
				dateInscription, enabled);
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
	 * @param emprunts
	 * @param dateInscription
	 */
	public Client(int idPersonne,@NotBlank String nom, @NotBlank String prenom, String username, @NotBlank String password,
			@NotBlank String confirmPassword, Coordonnee coordonnee, Caution caution, List<Emprunt> emprunts,
			@NotNull LocalDateTime dateInscription, boolean enabled)  {
		super(idPersonne, nom, prenom, username, password, confirmPassword, coordonnee, caution, emprunts,
				dateInscription, enabled);
	}

	/**
	 * Méthode en charge de récupérer la valeur de serialversionuid.
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
