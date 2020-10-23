package be.switchfully.codecavalry.digibooky.service;

import be.switchfully.codecavalry.digibooky.business.repository.LibrarianRepository;
import be.switchfully.codecavalry.digibooky.service.dto.users.LibrarianDTO;
import be.switchfully.codecavalry.digibooky.service.mapper.LibrarianMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;


class LibrarianServiceTest {

    private LibrarianDTO result;
    private LibrarianService  service;

    @BeforeEach
    public void setUp(){
        result = new LibrarianDTO();
        result.setSocialSecurityNumber("121212-123-12");
        result.setFirstName("Jeroen");
        result.setLastName("De Man");
        result.setMailAddress("mail@address.com");

        service = new LibrarianService(new LibrarianRepository(), new LibrarianMapper());
    }

    @Test
    public void saveLibrarianDTO_ReturnsSameLibrarianDTO(){
        Assertions.assertEquals(result, service.save(result));
    }

    @Test
    public void WhenCalling_getAllLibrarians_ReturnListOfLibrariansDTO() {
        List<LibrarianDTO> listOfLibrarians = service.getAllLibrarians();
        Assertions.assertEquals(0, listOfLibrarians.size());
    }

}