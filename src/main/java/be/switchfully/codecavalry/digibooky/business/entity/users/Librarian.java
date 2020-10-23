package be.switchfully.codecavalry.digibooky.business.entity.users;

import be.switchfully.codecavalry.digibooky.util.MailAddress;
import be.switchfully.codecavalry.digibooky.util.SocialSecurityNumber;

public class Librarian extends User {

    public Librarian(SocialSecurityNumber socialSecurityNumber, String firstname, String lastname, MailAddress mailAddress) {
        super(socialSecurityNumber, firstname, lastname, mailAddress, Usertype.LIBRARIAN);
    }

    public Librarian(SocialSecurityNumber socialSecurityNumber, String lastname, MailAddress mailAddress) {
        super(socialSecurityNumber, lastname, mailAddress, Usertype.LIBRARIAN);
    }
}
