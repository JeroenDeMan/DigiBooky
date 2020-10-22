package be.switchfully.codecavalry.digibooky.service;

import be.switchfully.codecavalry.digibooky.business.repository.BookRepository;
import be.switchfully.codecavalry.digibooky.service.dto.BookDTO;
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

    public List<BookDTO> getAllBookDTOs() {
        return bookRepository.getBooks().stream()
                .map(book -> bookmapper.overViewDTO(book))
                .collect(Collectors.toList());
    }

    public BookDTO getBookDetailsById(long isbn) {
        return bookmapper.detailDTO(bookRepository.getBook(isbn));

    }

    public List <BookDTO> getBooksByPartialIsbn(String isbnPartialToCheck) {

        List<Long> keys =
                bookRepository.getBookMap()
                        .keySet()
                        .stream()
                        .map(isbn -> String.valueOf(isbn))
                        .filter(isbn -> isbn.contains(isbnPartialToCheck))
                        .map(isbn -> Long.valueOf(isbn))
                        .collect(Collectors.toList());

        List<BookDTO> result = new ArrayList<>();
        for (long isbnkey : keys) {
            result.add(bookmapper.overViewDTO(bookRepository.getBook(isbnkey)));
        }
        return result;
    }
}
