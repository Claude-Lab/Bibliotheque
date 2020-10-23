/**
 * 
 */
package fr.lusseau.bibliotheque.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import fr.lusseau.bibliotheque.dao.EditorDAO;

/**
 * Classe en charge de
 * @Version Bibliotheque -v1,0
 * @date  21 août 2020 - 14:11:25
 * @author Claude LUSSEAU
 *
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class EditorController {

	@Autowired
	EditorDAO dao;
	
	@PostConstruct
	private void init() {
	}
	
	
}
