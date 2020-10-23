/**
 * 
 */
package fr.lusseau.bibliotheque.controller;

import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.lusseau.bibliotheque.entity.Category;
import fr.lusseau.bibliotheque.service.impl.CategoryServiceImpl;
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
@RestController
@Api(value = "Category Rest Controller: Contient toute les opération pour la gestion des categories")
@RequestMapping("/rest/api/v1")
public class CategoryController {

	public static final Logger LOGGER = LoggerFactory.getLogger(CategoryController.class);

	@Autowired
	CategoryServiceImpl categoryService;

	/**
	 * Methode en charge de d'ajouter une nouvelle catégorie dans la base de données.
	 * 
	 * @param categorie
	 * @return
	 */
	@PostMapping("/category/addCategory")
	@ApiOperation(value = "Ajouter une nouvelle catégorie", response = Category.class)
	@ApiResponses(value = { @ApiResponse(code = 409, message = "Erreur : la catégorie existe déjà"),
			@ApiResponse(code = 201, message = "Création : la catégorie a été correctement créée"),
			@ApiResponse(code = 304, message = "Non modifiée : la catégorie n'a pas été créée") })
	public ResponseEntity<Category> createNewCategory(@RequestBody Category category) {
		Category existingCategory = categoryService.findCategoryByLabelIgnoreCase(category.getLabel());
		if (existingCategory != null) {
			return new ResponseEntity<Category>(HttpStatus.CONFLICT);
		}
		Category categoryResponse = categoryService.saveCategory(category);
		if (categoryResponse != null) {

			return new ResponseEntity<Category>(categoryResponse, HttpStatus.CREATED);
		}
		return new ResponseEntity<Category>(HttpStatus.NOT_MODIFIED);
	}

	/**
	 * Methode en charge de lister toutes les catégories de la base de données.
	 * @return
	 */
	@GetMapping("/category/listCategories")
	@ApiOperation(value="List all book categories of the Library", response = List.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Ok: liste réussie"),
			@ApiResponse(code = 204, message = "Pas de donnée: pas de résultat"),
	})
	public ResponseEntity<List<Category>> CategoriesList() {
		List<Category> categories = categoryService.findAllCategory();
		if (!CollectionUtils.isEmpty(categories)) {
			categories.removeAll(Collections.singleton(null));
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
	@DeleteMapping("/category/deleteCategory/{idCategory}")
	@ApiOperation(value = "Supprimer une catégorie. Si la categorie n'existe pas, rien ne se passe", response = String.class)
	@ApiResponse(code = 204, message = "Pas de donnée: catégorie correctement supprimée")
	public ResponseEntity<String> deleteCategory(@PathVariable Integer idCategory) {
		categoryService.deleteCategory(idCategory);
		return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
	}
	
	/**
	 * Methode en charge de la mise à jour d'une catégorie.
	 * @param categorieRequest
	 * @return
	 */
	@PutMapping("/category/updateCategory")
	@ApiOperation(value = "Modifie une categorie existante", response = Category.class)
	@ApiResponses(value = { @ApiResponse(code = 404, message = "Not Found : L'auteur.trice n'existe pas"),
			@ApiResponse(code = 200, message = "Ok: L'auteur.trice a été mis à jour"),
			@ApiResponse(code = 304, message = "Non modifié: L'auteur.trice N'A PAS ETE MIS A JOUR !") })
	public ResponseEntity<Category> updateCategory(@RequestBody Category categoryRequest) {
		if (!categoryService.checkIfIdExists(categoryRequest.getIdCategory())) {
			return new ResponseEntity<Category>(HttpStatus.NOT_FOUND);
		}
		Category categorie = categoryService.updateCategory(categoryRequest);
		if (categorie != null) {
			
			return new ResponseEntity<Category>(categorie, HttpStatus.OK);
		}
		return new ResponseEntity<Category>(HttpStatus.NOT_MODIFIED);
	}


}
