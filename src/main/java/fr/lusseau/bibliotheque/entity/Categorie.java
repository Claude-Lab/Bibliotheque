/**
 * 
 */
package fr.lusseau.bibliotheque.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

/**
 * Classe en charge de definir le bean Style.
 * @Version Bibliotheque -v1,0
 * @date  21 août 2020 - 09:14:24
 * @author Claude LUSSEAU
 *
 */

@Entity
@Table(name = "Categorie")
public class Categorie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idCategorie")
	private Integer idCategorie;
	
	@Column(name = "code")
	private String code;
	
	@NotBlank
	@Column(unique = true, nullable = false, name = "libelle")
	private String libelle;
		
	/**
	 * Constructeur.
	 */
	public Categorie() {
		this(0, null, null);
	}
	
	/**
	 * Constructeur.
	 * @param idCategorie
	 * @param code
	 * @param libelle
	 */
	public Categorie(Integer idCategorie, String code, @NotBlank String libelle) {
		this.idCategorie = idCategorie;
		this.code = code;
		this.libelle = libelle;
	}

	/**
	 * Méthode en charge de récupérer la valeur de idCategorie.
	 * @return the idCategorie
	 */
	public Integer getIdCategorie() {
		return idCategorie;
	}



	/**
	 * Méthode en charge de définir la valeur de idCategorie.
	 * @param idCategorie the idCategorie to set
	 */
	public void setIdCategorie(Integer idCategorie) {
		this.idCategorie = idCategorie;
	}



	/**
	 * Constructeur.
	 * @param code
	 * @param libelle
	 */
	public Categorie(String code, @NotBlank String libelle) {
		this.code = code;
		this.libelle = libelle;
	}

	/**
	 * Méthode en charge de récupérer la valeur de code.
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Méthode en charge de définir la valeur de code.
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * Méthode en charge de récupérer la valeur de libelle.
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}

	/**
	 * Méthode en charge de définir la valeur de libelle.
	 * @param libelle the libelle to set
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}



	/**
	 * @{inheritDoc}
	*/
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((idCategorie == null) ? 0 : idCategorie.hashCode());
		result = prime * result + ((libelle == null) ? 0 : libelle.hashCode());
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
		if (!(obj instanceof Categorie)) {
			return false;
		}
		Categorie other = (Categorie) obj;
		if (code == null) {
			if (other.code != null) {
				return false;
			}
		} else if (!code.equals(other.code)) {
			return false;
		}
		if (idCategorie == null) {
			if (other.idCategorie != null) {
				return false;
			}
		} else if (!idCategorie.equals(other.idCategorie)) {
			return false;
		}
		if (libelle == null) {
			if (other.libelle != null) {
				return false;
			}
		} else if (!libelle.equals(other.libelle)) {
			return false;
		}
		return true;
	}

	
	
	
}
