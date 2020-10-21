package be.switchfully.codecavalry.digibooky.util;

import java.util.Objects;
import java.util.regex.Pattern;

public class MailAddress {

    private String mailAddress;

    public MailAddress(String mailAddress){
       if(isMailAddressValid(mailAddress)) {
           this.mailAddress = mailAddress;
       }
    }


     public static boolean isMailAddressValid(String email)
    {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null || !pat.matcher(email).matches())throw new IllegalArgumentException("Not a valid mail address");

        return true;
    }

    @Override
    public String toString() {
        return mailAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MailAddress that = (MailAddress) o;
        return Objects.equals(mailAddress, that.mailAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mailAddress);
    }
}
