/**
 * 
 */
package fr.lusseau.bibliotheque.utils.impl;

import org.mapstruct.Mapper;
import org.springframework.util.StringUtils;

import fr.lusseau.bibliotheque.dto.registration.UserRegistration;
import fr.lusseau.bibliotheque.dto.request.UserRequest;
import fr.lusseau.bibliotheque.dto.update.UserUpdate;
import fr.lusseau.bibliotheque.entity.User;
import fr.lusseau.bibliotheque.utils.UserMapper;

/**
 * Class in charge of defining .
 * @Version Bibliotheque -v1,0
 * @date  17 déc. 2020 - 18:45:43
 * @author Claude LUSSEAU
 *
 */
@Mapper
public class UserMapperImpl implements UserMapper {
	
	/**
	 * Transforme un entity User en un POJO UserDTO.
	 * 
	 * @param User
	 * @return
	 */
	public UserRequest entityToDtoRegistration(User user) {
		UserRequest dto = new UserRequest(user.getId(), user.getFirstname(), user.getLastname(),
				user.getUsername(), user.getEmail(), user.getPassword(), user.getPhone(), user.getAddress(),
				user.getZip(), user.getCity(), user.getCreatedAt(), user.getUpdatedAt(), user.getRoles(),
				user.getSurety(), user.getLoans());

		return dto;
	}
	
	/**
	 * Transforme un entity User en un POJO UserDTO.
	 * 
	 * @param User
	 * @return
	 */
	public UserUpdate entityUpdateToDtoUpdate(User user) {
		UserUpdate dto = new UserUpdate(user.getFirstname(), user.getLastname(), user.getUsername(),
				user.getEmail(), user.getPassword(), user.getPhone(), user.getAddress(), user.getZip(), user.getCity(),
				user.getCreatedAt(), user.getUpdatedAt(), user.getRoles(), user.getSurety(), user.getLoans());

		return dto;
	}
	
	/**
	 * Transforme un entity User en un POJO UserRegistration.
	 * 
	 * @param User
	 * @return
	 */
	public UserRegistration entityToUserRegistration(User user) {
		UserRegistration dto = new UserRegistration(user.getFirstname(), user.getLastname(), user.getUsername(),
				user.getEmail(), user.getPassword(), user.getPhone(), user.getAddress(), user.getZip(), user.getCity(),
				user.getCreatedAt(), user.getUpdatedAt(), user.getRoles(), user.getSurety(), user.getLoans());

		return dto;
	}

	/**
	 * Transforme un POJO UserDTO en en entity User.
	 * 
	 * @param UserRegistration
	 * @return
	 */
	public User userRegistrationToEntity(UserRegistration dto) {
		User user = new User(dto.getFirstname(), dto.getLastname(), dto.getUsername(), dto.getEmail(),
				dto.getPassword(), dto.getPhone(), dto.getAddress(), dto.getZip(), dto.getCity(), dto.getCreatedAt(),
				dto.getUpdatedAt(), dto.getRoles(), dto.getSurety(), dto.getLoans());
		if (!StringUtils.isEmpty(dto.getId())) {
			user.setId(dto.getId());
		}
		return user;
	}
	
	/**
	 * Transforme un POJO UserDTO en en entity User.
	 * 
	 * @param UserRegistration
	 * @return
	 */
	public User userUpdateToEntity(UserUpdate dto) {
		User user = new User(dto.getFirstname(), dto.getLastname(), dto.getUsername(), dto.getEmail(),
				dto.getPassword(), dto.getPhone(), dto.getAddress(), dto.getZip(), dto.getCity(), dto.getCreatedAt(),
				dto.getUpdatedAt(), dto.getRoles(), dto.getSurety(), dto.getLoans());
		
		return user;
	}

}