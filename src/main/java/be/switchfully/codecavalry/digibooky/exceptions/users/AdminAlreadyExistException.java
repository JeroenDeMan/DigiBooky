package be.switchfully.codecavalry.digibooky.exceptions.users;

public class AdminAlreadyExistException extends RuntimeException {

    String message;

    public AdminAlreadyExistException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message + " already exist";
    }
}
