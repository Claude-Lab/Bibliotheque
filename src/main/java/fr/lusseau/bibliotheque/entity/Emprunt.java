/**
 * 
 */
package fr.lusseau.bibliotheque.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(columnDefinition = "DATE")
	@NotNull
	private LocalDate dateRetrait;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(columnDefinition = "DATE")
	@NotNull
	private LocalDate dateRetour;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(columnDefinition = "DATE")
	private LocalDate retraitClientOk;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(columnDefinition = "DATE")
	private LocalDate retourClientOk;
	
	@ManyToOne(targetEntity = Livre.class, fetch = FetchType.LAZY )
	@JoinColumn(name="idLivre", nullable=false)
	private Livre livre;
	
	@ManyToOne(targetEntity = Personne.class, fetch = FetchType.LAZY )
	@JoinColumn(name="idPersonne", nullable=false)
	private Personne personne;
	
	/**
	 * Constructeur.
	 */
	public Emprunt() {
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
	public Emprunt(@NotNull LocalDate dateRetrait, @NotNull LocalDate dateRetour, LocalDate retraitClientOk,
			LocalDate retourClientOk, Livre livre, Personne personne) {
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
	public Emprunt(int idEmprunt, @NotNull LocalDate dateRetrait, @NotNull LocalDate dateRetour,
			LocalDate retraitClientOk, LocalDate retourClientOk, Livre livre, Personne personne) {
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
	public LocalDate getDateRetrait() {
		return dateRetrait;
	}

	/**
	 * Méthode en charge de définir la valeur de dateRetrait.
	 * @param dateRetrait the dateRetrait to set
	 */
	public void setDateRetrait(LocalDate dateRetrait) {
		this.dateRetrait = dateRetrait;
	}

	/**
	 * Méthode en charge de récupérer la valeur de dateRetour.
	 * @return the dateRetour
	 */
	public LocalDate getDateRetour() {
		return dateRetour;
	}

	/**
	 * Méthode en charge de définir la valeur de dateRetour.
	 * @param dateRetour the dateRetour to set
	 */
	public void setDateRetour(LocalDate dateRetour) {
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
	public LocalDate getRetraitClientOk() {
		return retraitClientOk;
	}

	/**
	 * Méthode en charge de définir la valeur de retraitClientOk.
	 * @param retraitClientOk the retraitClientOk to set
	 */
	public void setRetraitClientOk(LocalDate retraitClientOk) {
		this.retraitClientOk = retraitClientOk;
	}

	/**
	 * Méthode en charge de récupérer la valeur de retourClientOk.
	 * @return the retourClientOk
	 */
	public LocalDate getRetourClientOk() {
		return retourClientOk;
	}

	/**
	 * Méthode en charge de définir la valeur de retourClientOk.
	 * @param retourClientOk the retourClientOk to set
	 */
	public void setRetourClientOk(LocalDate retourClientOk) {
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



	/**
	 * @{inheritDoc}
	*/
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Emprunt [idEmprunt=");
		builder.append(idEmprunt);
		builder.append(", dateRetrait=");
		builder.append(dateRetrait);
		builder.append(", dateRetour=");
		builder.append(dateRetour);
		builder.append(", retraitClientOk=");
		builder.append(retraitClientOk);
		builder.append(", retourClientOk=");
		return builder.toString();
	}
	
	

	
}
