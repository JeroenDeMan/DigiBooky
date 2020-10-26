package be.switchfully.codecavalry.digibooky.business.repository;

import be.switchfully.codecavalry.digibooky.business.entity.Author;
import be.switchfully.codecavalry.digibooky.business.entity.Book;
import be.switchfully.codecavalry.digibooky.exceptions.books.BookNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.*;


@Repository
public class BookRepository {

    private Map<Long, Book> books;
    private Map<Long, Book> deletedBooks;

    public BookRepository() {
        this.books = new HashMap<>();
        this.deletedBooks = new HashMap<>();
        addFirstThreeBooks();
    }

    public Book save(Book book) {
        if (book == null)              throw new BookNotFoundException("No data provided");
        if (books.containsValue(book)) throw new BookNotFoundException(book.getIsbn() + " already exists");

        books.put(book.getIsbn(), book);
        return book;

    }

    public void addFirstThreeBooks() {
        Book book1 = new Book(new Author("Gunther", "Lippens"), 1234567891011L,
                "Java is cool", "Talk about Java");
        Book book2 = new Book(new Author("Pascal", "Baelen"), 1110987654321L,
                "Java is hot", "Talk about Anything");
        Book book3 = new Book(new Author("Jeroen", "De Man"), 1000987654321L,
                "Java is whatever", "Talk about whatever");
        books.put(1234567891011L, book1);
        books.put(1110987654321L, book2);
        books.put(1000987654321L, book3);
    }

    public Book getBook(long isbn) {
        Book book = books.get(isbn);
        if (Objects.isNull(book)) {
            throw new BookNotFoundException("There is no book available with the isbn number " + isbn);
        }
        return book;
    }

    public Book delete(long isbn) {
        Book result = books.remove(isbn);
        deletedBooks.put(result.getIsbn(), result);
        return result;
    }

    public Book retrieveDeletedBook(long isbn){
        Book result = deletedBooks.remove(isbn);
        books.put(result.getIsbn(), result);
        return result;
    }

    public List<Book> getBooks() {
        return new ArrayList<>(books.values());
    }

    public Map<Long,Book> getBookMap(){
        return books;
    }

    public Map<Long, Book> getDeletedBooks(){
        return deletedBooks;
    }
}

