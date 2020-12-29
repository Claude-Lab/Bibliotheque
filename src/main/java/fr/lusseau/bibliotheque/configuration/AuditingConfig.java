///**
// * 
// */
//package fr.lusseau.bibliotheque.configuration;
//
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.domain.AuditorAware;
//import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
//import org.springframework.security.authentication.AnonymousAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//
//import fr.lusseau.bibliotheque.configuration.security.UserPrincipal;
//
//import java.util.Optional;
//
///**
// * Class in charge of defining .
// * @Version Bibliotheque -v1,0
// * @date  18 déc. 2020 - 08:35:27
// * @author Claude LUSSEAU
// *
// */
//@Configuration
//@EnableJpaAuditing
//public class AuditingConfig {
//
//    @Bean
//    public AuditorAware<Long> auditorProvider() {
//        return new SpringSecurityAuditAwareImpl();
//    }
//}
//
//class SpringSecurityAuditAwareImpl implements AuditorAware<Long> {
//
//    @Override
//    public Optional<Long> getCurrentAuditor() {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//
//        if (authentication == null ||
//                !authentication.isAuthenticated() ||
//                authentication instanceof AnonymousAuthenticationToken) {
//            return Optional.empty();
//        }
//
//        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
//
//        return Optional.ofNullable(userPrincipal.getId());
//    }
//}