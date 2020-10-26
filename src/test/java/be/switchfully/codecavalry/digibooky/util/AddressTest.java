package be.switchfully.codecavalry.digibooky.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddressTest {

    @Test
    public void incorrectPostalCode_ThrowsIllegalArgument(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Address("Some street", "25", "Lokeren", 21478));
    }

    @Test
    public void correctAddress_EqualsToString(){
        StringBuilder expectedResult = new StringBuilder();
        expectedResult.append("Some street 25")
                .append(System.lineSeparator())
                .append("2147 Lokeren");


        Address address = new Address("Some street", "25", "Lokeren", 2147);

        Assertions.assertEquals(expectedResult.toString(), address.toString());

    }

    @Test
    public void correctAddressWithoutStreet_EqualsToString(){
        StringBuilder expectedResult = new StringBuilder();
        expectedResult.append("NOT PROVIDED NOT PROVIDED")
                .append(System.lineSeparator())
                .append("2147 Lokeren");


        Address address = new Address("Lokeren", 2147);

        Assertions.assertEquals(expectedResult.toString(), address.toString());

    }
}