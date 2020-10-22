package be.switchfully.codecavalry.digibooky.exceptions;

import be.switchfully.codecavalry.digibooky.exceptions.books.BookNotFoundException;
import be.switchfully.codecavalry.digibooky.exceptions.users.MemberAlreadyExist;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(MemberAlreadyExist.class)
    protected void MemberAlreadyExistsException(MemberAlreadyExist ex, HttpServletResponse response) throws IOException {
        response.sendError(HttpServletResponse.SC_BAD_REQUEST, ex.getMessage());
    }

    @ExceptionHandler(BookNotFoundException.class)
    protected void BookNotFoundException(BookNotFoundException ex, HttpServletResponse response) throws IOException {
        response.sendError(HttpServletResponse.SC_BAD_REQUEST, ex.getMessage());
    }
}