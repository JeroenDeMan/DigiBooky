package be.switchfully.codecavalry.digibooky.service;

import be.switchfully.codecavalry.digibooky.business.entity.users.Member;
import be.switchfully.codecavalry.digibooky.business.repository.BookRepository;
import be.switchfully.codecavalry.digibooky.business.repository.LendingRepository;
import be.switchfully.codecavalry.digibooky.business.repository.MemberRepository;
import be.switchfully.codecavalry.digibooky.service.dto.LendingDTO;
import be.switchfully.codecavalry.digibooky.service.mapper.BookMapper;
import be.switchfully.codecavalry.digibooky.service.mapper.LendingMapper;
import be.switchfully.codecavalry.digibooky.service.mapper.MemberMapper;
import be.switchfully.codecavalry.digibooky.util.Address;
import be.switchfully.codecavalry.digibooky.util.MailAddress;
import be.switchfully.codecavalry.digibooky.util.SocialSecurityNumber;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LendingServiceTest {

    private LendingService lendingService;
    private LendingDTO lendingDTO;
    private Member member;
    private MemberRepository memberRepository;

    @BeforeEach

    public void setup() {
        member = new Member(new SocialSecurityNumber("671220-333-73"),
                "Pascal",
                "Baelen",
                new MailAddress("pascal.baelen@switchfully.com"),
                new Address("some street", "22A", "Brussel", 1000));

        memberRepository = new MemberRepository();
        memberRepository.save(member);

        lendingService = new LendingService(new LendingRepository(), new LendingMapper(),
                new BookService(new BookRepository(), new BookMapper()),
                new MemberService(memberRepository, new MemberMapper()));



        lendingDTO = new LendingDTO();
        lendingDTO.setMemberId(member.getId());
        lendingDTO.setBookId(1110987654321L);
        lendingDTO.setLendingId("1259877abc");
    }

    @Test
    public void lendABook_returnsLendBookWithMemberName() {
        LendingDTO result = lendingService.lendABook(lendingDTO);
        Assertions.assertEquals("Pascal Baelen", result.getMemberName());
    }

    @Test
    public void lendABook_returnsLendBookWithTitle() {
        LendingDTO result = lendingService.lendABook(lendingDTO);
        Assertions.assertEquals("Java is hot", result.getBookTitle());
    }

    @Test
    public void getAllLendsBooks_containsSavedLandingDTO() {
        LendingDTO result = lendingService.lendABook(lendingDTO);
        Assertions.assertTrue(lendingService.getAllLends().contains(result));
    }

    @Test
    public void getAllLendsForASpecificMember_returnsExpectedBook(){
        LendingDTO result = lendingService.lendABook(lendingDTO);
        Assertions.assertEquals(1, lendingService.getAllLendsForSpecificMember(member.getId()).size());
        Assertions.assertTrue(lendingService.getAllLendsForSpecificMember(member.getId()).contains(result));
    }
}