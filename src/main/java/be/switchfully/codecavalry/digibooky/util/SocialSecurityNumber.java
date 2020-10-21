package be.switchfully.codecavalry.digibooky.util;

import java.util.Objects;

public class SocialSecurityNumber {

    private final String socialSecurityNumber;

    public SocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    @Override
    public String toString() {
        return  socialSecurityNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SocialSecurityNumber that = (SocialSecurityNumber) o;
        return Objects.equals(socialSecurityNumber, that.socialSecurityNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(socialSecurityNumber);
    }
}
