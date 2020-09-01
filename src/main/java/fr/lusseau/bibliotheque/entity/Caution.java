/**
 * 
 */
package fr.lusseau.bibliotheque.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Classe en charge de definir le bean Caution.
 * @Version Bibliotheque -v1,0
 * @date  14 août 2020 - 09:49:29
 * @author Claude LUSSEAU
 *
 */
@Entity
public class Caution implements Serializable {

	private static final long serialVersionUID = 8461939623329542423L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCaution;
	
	@NotNull
	@Min(value=0)
	@Column(unique = true)
	private int valeur;
	
	@NotNull
	@Min(value=0)
	private int nbLivres;
	
	@OneToMany( targetEntity=Personne.class, mappedBy="caution" )
	private List<Personne> personnes;
	
	/**
	 * Constructeur.
	 */
	public Caution() {
		this(0, 0, 0, new ArrayList<>());
	}

	/**
	 * Constructeur.
	 * @param valeur
	 * @param nbLivres
	 * @param personnes
	 */
	public Caution(int valeur, int nbLivres, List<Personne> personnes) {
		super();
		this.valeur = valeur;
		this.nbLivres = nbLivres;
		this.personnes = personnes;
	}

	/**
	 * Constructeur.
	 * @param idCaution
	 * @param valeur
	 * @param nbLivres
	 * @param personnes
	 */
	public Caution(int idCaution, int valeur, int nbLivres, List<Personne> personnes) {
		super();
		this.idCaution = idCaution;
		this.valeur = valeur;
		this.nbLivres = nbLivres;
		this.personnes = personnes;
	}

	/**
	 * Méthode en charge de récupérer la valeur de idCaution.
	 * @return the idCaution
	 */
	public int getIdCaution() {
		return this.idCaution;
	}

	/**
	 * Méthode en charge de définir la valeur de idCaution.
	 * @param idCaution the idCaution to set
	 */
	public void setIdCaution(int idCaution) {
		this.idCaution = idCaution;
	}

	/**
	 * Méthode en charge de récupérer la valeur de valeur.
	 * @return the valeur
	 */
	public int getValeur() {
		return this.valeur;
	}

	/**
	 * Méthode en charge de définir la valeur de valeur.
	 * @param valeur the valeur to set
	 */
	public void setValeur(int valeur) {
		this.valeur = valeur;
	}

	/**
	 * Méthode en charge de récupérer la valeur de nbLivres.
	 * @return the nbLivres
	 */
	public int getNbLivres() {
		return this.nbLivres;
	}

	/**
	 * Méthode en charge de définir la valeur de nbLivres.
	 * @param nbLivres the nbLivres to set
	 */
	public void setNbLivres(int nbLivres) {
		this.nbLivres = nbLivres;
	}

	/**
	 * Méthode en charge de récupérer la valeur de personnes.
	 * @return the personnes
	 */
	public List<Personne> getPersonnes() {
		return personnes;
	}

	/**
	 * Méthode en charge de définir la valeur de personnes.
	 * @param personnes the personnes to set
	 */
	public void setPersonnes(List<Personne> personnes) {
		this.personnes = personnes;
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
		result = prime * result + idCaution;
		result = prime * result + nbLivres;
		result = prime * result + ((personnes == null) ? 0 : personnes.hashCode());
		result = prime * result + valeur;
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
		Caution other = (Caution) obj;
		if (idCaution != other.idCaution)
			return false;
		if (nbLivres != other.nbLivres)
			return false;
		if (personnes == null) {
			if (other.personnes != null)
				return false;
		} else if (!personnes.equals(other.personnes))
			return false;
		if (valeur != other.valeur)
			return false;
		return true;
	}

	/**
	 * @{inheritDoc}
	*/
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Caution [idCaution=");
		builder.append(idCaution);
		builder.append(", valeur=");
		builder.append(valeur);
		builder.append(", nbLivres=");
		builder.append(nbLivres);
		builder.append("]");
		return builder.toString();
	}

}
