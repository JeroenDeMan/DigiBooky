package be.switchfully.codecavalry.digibooky.service;

import be.switchfully.codecavalry.digibooky.business.entity.users.Member;
import be.switchfully.codecavalry.digibooky.business.repository.MemberRepository;
import be.switchfully.codecavalry.digibooky.service.dto.users.MemberDTO;
import be.switchfully.codecavalry.digibooky.service.mapper.MemberMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {
    private MemberDTO result;
    private MemberService service;

    @BeforeEach
    public void setUp(){
        result = new MemberDTO();
        result.setSocialSecurityNumber("121212-123-12");
        result.setFirstName("Jeroen");
        result.setLastName("De Man");
        result.setMailAddress("mail@address.com");
        result.setStreet("street");
        result.setStreetNumber("15");
        result.setCity("Lokeren");
        result.setPostalCode(1234);

        service = new MemberService(new MemberRepository(), new MemberMapper());
    }

    @Test
    public void saveMemberDTO_ReturnsSameMemberDTO(){
        Assertions.assertEquals(result, service.save(result));
    }

    @Test
    public void WhenCalling_getAllMembers_ReturnListOfMembersDTO() {
        List<MemberDTO> listOfMembers = service.getAllMembers();
        Assertions.assertEquals(1, listOfMembers.size());
    }

}