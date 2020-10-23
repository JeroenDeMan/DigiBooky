package be.switchfully.codecavalry.digibooky.business.entity.users;

import be.switchfully.codecavalry.digibooky.util.MailAddress;
import be.switchfully.codecavalry.digibooky.util.SocialSecurityNumber;

import java.util.List;

public class Admin extends User {


    public Admin(SocialSecurityNumber socialSecurityNumber, String firstname, String lastname, MailAddress mailAddress) {
        super(socialSecurityNumber, firstname, lastname, mailAddress, Usertype.ADMIN);
    }

    public Admin(SocialSecurityNumber socialSecurityNumber, String lastname, MailAddress mailAddress) {
        super(socialSecurityNumber, lastname, mailAddress, Usertype.ADMIN);
    }
}
