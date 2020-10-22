/**
 * 
 */
package fr.lusseau.bibliotheque.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import fr.lusseau.bibliotheque.dao.CautionDAO;

/**
 * Classe en charge de la gestion et de la synchronisation des événements liés à la classe Caution.
 * @Version Bibliotheque -v1,0
 * @date  15 août 2020 - 10:35:13
 * @author Claude LUSSEAU
 *
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CautionController {
	
	@Autowired
	CautionDAO dao;
	
	@PostConstruct
	private void init() {
	}
	
	
}
