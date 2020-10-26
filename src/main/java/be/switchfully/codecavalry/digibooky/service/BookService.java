package be.switchfully.codecavalry.digibooky.service;

import be.switchfully.codecavalry.digibooky.business.entity.Book;
import be.switchfully.codecavalry.digibooky.business.repository.BookRepository;
import be.switchfully.codecavalry.digibooky.exceptions.books.BookNotFoundException;
import be.switchfully.codecavalry.digibooky.service.dto.BookDTO;
import be.switchfully.codecavalry.digibooky.service.dto.BookDTOCompactOverview;
import be.switchfully.codecavalry.digibooky.service.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    private BookRepository bookRepository;
    private BookMapper bookMapper;

    @Autowired
    public BookService(BookRepository bookRepository, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }

    public BookRepository getBookRepository() {
        return bookRepository;
    }

    public BookMapper getBookMapper() {
        return bookMapper;
    }

    public List<BookDTOCompactOverview> getAllBookDTOs() {
        return bookRepository.getBooks().stream()
                .map(book -> bookMapper.overviewDTO(book))
                .collect(Collectors.toList());
    }

    public BookDTO getBookDetailsById(long isbn) {
        return bookMapper.detailDTO(bookRepository.getBook(isbn));

    }

    public List<BookDTOCompactOverview> getBooksByPartialIsbn(String isbnPartialToCheck) {

        List<Long> keys =
                bookRepository.getBookMap()
                        .keySet()
                        .stream()
                        .map(isbn -> String.valueOf(isbn))
                        .filter(isbn -> isbn.contains(isbnPartialToCheck))
                        .map(isbn -> Long.valueOf(isbn))
                        .collect(Collectors.toList());

        if (keys.isEmpty()) throw new BookNotFoundException("No book matching input by user");

        List<BookDTOCompactOverview> result = new ArrayList<>();
        for (long isbnKey : keys) {
            result.add(bookMapper.overviewDTO(bookRepository.getBook(isbnKey)));
        }
        return result;
    }

    public List<BookDTOCompactOverview> getBookByTitle(String partialTitle) {
        List<Book> books =
                bookRepository.getBooks().stream()
                        .filter(book -> book.getTitle().toLowerCase().contains(partialTitle.toLowerCase()))
                        .collect(Collectors.toList());

        if (books.isEmpty()) throw new BookNotFoundException("No book matching by input user");

        return books.stream().map(book -> bookMapper.overviewDTO(book)).collect(Collectors.toList());
    }

    public List<BookDTOCompactOverview> getBookByAuthor(String partialAuthor) {
        List<Book> books =
                bookRepository.getBooks().stream()
                        .filter(book -> book.getAuthor().getFullName().toLowerCase().contains(partialAuthor.toLowerCase()))
                        .collect(Collectors.toList());

        if (books.isEmpty()) throw new BookNotFoundException("No book matching by input user");

        return books.stream().map(book -> bookMapper.overviewDTO(book)).collect(Collectors.toList());
    }

    public BookDTO registerBook(BookDTO bookDTO) {
        Book book = bookRepository.save(bookMapper.createBook(bookDTO));
        return bookMapper.detailDTO(book);
    }

    public BookDTO updateBook(long isbn, BookDTO bookDTO) {
        if (!bookRepository.getBookMap().containsKey(isbn)) throw new BookNotFoundException("Book with Isbn " + isbn + " not found");

        Book book = bookRepository.getBook(isbn);
        book.getAuthor().setFirstName(bookDTO.getAuthorFirstName());
        book.getAuthor().setLastName(bookDTO.getAuthorLastName());
        book.setTitle(bookDTO.getTitle());
        book.setSmallSummary(bookDTO.getSmallSummary());
        return bookMapper.detailDTO(book);
    }

    public BookDTOCompactOverview deleteBook(long isbn) {
        return bookMapper.overviewDTO(bookRepository.delete(isbn));
    }


}
