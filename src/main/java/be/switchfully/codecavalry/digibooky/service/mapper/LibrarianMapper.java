package be.switchfully.codecavalry.digibooky.service.mapper;

import be.switchfully.codecavalry.digibooky.business.entity.users.Librarian;
import be.switchfully.codecavalry.digibooky.service.dto.users.LibrarianDTO;
import be.switchfully.codecavalry.digibooky.util.MailAddress;
import be.switchfully.codecavalry.digibooky.util.SocialSecurityNumber;
import org.springframework.stereotype.Component;

@Component
public class LibrarianMapper {

    public Librarian toEntity(LibrarianDTO librarianDTO) {
        Librarian result = new Librarian(
                new SocialSecurityNumber(librarianDTO.getSocialSecurityNumber()),
                librarianDTO.getFirstName(),
                librarianDTO.getLastName(),
                new MailAddress(librarianDTO.getMailAddress())
        );

        return result;
    }

    public LibrarianDTO toDTO(Librarian librarian) {
        LibrarianDTO result = new LibrarianDTO();

        result.setSocialSecurityNumber(librarian.getSocialSecurityNumber().getSocialSecurityNumber());
        result.setFirstName(librarian.getFirstname());
        result.setLastName(librarian.getLastname());
        result.setMailAddress(librarian.getMailAddress().getMailAddress());
        result.setUsertype(librarian.getUsertype());
        return result;
    }
}
