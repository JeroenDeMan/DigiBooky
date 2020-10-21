package be.switchfully.codecavalry.digibooky.business.entity.users;

import be.switchfully.codecavalry.digibooky.util.MailAddress;
import be.switchfully.codecavalry.digibooky.util.SocialSecurityNumber;

import java.util.Objects;


public abstract class User {

    private final SocialSecurityNumber socialSecurityNumber;
    private MailAddress mailAddress;
    private String firstname;
    private final String lastname;

    public User(SocialSecurityNumber socialSecurityNumber, String firstname, String lastname, MailAddress mailAddress) {
        this.socialSecurityNumber = socialSecurityNumber;
        this.firstname = firstname;
        this.lastname = lastname;
        this.mailAddress = mailAddress;
    }

    public User(SocialSecurityNumber socialSecurityNumber, String lastname, MailAddress mailAddress) {
        this.socialSecurityNumber = socialSecurityNumber;
        this.firstname = "";
        this.lastname = lastname;
        this.mailAddress = mailAddress;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(socialSecurityNumber)
                .append(System.lineSeparator())
                .append("Name: " + lastname + " " + firstname)
                .append(mailAddress);
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(socialSecurityNumber, user.socialSecurityNumber) &&
                Objects.equals(mailAddress, user.mailAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(socialSecurityNumber, mailAddress);
    }
}
