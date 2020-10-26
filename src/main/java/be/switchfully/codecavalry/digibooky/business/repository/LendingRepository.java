package be.switchfully.codecavalry.digibooky.business.repository;

import be.switchfully.codecavalry.digibooky.business.entity.Library.Lending;
import be.switchfully.codecavalry.digibooky.util.SocialSecurityNumber;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class LendingRepository {

    private Map<String, Lending> lends;

    public LendingRepository() {
        lends = new HashMap<>();
        addFirstLending();
    }

    public Lending lendABook(Lending lending) {
        lends.put(lending.getId(), lending);
        return lending;
    }

    public void addFirstLending() {
        Lending lending = new Lending(new SocialSecurityNumber("671220-333-73"), 1234567891011L);
        lends.put(lending.getId(), lending);
    }

    public List<Lending> getLends() {
        return new ArrayList<>(lends.values());
    }
}
