package be.switchfully.codecavalry.digibooky.service.mapper;

import be.switchfully.codecavalry.digibooky.business.entity.Author;
import be.switchfully.codecavalry.digibooky.business.entity.Book;
import be.switchfully.codecavalry.digibooky.service.dto.BookDTO;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {

    public Book createBook(BookDTO bookDTO) {
        return new Book(
                new Author(
                        bookDTO.getAuthorFirstName(),
                        bookDTO.getAuthorLastName()),
                bookDTO.getIsbn(),
                bookDTO.getTitle(),
                bookDTO.getSmallSummary());
    }

    public BookDTO overViewDTO(Book book) {
        BookDTO result = new BookDTO();
        result.setAuthorFirstName(book.getAuthor().getFirstName());
        result.setAuthorLastName(book.getAuthor().getLastName());
        result.setIsbn(book.getIsbn());
        result.setTitle(book.getTitle());
        return result;

    }

    public BookDTO detailDTO(Book book) {
        BookDTO result = overViewDTO(book);
        result.setSmallSummary(book.getSmallSummary());
        return result;
    }
}

