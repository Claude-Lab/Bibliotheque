/**
 * 
 */
package fr.lusseau.bibliotheque.service;

import java.util.List;

import fr.lusseau.bibliotheque.entity.Editeur;

/**
 * Classe en charge de
 * 
 * @Version Bibliotheque -v1,0
 * @date 17 oct. 2020 - 17:40:06
 * @author Claude LUSSEAU
 *
 */
public interface EditeurService {

	public Editeur saveEditeur(Editeur editeur);

	public Editeur updateEditeur(Editeur editeur);

	public void deleteEditeur(Integer idEditeur);

	public List<Editeur> findByNomContaining(String nom);

	public boolean checkIfEditeurExists(Integer idEditeur);

}
