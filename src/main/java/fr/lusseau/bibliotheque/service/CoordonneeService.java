/**
 * 
 */
package fr.lusseau.bibliotheque.service;

import fr.lusseau.bibliotheque.entity.Coordonnee;

/**
 * Classe en charge de
 * @Version Bibliotheque -v1,0
 * @date  17 oct. 2020 - 17:38:49
 * @author Claude LUSSEAU
 *
 */
public interface CoordonneeService {
	
	public Coordonnee saveCoordonnee (Coordonnee coordonnee);
	
	public Coordonnee updateCoordonnee (Coordonnee coordonnee);
	
	public void deleteCoordonnee(Integer idCoordonnee);
		
	public boolean checkIfCoordonneeExists(Integer idCoordonnee);
	
	public Coordonnee findOne(Integer idCoordonnee);

}
