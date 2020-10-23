/**
 * 
 */
package fr.lusseau.bibliotheque.service;

import fr.lusseau.bibliotheque.entity.Contact;

/**
 * Classe en charge de
 * @Version Bibliotheque -v1,0
 * @date  17 oct. 2020 - 17:38:49
 * @author Claude LUSSEAU
 *
 */
public interface ContactService {
	
	public Contact saveContact (Contact contact);
	
	public Contact updateContact (Contact contact);
	
	public void deleteContact(Integer idContact);
		
	public boolean checkIfContactExists(Integer idContact);
	
	public Contact findOne(Integer idContact);

}
