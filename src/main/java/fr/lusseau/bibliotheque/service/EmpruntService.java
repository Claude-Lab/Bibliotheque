/**
 * 
 */
package fr.lusseau.bibliotheque.service;

import java.time.LocalDate;
import java.util.List;

import fr.lusseau.bibliotheque.entity.Emprunt;
import fr.lusseau.bibliotheque.entity.EmpruntStatus;

/**
 * Classe en charge de
 * @Version Bibliotheque -v1,0
 * @date  18 oct. 2020 - 07:38:12
 * @author Claude LUSSEAU
 *
 */
public interface EmpruntService {

public List<Emprunt> findAllEmpruntsByEndDateBefore(LocalDate maxEndDate);
    
    public List<Emprunt> getAllOpenEmpruntsOfThisPersonne(String email, EmpruntStatus status);
    
    public Emprunt getOpenedEmprunt(Emprunt emprunt);
    
    public boolean checkIfEmpruntExists(Emprunt emprunt);
    
    public Emprunt saveEmprunt(Emprunt emrpunt);
    
    public void closeEmprunt(Emprunt emrpunt);
}
