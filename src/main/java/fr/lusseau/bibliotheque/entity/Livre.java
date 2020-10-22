/**
 * 
 */
package fr.lusseau.bibliotheque.entity;

import java.time.LocalDate;
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
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Classe en charge de definir le bean Livre.
 * @Version Bibliotheque -v1,0
 * @date  Aug 28, 2020 - 10:46:55 AM
 * @author Claude LUSSEAU
 *
 */
@Entity
@Table(name = "Livre")
public class Livre {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idLivre")
	private Integer idLivre;
	
	@Column(name = "titre", nullable = false)
	private String titre;
	
	@Column(unique = true, name = "isbn", nullable = false)
	private String isbn;
	
	@Column(name = "releaseDate", nullable = false)
	private LocalDate releaseDate;
	
	@Column(name = "registerDate", nullable = false)
	private LocalDate registerDate;
	
	@Column(name = "nbExamplaires")
	private Integer nbExamplaires;
	
	@ManyToMany(targetEntity= Auteur.class, cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinTable( name = "livre_Auteur",
                joinColumns = @JoinColumn( name = "idLivre", referencedColumnName = "idLivre" ),
                inverseJoinColumns = @JoinColumn( name = "idAuteur", referencedColumnName = "idAuteur" ))
	private Set<Auteur> auteurs = new HashSet<Auteur>();
	
	@ManyToMany(targetEntity= Categorie.class, cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@JoinTable(  name = "livre_Cat",
            joinColumns = @JoinColumn( name = "idLivre", referencedColumnName = "idLivre"),
            inverseJoinColumns = @JoinColumn( name = "code", referencedColumnName = "code" ))
	private Set<Categorie> categories = new HashSet<Categorie>();
	
	@Lob
	@Column(name = "description", nullable = false)
	private String description;
	
	
	@ManyToOne(optional = false) 
	@JoinColumn(name="idEditeur", nullable=false)
	private Editeur editeur;
	
	@ManyToOne(optional = false)
	@JoinColumn(name="idBibliotheque", nullable=false)
	private Bibliotheque bibliotheque;
	
	@ManyToOne(optional = false)
	@JoinColumn(name="idEtat", nullable=false)
	private Etat etat;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "livre", cascade = CascadeType.ALL)
	Set<Emprunt> emprunts = new HashSet<Emprunt>();
	
	
	/**
	 * Constructeur.
	 */
	public Livre() {
		// TODO Auto-generated constructor stub
	}


	/**
	 * Méthode en charge de récupérer la valeur de idLivre.
	 * @return the idLivre
	 */
	public Integer getIdLivre() {
		return idLivre;
	}


	/**
	 * Méthode en charge de définir la valeur de idLivre.
	 * @param idLivre the idLivre to set
	 */
	public void setIdLivre(Integer idLivre) {
		this.idLivre = idLivre;
	}


	/**
	 * Méthode en charge de récupérer la valeur de titre.
	 * @return the titre
	 */
	public String getTitre() {
		return titre;
	}


	/**
	 * Méthode en charge de définir la valeur de titre.
	 * @param titre the titre to set
	 */
	public void setTitre(String titre) {
		this.titre = titre;
	}


	/**
	 * Méthode en charge de récupérer la valeur de isbn.
	 * @return the isbn
	 */
	public String getIsbn() {
		return isbn;
	}


	/**
	 * Méthode en charge de définir la valeur de isbn.
	 * @param isbn the isbn to set
	 */
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}


	/**
	 * Méthode en charge de récupérer la valeur de releaseDate.
	 * @return the releaseDate
	 */
	public LocalDate getReleaseDate() {
		return releaseDate;
	}


