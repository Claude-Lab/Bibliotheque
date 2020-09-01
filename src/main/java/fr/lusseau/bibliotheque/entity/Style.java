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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * Classe en charge de definir le bean Style.
 * @Version Bibliotheque -v1,0
 * @date  21 août 2020 - 09:14:24
 * @author Claude LUSSEAU
 *
 */
@Entity
@JsonIdentityInfo(  generator = ObjectIdGenerators.PropertyGenerator.class, property = "idStyle")
public class Style implements Serializable {
	
	private static final long serialVersionUID = 1695327707040112L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idStyle;
	
	@NotBlank
	@Column(unique = true)
	private String libelle;
	
	@ManyToMany(cascade = {CascadeType.REFRESH}, mappedBy = "styles",targetEntity = Livre.class)
	private Set<Livre> livres = new HashSet<Livre>();
	
	/**
	 * Constructeur.
	 */
	public Style() {
		this("", new HashSet<Livre>());
	}

	/**
	 * Constructeur.
	 * @param libelle
	 * @param livresStyles
	 */
	public Style(String libelle, Set<Livre> livres) {
		super();
		this.libelle = libelle;
		this.livres = livres;
	}

	/**
	 * Constructeur.
	 * @param idStyle
	 * @param libelle
	 * @param livresStyles
	 */
	public Style(int idStyle, String libelle, Set<Livre> livres) {
		super();
		this.idStyle = idStyle;
		this.libelle = libelle;
		this.livres = livres;
	}

	/**
	 * Méthode en charge de récupérer la valeur de idStyle.
	 * @return the idStyle
	 */
	public int getIdStyle() {
		return this.idStyle;
	}

	/**
	 * Méthode en charge de définir la valeur de idStyle.
	 * @param idStyle the idStyle to set
	 */
	public void setIdStyle(int idStyle) {
		this.idStyle = idStyle;
	}

	/**
	 * Méthode en charge de récupérer la valeur de libelle.
	 * @return the libelle
	 */
	public String getLibelle() {
		return this.libelle;
	}

	/**
	 * Méthode en charge de définir la valeur de libelle.
	 * @param libelle the libelle to set
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	/**
	 * Méthode en charge de récupérer la valeur de livresStyles.
	 * @return the livresStyles
	 */
	public Set<Livre> getLivres() {
		return livres;
	}

	/**
	 * Méthode en charge de définir la valeur de livresStyles.
	 * @param livresStyles the livresStyles to set
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
	
	

	/**
	 * @{inheritDoc}
	*/
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idStyle;
		result = prime * result + ((libelle == null) ? 0 : libelle.hashCode());
		result = prime * result + ((livres == null) ? 0 : livres.hashCode());
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
		Style other = (Style) obj;
		if (idStyle != other.idStyle)
			return false;
		if (libelle == null) {
			if (other.libelle != null)
				return false;
		} else if (!libelle.equals(other.libelle))
			return false;
		if (livres == null) {
			if (other.livres != null)
				return false;
		} else if (!livres.equals(other.livres))
			return false;
		return true;
	}

	/**
	 * @{inheritDoc}
	*/
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(getLibelle());
		return builder.toString();
	}

	

	
}
