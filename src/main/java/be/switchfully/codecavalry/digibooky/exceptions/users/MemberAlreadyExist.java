package be.switchfully.codecavalry.digibooky.exceptions.users;

public class MemberAlreadyExist extends RuntimeException{
    String message;

    public MemberAlreadyExist(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message + " already exist";
    }
}
