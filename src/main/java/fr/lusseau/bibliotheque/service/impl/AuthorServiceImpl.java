/**
 * 
 */
package fr.lusseau.bibliotheque.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.lusseau.bibliotheque.dao.AuthorDAO;
import fr.lusseau.bibliotheque.entity.Author;
import fr.lusseau.bibliotheque.service.AuthorService;

/**
 * Classe en charge de
 * @Version Bibliotheque -v1,0
 * @date  17 oct. 2020 - 10:22:52
 * @author Claude LUSSEAU
 *
 */
@Service("AuthorService")
@Transactional
public class AuthorServiceImpl implements AuthorService {

	@Autowired
	private AuthorDAO dao;
	
	
	public List<Author> findAll() {
		return dao.findAll();
	}
	
	@Override
	public Author saveAuthor(Author auteur) {
		return dao.save(auteur);
	}

	/**
	 * @{inheritDoc}
	*/
	@Override
	public Author updateAuthor(Author auteur) {
		return dao.save(auteur);
	}

	/**
	 * @{inheritDoc}
	*/
	@Override
	public void deleteAuthor(Integer idAuthor) {
		dao.deleteById(idAuthor);
	}

	/**
	 * @{inheritDoc}
	*/
	@Override
	public List<Author> findByLastNameContaining(String lastName) {
		return dao.findByLastNameContaining((new StringBuilder()).append("%").append(lastName).append("%").toString());
	}

	/**
	 * @{inheritDoc}
	*/
	@Override
	public boolean checkIfIdexists(Integer idAuthor) {
		return dao.existsById(idAuthor);
	}
	
	public List<Author> findByLastNameLikeIgnoreCase(String name){
		return dao.findByLastNameLikeIgnoreCase(name);
	}

	/**
	 * @{inheritDoc}
	*/
	@Override
	public Author findByLastName(String lastName) {
		return dao.findByLastName(lastName);
	}

}
