package be.switchfully.codecavalry.digibooky.service.mapper;

import be.switchfully.codecavalry.digibooky.business.entity.Author;
import be.switchfully.codecavalry.digibooky.business.entity.Book;
import be.switchfully.codecavalry.digibooky.business.repository.BookRepository;
import be.switchfully.codecavalry.digibooky.service.dto.BookDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookMapperTest {

    @Test
    void testIfMapperWorksAsItShouldObjectToDTO() {
        BookRepository bookRepository = new BookRepository();
        BookMapper bookMapper = new BookMapper();

        Book book = bookRepository.getBook(1234567891011L);
        BookDTO bookDTO = bookMapper.toDTO(book);

        Assertions.assertEquals(book.getAuthor(), bookDTO.getAuthor());
        Assertions.assertEquals(book.getIsbn(), bookDTO.getIsbn());
        Assertions.assertEquals(book.getTitle(), bookDTO.getTitle());
        Assertions.assertEquals(book.getSmallSummary(), bookDTO.getSmallSummary());

    }

    @Test
    void testIfMapperWorksAsItShouldDTOToObject() {
        BookMapper bookMapper = new BookMapper();

        BookDTO bookDTO = new BookDTO(new Author("Pascal", "Baelen"), 1110987654321L, "Java is hot",
                "Talk about anything");

        Book book = bookMapper.createBook(bookDTO);

        Assertions.assertEquals(book.getAuthor(), bookDTO.getAuthor());
        Assertions.assertEquals(book.getIsbn(), bookDTO.getIsbn());
        Assertions.assertEquals(book.getTitle(), bookDTO.getTitle());
        Assertions.assertEquals(book.getSmallSummary(), bookDTO.getSmallSummary());

    }


}
