/**
 * 
 */
package fr.lusseau.bibliotheque.service;

import java.util.List;

import fr.lusseau.bibliotheque.entity.Auteur;

/**
 * Classe en charge de
 * @Version Bibliotheque -v1,0
 * @date  17 oct. 2020 - 10:15:59
 * @author Claude LUSSEAU
 *
 */
public interface AuteurService {
	
	public Auteur saveAuteur (Auteur auteur);
	
	public Auteur updateAuteur (Auteur auteur);
	
	public void deleteAuteur(Integer idAuteur);
	
	public Auteur findAuteurByPrenomNom(String prenomNom);
	
	public List<Auteur> findByNomLikeIgnoreCase(String nom);
	
	public List<Auteur> findByPrenomNomContaining(String nom);
	
	public boolean checkIfIdexists(Integer id);
	

}
