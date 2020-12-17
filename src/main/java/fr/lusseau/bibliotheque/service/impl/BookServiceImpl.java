/**
 * 
 */
package fr.lusseau.bibliotheque.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.lusseau.bibliotheque.dao.BookDAO;
import fr.lusseau.bibliotheque.entity.Book;
import fr.lusseau.bibliotheque.service.BookService;

/**
 * Class in charge of defining .
 * @Version Bibliotheque -v1,0
 * @date  25 oct. 2020 - 12:28:29
 * @author Claude LUSSEAU
 *
 */
@Service("BookService")
@Transactional
public class BookServiceImpl implements BookService {

	@Autowired
	BookDAO dao;
	
	/**
	 * @{inheritDoc}
	*/
	@Override
	public Book saveBook(Book book) {
		return dao.save(book);
	}

	/**
	 * @{inheritDoc}
	*/
	@Override
	public Book updateBook(Book book) {
		return dao.save(book);
	}

	/**
	 * @{inheritDoc}
	*/
	@Override
	public void deleteBook(Integer idBook) {
		dao.deleteById(idBook);
	}

	/**
	 * @{inheritDoc}
	*/
	@Override
	public List<Book> findByTitleContainingIgnoreCase(String title) {
		return dao.findByTitleContainingIgnoreCase(title);
	}


	/**
	 * @{inheritDoc}
	*/
	@Override
	public boolean checkIfIdExists(Integer idBook) {
		return dao.existsById(idBook);
	}

	/**
	 * @{inheritDoc}
	*/
	@Override
	public Book findByTitle(String title) {
		return dao.findByTitle(title);
	}

	/**
	 * @{inheritDoc}
	*/
	@Override
	public List<Book> findAll() {
		return dao.findAll();
	}
}
