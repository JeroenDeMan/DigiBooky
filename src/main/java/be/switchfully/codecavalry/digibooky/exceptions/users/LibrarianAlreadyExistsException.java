package be.switchfully.codecavalry.digibooky.exceptions.users;

public class LibrarianAlreadyExistsException extends RuntimeException {

    String message;

    public LibrarianAlreadyExistsException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message + " already exist";
    }
}
