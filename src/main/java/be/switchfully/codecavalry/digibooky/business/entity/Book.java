package be.switchfully.codecavalry.digibooky.business.entity;

import java.util.Objects;

public class Book {
    private final Author author;
    private final long isbn;
    private final String title;
    private final String smallSummary;

    public Book(Author author, long isbn, String title, String smallSummary) {
        this.author = author;
        this.isbn = isbn;
        this.title = title;
        this.smallSummary = smallSummary;
    }

    public Author getAuthor() {
        return author;
    }

    public long getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getSmallSummary() {
        return smallSummary;
    }

    @Override
    public String toString() {
        return "Book{" +
                "author=" + author +
                ", isbn=" + isbn +
                ", title='" + title + '\'' +
                ", smallSummary='" + smallSummary + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return isbn == book.isbn &&
                author.equals(book.author) &&
                title.equals(book.title) &&
                smallSummary.equals(book.smallSummary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, isbn, title, smallSummary);
    }
}
