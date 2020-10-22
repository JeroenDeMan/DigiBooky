package be.switchfully.codecavalry.digibooky.service.dto;
import be.switchfully.codecavalry.digibooky.business.entity.Author;
import java.util.Objects;


    public class BookDTO {

        private String authorFirstName;
        private String authorLastName;
        private final long isbn;
        private String title;
        private String smallSummary;

        public BookDTO(String authorFirstName, String authorLastName, long isbn, String title, String smallSummary) {
            this.authorFirstName = authorFirstName;
            this.authorLastName = authorLastName;
            this.isbn = isbn;
            this.title = title;
            this.smallSummary = smallSummary;
        }

        public String getAuthorFirstName() {
            return authorFirstName;
        }

        public String getAuthorLastName() {
            return authorLastName;
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
                    Objects.equals(authorFirstName, bookDTO.authorFirstName) &&
                    Objects.equals(authorLastName, bookDTO.authorLastName) &&
                    Objects.equals(title, bookDTO.title) &&
                    Objects.equals(smallSummary, bookDTO.smallSummary);
        }

        @Override
        public int hashCode() {
            return Objects.hash(authorFirstName, authorLastName, isbn, title, smallSummary);
        }

        @Override
        public String toString() {
            return "BookDTO{" +
                    "authorFirstName='" + authorFirstName + '\'' +
                    ", authorLastName='" + authorLastName + '\'' +
                    ", isbn=" + isbn +
                    ", title='" + title + '\'' +
                    ", smallSummary='" + smallSummary + '\'' +
                    '}';
        }
    }


