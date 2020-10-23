/**
 * 
 */
package fr.lusseau.bibliotheque.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.lusseau.bibliotheque.service.impl.StateServiceImpl;

/**
 * Classe en charge de
 * 
 * @Version Bibliotheque -v1,0
 * @date 18 août 2020 - 18:36:01
 * @author Claude LUSSEAU
 *
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/rest/api/v1")
public class StateController {

	@Autowired
	StateServiceImpl stateService;

	

}
