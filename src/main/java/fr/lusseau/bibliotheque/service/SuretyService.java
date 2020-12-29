/**
 * 
 */
package fr.lusseau.bibliotheque.service;

import java.util.List;

import fr.lusseau.bibliotheque.entity.Surety;

/**
 * Classe en charge de.
 * 
 * @Version Bibliotheque -v1,0
 * @date 17 oct. 2020 - 17:33:49
 * @author Claude LUSSEAU
 *
 */
public interface SuretyService {

	Surety save(Surety surety);

	void deleteSurety(Integer id);

	boolean checkIfSuretyExists(Integer id);

	List<Surety> findAll();

	Surety getOne(Integer id);

	Surety findByNbBooks(int nbBooks);

	Surety findByValue(double values);

	boolean existsByValue(double values);

	boolean existsByNbBooks(int nbBooks);
}
