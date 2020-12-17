/**
 * 
 */
package fr.lusseau.bibliotheque.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import fr.lusseau.bibliotheque.entity.User;

/**
 * Classe en charge de
 * 
 * @Version Bibliotheque -v1,0
 * @date 14 août 2020 - 10:55:30
 * @author Claude LUSSEAU
 *
 */
@RepositoryRestResource(collectionResourceRel = "user", path = "users")
public interface UserDAO extends JpaRepository<User, Long> {
	
	Optional<User> findByUsernameOrEmail(String username, String email);

	List<User> findByLastnameIgnoreCase(String lastname);

	List<User> findByLastnameLikeIgnoreCase(String lastname);

	List<User> findByLastnameContaining(String lastname);
	
	User findByUsername(String username);
	
	boolean existsByUsername(String username);

    boolean existsByEmail(String email);

    User findByEmail(String email);

	long count();
}
