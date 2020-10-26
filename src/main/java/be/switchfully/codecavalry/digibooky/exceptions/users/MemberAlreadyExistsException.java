package be.switchfully.codecavalry.digibooky.exceptions.users;

public class MemberAlreadyExistsException extends RuntimeException{
    String message;

    public MemberAlreadyExistsException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message + " already exists";
    }
}
