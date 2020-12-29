/**
 * 
 */
package fr.lusseau.bibliotheque.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.lusseau.bibliotheque.dao.EditorDAO;
import fr.lusseau.bibliotheque.entity.Editor;
import fr.lusseau.bibliotheque.service.EditorService;

/**
 * Classe en charge de
 * @Version Bibliotheque -v1,0
 * @date  18 oct. 2020 - 08:23:37
 * @author Claude LUSSEAU
 *
 */
@Service("EditorService")
@Transactional
public class EditorServiceImpl implements EditorService {

	@Autowired
	private EditorDAO dao;
	

	/**
	 * @{inheritDoc}
	*/
	@Override
	public Editor save(Editor editor) {
		return dao.save(editor);
	}

	/**
	 * @{inheritDoc}
	*/
	@Override
	public Editor update(Editor editor) {
		return dao.save(editor);
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
	public List<Editor> findByNameContaining(String name) {
		return dao.findByNameContaining(name);
	}
	
	/**
	 * @{inheritDoc}
	*/
	@Override
	public List<Editor> findAll() {
		return dao.findAll();
	}
	
	/**
	 * @{inheritDoc}
	*/
	@Override
	public Editor findByName(String name) {
		return dao.findByName(name);
	}
	
	/**
	 * @{inheritDoc}
	*/
	@Override
	public Editor getOne(Integer id) {
		return dao.getOne(id);
	}
	
	/**
	 * Method in charge of 
	 * @param name
	 * @return
	 */
	@Override
	public boolean existsByName(String name) {
		return dao.existsByName(name);
	}

}
