package ee.meriloo.laenutus.model;

import java.util.ArrayList;
import java.util.List;

public class Catalog {

    private List<Book> books;

    public Catalog() {
        this.books = new ArrayList<>();
        books.add(new Book("Name1", "Author1"));
        books.add(new Book("Name2", "Author2"));
        books.add(new Book("Name3", "Author3"));
    }

    public List<Book> getBooks() {
        return books;
    }
}
