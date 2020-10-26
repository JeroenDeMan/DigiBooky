package be.switchfully.codecavalry.digibooky.business.entity.users;

import be.switchfully.codecavalry.digibooky.util.Address;
import be.switchfully.codecavalry.digibooky.util.MailAddress;
import be.switchfully.codecavalry.digibooky.util.SocialSecurityNumber;

public class Member extends User{

    private Address address;


    public Member(SocialSecurityNumber socialSecurityNumber, String firstname, String lastname, MailAddress mailAddress, Address address) {
        super(socialSecurityNumber, firstname, lastname, mailAddress, Usertype.MEMBER);
        this.address = address;
    }

    public Member(SocialSecurityNumber socialSecurityNumber, String lastname, MailAddress mailAddress, Address address) {
        super(socialSecurityNumber, lastname, mailAddress, Usertype.MEMBER);
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }
}
