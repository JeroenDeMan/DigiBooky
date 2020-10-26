package be.switchfully.codecavalry.digibooky.business.repository;

import be.switchfully.codecavalry.digibooky.business.entity.users.Librarian;
import be.switchfully.codecavalry.digibooky.exceptions.users.LibrarianAlreadyExistsException;
import be.switchfully.codecavalry.digibooky.util.MailAddress;
import be.switchfully.codecavalry.digibooky.util.SocialSecurityNumber;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class LibrarianRepositoryTest {
    private Librarian librarian;
    private Librarian librarian2;
    private LibrarianRepository repository;

    @BeforeEach
    public void setUp(){
        SocialSecurityNumber socialSecurityNumber = new SocialSecurityNumber("121212-123-12");
        MailAddress mailAddress = new MailAddress("MyEmail@gmail.com");
        SocialSecurityNumber socialSecurityNumber2 = new SocialSecurityNumber("121212-123-22");
        MailAddress mailAddress2 = new MailAddress("MyEmailtje@gmail.com");

        librarian = new Librarian(socialSecurityNumber, "Jeroen", "De Man", mailAddress);

        librarian2 = new Librarian(socialSecurityNumber2, "Lisa", "Hammouri", mailAddress2);

        repository = new LibrarianRepository();

    }

    @Test
    public void librarianAlreadyExist_ThrowsLibrarianAlreadyExistException(){
        repository.save(librarian);
        Assertions.assertThrows(LibrarianAlreadyExistsException.class, ()-> repository.save(librarian));

    }

    @Test
    public void saveLibrarian_ReturnsSameLibrarian(){
        Assertions.assertEquals(librarian, repository.save(librarian));
    }

    @Test
    public void whenOfferingTwoLibrarians_ReturnListOfTwoLibrarians(){
        List<Librarian> listOfLibrarians = new ArrayList<>();

        listOfLibrarians.add(librarian);
        listOfLibrarians.add(librarian2);

        repository.save(librarian);
        repository.save(librarian2);

        Assertions.assertEquals(listOfLibrarians.size(), repository.getLibrarians().size());
    }

}