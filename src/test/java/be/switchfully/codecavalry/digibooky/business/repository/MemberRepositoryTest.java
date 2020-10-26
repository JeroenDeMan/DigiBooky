package be.switchfully.codecavalry.digibooky.business.repository;

import be.switchfully.codecavalry.digibooky.business.entity.users.Member;
import be.switchfully.codecavalry.digibooky.business.entity.users.Usertype;
import be.switchfully.codecavalry.digibooky.exceptions.users.MemberAlreadyExistsException;
import be.switchfully.codecavalry.digibooky.util.Address;
import be.switchfully.codecavalry.digibooky.util.MailAddress;
import be.switchfully.codecavalry.digibooky.util.SocialSecurityNumber;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MemberRepositoryTest {
    private Member member;
    private MemberRepository repository;

    @BeforeEach
    public void setUp(){
        SocialSecurityNumber socialSecurityNumber = new SocialSecurityNumber("121212-123-12");
        MailAddress mailAddress = new MailAddress("MyEmail@gmail.com");
        Address address = new Address("Some street", "25", "Lokeren", 2147);
        Usertype usertype = Usertype.MEMBER;

        member = new Member(socialSecurityNumber, "Jeroen", "De Man", mailAddress, address);

        repository = new MemberRepository();

    }


    @Test
    public void memberAlreadyExist_ThrowsMemberAlreadyExistException(){
        repository.save(member);

        Assertions.assertThrows(MemberAlreadyExistsException.class, ()-> repository.save(member));

    }

    @Test
    public void saveMember_ReturnsSameMember(){
        Assertions.assertEquals(member, repository.save(member));
    }

}