package be.switchfully.codecavalry.digibooky.service;

import be.switchfully.codecavalry.digibooky.business.repository.BookRepository;
import be.switchfully.codecavalry.digibooky.business.repository.LendingRepository;
import be.switchfully.codecavalry.digibooky.business.repository.MemberRepository;
import be.switchfully.codecavalry.digibooky.service.dto.LendingDTO;
import be.switchfully.codecavalry.digibooky.service.mapper.BookMapper;
import be.switchfully.codecavalry.digibooky.service.mapper.LendingMapper;
import be.switchfully.codecavalry.digibooky.service.mapper.MemberMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LendingServiceTest {

    private LendingService lendingService;
    private LendingDTO lendingDTO;

    @BeforeEach

    public void setup() {
        lendingService = new LendingService(new LendingRepository(), new LendingMapper(),
                new BookService(new BookRepository(), new BookMapper()),
                new MemberService(new MemberRepository(), new MemberMapper()));

        lendingDTO = new LendingDTO();
        lendingDTO.setMemberId("671220-333-73");
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
    public void getAllLendsBooks() {
        LendingDTO result = lendingService.lendABook(lendingDTO);
        Assertions.assertTrue(lendingService.getAllLends().contains(result));
    }
}