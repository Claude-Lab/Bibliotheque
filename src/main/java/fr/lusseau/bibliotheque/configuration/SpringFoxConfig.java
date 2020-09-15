///**
// * 
// */
//package fr.lusseau.bibliotheque.configuration;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
///**
// * Classe en charge de
// * @Version Bibliotheque -v1,0
// * @date  14 sept. 2020 - 20:55:20
// * @author Claude LUSSEAU
// *
// */
//@Configuration
//@EnableSwagger2
//public class SpringFoxConfig {                                    
//    @Bean
//    public Docket api() { 
//        return new Docket(DocumentationType.SWAGGER_2)  
//          .select()                                  
//          .apis(RequestHandlerSelectors.basePackage("fr.lusseau.microcommerce"))              
//          .paths(PathSelectors.regex("/Produits.*"))                          
//          .build();                                           
//    } 
//
//}
