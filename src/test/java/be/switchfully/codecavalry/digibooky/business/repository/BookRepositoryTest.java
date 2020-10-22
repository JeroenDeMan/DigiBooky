package be.switchfully.codecavalry.digibooky.business.repository;

import be.switchfully.codecavalry.digibooky.business.entity.Author;
import be.switchfully.codecavalry.digibooky.business.entity.Book;
import be.switchfully.codecavalry.digibooky.exceptions.books.BookNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class BookRepositoryTest {

    @Test
    public void whenAskingForBookWithIsbnThenReturnRelatedBookWithCorrectAuthor () {
        BookRepository bookRepository = new BookRepository();
        Book book = bookRepository.getBook(1234567891011L);
        Assertions.assertEquals(book.getAuthor(), new Author("Gunther","Lippens"));
    }

    @Test
    public void whenAskingForBookWithIsbnThenReturnRelatedBookWithCorrectIsbn () {
        BookRepository bookRepository = new BookRepository();
        Book book = bookRepository.getBook(1234567891011L);
        Assertions.assertEquals(book.getIsbn(), 1234567891011L);


    }

    @Test
    public void whenAskingForBookWithIsbnThenReturnRelatedBookWithCorrectTitle () {
        BookRepository bookRepository = new BookRepository();
        Book book = bookRepository.getBook(1234567891011L);
        Assertions.assertEquals(book.getTitle(), "Java is cool");
    }

    @Test
    public void whenAskingForBookWithIsbnThenReturnRelatedBookWithCorrectSmallSummary ()
    {
        BookRepository bookRepository = new BookRepository();
        Book book = bookRepository.getBook(1234567891011L);
        Assertions.assertEquals(book.getSmallSummary(), "Talk about Java");
    }

    @Test
    public void whenAskingForBookWithNonExistingIsbn_thenThrowsBookNotFoundException () {
        BookRepository bookRepository = new BookRepository();
        Assertions.assertThrows(BookNotFoundException.class,() -> bookRepository.getBook(6666666666666L));
    }

    @Test
    public void whenAskingForAllBooks_thenSizeOfReturnedCollectionIsTwo () {
        BookRepository bookRepository = new BookRepository();
        List<Book> books = bookRepository.getBooks();
        final int expectedSize = 3;
        Assertions.assertEquals(expectedSize,books.size());
    }

}