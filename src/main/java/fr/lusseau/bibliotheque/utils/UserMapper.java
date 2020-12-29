/**
 * 
 */
package fr.lusseau.bibliotheque.utils;

import fr.lusseau.bibliotheque.dto.registration.UserRegistration;
import fr.lusseau.bibliotheque.dto.request.UserRequest;
import fr.lusseau.bibliotheque.dto.update.UserUpdate;
import fr.lusseau.bibliotheque.entity.User;

/**
 * Class in charge of defining .
 * @Version Bibliotheque -v1,0
 * @date  20 déc. 2020 - 19:02:34
 * @author Claude LUSSEAU
 *
 */
public interface UserMapper {
	
	UserRequest entityToDtoRegistration(User user);
	
	UserUpdate entityUpdateToDtoUpdate(User user);
	
	UserRegistration entityToUserRegistration(User user);
	
	User userRegistrationToEntity(UserRegistration dto);
	
	User userUpdateToEntity(UserUpdate dto);

}
