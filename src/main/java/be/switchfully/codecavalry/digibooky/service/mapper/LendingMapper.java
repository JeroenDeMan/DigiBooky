package be.switchfully.codecavalry.digibooky.service.mapper;

import be.switchfully.codecavalry.digibooky.business.entity.Library.Lending;
import be.switchfully.codecavalry.digibooky.service.dto.LendingDTO;
import be.switchfully.codecavalry.digibooky.util.SocialSecurityNumber;
import org.springframework.stereotype.Component;

@Component
public class LendingMapper {

    public Lending toEntity(LendingDTO lendingDTO) {
        Lending result = new Lending(new SocialSecurityNumber(lendingDTO.getMemberId()), lendingDTO.getBookId());

        return result;
    }

    public LendingDTO toDTO(Lending lending)
    {   LendingDTO result = new LendingDTO();
        result.setLendingId(lending.getId());
        result.setBookId(lending.getIsbn());
        result.setMemberId(lending.getMemberId().getSocialSecurityNumber());
        result.setDateOfLending(lending.getDateOfLending().toString());
        result.setDateOfReturn(lending.getDateOfReturning().toString());
        return result;
    }

}
