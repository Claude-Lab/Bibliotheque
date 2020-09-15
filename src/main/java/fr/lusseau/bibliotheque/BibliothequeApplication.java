package fr.lusseau.bibliotheque;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.format.Formatter;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableAutoConfiguration
@SpringBootApplication
@EnableSwagger2
@ComponentScan(basePackages = {"fr.lusseau.bibliotheque"})
@EntityScan("fr.lusseau.bibliotheque.entity")
public class BibliothequeApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(BibliothequeApplication.class, args);
	}
	
	public void configureViewResolvers(ViewResolverRegistry registry) {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/view/");
        resolver.setSuffix(".jsp");
        resolver.setViewClass(JstlView.class);
        registry.viewResolver(resolver);
    }
	
	 @Bean
	  public Formatter<LocalDate> localDateFormatter() {
	    return new Formatter<LocalDate>() {
	      @Override
	      public LocalDate parse(String text, Locale locale) throws ParseException {
	        return LocalDate.parse(text, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	      }

	      @Override
	      public String print(LocalDate object, Locale locale) {
	        return DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.FRANCE).format(object);
	      }
	    };
	  }
}
