package be.switchfully.codecavalry.digibooky.business.repository;

import be.switchfully.codecavalry.digibooky.business.entity.Library.Lending;
import be.switchfully.codecavalry.digibooky.util.SocialSecurityNumber;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LendingRepositoryTest {
    private Lending lend;
    private LendingRepository lendingRepository;


    @BeforeEach
    public void setup() {
        lend = new Lending(new SocialSecurityNumber("671220-333-73"), 1110987654321L);
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