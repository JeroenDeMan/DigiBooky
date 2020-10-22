package be.switchfully.codecavalry.digibooky.business.entity.users;

import be.switchfully.codecavalry.digibooky.util.MailAddress;
import be.switchfully.codecavalry.digibooky.util.SocialSecurityNumber;

import java.util.Objects;


public abstract class User {

    private final SocialSecurityNumber socialSecurityNumber;
    private MailAddress mailAddress;
    private String firstname;
    private final String lastname;
    private Usertype usertype;


    public User(SocialSecurityNumber socialSecurityNumber, String firstname, String lastname, MailAddress mailAddress, Usertype usertype) {
        this.socialSecurityNumber = socialSecurityNumber;
        this.firstname = firstname;
        this.lastname = lastname;
        this.mailAddress = mailAddress;
        this.usertype = usertype;
    }

    public User(SocialSecurityNumber socialSecurityNumber, String lastname, MailAddress mailAddress, Usertype usertype) {
        this.socialSecurityNumber = socialSecurityNumber;
        this.firstname = "";
        this.lastname = lastname;
        this.mailAddress = mailAddress;
        this.usertype = usertype;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public SocialSecurityNumber getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public MailAddress getMailAddress() {
        return mailAddress;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public Usertype getUsertype() { return usertype; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return socialSecurityNumber.equals(user.socialSecurityNumber) &&
                mailAddress.equals(user.mailAddress) &&
                firstname.equals(user.firstname) &&
                lastname.equals(user.lastname) &&
                usertype == user.usertype;
    }

    @Override
    public int hashCode() {
        return Objects.hash(socialSecurityNumber, mailAddress, firstname, lastname, usertype);
    }

    @Override
    public String toString() {
        return "User{" +
                "socialSecurityNumber=" + socialSecurityNumber +
                ", mailAddress=" + mailAddress +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", usertype=" + usertype +
                '}';
    }
}
