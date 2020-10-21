package be.switchfully.codecavalry.digibooky.business.repository;

import be.switchfully.codecavalry.digibooky.business.entity.Author;
import be.switchfully.codecavalry.digibooky.business.entity.Book;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;


@Repository
public class BookRepository {

    private Map<Long, Book> books;

    public BookRepository() {
        this.books = new HashMap<>();
        addFirsttwoBooks();
    }

    public Book save(Book book) {
        if (book == null) throw new IllegalArgumentException("No data provided");
        if (books.containsValue(book)) throw new IllegalArgumentException(book.getTitle() + " already exists");

        books.put(book.getIsbn(), book);
        return book;

    }

    public void addFirsttwoBooks() {
        Book book1 = new Book(new Author("Gunther", "Lippens"), 1234567891011L,
                "Java is cool", "Talk about Java");
        Book book2 = new Book(new Author("Pascal", "Baelen"), 1110987654321L,
                "Java is hot", "Talk about Anything");
        books.put(1234567891011L, book1);
        books.put(1110987654321L, book2);
    }

    public Book getBook(long isbn) {
        return books.get(isbn);
    }

    public Book delete(String id) {
        return books.remove(id);
    }

}

