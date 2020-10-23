/**
 * 
 */
package fr.lusseau.bibliotheque.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.lusseau.bibliotheque.dao.ContactDAO;
import fr.lusseau.bibliotheque.entity.Contact;
import fr.lusseau.bibliotheque.service.ContactService;

/**
 * Classe en charge de
 * @Version Bibliotheque -v1,0
 * @date  18 oct. 2020 - 08:20:42
 * @author Claude LUSSEAU
 *
 */
@Service("ContactService")
@Transactional
public class ContactServiceImpl implements ContactService{
	
	@Autowired
	private ContactDAO dao;
	

	/**
	 * @{inheritDoc}
	*/
	@Override
	public Contact saveContact(Contact contact) {
		return dao.save(contact);
	}

	/**
	 * @{inheritDoc}
	*/
	@Override
	public Contact updateContact(Contact contact) {
		return dao.save(contact);
	}

	/**
	 * @{inheritDoc}
	*/
	@Override
	public void deleteContact(Integer idContact) {
		dao.deleteById(idContact);
		
	}

	/**
	 * @{inheritDoc}
	*/
	@Override
	public boolean checkIfContactExists(Integer idContact) {
		return dao.existsById(idContact);
	}

	/**
	 * @{inheritDoc}
	*/
	@Override
	public Contact findOne(Integer idContact) {
		return dao.getOne(idContact);
	}

	
	

}
