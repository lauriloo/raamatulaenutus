package ee.meriloo.laenutus;

import ee.meriloo.laenutus.model.Book;
import ee.meriloo.laenutus.service.BookService;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;


import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BookRestApiControllerTests {

  @Autowired
  private TestRestTemplate restTemplate;

  @Autowired
  private BookService bookService;


  @Test
  public void testGetBook() {
    prepareDB();
    Book book = this.restTemplate.getForObject("/api/book/1", Book.class);
    assertThat(book.getAuthor()).isEqualToIgnoringCase("Eno Raud");
    assertThat(book.getTitle()).isEqualToIgnoringCase("Sipsik");
    assertThat(book.isRentedout()).isEqualTo(false);
    assertThat(book.getComment()).isEqualToIgnoringCase(null);
    assertThat(book.getRentingdate()).isEqualTo(null);
  }

  @Test
  public void testListAllBooks() {
    List books = this.restTemplate.getForObject("/api/book/", List.class);
    assertThat(books.size()).isEqualTo(3);
  }

  @Test
  public void testUpdateBook() {
    Book bookForUpdateTest = getBookForUpdateTest();
    this.restTemplate.put("/api/book/1", bookForUpdateTest);
    Book book = this.restTemplate.getForObject("/api/book/1", Book.class);
    assertThat(book.getAuthor()).isEqualToIgnoringCase("Eno Raud");
    assertThat(book.getTitle()).isEqualToIgnoringCase("Sipsik");
    assertThat(book.isRentedout()).isEqualTo(true);
    assertThat(book.getComment()).isEqualToIgnoringCase("Renditud");
    assertEquals(book.getRentingdate().toLocalDate(), LocalDate.now());
  }



  private void prepareDB() {
    Book newBook1 = new Book();
    newBook1.setAuthor("Eno Raud");
    newBook1.setTitle("Sipsik");
    newBook1.setRentedout(false);
    newBook1.setComment(null);
    newBook1.setRentingdate(null);
    bookService.saveBook(newBook1);

    Book newBook2 = new Book();
    newBook2.setAuthor("Autor2");
    newBook2.setTitle("Pealkiri2");
    newBook2.setRentedout(false);
    newBook2.setComment(null);
    newBook2.setRentingdate(null);
    bookService.saveBook(newBook2);

    Book newBook3 = new Book();
    newBook3.setAuthor("Autor3");
    newBook3.setTitle("Pealkiri3");
    newBook3.setRentedout(false);
    newBook3.setComment(null);
    newBook3.setRentingdate(null);
    bookService.saveBook(newBook3);
  }

  private Book getBookForUpdateTest(){
    Book book = new Book();
    book.setId(1L);
    book.setAuthor("Eno Raud");
    book.setTitle("Sipsik");
    book.setRentedout(true);
    book.setComment("Renditud");
    book.setRentingdate(null);
    return book;
  }


}
