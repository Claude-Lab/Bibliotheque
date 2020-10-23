/**
 * 
 */
package fr.lusseau.bibliotheque.dao;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fr.lusseau.bibliotheque.entity.Library;

/**
 * Interface en charge de la liaison service-persistence de la class Bibliotheque.
 * @Version Bibliotheque -v1,0
 * @date  14 août 2020 - 11:10:17
 * @author Claude LUSSEAU
 *
 */
@Repository
public interface LibraryDAO extends JpaRepository<Library, Integer>{
	
	@Query(value = "select b.id_library, b.id_contact, c.email from Library b INNER JOIN Contact c ON  b.id_contact = c.id_contact where c.email= :email")
	public Library findLibraryByContactEmail(@Param("email") String email);
	
	public List<Library> findByNameContaining(String name);
	
	public Library findByName(String name);
	

}
