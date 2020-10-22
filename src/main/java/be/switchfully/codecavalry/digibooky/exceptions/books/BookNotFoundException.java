package be.switchfully.codecavalry.digibooky.exceptions.books;

public class BookNotFoundException extends RuntimeException {
    private String errorMessage;

    public BookNotFoundException(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String getMessage(){
        return "Book with isbn: " + errorMessage + " is not found in the library";
    }
}
