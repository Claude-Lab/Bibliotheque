/**
 * 
 */
package fr.lusseau.bibliotheque.service;

import java.util.List;
import java.util.Optional;

import fr.lusseau.bibliotheque.entity.User;

/**
 * Classe en charge de
 * 
 * @Version Bibliotheque -v1,0
 * @date 17 oct. 2020 - 17:36:15
 * @author Claude LUSSEAU
 *
 */
public interface UserService {

	User saveUser(User user);

	User updateUser(User user);

	void deleteUser(Long idUser);
		
	List<User> findAll();
	
	Optional<User> findById(Long idUser);

	User findByUsername(String username);

	List<User> findByLastnameLikeIgnoreCase(String name);
	
	List<User> findByLastnameContaining(String name);
	
	User findByEmail(String email);
	
	Optional<User> findByUsernameOrEmail(String username, String email);
	
	boolean existsByUsername(String username);

    boolean existsByEmail(String email);

}
