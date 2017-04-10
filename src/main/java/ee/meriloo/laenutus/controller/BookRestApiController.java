package ee.meriloo.laenutus.controller;

import ee.meriloo.laenutus.model.Book;
import ee.meriloo.laenutus.service.BookService;
import ee.meriloo.laenutus.util.CustomErrorType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api")
public class BookRestApiController {

	public static final Logger logger = LoggerFactory.getLogger(BookRestApiController.class);

	@Autowired
	BookService bookService; //Service which will do all data retrieval/manipulation work

	// -------------------Retrieve All Books---------------------------------------------

	@RequestMapping(value = "/book/", method = RequestMethod.GET)
	public ResponseEntity listAllBooks() {
		List<Book> books = bookService.findAllBooks();
		if (books.isEmpty()) return new ResponseEntity(HttpStatus.NO_CONTENT);
		return new ResponseEntity<>(books, HttpStatus.OK);
	}

	// -------------------Retrieve Single Book------------------------------------------

	@RequestMapping(value = "/book/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getBook(@PathVariable("id") long id) {
		logger.info("Fetching Book with id {}", id);
		Book book = bookService.findById(id);
		if (book == null) {
			logger.error("User with id {} not found.", id);
			return new ResponseEntity(new CustomErrorType("Book with id " + id
					+ " not found"), HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Book>(book, HttpStatus.OK);
	}

	// ------------------- Update a Book ------------------------------------------------

	@RequestMapping(value = "/book/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateBook(@PathVariable("id") long id, @RequestBody Book book) {
		logger.info("Updating Book with id {}", id);

    Book currentBook = bookService.findById(id);

		if (currentBook == null) {
			logger.error("Unable to update. Book with id {} not found.", id);
			return new ResponseEntity(new CustomErrorType("Unable to upate. Book with id " + id + " not found."),
					HttpStatus.NOT_FOUND);
		}

		currentBook.setTitle(book.getTitle());
		currentBook.setAuthor(book.getAuthor());
		if (book.isRentedout() && !currentBook.isRentedout()) {
			currentBook.setRentingdate(Date.valueOf(LocalDate.now()));
		} else if (!book.isRentedout() && currentBook.isRentedout()) {
			currentBook.setRentingdate(null);
		}
		currentBook.setRentedout(book.isRentedout());
		currentBook.setComment(book.getComment());

    bookService.updateBook(currentBook);
		return new ResponseEntity<>(currentBook, HttpStatus.OK);
	}

}