	/**
	 * Méthode en charge de définir la valeur de releaseDate.
	 * @param releaseDate the releaseDate to set
	 */
	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}


	/**
	 * Méthode en charge de récupérer la valeur de registerDate.
	 * @return the registerDate
	 */
	public LocalDate getRegisterDate() {
		return registerDate;
	}


	/**
	 * Méthode en charge de définir la valeur de registerDate.
	 * @param registerDate the registerDate to set
	 */
	public void setRegisterDate(LocalDate registerDate) {
		this.registerDate = registerDate;
	}


	/**
	 * Méthode en charge de récupérer la valeur de nbExamplaires.
	 * @return the nbExamplaires
	 */
	public Integer getNbExamplaires() {
		return nbExamplaires;
	}


	/**
	 * Méthode en charge de définir la valeur de nbExamplaires.
	 * @param nbExamplaires the nbExamplaires to set
	 */
	public void setNbExamplaires(Integer nbExamplaires) {
		this.nbExamplaires = nbExamplaires;
	}


	/**
	 * Méthode en charge de récupérer la valeur de auteurs.
	 * @return the auteurs
	 */
	public Set<Auteur> getAuteurs() {
		return auteurs;
	}


	/**
	 * Méthode en charge de définir la valeur de auteurs.
	 * @param auteurs the auteurs to set
	 */
	public void setAuteurs(Set<Auteur> auteurs) {
		this.auteurs = auteurs;
	}


	/**
	 * Méthode en charge de récupérer la valeur de categories.
	 * @return the categories
	 */
	public Set<Categorie> getCategories() {
		return categories;
	}


	/**
	 * Méthode en charge de définir la valeur de categories.
	 * @param categories the categories to set
	 */
	public void setCategories(Set<Categorie> categories) {
		this.categories = categories;
	}


	/**
	 * Méthode en charge de récupérer la valeur de description.
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}


	/**
	 * Méthode en charge de définir la valeur de description.
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}


	/**
	 * Méthode en charge de récupérer la valeur de editeur.
	 * @return the editeur
	 */
	public Editeur getEditeur() {
		return editeur;
	}


	/**
	 * Méthode en charge de définir la valeur de editeur.
	 * @param editeur the editeur to set
	 */
	public void setEditeur(Editeur editeur) {
		this.editeur = editeur;
	}


	/**
	 * Méthode en charge de récupérer la valeur de bibliotheque.
	 * @return the bibliotheque
	 */
	public Bibliotheque getBibliotheque() {
		return bibliotheque;
	}


	/**
	 * Méthode en charge de définir la valeur de bibliotheque.
	 * @param bibliotheque the bibliotheque to set
	 */
	public void setBibliotheque(Bibliotheque bibliotheque) {
		this.bibliotheque = bibliotheque;
	}


	/**
	 * Méthode en charge de récupérer la valeur de etat.
	 * @return the etat
	 */
	public Etat getEtat() {
		return etat;
	}


	/**
	 * Méthode en charge de définir la valeur de etat.
	 * @param etat the etat to set
	 */
	public void setEtat(Etat etat) {
		this.etat = etat;
	}


	/**
	 * Méthode en charge de récupérer la valeur de emprunts.
	 * @return the emprunts
	 */
	public Set<Emprunt> getEmprunts() {
		return emprunts;
	}


	/**
	 * Méthode en charge de définir la valeur de emprunts.
	 * @param emprunts the emprunts to set
	 */
	public void setEmprunts(Set<Emprunt> emprunts) {
		this.emprunts = emprunts;
	}


	/**
	 * @{inheritDoc}
	*/
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((auteurs == null) ? 0 : auteurs.hashCode());
		result = prime * result + ((bibliotheque == null) ? 0 : bibliotheque.hashCode());
		result = prime * result + ((categories == null) ? 0 : categories.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((editeur == null) ? 0 : editeur.hashCode());
		result = prime * result + ((emprunts == null) ? 0 : emprunts.hashCode());
		result = prime * result + ((etat == null) ? 0 : etat.hashCode());
		result = prime * result + ((idLivre == null) ? 0 : idLivre.hashCode());
		result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
		result = prime * result + ((nbExamplaires == null) ? 0 : nbExamplaires.hashCode());
		result = prime * result + ((registerDate == null) ? 0 : registerDate.hashCode());
		result = prime * result + ((releaseDate == null) ? 0 : releaseDate.hashCode());
		result = prime * result + ((titre == null) ? 0 : titre.hashCode());
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
		if (!(obj instanceof Livre)) {
			return false;
		}
		Livre other = (Livre) obj;
		if (auteurs == null) {
			if (other.auteurs != null) {
				return false;
			}
		} else if (!auteurs.equals(other.auteurs)) {
			return false;
		}
		if (bibliotheque == null) {
			if (other.bibliotheque != null) {
				return false;
			}
		} else if (!bibliotheque.equals(other.bibliotheque)) {
			return false;
		}
		if (categories == null) {
			if (other.categories != null) {
				return false;
			}
		} else if (!categories.equals(other.categories)) {
			return false;
		}
		if (description == null) {
			if (other.description != null) {
				return false;
			}
		} else if (!description.equals(other.description)) {
			return false;
		}
		if (editeur == null) {
			if (other.editeur != null) {
				return false;
			}
		} else if (!editeur.equals(other.editeur)) {
			return false;
		}
		if (emprunts == null) {
			if (other.emprunts != null) {
				return false;
			}
		} else if (!emprunts.equals(other.emprunts)) {
			return false;
		}
		if (etat == null) {
			if (other.etat != null) {
				return false;
			}
		} else if (!etat.equals(other.etat)) {
			return false;
		}
		if (idLivre == null) {
			if (other.idLivre != null) {
				return false;
			}
		} else if (!idLivre.equals(other.idLivre)) {
			return false;
		}
		if (isbn == null) {
			if (other.isbn != null) {
				return false;
			}
		} else if (!isbn.equals(other.isbn)) {
			return false;
		}
		if (nbExamplaires == null) {
			if (other.nbExamplaires != null) {
				return false;
			}
		} else if (!nbExamplaires.equals(other.nbExamplaires)) {
			return false;
		}
		if (registerDate == null) {
			if (other.registerDate != null) {
				return false;
			}
		} else if (!registerDate.equals(other.registerDate)) {
			return false;
		}
		if (releaseDate == null) {
			if (other.releaseDate != null) {
				return false;
			}
		} else if (!releaseDate.equals(other.releaseDate)) {
			return false;
		}
		if (titre == null) {
			if (other.titre != null) {
				return false;
			}
		} else if (!titre.equals(other.titre)) {
			return false;
		}
		return true;
	}
	
	
	
}
