package be.switchfully.codecavalry.digibooky.service.mapper;

import be.switchfully.codecavalry.digibooky.business.entity.Book;
import be.switchfully.codecavalry.digibooky.service.dto.BookDTO;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {

    public Book createBook(BookDTO bookDTO) {
        return new Book(
                bookDTO.getAuthor(),
                bookDTO.getIsbn(),
                bookDTO.getTitle(),
                bookDTO.getSmallSummary());
    }

    public BookDTO toDTO(Book book) {
        BookDTO result = new BookDTO(book.getAuthor(), book.getIsbn(), book.getTitle(), book.getSmallSummary());
        return result;

    }

}
