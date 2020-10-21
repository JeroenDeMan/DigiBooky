package be.switchfully.codecavalry.digibooky.business.repository;

import be.switchfully.codecavalry.digibooky.business.entity.Author;
import be.switchfully.codecavalry.digibooky.business.entity.Book;
import be.switchfully.codecavalry.digibooky.service.dto.BookDTO;
import be.switchfully.codecavalry.digibooky.service.mapper.BookMapper;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;


@Repository
public class BookRepository {

    private Map<Long, Book> books;
    private BookMapper bookMapper;

    public BookRepository() {
        this.books = new HashMap<>();
        addFirsttwoBooks();
    }

    public Book save(Book book) {
        if (book == null)              throw new BookNotFoundException("No data provided");
        if (books.containsValue(book)) throw new BookNotFoundException(book.getIsbn() + " already exists");

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
        Book book = books.get(isbn);
        if (Objects.isNull(book)) {
            throw new BookNotFoundException("There is no book availaible with the isbn number " + isbn);
        }
        return book;
    }

    public Book delete(long isbn) {
        return books.remove(isbn);
    }

    public List<Book> getBooks() {
        return new ArrayList<>(books.values());
    }
}

