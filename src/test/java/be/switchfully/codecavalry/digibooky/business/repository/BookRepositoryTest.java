package be.switchfully.codecavalry.digibooky.business.repository;

import be.switchfully.codecavalry.digibooky.business.entity.Author;
import be.switchfully.codecavalry.digibooky.business.entity.Book;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookRepositoryTest {

    @Test

    public void whenAskingForBookWithIsbnThenReturnRelatedBook ()
    {
        BookRepository bookRepository = new BookRepository();

        Book book = bookRepository.getBook(1234567891011L);

        Assertions.assertEquals(book.getAuthor(), new Author("Gunther","Lippens"));
        Assertions.assertEquals(book.getIsbn(), 1234567891011L);
        Assertions.assertEquals(book.getTitle(), "Java is cool");
        Assertions.assertEquals(book.getSmallSummary(), "Talk about Java");

    }

}