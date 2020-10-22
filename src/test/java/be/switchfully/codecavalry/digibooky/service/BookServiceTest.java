package be.switchfully.codecavalry.digibooky.service;

import be.switchfully.codecavalry.digibooky.business.repository.BookRepository;
import be.switchfully.codecavalry.digibooky.service.dto.BookDTO;
import be.switchfully.codecavalry.digibooky.service.mapper.BookMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookServiceTest {

    @Test

    void givenPartOfIsbreturnsExpectedBook() {

        BookDTO bookDTO = new BookDTO();
        bookDTO.setAuthorFirstName("Pascal");
        bookDTO.setAuthorLastName("Baelen");
        bookDTO.setIsbn(1110987654321L);
        bookDTO.setTitle("Java is hot");
        bookDTO.setSmallSummary("Talk about anything");

        BookService bookService = new BookService(new BookRepository(), new BookMapper());

        bookService.getBookRepository().save(bookService.getBookmapper().createBook(bookDTO));
        //System.out.println(bookService.getBooksByPartialIsbn("1109"));
        Assertions.assertTrue(bookService.getBooksByPartialIsbn("1109").contains(bookDTO));
    }

}