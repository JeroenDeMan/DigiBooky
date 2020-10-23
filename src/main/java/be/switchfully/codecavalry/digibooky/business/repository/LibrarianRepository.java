package be.switchfully.codecavalry.digibooky.business.repository;

import be.switchfully.codecavalry.digibooky.business.entity.users.Librarian;
import be.switchfully.codecavalry.digibooky.business.entity.users.Member;
import be.switchfully.codecavalry.digibooky.exceptions.users.LibrarianAlreadyExistException;
import be.switchfully.codecavalry.digibooky.exceptions.users.MemberAlreadyExist;
import be.switchfully.codecavalry.digibooky.util.SocialSecurityNumber;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class LibrarianRepository {

    private final Map<SocialSecurityNumber, Librarian> librarians;

    public LibrarianRepository() {
        this.librarians = new HashMap<>();
    }

    public Librarian save(Librarian librarian) {
        if (librarians.containsValue(librarian))
            throw new LibrarianAlreadyExistException(librarian.getFirstname() + librarian.getLastname());
        librarians.put(librarian.getSocialSecurityNumber(), librarian);

        return librarian;
    }

    public List<Librarian> getLibrarians() {
        return new ArrayList<>(librarians.values());
    }
}
