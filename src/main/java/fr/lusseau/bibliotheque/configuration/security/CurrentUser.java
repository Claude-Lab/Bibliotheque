/**
 * 
 */
package fr.lusseau.bibliotheque.configuration.security;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.security.core.annotation.AuthenticationPrincipal;

/**
 * Class in charge of defining .
 * @Version Bibliotheque -v1,0
 * @date  17 déc. 2020 - 10:47:11
 * @author Claude LUSSEAU
 *
 */
@Target({ElementType.PARAMETER, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@AuthenticationPrincipal
public @interface CurrentUser {

}
