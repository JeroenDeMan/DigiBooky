package be.switchfully.codecavalry.digibooky.business.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {
    @Test
    public void creatingNewBook_thenBookHasCorrectAuthor () {
        Book book = new Book(new Author("Pascal", "Baelen"), 1110987654321L, "Java is hot",
                "Talk about anything");
        Assertions.assertEquals(new Author("Pascal","Baelen"), book.getAuthor());
    }

    @Test
    public void creatingNewBook_thenBookHasCorrectIsbn () {
        Book book = new Book(new Author("Pascal", "Baelen"), 1110987654321L, "Java is hot",
                "Talk about anything");
        Assertions.assertEquals(1110987654321L, book.getIsbn());
    }

    @Test
    public void creatingNewBook_thenBookHasCorrectTitle () {
        Book book = new Book(new Author("Pascal", "Baelen"), 1110987654321L, "Java is hot",
                "Talk about anything");
        Assertions.assertEquals("Java is hot", book.getTitle());
    }

    @Test
    public void creatingNewBook_thenBookHasCorrectSmallSummary () {
        Book book = new Book(new Author("Pascal", "Baelen"), 1110987654321L, "Java is hot",
                "Talk about anything");
        Assertions.assertEquals("Talk about anything", book.getSmallSummary());
    }

}