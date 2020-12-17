/**
 * 
 */
package fr.lusseau.bibliotheque.utils;

import org.springframework.util.StringUtils;

import fr.lusseau.bibliotheque.dto.registration.UserUpdate;
import fr.lusseau.bibliotheque.dto.request.UserRequestDTO;
import fr.lusseau.bibliotheque.entity.User;

/**
 * Class in charge of defining .
 * @Version Bibliotheque -v1,0
 * @date  17 déc. 2020 - 18:45:43
 * @author Claude LUSSEAU
 *
 */
public class UserMapper {
	
	/**
	 * Transforme un entity User en un POJO UserDTO.
	 * 
	 * @param User
	 * @return
	 */
	public UserRequestDTO entityToDtoRegistration(User user) {
		UserRequestDTO dto = new UserRequestDTO(user.getId(), user.getFirstname(), user.getLastname(),
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
		UserUpdate dto = new UserUpdate(user.getId(), user.getFirstname(), user.getLastname(),
				user.getUsername(), user.getEmail(), user.getPassword(), user.getPhone(), user.getAddress(),
				user.getZip(), user.getCity(), user.getCreatedAt(), user.getUpdatedAt(), user.getRoles(),
				user.getSurety(), user.getLoans());

		return dto;
	}

	/**
	 * Transforme un POJO UserDTO en en entity User.
	 * 
	 * @param UserRegistration
	 * @return
	 */
	public User userRegistrationToEntity(UserRequestDTO dto) {
		User user = new User(dto.getFirstname(), dto.getLastname(), dto.getUsername(), dto.getEmail(),
				dto.getPassword(), dto.getPhone(), dto.getAddress(), dto.getZip(), dto.getCity(), dto.getCreatedAt(),
				dto.getUpdatedAt(), dto.getSurety(), dto.getLoans(), dto.getRoles());
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
				dto.getUpdatedAt(), dto.getSurety(), dto.getLoans(), dto.getRoles());
		if (!StringUtils.isEmpty(dto.getId())) {
			user.setId(dto.getId());
		}
		return user;
	}

}
