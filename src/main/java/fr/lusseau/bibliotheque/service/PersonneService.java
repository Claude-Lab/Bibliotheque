/**
 * 
 */
package fr.lusseau.bibliotheque.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import fr.lusseau.bibliotheque.entity.Personne;

/**
 * Classe en charge de
 * @Version Bibliotheque -v1,0
 * @date  17 oct. 2020 - 17:36:15
 * @author Claude LUSSEAU
 *
 */
public interface PersonneService {
	
	public Personne savePersonne (Personne personne);
	
	public Personne updatePersonne (Personne personne);
	
	public void deletePersonne(Integer idPersonne);
	
	public List<Personne> findByNomContaining(String nom);
	
	public List<Personne> findPersonneByNomIgnoreCase(String nom);
	
	public boolean checkIfIdExists(Integer idPersonne);
	
	public Personne findPersonneByCoordonneeEmail(@Param("email") String email);
	
//	Personne findEmail(@Param("idPersonne") Personne personne);
	

}
