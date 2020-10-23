package be.switchfully.codecavalry.digibooky.service;

import be.switchfully.codecavalry.digibooky.business.repository.BookRepository;
import be.switchfully.codecavalry.digibooky.exceptions.books.BookNotFoundException;
import be.switchfully.codecavalry.digibooky.service.dto.BookDTO;
import be.switchfully.codecavalry.digibooky.service.dto.BookDTOCompactOverview;
import be.switchfully.codecavalry.digibooky.service.mapper.BookMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BookServiceTest {

    BookDTO bookDTO;
    BookService bookService;

    @BeforeEach
    public void setUp() {
        bookDTO = new BookDTO();
        bookDTO.setAuthorFirstName("Pascal");
        bookDTO.setAuthorLastName("Baelen");
        bookDTO.setIsbn(1110987654321L);
        bookDTO.setTitle("Java is hot");
        bookDTO.setSmallSummary("Talk about anything");

        bookService = new BookService(new BookRepository(), new BookMapper());

    }

    @Test
    void givenPartOfIsbreturnsExpectedBook() {

        bookService.registerBook(bookDTO);

        BookDTOCompactOverview summier = bookService.getBookmapper().overviewDTO(bookService.
                getBookRepository().getBook(1110987654321L));

        Assertions.assertTrue(bookService.getBooksByPartialIsbn("1109").contains(summier));
    }

    @Test
    void givenPartOfIsbrthatNotExsistsThrowsBookNotFoundException() {

        bookService.registerBook(bookDTO);

        Assertions.assertThrows(BookNotFoundException.class, () -> bookService.
                getBooksByPartialIsbn("9999"));
    }

    @Test
    void givenPartOfTitleReturnsExpectedBook() {

        bookService.registerBook(bookDTO);

        BookDTOCompactOverview summier = bookService.getBookmapper().overviewDTO(bookService.
                getBookRepository().getBook(1110987654321L));
        Assertions.assertTrue(bookService.getBookByTitle("Java").contains(summier));
    }

    @Test
    void givenPartOfTitlethatNotExsistsThrowsBookNotFoundException() {

        bookService.registerBook(bookDTO);

        Assertions.assertThrows(BookNotFoundException.class, () -> bookService.
                getBookByTitle(".net is cool"));
    }

    @Test
    void givenPartOfTitleReturnsExpectedBookwithCaseSensitivity() {

        bookService.registerBook(bookDTO);

        BookDTOCompactOverview summier = bookService.getBookmapper().overviewDTO(bookService.
                getBookRepository().getBook(1110987654321L));
        Assertions.assertTrue(bookService.getBookByTitle("java").contains(summier));
    }

    @Test
    void givenPartOfAuthorReturnsExpectedBook() {

        bookService.registerBook(bookDTO);

        BookDTOCompactOverview summier = bookService.getBookmapper().overviewDTO(bookService.
                getBookRepository().getBook(1110987654321L));
        Assertions.assertTrue(bookService.getBookByAuthor("Pas").contains(summier));

    }

    @Test
    void givenPartOfAuthorthatNotExsistsThrowsBookNotFoundException() {

        bookService.registerBook(bookDTO);

        Assertions.assertThrows(BookNotFoundException.class, () -> bookService.
                getBookByAuthor("Alex"));
    }

    @Test
    void givenPartOfAuthorReturnsExpectedBookwithCaseSensitivity() {

        bookService.registerBook(bookDTO);

        BookDTOCompactOverview summier = bookService.getBookmapper().overviewDTO(bookService.
                getBookRepository().getBook(1110987654321L));
        Assertions.assertTrue(bookService.getBookByAuthor("pas").contains(summier));

    }

    @Test
    void createNewBookReturnsExpectedBook() {

        Assertions.assertEquals(bookDTO, bookService.registerBook(bookDTO));
    }

    @Test
    void updateBookReturnsExpectedBook() {

        BookDTO bookDTO2 = new BookDTO();
        bookDTO2.setAuthorFirstName("Pascal");
        bookDTO2.setAuthorLastName("Baelen");
        bookDTO2.setIsbn(1110987654321L);
        bookDTO2.setTitle("Java is chocolat");
        bookDTO2.setSmallSummary("Talk about chocolat");


        Assertions.assertEquals(bookDTO2.getTitle(), bookService.updateBook(bookDTO.getIsbn(), bookDTO2).getTitle());

    }


}