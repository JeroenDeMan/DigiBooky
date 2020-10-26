package be.switchfully.codecavalry.digibooky.service.dto.users;

import be.switchfully.codecavalry.digibooky.business.entity.users.Usertype;
import be.switchfully.codecavalry.digibooky.util.MailAddress;
import be.switchfully.codecavalry.digibooky.util.SocialSecurityNumber;

import java.util.Objects;

public abstract class UserDTO {

    private String id;
    private String socialSecurityNumber;
    private String firstName;
    private String lastName;
    private String mailAddress;
    private Usertype usertype;

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public void setSocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMailAddress() {
        return mailAddress;
    }

    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }

    public Usertype getUsertype() { return usertype; }

    public void setUsertype(Usertype usertype) { this.usertype = usertype; }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDTO userDTO = (UserDTO) o;
        return Objects.equals(id, userDTO.id) &&
                Objects.equals(socialSecurityNumber, userDTO.socialSecurityNumber) &&
                Objects.equals(mailAddress, userDTO.mailAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, socialSecurityNumber, mailAddress);
    }
}
