/**
 * 
 */
package fr.lusseau.bibliotheque.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import fr.lusseau.bibliotheque.entity.Bibliotheque;

/**
 * Classe en charge de
 * @Version Bibliotheque -v1,0
 * @date  17 oct. 2020 - 17:29:56
 * @author Claude LUSSEAU
 *
 */
public interface BibliothequeService {

	public Bibliotheque saveBibliotheque (Bibliotheque bibliotheque);

	public Bibliotheque updateBibliotheque (Bibliotheque bibliotheque);
	
	public void deleteBibliotheque (Integer idBibliotheque);
	
	public List<Bibliotheque> findByNomContaining(String nom);
	
	public boolean checkIsBibliothequExists(Integer idBibliotheque);
	
	public Bibliotheque findBibliothequeByCoordonneeEmail(@Param("email") String email);
	
	public Bibliotheque findByNom(String nom);
	
	public Bibliotheque findOne(Integer idBibliotheque);

}
