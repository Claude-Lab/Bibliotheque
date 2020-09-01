/**
 * 
 */
package fr.lusseau.bibliotheque.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * Classe en charge de
 * @Version Bibliotheque -v1,0
 * @date  14 août 2020 - 09:54:03
 * @author Claude LUSSEAU
 *
 */
@Entity
public class Emprunt implements Serializable {

	private static final long serialVersionUID = 2325950927440932474L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idEmprunt;
	
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@Column(columnDefinition = "DATETIME")
	@NotNull
	private LocalDateTime dateRetrait;
	
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@Column(columnDefinition = "DATETIME")
	@NotNull
	private LocalDateTime dateRetour;
	
	@DateTimeFormat(pattern="dd/MM/yyyy HH:mm")
	@Column(columnDefinition = "DATETIME")
	private LocalDateTime retraitClientOk;
	
	@DateTimeFormat(pattern="dd/MM/yyyy HH:mm")
	@Column(columnDefinition = "DATETIME")
	private LocalDateTime retourClientOk;
	
	@ManyToOne
	private Livre livre;
	
	@OneToOne
	private Personne personne;
	
	/**
	 * Constructeur.
	 */
	public Emprunt() {
		//this(0, LocalDateTime.now(ZoneId.of("Europe/Paris")), LocalDateTime.now(ZoneId.of("Europe/Paris")), LocalDateTime.now(ZoneId.of("Europe/Paris")), LocalDateTime.now(ZoneId.of("Europe/Paris")), new Livre(), new Personne());
	}

	

	/**
	 * Constructeur.
	 * @param dateRetrait
	 * @param dateRetour
	 * @param retraitClientOk
	 * @param retourClientOk
	 * @param livre
	 * @param personne
	 */
	public Emprunt(@NotNull LocalDateTime dateRetrait, @NotNull LocalDateTime dateRetour, LocalDateTime retraitClientOk,
			LocalDateTime retourClientOk, Livre livre, Personne personne) {
		this.dateRetrait = dateRetrait;
		this.dateRetour = dateRetour;
		this.retraitClientOk = retraitClientOk;
		this.retourClientOk = retourClientOk;
		this.livre = livre;
		this.personne = personne;
	}

	/**
	 * Constructeur.
	 * @param idEmprunt
	 * @param dateRetrait
	 * @param dateRetour
	 * @param retraitClientOk
	 * @param retourClientOk
	 * @param livre
	 * @param personne
	 */
	public Emprunt(int idEmprunt, @NotNull LocalDateTime dateRetrait, @NotNull LocalDateTime dateRetour,
			LocalDateTime retraitClientOk, LocalDateTime retourClientOk, Livre livre, Personne personne) {
		this.idEmprunt = idEmprunt;
		this.dateRetrait = dateRetrait;
		this.dateRetour = dateRetour;
		this.retraitClientOk = retraitClientOk;
		this.retourClientOk = retourClientOk;
		this.livre = livre;
		this.personne = personne;
	}



	/**
	 * Méthode en charge de récupérer la valeur de idEmprunt.
	 * @return the idEmprunt
	 */
	public int getIdEmprunt() {
		return idEmprunt;
	}

	/**
	 * Méthode en charge de définir la valeur de idEmprunt.
	 * @param idEmprunt the idEmprunt to set
	 */
	public void setIdEmprunt(int idEmprunt) {
		this.idEmprunt = idEmprunt;
	}

	/**
	 * Méthode en charge de récupérer la valeur de dateRetrait.
	 * @return the dateRetrait
	 */
	public LocalDateTime getDateRetrait() {
		return dateRetrait;
	}

	/**
	 * Méthode en charge de définir la valeur de dateRetrait.
	 * @param dateRetrait the dateRetrait to set
	 */
	public void setDateRetrait(LocalDateTime dateRetrait) {
		this.dateRetrait = dateRetrait;
	}

