package ee.meriloo.laenutus.service;

import ee.meriloo.laenutus.model.Book;
import ee.meriloo.laenutus.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service("bookService")
@Transactional
public class BookServiceImpl implements BookService{

	@Autowired
	private BookRepository bookRepository;

	public Book findById(Long id) {
		return bookRepository.findOne(id);
	}

	public void saveBook(Book book) {
		bookRepository.save(book);
	}

	public void updateBook(Book book){
		saveBook(book);
	}

	public List<Book> findAllBooks(){
		return bookRepository.findAll();
	}

}
