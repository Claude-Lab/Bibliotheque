/**
 * 
 */
package fr.lusseau.bibliotheque.service;

import fr.lusseau.bibliotheque.entity.Surety;

/**
 * Classe en charge de
 * @Version Bibliotheque -v1,0
 * @date  17 oct. 2020 - 17:33:49
 * @author Claude LUSSEAU
 *
 */
public interface SuretyService {
	
	public Surety saveSurety (Surety surety);
	
	public Surety updateSurety (Surety surety);
	
	public void deleteSurety (Integer idSurety);
	
	public boolean checkIfSuretyExists (Integer idSurety);

}
