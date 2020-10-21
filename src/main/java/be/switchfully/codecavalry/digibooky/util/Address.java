package be.switchfully.codecavalry.digibooky.util;

public class Address {

    private String street;
    private String streetNumber;
    private String city;

    private Integer postalCode;

    public Address(String street, String streetNumber, String city, Integer postalCode) {
        this.street = street;
        this.streetNumber = streetNumber;
        this.city = city;
        isPostalCodeValid(postalCode);
    }

    public Address(String city, Integer postalCode) {
        this.street = "";
        this.streetNumber = "";
        this.city = city;
        isPostalCodeValid(postalCode);
    }

    private void isPostalCodeValid(Integer postalCode){
        if(postalCode.toString().length() != 4){
            throw new IllegalArgumentException("Postal code exist of 4 digits");
        } this.postalCode = postalCode;
    }

    public String getStreet() {
        return street;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public String getCity() {
        return city;
    }

    public Integer getPostalCode() {
        return postalCode;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(street + " " + streetNumber)
                .append(System.lineSeparator())
                .append(postalCode + " " + city);
        return stringBuilder.toString();
    }
}