	/**
	 * Méthode en charge de récupérer la valeur de dateRetour.
	 * @return the dateRetour
	 */
	public LocalDateTime getDateRetour() {
		return dateRetour;
	}

	/**
	 * Méthode en charge de définir la valeur de dateRetour.
	 * @param dateRetour the dateRetour to set
	 */
	public void setDateRetour(LocalDateTime dateRetour) {
		this.dateRetour = dateRetour;
	}

	/**
	 * Méthode en charge de récupérer la valeur de livres.
	 * @return the livres
	 */
	public Livre getLivres() {
		return livre;
	}

	/**
	 * Méthode en charge de définir la valeur de livres.
	 * @param livres the livres to set
	 */
	public void setLivres(Livre livre) {
		this.livre = livre;
	}

	/**
	 * Méthode en charge de récupérer la valeur de personne.
	 * @return the personne
	 */
	public Personne getPersonne() {
		return personne;
	}

	/**
	 * Méthode en charge de définir la valeur de personne.
	 * @param personne the personne to set
	 */
	public void setPersonne(Personne personne) {
		this.personne = personne;
	}
	

	/**
	 * Méthode en charge de récupérer la valeur de retraitClientOk.
	 * @return the retraitClientOk
	 */
	public LocalDateTime getRetraitClientOk() {
		return retraitClientOk;
	}

	/**
	 * Méthode en charge de définir la valeur de retraitClientOk.
	 * @param retraitClientOk the retraitClientOk to set
	 */
	public void setRetraitClientOk(LocalDateTime retraitClientOk) {
		this.retraitClientOk = retraitClientOk;
	}

	/**
	 * Méthode en charge de récupérer la valeur de retourClientOk.
	 * @return the retourClientOk
	 */
	public LocalDateTime getRetourClientOk() {
		return retourClientOk;
	}

	/**
	 * Méthode en charge de définir la valeur de retourClientOk.
	 * @param retourClientOk the retourClientOk to set
	 */
	public void setRetourClientOk(LocalDateTime retourClientOk) {
		this.retourClientOk = retourClientOk;
	}

	/**
	 * Méthode en charge de récupérer la valeur de livre.
	 * @return the livre
	 */
	public Livre getLivre() {
		return livre;
	}

	/**
	 * Méthode en charge de définir la valeur de livre.
	 * @param livre the livre to set
	 */
	public void setLivre(Livre livre) {
		this.livre = livre;
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
		result = prime * result + ((dateRetour == null) ? 0 : dateRetour.hashCode());
		result = prime * result + ((dateRetrait == null) ? 0 : dateRetrait.hashCode());
		result = prime * result + idEmprunt;
		result = prime * result + ((livre == null) ? 0 : livre.hashCode());
		result = prime * result + ((personne == null) ? 0 : personne.hashCode());
		result = prime * result + ((retourClientOk == null) ? 0 : retourClientOk.hashCode());
		result = prime * result + ((retraitClientOk == null) ? 0 : retraitClientOk.hashCode());
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
		Emprunt other = (Emprunt) obj;
		if (dateRetour == null) {
			if (other.dateRetour != null)
				return false;
		} else if (!dateRetour.equals(other.dateRetour))
			return false;
		if (dateRetrait == null) {
			if (other.dateRetrait != null)
				return false;
		} else if (!dateRetrait.equals(other.dateRetrait))
			return false;
		if (idEmprunt != other.idEmprunt)
			return false;
		if (livre == null) {
			if (other.livre != null)
				return false;
		} else if (!livre.equals(other.livre))
			return false;
		if (personne == null) {
			if (other.personne != null)
				return false;
		} else if (!personne.equals(other.personne))
			return false;
		if (retourClientOk == null) {
			if (other.retourClientOk != null)
				return false;
		} else if (!retourClientOk.equals(other.retourClientOk))
			return false;
		if (retraitClientOk == null) {
			if (other.retraitClientOk != null)
				return false;
		} else if (!retraitClientOk.equals(other.retraitClientOk))
			return false;
		return true;
	}

	
}
