package be.switchfully.codecavalry.digibooky.api;

import be.switchfully.codecavalry.digibooky.service.BookService;
import be.switchfully.codecavalry.digibooky.service.dto.BookDTO;
import be.switchfully.codecavalry.digibooky.service.dto.BookDTOCompactOverview;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/books")
public class BookController {
    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<BookDTOCompactOverview> getAllBooks() {
        return bookService.getAllBookDTOs();
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public BookDTO getSpecificBook(@PathVariable long id) {
        return bookService.getBookDetailsById(id);
    }

    @GetMapping(path = "/findByIsbn/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<BookDTOCompactOverview> bookDTO(@PathVariable String id) {
        return bookService.getBooksByPartialIsbn(id);
    }
    @GetMapping(path = "/findByTitle/{title}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<BookDTOCompactOverview> getbookbyTitle(@PathVariable String title) {
        return bookService.getBookByTitle(title);
    }
    @GetMapping(path = "/findByAuthor/{author}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<BookDTOCompactOverview> getbookbyAuthor(@PathVariable String author) {
        return bookService.getBookByAuthor(author);
    }

    @PostMapping(path = "/librarian", produces = MediaType.APPLICATION_JSON_VALUE,
    consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public BookDTO createbook(@RequestBody BookDTO bookDTO) {
        return bookService.registerBook(bookDTO);
    }

    @PutMapping(path = "/librarian/{isbn}", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public BookDTO updateBook(@PathVariable long isbn, @RequestBody BookDTO bookDTO) {
        return bookService.updateBook(isbn,bookDTO);
    }
}



