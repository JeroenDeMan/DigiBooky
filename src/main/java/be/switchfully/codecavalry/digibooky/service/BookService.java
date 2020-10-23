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
    private BookMapper bookmapper;

    @Autowired
    public BookService(BookRepository bookRepository, BookMapper bookmapper) {
        this.bookRepository = bookRepository;
        this.bookmapper = bookmapper;
    }

    public List<BookDTOCompactOverview> getAllBookDTOs() {
        return bookRepository.getBooks().stream()
                .map(book -> bookmapper.overviewDTO(book))
                .collect(Collectors.toList());
    }

    public BookDTO getBookDetailsById(long isbn) {
        return bookmapper.detailDTO(bookRepository.getBook(isbn));

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

        if (keys.isEmpty()) {
            throw new BookNotFoundException("No book matching input by user");
        }

        List<BookDTOCompactOverview> result = new ArrayList<>();
        for (long isbnkey : keys) {
            result.add(bookmapper.overviewDTO(bookRepository.getBook(isbnkey)));
        }
        return result;
    }

    public List<BookDTOCompactOverview> getBookByTitle(String partialTitle) {
        List<Book> books =
                bookRepository.getBooks().stream()
                        .filter(book -> book.getTitle().toLowerCase().contains(partialTitle.toLowerCase()))
                        .collect(Collectors.toList());

        return books.stream().map(book -> bookmapper.overviewDTO(book)).collect(Collectors.toList());
    }

    public List<BookDTOCompactOverview> getBookByAuthor(String partialAuthor) {
        List<Book> books =
                bookRepository.getBooks().stream()
                        .filter(book -> book.getAuthor().getFullName().toLowerCase().contains(partialAuthor.toLowerCase()))
                        .collect(Collectors.toList());

        return books.stream().map(book -> bookmapper.overviewDTO(book)).collect(Collectors.toList());
    }

    public BookRepository getBookRepository() {
        return bookRepository;
    }

    public BookMapper getBookmapper() {
        return bookmapper;
    }
}
