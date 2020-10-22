package be.switchfully.codecavalry.digibooky.business.entity.users;

import be.switchfully.codecavalry.digibooky.util.MailAddress;
import be.switchfully.codecavalry.digibooky.util.SocialSecurityNumber;

import java.util.List;

public class Admin extends User {

    private List<Member> memberList;

    public Admin(SocialSecurityNumber socialSecurityNumber, String firstname, String lastname, MailAddress mailAddress, Usertype usertype) {
        super(socialSecurityNumber, firstname, lastname, mailAddress, usertype);
    }

    public List<Member> viewMemberList(){
        return null;
    }

}
