/**
 * 
 */
package fr.lusseau.bibliotheque.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.lusseau.bibliotheque.entity.Role;
import fr.lusseau.bibliotheque.service.GestionRole;

/**
 * 
 * Classe en charge de la gestion et de la synchronisation des événements à la classe  Role.
 * @Version Bibliotheque -v1,0
 * @date  15 août 2020 - 10:35:22
 * @author Claude LUSSEAU
 *
 */

@Controller
public class RoleController {
	
	@Autowired
	GestionRole gr;
	
	@PostConstruct
	private void init() {
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/listeRoles")
	public ModelAndView listerRoles() {
		List<Role> listeR = gr.listeRoles();
		return new ModelAndView("/admin/listes/listeRoles", "listeR", listeR);
	}
	
	@RequestMapping(value = "/gestionRoles", method = RequestMethod.GET)
	public ModelAndView gererRoles() {
		List<Role> listeR = gr.listeRoles();
		Role role = new Role();
		ModelAndView mav = new ModelAndView("/admin/gestion/gestionRoles", "listeR", listeR);
		mav.getModelMap().addAttribute("role", role);
		return mav;
	}
	@RequestMapping( value = "/ajouterRoles", method = RequestMethod.GET)
	public ModelAndView ajoutRole() {
		Role role = new Role();
		ModelAndView mav = new ModelAndView("/admin/ajouts/ajoutRole", "role", role);
		mav.getModelMap().addAttribute("role", role);
		return mav;
	}

	@RequestMapping( value = "/validRole", method = RequestMethod.POST)
	public String ajoutRoleValid(@ModelAttribute("role") @Valid Role role, BindingResult result) {
		if (result.hasErrors()) 
			return "/admin/ajouts/ajoutRole";
		 else
			gr.ajouterRole(role);
			return "redirect:/gestionRoles";
	}
	
	
	@RequestMapping(value="/modifierRole", method=RequestMethod.GET)
	public ModelAndView modifRole(String index){
		int i = Integer.parseInt(index.substring(1));
		return new ModelAndView("/admin/modifs/modifRole", "role", gr.trouverRole(i));
	}
	
	@RequestMapping(value="/modifierRoleValid", method=RequestMethod.POST)
	public ModelAndView listeRoleValid(Role role){	
		gr.modifierRole(role);
		return gererRoles();
	}
	
	@RequestMapping(value="/supprimerRole", method=RequestMethod.GET)
	public ModelAndView supprimerRole(String index){
		int i = Integer.parseInt(index.substring(1));
		Role role = gr.trouverRole(i);
		try {
			gr.supprimerRole(role);
		} catch (Exception e) {			
		}
		
		return gererRoles();
	}

}
