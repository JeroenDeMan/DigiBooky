package be.switchfully.codecavalry.digibooky.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SocialSecurityNumberTest {

    @Test
    public void givenSocial_SocialNumberEqualsToString(){
        SocialSecurityNumber socialSecurityNumber = new SocialSecurityNumber("101010-147-14");
        String expectedSocialNumber = "101010-147-14";

        Assertions.assertEquals(expectedSocialNumber, socialSecurityNumber.toString());
    }

    @Test
    public void givenTwoIdenticalSocial_EqualsReturnTrue(){
        SocialSecurityNumber socialSecurityNumber = new SocialSecurityNumber("101010-147-14");
        SocialSecurityNumber socialSecurityNumberToCompare = new SocialSecurityNumber("101010-147-14");

        Assertions.assertTrue(socialSecurityNumberToCompare.equals(socialSecurityNumber));
    }

    @Test
    public void givenDifferentSocial_EqualsReturnFalse(){
        SocialSecurityNumber socialSecurityNumber = new SocialSecurityNumber("101010-147-14");
        SocialSecurityNumber socialSecurityNumberToCompare = new SocialSecurityNumber("202020-214-24");

        Assertions.assertFalse(socialSecurityNumberToCompare.equals(socialSecurityNumber));
    }

}