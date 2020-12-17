package fr.lusseau.bibliotheque.configuration.keycloak;
///**
// * 
// */
//package fr.lusseau.bibliotheque.configuration;
//
//import org.keycloak.adapters.KeycloakConfigResolver;
//import org.keycloak.adapters.springboot.KeycloakSpringBootConfigResolver;
//import org.keycloak.adapters.springsecurity.KeycloakSecurityComponents;
//import org.keycloak.adapters.springsecurity.authentication.KeycloakAuthenticationProvider;
//import org.keycloak.adapters.springsecurity.config.KeycloakWebSecurityConfigurerAdapter;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.authority.mapping.SimpleAuthorityMapper;
//import org.springframework.security.core.session.SessionRegistryImpl;
//import org.springframework.security.web.authentication.session.RegisterSessionAuthenticationStrategy;
//import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;
//
///**
// * Class in charge of defining .
// * 
// * @Version Bibliotheque -v1,0
// * @date 4 nov. 2020 - 09:12:31
// * @author Claude LUSSEAU
// *
// */
//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
//@ComponentScan(basePackageClasses = KeycloakSecurityComponents.class)
//public class KeycloakSpringSecuriteConfig extends KeycloakWebSecurityConfigurerAdapter {
//
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		super.configure(http);
//		http.cors().and().authorizeRequests().antMatchers("authors").hasAnyRole("ADMIN", "EMPLOYEE")
//				.antMatchers("users").hasAnyRole("ADMIN", "EMPLOYEE").anyRequest().permitAll();
//		http.csrf().disable();
//
//	}
//
//	@Autowired
//	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//		KeycloakAuthenticationProvider keycloakAuthenticationProvider = keycloakAuthenticationProvider();
//		keycloakAuthenticationProvider.setGrantedAuthoritiesMapper(new SimpleAuthorityMapper());
//		auth.authenticationProvider(keycloakAuthenticationProvider);
//	}
//
//	@Bean
//	@Override
//	protected SessionAuthenticationStrategy sessionAuthenticationStrategy() {
//		return new RegisterSessionAuthenticationStrategy(new SessionRegistryImpl());
//	}
//
//	@Bean
//	public KeycloakConfigResolver KeycloakConfigResolver() {
//		return new KeycloakSpringBootConfigResolver();
//	}
//}