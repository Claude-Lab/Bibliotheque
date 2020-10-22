/**
 * 
 */
package fr.lusseau.bibliotheque.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Classe en charge de
 * @Version Bibliotheque -v1,0
 * @date  Aug 28, 2020 - 10:45:40 AM
 * @author Claude LUSSEAU
 *
 */
@Entity
@Table(name = "Bibliotheque")
public class Bibliotheque implements Serializable {

	private static final long serialVersionUID = 7887547268848737456L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idBibliotheque")
	private int idBibliotheque;
	
	@Column(unique = true, name = "nom")
	private String nom;
	
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	@JoinColumn( name="idCoordonnee", nullable=false )
	private Coordonnee coordonnee;
	
	@OneToMany( targetEntity=Livre.class, mappedBy="bibliotheque", fetch = FetchType.LAZY)
	private Set<Livre> livres;
	
	/**
	 * Constructeur.
	 */
	public Bibliotheque() {
		this(0, "", new Coordonnee(), new HashSet<>());
	}

	/**
	 * Constructeur.
	 * @param nom
	 * @param coordonnees
	 * @param livres
	 */
	public Bibliotheque(String nom, Coordonnee coordonnee, HashSet<Livre> livres) {
		super();
		this.nom = nom;
		this.coordonnee = coordonnee;
		this.livres = livres;
	}

	/**
	 * Constructeur.
	 * @param idBibliotheque
	 * @param nom
	 * @param coordonnees
	 * @param livres
	 */
	public Bibliotheque(int idBibliotheque, String nom, Coordonnee coordonnee, HashSet<Livre> livres) {
		super();
		this.idBibliotheque = idBibliotheque;
		this.nom = nom;
		this.coordonnee = coordonnee;
		this.livres = livres;
	}

	/**
	 * Méthode en charge de récupérer la valeur de idBibliotheque.
	 * @return the idBibliotheque
	 */
	public int getIdBibliotheque() {
		return this.idBibliotheque;
	}

	/**
	 * Méthode en charge de définir la valeur de idBibliotheque.
	 * @param idBibliotheque the idBibliotheque to set
	 */
	public void setIdBibliotheque(int idBibliotheque) {
		this.idBibliotheque = idBibliotheque;
	}

	/**
	 * Méthode en charge de récupérer la valeur de nom.
	 * @return the nom
	 */
	public String getNom() {
		return this.nom;
	}

	/**
	 * Méthode en charge de définir la valeur de nom.
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Méthode en charge de récupérer la valeur de coordonnees.
	 * @return the coordonnees
	 */
	public Coordonnee getCoordonnee() {
		return this.coordonnee;
	}

	/**
	 * Méthode en charge de définir la valeur de coordonnees.
	 * @param coordonnees the coordonnees to set
	 */
	public void setCoordonnee(Coordonnee coordonnee) {
		this.coordonnee = coordonnee;
	}

	/**
	 * Méthode en charge de récupérer la valeur de livres.
	 * @return the livres
	 */
	public Set<Livre> getLivres() {
		return this.livres;
	}

	/**
	 * Méthode en charge de définir la valeur de livres.
	 * @param livres the livres to set
	 */
	public void setLivres(Set<Livre> livres) {
		this.livres = livres;
	}

	/**
	 * Méthode en charge de récupérer la valeur de serialversionuid.
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}

