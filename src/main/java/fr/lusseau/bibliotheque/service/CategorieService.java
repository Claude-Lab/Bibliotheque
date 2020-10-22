/**
 * 
 */
package fr.lusseau.bibliotheque.service;

import java.util.List;

import fr.lusseau.bibliotheque.entity.Categorie;

/**
 * Classe en charge de
 * @Version Bibliotheque -v1,0
 * @date  21 oct. 2020 - 13:58:30
 * @author Claude LUSSEAU
 *
 */
public interface CategorieService {

	public Categorie saveCategorie (Categorie categorie);
	
	public Categorie updateCategorie (Categorie categorie);
	
	public void deleteCategorie(Integer idPersonne);
	
	public List<Categorie> findByLibelleContaining(String libelle);
	
	public Categorie findCategorieByLibelleIgnoreCase(String libelle);
	
	public boolean checkIfIdExists(Integer idCategorie);
}
