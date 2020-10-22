/**
 * 
 */
package fr.lusseau.bibliotheque.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
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
@Table(name = "Caution")
public class Caution {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idCaution")
	private int idCaution;
	
	@NotNull
	@Min(value=0)
	@Column(unique = true, name = "valeur")
	private double valeur;
	
	@NotNull
	@Min(value=0)
	@Column(name = "nbLivres")
	private int nbLivres;
	
	@OneToMany( targetEntity=Personne.class, mappedBy="caution", fetch = FetchType.LAZY )
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
	public double getValeur() {
		return this.valeur;
	}

	/**
	 * Méthode en charge de définir la valeur de valeur.
	 * @param valeur the valeur to set
	 */
	public void setValeur(double valeur) {
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


}