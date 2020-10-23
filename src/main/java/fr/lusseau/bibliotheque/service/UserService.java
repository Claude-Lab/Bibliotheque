/**
 * 
 */
package fr.lusseau.bibliotheque.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import fr.lusseau.bibliotheque.entity.User;

/**
 * Classe en charge de
 * @Version Bibliotheque -v1,0
 * @date  17 oct. 2020 - 17:36:15
 * @author Claude LUSSEAU
 *
 */
public interface UserService {
	
	public User saveUser (User user);
	
	public User updateUser (User user);
	
	public void deleteUser(Integer idUser);
	
	public List<User> findByLastNameLikeIgnoreCase(String name);
	
	public List<User> findByLastNameContaining(String name);
	
	public boolean checkIfIdExists(Integer idUser);
	
	public User findUserByContactEmail(@Param("email") String email);
	
//	Personne findEmail(@Param("idPersonne") Personne personne);
	

}
