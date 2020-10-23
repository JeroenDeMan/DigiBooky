package be.switchfully.codecavalry.digibooky.service.mapper;

import be.switchfully.codecavalry.digibooky.business.entity.users.Admin;
import be.switchfully.codecavalry.digibooky.service.dto.users.AdminDTO;
import be.switchfully.codecavalry.digibooky.util.MailAddress;
import be.switchfully.codecavalry.digibooky.util.SocialSecurityNumber;
import org.springframework.stereotype.Component;

@Component
public class AdminMapper {
    public Admin toEntity(AdminDTO adminDTO) {
        Admin result = new Admin(
                new SocialSecurityNumber(adminDTO.getSocialSecurityNumber()),
                adminDTO.getFirstName(),
                adminDTO.getLastName(),
                new MailAddress(adminDTO.getMailAddress())
        );

        return result;
    }

    public AdminDTO toDTO(Admin admin) {
        AdminDTO result = new AdminDTO();

        result.setSocialSecurityNumber(admin.getSocialSecurityNumber().getSocialSecurityNumber());
        result.setFirstName(admin.getFirstname());
        result.setLastName(admin.getLastname());
        result.setMailAddress(admin.getMailAddress().getMailAddress());
        result.setUsertype(admin.getUsertype());
        return result;
    }
}
