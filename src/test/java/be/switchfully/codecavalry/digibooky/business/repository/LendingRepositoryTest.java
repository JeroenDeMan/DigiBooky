package be.switchfully.codecavalry.digibooky.business.repository;

import be.switchfully.codecavalry.digibooky.business.entity.Library.Lending;
import be.switchfully.codecavalry.digibooky.business.entity.users.Member;
import be.switchfully.codecavalry.digibooky.util.Address;
import be.switchfully.codecavalry.digibooky.util.MailAddress;
import be.switchfully.codecavalry.digibooky.util.SocialSecurityNumber;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LendingRepositoryTest {
    private Lending lend;
    private LendingRepository lendingRepository;
    private Member member;


    @BeforeEach
    public void setup() {
        member = new Member(new SocialSecurityNumber("671220-333-73"),
                "Pascal",
                "Baelen",
                new MailAddress("pascal.baelen@switchfully.com"),
                new Address("some street", "22A", "Brussel", 1000));
        lend = new Lending(member.getId(), 1110987654321L);
        lendingRepository = new LendingRepository();
    }

    @Test
    public void whenAddingNewLending_thenRepositoryContainsOneLending() {
        Assertions.assertEquals(lend, lendingRepository.lendABook(lend));
    }

    @Test
    public void whenGettingTheLend_thenRepositoryContainsSavedLend() {
        lendingRepository.lendABook(lend);
        Assertions.assertTrue(lendingRepository.getLends().contains(lend));
    }

}