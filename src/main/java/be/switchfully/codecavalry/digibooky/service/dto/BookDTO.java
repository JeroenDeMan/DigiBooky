package be.switchfully.codecavalry.digibooky.service.dto;
import be.switchfully.codecavalry.digibooky.business.entity.Author;
import java.util.Objects;


    public class BookDTO {

        private String authorFirstName;
        private String authorLastName;
        private long isbn;
        private String title;
        private String smallSummary;

        public void setAuthorFirstName(String authorFirstName) {
            this.authorFirstName = authorFirstName;
        }

        public void setAuthorLastName(String authorLastName) {
            this.authorLastName = authorLastName;
        }

        public void setIsbn(long isbn) {
            this.isbn = isbn;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setSmallSummary(String smallSummary) {
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
            return isbn == bookDTO.isbn;
        }

        @Override
        public int hashCode() {
            return Objects.hash(isbn);
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


