package ee.meriloo.laenutus.service;

import ee.meriloo.laenutus.model.Book;

import java.util.List;

public interface BookService {

	Book findById(Long id);

	void saveBook(Book user);

	void updateBook(Book user);

	List<Book> findAllBooks();

}