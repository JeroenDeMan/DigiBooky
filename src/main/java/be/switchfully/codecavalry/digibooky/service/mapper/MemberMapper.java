package be.switchfully.codecavalry.digibooky.service.mapper;

import be.switchfully.codecavalry.digibooky.business.entity.users.Member;
import be.switchfully.codecavalry.digibooky.business.entity.users.Usertype;
import be.switchfully.codecavalry.digibooky.service.dto.users.MemberDTO;
import be.switchfully.codecavalry.digibooky.util.Address;
import be.switchfully.codecavalry.digibooky.util.MailAddress;
import be.switchfully.codecavalry.digibooky.util.SocialSecurityNumber;
import org.springframework.stereotype.Component;

@Component
public class MemberMapper {

    public Member toEntity (MemberDTO memberDTO){
        Address address = new Address(
                memberDTO.getStreet(),
                memberDTO.getStreetNumber(),
                memberDTO.getCity(),
                memberDTO.getPostalCode()
        );
        Member result = new Member(
                new SocialSecurityNumber(memberDTO.getSocialSecurityNumber()),
                memberDTO.getFirstName(),
                memberDTO.getLastName(),
                new MailAddress(memberDTO.getMailAddress()),
                address
        );

        return result;
    }

    public MemberDTO toDTO(Member member){
        MemberDTO result = new MemberDTO();
        result.setId(member.getId());
        result.setSocialSecurityNumber(member.getSocialSecurityNumber().getSocialSecurityNumber());
        result.setFirstName(member.getFirstname());
        result.setLastName(member.getLastname());
        result.setMailAddress(member.getMailAddress().getMailAddress());
        result.setStreet(member.getAddress().getStreet());
        result.setStreetNumber(member.getAddress().getStreetNumber());
        result.setCity(member.getAddress().getCity());
        result.setPostalCode(member.getAddress().getPostalCode());
        result.setUsertype(member.getUsertype());

        return result;
    }

    public MemberDTO toRestrictedDTO(Member member){
        MemberDTO result = new MemberDTO();
        result.setId(member.getId());
        result.setSocialSecurityNumber("Nice try Karel, you don't have access!");
        result.setFirstName(member.getFirstname());
        result.setLastName(member.getLastname());
        result.setMailAddress(member.getMailAddress().getMailAddress());
        result.setStreet(member.getAddress().getStreet());
        result.setStreetNumber(member.getAddress().getStreetNumber());
        result.setCity(member.getAddress().getCity());
        result.setPostalCode(member.getAddress().getPostalCode());
        result.setUsertype(member.getUsertype());

        return result;
    }
}
