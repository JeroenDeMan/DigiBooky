package be.switchfully.codecavalry.digibooky.exceptions;

import be.switchfully.codecavalry.digibooky.exceptions.books.BookNotFoundException;
import be.switchfully.codecavalry.digibooky.exceptions.users.AdminAlreadyExistsException;
import be.switchfully.codecavalry.digibooky.exceptions.users.LibrarianAlreadyExistsException;
import be.switchfully.codecavalry.digibooky.exceptions.users.MemberAlreadyExistsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(MemberAlreadyExistsException.class)
    protected void memberAlreadyExistsException(MemberAlreadyExistsException ex, HttpServletResponse response) throws IOException {
        response.sendError(HttpServletResponse.SC_BAD_REQUEST, ex.getMessage());
    }

    @ExceptionHandler(BookNotFoundException.class)
    protected void bookNotFoundException(BookNotFoundException ex, HttpServletResponse response) throws IOException {
        response.sendError(HttpServletResponse.SC_BAD_REQUEST, ex.getMessage());
    }

    @ExceptionHandler(LibrarianAlreadyExistsException.class)
    protected void librarianAlreadyExistsException(LibrarianAlreadyExistsException ex, HttpServletResponse response) throws IOException {
        response.sendError(HttpServletResponse.SC_BAD_REQUEST, ex.getMessage());
    }

    @ExceptionHandler(AdminAlreadyExistsException.class)
    protected void adminAlreadyExistsException(AdminAlreadyExistsException ex, HttpServletResponse response) throws IOException {
        response.sendError(HttpServletResponse.SC_BAD_REQUEST, ex.getMessage());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    protected void illegalArgumentException(IllegalArgumentException ex, HttpServletResponse response) throws IOException {
        response.sendError(HttpServletResponse.SC_BAD_REQUEST, ex.getMessage());
    }
}