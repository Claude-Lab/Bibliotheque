/**
 * 
 */
package fr.lusseau.bibliotheque.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.lusseau.bibliotheque.dto.request.CategoryRequest;
import fr.lusseau.bibliotheque.entity.Author;
import fr.lusseau.bibliotheque.entity.Category;
import fr.lusseau.bibliotheque.payload.RestApiResponse;
import fr.lusseau.bibliotheque.service.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


/**
 * Classe en charge de la gestion des catégories.
 * 
 * @Version Bibliotheque -v1,0
 * @date 21 oct. 2020 - 13:55:29
 * @author Claude LUSSEAU
 *
 */
@CrossOrigin("*")
@RestController
@Api(value = "Category Rest Controller: Contient toute les opération pour la gestion des categories")
@RequestMapping("/admin/category")
public class CategoryController {


	@Autowired
	CategoryService service;

	/**
	 * Methode en charge de d'ajouter une nouvelle catégorie dans la base de données.
	 * 
	 * @param categorie
	 * @return
	 */
	@PostMapping("/addCategory")
	@ApiOperation(value = "Ajouter une nouvelle catégorie", response = Category.class)
	@ApiResponses(value = { @ApiResponse(code = 409, message = "Erreur : la catégorie existe déjà"),
			@ApiResponse(code = 201, message = "Création : la catégorie a été correctement créée"),
			@ApiResponse(code = 304, message = "Non modifiée : la catégorie n'a pas été créée") })
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_EMPLOYE')")
	public ResponseEntity<?> createNewCategory(@RequestBody Category category) {
		
		if (service.existsByLabel(category.getLabel())) {
			return new ResponseEntity<Object>(new RestApiResponse(false, "Category with this label is already taken!"),
					HttpStatus.CONFLICT);
		}
		
		if (service.existsByCode(category.getCode())) {
			return new ResponseEntity<Object>(new RestApiResponse(false, "Category with this code is already taken!"),
					HttpStatus.CONFLICT);
		}
		category = new Category(category.getLabel(), category.getCode());
		Category categoryResponse = service.save(category);
		if (categoryResponse == null) {
			return new ResponseEntity<Category>(category, HttpStatus.NOT_IMPLEMENTED);
		}
		return new ResponseEntity<Object>(new RestApiResponse(true, "Category registered successfully"),
				HttpStatus.CREATED);
	}

	/**
	 * Methode en charge de lister toutes les catégories de la base de données.
	 * @return
	 */
	@GetMapping(value = "/allCategories")
	@ApiOperation(value="List all book categories of the Library", response = List.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Ok: liste réussie"),
			@ApiResponse(code = 204, message = "Pas de donnée: pas de résultat"),
	})
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_EMPLOYE') or hasRole('ROLE_USER')")
	public ResponseEntity<List<Category>> categoriesList() {
		List<Category> categories = service.findAll();
		if (!CollectionUtils.isEmpty(categories)) {
			return new ResponseEntity<List<Category>>(categories, HttpStatus.OK);
		}
		return new ResponseEntity<List<Category>>(HttpStatus.NO_CONTENT);
	}
	
	
	
	/**
	 * Methode en charge de supprimer une catégorie dans la base de données.
	 * 
	 * @param idCategorie
	 * @return
	 */
	@DeleteMapping("/delete/{id}")
	@ApiOperation(value = "Supprimer une catégorie. Si la categorie n'existe pas, rien ne se passe", response = String.class)
	@ApiResponse(code = 204, message = "Pas de donnée: catégorie correctement supprimée")
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_EMPLOYE')")
	public ResponseEntity<?> deleteCategory(@PathVariable Integer id) {
		Category category = service.getOne(id);
		if (category != null) {
			service.delete(id);
			return new ResponseEntity<Object>(new RestApiResponse(true, "Caterogy has been successfully deleted !"),
					HttpStatus.OK);
		}
		return new ResponseEntity<Object>(new RestApiResponse(false, "Caterogy not found !"), HttpStatus.NOT_FOUND);
	}
	
	/**
	 * Methode en charge de d'afficher une categorie de la base de données.
	 * 
	 * @return
	 */
	@GetMapping("/{id}")
	@ApiOperation(value = "affiche une categorie", response = Author.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Ok !"),
			@ApiResponse(code = 204, message = "Pas de donnée: pas de résultat"), })
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_EMPLOYE') or hasRole('ROLE_USER')")
	public ResponseEntity<?> getCategory(@PathVariable Integer id) {
		if (service.getOne(id) != null) {
			Category category = service.getOne(id);
			return new ResponseEntity<Object>(category, HttpStatus.OK);
		}
		return new ResponseEntity<Object>(new RestApiResponse(false, "Category not found !"), HttpStatus.NOT_FOUND);

	}
	
	/**
	 * Methode en charge de la mise à jour d'une catégorie.
	 * @param categorieRequest
	 * @return
	 */
	@PutMapping("/update/{id}")
	@ApiOperation(value = "Modifie une categorie existante", response = Category.class)
	@ApiResponses(value = { @ApiResponse(code = 404, message = "Not Found : La categorie n'existe pas"),
			@ApiResponse(code = 200, message = "Ok: La categorie a été mis à jour"),
			@ApiResponse(code = 304, message = "Non modifié: La categorie N'A PAS ETE MIS A JOUR !") })
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_EMPLOYE')")
	public ResponseEntity<?> updateCategory(@RequestBody CategoryRequest update, Category category, @PathVariable("id") Integer id) {
		
		category = service.getOne(id);
		
		if (service.existsByLabel(update.getLabel())) {
			return new ResponseEntity<Object>(new RestApiResponse(false, "Category with this label is already taken!"),
					HttpStatus.CONFLICT);
		}
		if (service.existsByCode(update.getCode())) {
			return new ResponseEntity<Object>(new RestApiResponse(false, "Category with this code is already taken!"),
					HttpStatus.CONFLICT);
		}
		
		if (category != null) {
			category.setLabel(update.getLabel());
			category.setCode(update.getCode());
			
			Category response = service.save(category);
			if( response != null) {
				return new ResponseEntity<Category>(response, HttpStatus.OK);
			}
		}
		return new ResponseEntity<Category>(HttpStatus.NOT_MODIFIED);
		
	}
}
