/**
 * 
 */
package fr.lusseau.bibliotheque.controller;

import javax.annotation.PostConstruct;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Classe en charge de la navigation despages statiques.
 * @Version Bibliotheque -v1,0
 * @date  17 août 2020 - 19:09:14
 * @author Claude LUSSEAU
 *
 */
@SpringBootApplication
@RestController
@RequestMapping("/")
public class NavigationController {

	@PostConstruct
	private void init() {
	}
	
	@RequestMapping(value = "/accueil", method = RequestMethod.GET)
	public ModelAndView accueilAdmin() {
		return new ModelAndView("/admin/accueil");
	}
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView home() {
		return new ModelAndView("index");
	}
}
