package be.switchfully.codecavalry.digibooky.service;

import be.switchfully.codecavalry.digibooky.business.repository.AdminRepository;
import be.switchfully.codecavalry.digibooky.service.dto.users.AdminDTO;
import be.switchfully.codecavalry.digibooky.service.mapper.AdminMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;


class AdminServiceTest {

    private AdminDTO result;
    private AdminService service;

    @BeforeEach
    public void setUp(){
        result = new AdminDTO();
        result.setSocialSecurityNumber("121212-123-12");
        result.setFirstName("Jeroen");
        result.setLastName("De Man");
        result.setMailAddress("mail@address.com");

        service = new AdminService(new AdminRepository(), new AdminMapper());
    }

    @Test
    public void saveAdminDTO_ReturnsSameAdminDTO(){
        AdminDTO expected = service.save(result);
        Assertions.assertTrue(service.getAllAdmins().contains(expected));
    }

    @Test
    public void WhenCalling_getAllAdmins_ReturnListOfAdminsDTO() {
        List<AdminDTO> listOfAdmins = service.getAllAdmins();
        Assertions.assertEquals(1, listOfAdmins.size());
    }

}