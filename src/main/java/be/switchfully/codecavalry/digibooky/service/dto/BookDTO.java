package be.switchfully.codecavalry.digibooky.service.dto;
import be.switchfully.codecavalry.digibooky.business.entity.Author;
import java.util.Objects;


    public class BookDTO {
        private Author author;
        private final long isbn;
        private String title;
        private String smallSummary;

        public BookDTO(Author author, long isbn, String title, String smallSummary) {
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
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            BookDTO bookDTO = (BookDTO) o;
            return isbn == bookDTO.isbn &&
                    author.equals(bookDTO.author) &&
                    title.equals(bookDTO.title) &&
                    smallSummary.equals(bookDTO.smallSummary);
        }

        @Override
        public int hashCode() {
            return Objects.hash(author, isbn, title, smallSummary);
        }

        @Override
        public String toString() {
            return "BookDTO{" +
                    "author=" + author +
                    ", isbn=" + isbn +
                    ", title='" + title + '\'' +
                    ", smallSummary='" + smallSummary + '\'' +
                    '}';
        }
    }


