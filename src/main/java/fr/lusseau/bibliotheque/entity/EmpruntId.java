/**
 * 
 */
package fr.lusseau.bibliotheque.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

/**
 * Classe en charge de
 * @Version Bibliotheque -v1,0
 * @date  17 oct. 2020 - 17:49:38
 * @author Claude LUSSEAU
 *
 */
@Embeddable
public class EmpruntId implements Serializable {

	private static final long serialVersionUID = 5382008555756597086L;
	
	@ManyToOne
	private Livre livre;
    
	@ManyToOne
    private Personne personne;
    
    @Column(name = "creationDateTime")
    private LocalDateTime creationDateTime;
    
    public EmpruntId() {
        super();
    }

    public EmpruntId(Livre livre, Personne personne) {
        super();
        this.livre = livre;
        this.personne = personne;
        this.creationDateTime = LocalDateTime.now();
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
	 * Méthode en charge de récupérer la valeur de creationDateTime.
	 * @return the creationDateTime
	 */
	public LocalDateTime getCreationDateTime() {
		return creationDateTime;
	}

	/**
	 * Méthode en charge de définir la valeur de creationDateTime.
	 * @param creationDateTime the creationDateTime to set
	 */
	public void setCreationDateTime(LocalDateTime creationDateTime) {
		this.creationDateTime = creationDateTime;
	}

	/**
	 * @{inheritDoc}
	*/
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((creationDateTime == null) ? 0 : creationDateTime.hashCode());
		result = prime * result + ((livre == null) ? 0 : livre.hashCode());
		result = prime * result + ((personne == null) ? 0 : personne.hashCode());
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
		if (!(obj instanceof EmpruntId)) {
			return false;
		}
		EmpruntId other = (EmpruntId) obj;
		if (creationDateTime == null) {
			if (other.creationDateTime != null) {
				return false;
			}
		} else if (!creationDateTime.equals(other.creationDateTime)) {
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
		return true;
	}

    

}
