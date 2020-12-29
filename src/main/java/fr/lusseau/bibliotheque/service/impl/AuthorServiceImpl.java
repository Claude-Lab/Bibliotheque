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
	public Author save(Author auteur) {
		return dao.save(auteur);
	}

	/**
	 * @{inheritDoc}
	*/
	@Override
	public void delete(Integer id) {
		dao.deleteById(id);
	}

	/**
	 * @{inheritDoc}
	*/
	@Override
	public List<Author> findByLastnameContaining(String lastname) {
		return dao.findByLastnameContaining((new StringBuilder()).append("%").append(lastname).append("%").toString());
	}

	/**
	 * @{inheritDoc}
	*/
	@Override
	public boolean checkIfIdexists(Integer id) {
		return dao.existsById(id);
	}
	
	public List<Author> findByLastnameLikeIgnoreCase(String lastname){
		return dao.findByLastnameLikeIgnoreCase(lastname);
	}

	/**
	 * @{inheritDoc}
	*/
	@Override
	public Author findByLastname(String lastname) {
		return dao.findByLastname(lastname);
	}

	

	/**
	 * @{inheritDoc}
	*/
	@Override
	public Author getOne(Integer id) {
		return dao.getOne(id);
	}

	/**
	 * @{inheritDoc}
	*/
	@Override
	public boolean existsByFullname(String fullname) {
		return dao.existsByFullname(fullname);
	}


}
