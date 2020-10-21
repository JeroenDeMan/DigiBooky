package be.switchfully.codecavalry.digibooky.service.mapper;

import be.switchfully.codecavalry.digibooky.business.entity.users.Member;
import be.switchfully.codecavalry.digibooky.service.dto.users.MemberDTO;
import be.switchfully.codecavalry.digibooky.util.Address;
import be.switchfully.codecavalry.digibooky.util.MailAddress;
import be.switchfully.codecavalry.digibooky.util.SocialSecurityNumber;

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

        result.setSocialSecurityNumber(member.getSocialSecurityNumber().getSocialSecurityNumber());
        result.setFirstName(member.getFirstname());
        result.setLastName(member.getLastname());
        result.setMailAddress(member.getMailAddress().getMailAddress());
        result.setStreet(member.getAddress().getStreet());
        result.setStreetNumber(member.getAddress().getStreetNumber());
        result.setCity(member.getAddress().getCity());
        result.setPostalCode(member.getAddress().getPostalCode());

        return result;
    }
}
