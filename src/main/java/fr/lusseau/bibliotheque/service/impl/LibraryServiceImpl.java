/**
 * 
 */
package fr.lusseau.bibliotheque.service.impl;

import java.util.List;

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

	
	public List<Library> findAllLibrary() {
		return dao.findAll();
	}
	
	/**
	 * @{inheritDoc}
	*/
	@Override
	public Library saveLibrary(Library library) {
		return dao.save(library);
	}

	/**
	 * @{inheritDoc}
	*/
	@Override
	public Library updateLibrary(Library library) {
		return dao.save(library);
	}

	/**
	 * @{inheritDoc}
	*/
	@Override
	public void deleteLibrary(Integer idLibrary) {
		dao.deleteById(idLibrary);
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
	public boolean checkIsLibraryExists(Integer idLibrary) {
		return dao.existsById(idLibrary);
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
	public Library findOne(Integer idLibrary) {
		return dao.getOne(idLibrary);
	}
	
	
}
