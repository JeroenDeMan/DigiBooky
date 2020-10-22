package be.switchfully.codecavalry.digibooky.service.mapper;

import be.switchfully.codecavalry.digibooky.business.entity.Author;
import be.switchfully.codecavalry.digibooky.business.entity.Book;
import be.switchfully.codecavalry.digibooky.business.repository.BookRepository;
import be.switchfully.codecavalry.digibooky.service.dto.BookDTO;
import be.switchfully.codecavalry.digibooky.service.dto.BookDTOSummier;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookMapperTest {

    @Test
    void testIfMapperWorksAsItShouldObjectToDTO() {
        BookRepository bookRepository = new BookRepository();
        BookMapper bookMapper = new BookMapper();

        Book book = bookRepository.getBook(1234567891011L);
        BookDTOSummier bookDTO = bookMapper.overviewDTO(book);

        Assertions.assertEquals(book.getAuthor().getFirstName(), bookDTO.getAuthorFirstName());
        Assertions.assertEquals(book.getAuthor().getLastName(), bookDTO.getAuthorLastName());
        Assertions.assertEquals(book.getIsbn(), bookDTO.getIsbn());
        Assertions.assertEquals(book.getTitle(), bookDTO.getTitle());


    }

    @Test
    void testIfMapperWorksAsItShouldDTOToObject() {
        BookMapper bookMapper = new BookMapper();

        BookDTO bookDTO = new BookDTO();
        bookDTO.setAuthorFirstName("Pascal");
        bookDTO.setAuthorLastName("Baelen");
        bookDTO.setIsbn(1110987654321L);
        bookDTO.setTitle("Java is hot");
        bookDTO.setSmallSummary("Talk about anything");
        Book book = bookMapper.createBook(bookDTO);

        Assertions.assertEquals(book.getAuthor().getFirstName(), bookDTO.getAuthorFirstName());
        Assertions.assertEquals(book.getAuthor().getLastName(), bookDTO.getAuthorLastName());
        Assertions.assertEquals(book.getIsbn(), bookDTO.getIsbn());
        Assertions.assertEquals(book.getTitle(), bookDTO.getTitle());
        Assertions.assertEquals(book.getSmallSummary(), bookDTO.getSmallSummary());

    }

    @Test
    void testIfmapperGiveDetailOfBook() {
        BookRepository bookRepository = new BookRepository();
        BookMapper bookMapper = new BookMapper();

        Book book = bookRepository.getBook(1234567891011L);
        BookDTO bookDTO = bookMapper.detailDTO(book);

        Assertions.assertEquals(book.getAuthor().getFirstName(), bookDTO.getAuthorFirstName());
        Assertions.assertEquals(book.getAuthor().getLastName(), bookDTO.getAuthorLastName());
        Assertions.assertEquals(book.getIsbn(), bookDTO.getIsbn());
        Assertions.assertEquals(book.getTitle(), bookDTO.getTitle());
        Assertions.assertEquals(book.getSmallSummary(),bookDTO.getSmallSummary());


    }
    }
