/**
 * 
 */
package fr.lusseau.bibliotheque.service;

import java.util.List;

import fr.lusseau.bibliotheque.entity.Author;

/**
 * Classe en charge de
 * @Version Bibliotheque -v1,0
 * @date  17 oct. 2020 - 10:15:59
 * @author Claude LUSSEAU
 *
 */
public interface AuthorService {
	
	public  Author saveAuthor ( Author auteur);
	
	public  Author updateAuthor ( Author auteur);
	
	public void deleteAuthor(Integer idAuthor);
	
	public  Author findByFullName(String fullName);
	
	public List< Author> findByLastNameLikeIgnoreCase(String name);
	
	public List< Author> findByFullNameContaining(String name);
	
	public boolean checkIfIdexists(Integer idAuthor);
	

}
