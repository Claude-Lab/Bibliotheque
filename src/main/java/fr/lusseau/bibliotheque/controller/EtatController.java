/**
 * 
 */
package fr.lusseau.bibliotheque.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.lusseau.bibliotheque.dao.EtatDAO;
import fr.lusseau.bibliotheque.entity.Etat;
import io.swagger.annotations.ApiOperation;

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
@RequestMapping("/api/v1")
public class EtatController {

	@Autowired
	EtatDAO dao;

	@PostConstruct
	private void init() {
	}

	// get all Roles
	@ApiOperation(value = "Récupère la liste des etats")
	@GetMapping(value = "etats")
	public List<Etat> listLivres() {
		return dao.findAll();
	}

}
