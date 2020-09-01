/**
 * 
 */
package fr.lusseau.bibliotheque.service.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;

import fr.lusseau.bibliotheque.service.GestionPersonne;

/**
 * Classe en charge de
 * 
 * @Version BibliothequeSB -v1,0
 * @date Aug 31, 2020 - 2:01:24 PM
 * @author Claude LUSSEAU
 *
 */
public class AppAuthProvider extends DaoAuthenticationProvider {

	@Autowired
	GestionPersonne gs;

	@SuppressWarnings("unused")
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		UsernamePasswordAuthenticationToken auth = (UsernamePasswordAuthenticationToken) authentication;
		String username = auth.getName();
		String password = auth.getCredentials().toString();
		UserDetails personne = gs.loadUserByUsername(username);
		if (personne == null) {
			throw new BadCredentialsException("Username/Password does not match for " + auth.getPrincipal());
		}
		return new UsernamePasswordAuthenticationToken(personne, null, personne.getAuthorities());
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return true;
	}

}
