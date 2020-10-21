package be.switchfully.codecavalry.digibooky.business.entity;

import be.switchfully.codecavalry.digibooky.util.MailAddress;
import be.switchfully.codecavalry.digibooky.util.SocialSecurityNumber;

public class Member extends User{


    public Member(SocialSecurityNumber socialSecurityNumber, String firstname, String lastname, MailAddress mailAddress) {
        super(socialSecurityNumber, firstname, lastname, mailAddress);
    }

    public Member(SocialSecurityNumber socialSecurityNumber, String lastname, MailAddress mailAddress) {
        super(socialSecurityNumber, lastname, mailAddress);
    }
}
