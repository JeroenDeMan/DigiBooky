package be.switchfully.codecavalry.digibooky.business.repository;

import be.switchfully.codecavalry.digibooky.business.entity.users.Admin;
import be.switchfully.codecavalry.digibooky.exceptions.users.AdminAlreadyExistsException;
import be.switchfully.codecavalry.digibooky.util.MailAddress;
import be.switchfully.codecavalry.digibooky.util.SocialSecurityNumber;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class AdminRepositoryTest {
    private Admin admin;
    private Admin admin2;
    private AdminRepository repository;

    @BeforeEach
    public void setUp(){
        SocialSecurityNumber socialSecurityNumber = new SocialSecurityNumber("121212-123-12");
        MailAddress mailAddress = new MailAddress("MyEmail@gmail.com");
        SocialSecurityNumber socialSecurityNumber2 = new SocialSecurityNumber("121212-123-15");
        MailAddress mailAddress2 = new MailAddress("MyEmails@gmail.com");

        admin = new Admin(socialSecurityNumber, "Jeroen", "De Man", mailAddress);
        admin2 = new Admin(socialSecurityNumber2, "Alex", "Schouten", mailAddress2);

        repository = new AdminRepository();

    }

    @Test
    public void adminAlreadyExist_ThrowsAdminAlreadyExistException(){
        repository.save(admin);
        Assertions.assertThrows(AdminAlreadyExistsException.class, ()-> repository.save(admin));

    }

    @Test
    public void saveAdmin_ReturnsSameAdmin(){
        Assertions.assertEquals(admin, repository.save(admin));
    }

    @Test
    public void whenOfferingTwoAdmins_ReturnListOfTwoAdmins(){
        List<Admin> listOfAdmins = new ArrayList<>();

        listOfAdmins.add(new Admin(new SocialSecurityNumber("1342549-325-15"), "Adrie", "Admin", new MailAddress("adrie@admin.be")));
        listOfAdmins.add(admin);
        listOfAdmins.add(admin2);

        repository.save(admin);
        repository.save(admin2);

        Assertions.assertEquals(listOfAdmins.size(), repository.getAdmins().size());
    }

}