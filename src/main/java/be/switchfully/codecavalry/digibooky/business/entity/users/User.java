package be.switchfully.codecavalry.digibooky.business.entity.users;

import be.switchfully.codecavalry.digibooky.util.MailAddress;
import be.switchfully.codecavalry.digibooky.util.SocialSecurityNumber;

import java.util.Objects;
import java.util.UUID;


public abstract class User {

    private final String id;
    private final SocialSecurityNumber socialSecurityNumber;
    private MailAddress mailAddress;
    private String firstname;
    private final String lastname;
    private final Usertype usertype;


    public User(SocialSecurityNumber socialSecurityNumber, String firstname, String lastname, MailAddress mailAddress, Usertype usertype) {
        this.id = UUID.randomUUID().toString();
        this.socialSecurityNumber = socialSecurityNumber;
        this.firstname = firstname;
        this.lastname = lastname;
        this.mailAddress = mailAddress;
        this.usertype = usertype;
    }

    public User(SocialSecurityNumber socialSecurityNumber, String lastname, MailAddress mailAddress, Usertype usertype) {
        this.id = UUID.randomUUID().toString();
        this.socialSecurityNumber = socialSecurityNumber;
        this.firstname = "NOT PROVIDED";
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

    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(socialSecurityNumber, user.socialSecurityNumber) &&
                Objects.equals(mailAddress, user.mailAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, socialSecurityNumber, mailAddress);
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", socialSecurityNumber=" + socialSecurityNumber +
                ", mailAddress=" + mailAddress +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", usertype=" + usertype +
                '}';
    }
}
