/**
 * 
 */
package fr.lusseau.bibliotheque.service;

import fr.lusseau.bibliotheque.entity.Caution;

/**
 * Classe en charge de
 * @Version Bibliotheque -v1,0
 * @date  17 oct. 2020 - 17:33:49
 * @author Claude LUSSEAU
 *
 */
public interface CautionService {
	
	public Caution saveCaution (Caution caution);
	
	public Caution updateCaution (Caution caution);
	
	public void deleteCaution (Integer idCaution);
	
	public boolean checkIfCautionExists (Integer idCaution);

}
