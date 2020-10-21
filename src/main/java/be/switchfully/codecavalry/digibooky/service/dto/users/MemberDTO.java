package be.switchfully.codecavalry.digibooky.service.dto.users;

import be.switchfully.codecavalry.digibooky.util.Address;

public class MemberDTO extends UserDTO {

    private String street;
    private String streetNumber;
    private String city;

    private Integer postalCode;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(Integer postalCode) {
        this.postalCode = postalCode;
    }
}
