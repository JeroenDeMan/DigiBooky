package be.switchfully.codecavalry.digibooky.exceptions.users;

public class LibrarianAlreadyExistException extends RuntimeException {

    String message;

    public LibrarianAlreadyExistException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message + " already exist";
    }
}
