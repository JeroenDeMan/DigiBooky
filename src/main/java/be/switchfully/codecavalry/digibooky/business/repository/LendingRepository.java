package be.switchfully.codecavalry.digibooky.business.repository;

import be.switchfully.codecavalry.digibooky.business.entity.Library.Lending;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class LendingRepository {

    private Map <String, Lending> lends;
    public LendingRepository()
    {lends = new HashMap<>();
     }

public Lending lendABook(Lending lending)
{   lends.put(lending.getId(), lending);
    return lending;
}
}
