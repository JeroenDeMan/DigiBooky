package be.switchfully.codecavalry.digibooky.exceptions.users;

public class AdminAlreadyExistsException extends RuntimeException {

    String message;

    public AdminAlreadyExistsException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message + " already exist";
    }
}
