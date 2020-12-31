/**
 * 
 */
package fr.lusseau.bibliotheque.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.lusseau.bibliotheque.dao.LibraryDAO;
import fr.lusseau.bibliotheque.entity.Library;
import fr.lusseau.bibliotheque.service.LibraryService;

/**
 * Classe en charge de
 * @Version Bibliotheque -v1,0
 * @date  18 oct. 2020 - 08:10:52
 * @author Claude LUSSEAU
 *
 */
@Service("BibliothequeService")
@Transactional
public class LibraryServiceImpl implements LibraryService {

	@Autowired
	private LibraryDAO dao;

	/**
	 * @{inheritDoc}
	*/
	@Override
	public Library save(Library library) {
		return dao.save(library);
	}

	/**
	 * @{inheritDoc}
	*/
	@Override
	public Library update(Library library) {
		return dao.save(library);
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
	public Optional<Library> findById(Integer id) {
		return dao.findById(id);
	}

	/**
	 * @{inheritDoc}
	*/
	@Override
	public List<Library> findAll() {
		return dao.findAll();
	}

	/**
	 * @{inheritDoc}
	*/
	@Override
	public List<Library> findByNameContaining(String name) {
		return dao.findByNameContaining(name);
	}

	/**
	 * @{inheritDoc}
	*/
	@Override
	public Library findByName(String name) {
		return dao.findByName(name);
	}

	/**
	 * @{inheritDoc}
	*/
	@Override
	public Library getOne(Integer id) {
		return dao.getOne(id);
	}

	/**
	 * @{inheritDoc}
	*/
	@Override
	public boolean existsByName(String name) {
		return dao.existsByName(name);
	}

	
	
}
