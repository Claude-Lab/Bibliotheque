/**
 * 
 */
package fr.lusseau.bibliotheque.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.lusseau.bibliotheque.dao.UserDAO;
import fr.lusseau.bibliotheque.entity.User;
import fr.lusseau.bibliotheque.service.UserService;

/**
 * Classe en charge de
 * @Version Bibliotheque -v1,0
 * @date  18 oct. 2020 - 07:56:22
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
	public void deleteUser(Integer idUser) {
		dao.deleteById(idUser);
	}

	/**
	 * @{inheritDoc}
	*/
	@Override
	public boolean checkIfIdExists(Integer idPersonne) {
		return dao.existsById(idPersonne);
	}

	/**
	 * @{inheritDoc}
	*/
	@Override
	public User findUserByContactEmail(@Param("email") String email) {
		return dao.findUserByContactEmail(email);
	}
	
	/**
	 * @{inheritDoc}
	*/
	public User findPersonneById(Integer personneId) {
		return dao.getOne(personneId);
	}

	/**
	 * @{inheritDoc}
	*/
	@Override
	public List<User> findByLastNameLikeIgnoreCase(String name) {
		return dao.findByLastNameLikeIgnoreCase(name);
	}

	/**
	 * @{inheritDoc}
	*/
	@Override
	public List<User> findByLastNameContaining(String name) {
		return dao.findByLastNameContaining(name);
	}
	
	/**
	 * @{inheritDoc}
	*/
	@Override
	public Optional<User> findById(Integer idUser) {
		return dao.findById(idUser);
	}
	
	/**
	 * @{inheritDoc}
	*/
	@Override
	public List<User> findAll() {
		return dao.findAll();
	}

//	/**
//	 * @{inheritDoc}
//	*/
//	@Override
//	public Personne findEmail(Personne personne) {
//		return dao.findEmail(personne);
//	}

	

	
	

}
