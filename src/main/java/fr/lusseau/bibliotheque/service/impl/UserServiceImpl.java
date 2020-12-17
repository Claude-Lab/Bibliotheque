/**
 * 
 */
package fr.lusseau.bibliotheque.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.lusseau.bibliotheque.dao.UserDAO;
import fr.lusseau.bibliotheque.entity.User;
import fr.lusseau.bibliotheque.service.UserService;

/**
 * Classe en charge de
 * 
 * @Version Bibliotheque -v1,0
 * @date 18 oct. 2020 - 07:56:22
 * @author Claude LUSSEAU
 *
 */
@Service("UserService")
@Transactional
public class UserServiceImpl implements UserService {

	
	@Autowired
	private UserDAO dao;
	
	
	/**
	 * @{inheritDoc}
	*/
	@Override
	public User saveUser(User user) {
		return dao.save(user);
	}

	/**
	 * @{inheritDoc}
	*/
	@Override
	public User updateUser(User user) {
		return dao.save(user);
	}

	/**
	 * @{inheritDoc}
	*/
	@Override
	public void deleteUser(long id) {
		dao.deleteById(id);
	}
	
	/**
	 * @{inheritDoc}
	*/
	public User findById(long id) {
		return dao.findById(id);
	}

	/**
	 * @{inheritDoc}
	*/
	@Override
	public List<User> findByLastnameLikeIgnoreCase(String lastname) {
		return dao.findByLastnameLikeIgnoreCase(lastname);
	}

	/**
	 * @{inheritDoc}
	*/
	@Override
	public List<User> findByLastnameContaining(String lastname) {
		return dao.findByLastnameContaining(lastname);
	}
	
		
	/**
	 * @{inheritDoc}
	*/
	@Override
	public List<User> findAll() {
		return dao.findAll();
	}

	/**
	 * @{inheritDoc}
	*/
	@Override
	public User findByUsername(String username) {
		return dao.findByUsername(username);
	}

	/**
	 * @{inheritDoc}
	*/
	@Override
	public User findByEmail(String email) {
		return dao.findByEmail(email);
	}

	/**
	 * @{inheritDoc}
	*/
	@Override
	public User findByUsernameOrEmail(String username, String email) {
		return dao.findByUsernameOrEmail(username, email);
	}
	
	@Override
	public boolean existsByUsername(String username) {
		return dao.existsByUsername(username);
	}

	@Override
	public boolean existsByEmail(String email) {
    	return dao.existsByEmail(email);
    }

	/**
	 * @{inheritDoc}
	*/
	@Override
	public boolean existsById(long id) {
		return dao.existsById(id);
	}

}