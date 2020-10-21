package be.switchfully.codecavalry.digibooky.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MailAddressTest {

    @Test
    public void givenIncorrectMailAddress_ThrowsIllegalArgumentException(){
        String incorrectMailAddress = "notCorrect.com";

        Assertions.assertThrows(IllegalArgumentException.class, ()-> MailAddress.isMailAddressValid(incorrectMailAddress));

    }

    @Test
    public void givenCorrectMailAddress_MailAddressEqualsToString(){
        MailAddress mailAddress = new MailAddress("thisis@correct.com");
        String expectedResult = "thisis@correct.com";

        Assertions.assertEquals(expectedResult, mailAddress.toString());
    }

    @Test
    public void givenTwoIdenticalMailAddress_ReturnsTrue(){
        MailAddress mailAddress = new MailAddress("thisis@correct.com");
        MailAddress mailAddressToCompare = new MailAddress("thisis@correct.com");

        Assertions.assertTrue(mailAddressToCompare.equals(mailAddress));
    }

    @Test
    public void givenDifferentMailAddress_ReturnsFalse(){
        MailAddress mailAddress = new MailAddress("thisis@correct.com");
        MailAddress mailAddressToCompare = new MailAddress("thisis@different.com");

        Assertions.assertFalse(mailAddressToCompare.equals(mailAddress));
    }

}