package be.switchfully.codecavalry.digibooky.service;

import be.switchfully.codecavalry.digibooky.business.repository.BookRepository;
import be.switchfully.codecavalry.digibooky.service.dto.BookDTO;
import be.switchfully.codecavalry.digibooky.service.dto.BookDTOCompactOverview;
import be.switchfully.codecavalry.digibooky.service.mapper.BookMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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

        BookDTOCompactOverview summier = bookService.getBookmapper().overviewDTO(bookService.
                getBookRepository().getBook(1110987654321L));

        Assertions.assertTrue(bookService.getBooksByPartialIsbn("1109").contains(summier));
    }

    @Test
    void givenPartOfTitleReturnsExpectedBook() {
        BookDTO bookDTO = new BookDTO();
        bookDTO.setAuthorFirstName("Pascal");
        bookDTO.setAuthorLastName("Baelen");
        bookDTO.setIsbn(1110987654321L);
        bookDTO.setTitle("Java is hot");
        bookDTO.setSmallSummary("Talk about anything");

        BookService bookService = new BookService(new BookRepository(), new BookMapper());

        bookService.getBookRepository().save(bookService.getBookmapper().createBook(bookDTO));

        BookDTOCompactOverview summier = bookService.getBookmapper().overviewDTO(bookService.
                getBookRepository().getBook(1110987654321L));
        Assertions.assertTrue(bookService.getBookByTitle("Java").contains(summier));
    }

    @Test
    void givenPartOfAuthorReturnsExpectedBook() {
        BookDTO bookDTO = new BookDTO();
        bookDTO.setAuthorFirstName("Pascal");
        bookDTO.setAuthorLastName("Baelen");
        bookDTO.setIsbn(1110987654321L);
        bookDTO.setTitle("Java is hot");
        bookDTO.setSmallSummary("Talk about anything");

        BookService bookService = new BookService(new BookRepository(), new BookMapper());

        bookService.getBookRepository().save(bookService.getBookmapper().createBook(bookDTO));

        BookDTOCompactOverview summier = bookService.getBookmapper().overviewDTO(bookService.
                getBookRepository().getBook(1110987654321L));
        Assertions.assertTrue(bookService.getBookByAuthor("Pas").contains(summier));


    }

    @Test
    void createNewBookReturnsExpectedBook() {
        BookDTO bookDTO = new BookDTO();
        bookDTO.setAuthorFirstName("Pascal");
        bookDTO.setAuthorLastName("Baelen");
        bookDTO.setIsbn(1110987654321L);
        bookDTO.setTitle("Java is hot");
        bookDTO.setSmallSummary("Talk about anything");

        BookService bookService = new BookService(new BookRepository(), new BookMapper());

        Assertions.assertEquals(bookDTO, bookService.registerBook(bookDTO));



    }

}