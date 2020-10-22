/**
 * 
 */
package fr.lusseau.bibliotheque.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Classe en charge de
 * @Version Bibliotheque -v1,0
 * @date  14 août 2020 - 09:54:03
 * @author Claude LUSSEAU
 *
 */
@Entity
@Table(name = "Emprunt")
//@AssociationOverrides({
//@AssociationOverride(name = "pk.livre", joinColumns = @JoinColumn(name = "idLivre")),
//@AssociationOverride(name = "pk.personne", joinColumns = @JoinColumn(name = "idPersonne"))
//})
public class Emprunt {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idEmprunt")
	private Integer idEmprunt;
    
	@Column(name = "beginDate", nullable = false)
    private LocalDate beginDate;
    
	@Column(name = "endDate", nullable = false)
    private LocalDate endDate;
    
	@Enumerated(EnumType.STRING)
	@Column(name = "status")
    private EmpruntStatus status;
	
	@ManyToOne(targetEntity = Livre.class, fetch = FetchType.LAZY )
	@JoinColumn(name="idLivre", nullable=false)
	private Livre livre;
	
	@ManyToOne(targetEntity = Personne.class, fetch = FetchType.LAZY )
	@JoinColumn(name="idPersonne", nullable=false)
	private Personne personne;

	

	/**
	 * Méthode en charge de récupérer la valeur de idEmprunt.
	 * @return the idEmprunt
	 */
	public Integer getIdEmprunt() {
		return idEmprunt;
	}

	/**
	 * Méthode en charge de définir la valeur de idEmprunt.
	 * @param idEmprunt the idEmprunt to set
	 */
	public void setIdEmprunt(Integer idEmprunt) {
		this.idEmprunt = idEmprunt;
	}

	/**
	 * Méthode en charge de récupérer la valeur de beginDate.
	 * @return the beginDate
	 */
	public LocalDate getBeginDate() {
		return beginDate;
	}

	/**
	 * Méthode en charge de définir la valeur de beginDate.
	 * @param beginDate the beginDate to set
	 */
	public void setBeginDate(LocalDate beginDate) {
		this.beginDate = beginDate;
	}

	/**
	 * Méthode en charge de récupérer la valeur de endDate.
	 * @return the endDate
	 */
	public LocalDate getEndDate() {
		return endDate;
	}

	/**
	 * Méthode en charge de définir la valeur de endDate.
	 * @param endDate the endDate to set
	 */
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	/**
	 * Méthode en charge de récupérer la valeur de status.
	 * @return the status
	 */
	public EmpruntStatus getStatus() {
		return status;
	}

	/**
	 * Méthode en charge de définir la valeur de status.
	 * @param status the status to set
	 */
	public void setStatus(EmpruntStatus status) {
		this.status = status;
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
	 * @{inheritDoc}
	*/
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((beginDate == null) ? 0 : beginDate.hashCode());
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + ((idEmprunt == null) ? 0 : idEmprunt.hashCode());
		result = prime * result + ((livre == null) ? 0 : livre.hashCode());
		result = prime * result + ((personne == null) ? 0 : personne.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		if (!(obj instanceof Emprunt)) {
			return false;
		}
		Emprunt other = (Emprunt) obj;
		if (beginDate == null) {
			if (other.beginDate != null) {
				return false;
			}
		} else if (!beginDate.equals(other.beginDate)) {
			return false;
		}
		if (endDate == null) {
			if (other.endDate != null) {
				return false;
			}
		} else if (!endDate.equals(other.endDate)) {
			return false;
		}
		if (idEmprunt == null) {
			if (other.idEmprunt != null) {
				return false;
			}
		} else if (!idEmprunt.equals(other.idEmprunt)) {
			return false;
		}
		if (livre == null) {
			if (other.livre != null) {
				return false;
			}
		} else if (!livre.equals(other.livre)) {
			return false;
		}
		if (personne == null) {
			if (other.personne != null) {
				return false;
			}
		} else if (!personne.equals(other.personne)) {
			return false;
		}
		if (status != other.status) {
			return false;
		}
		return true;
	}

	
}
