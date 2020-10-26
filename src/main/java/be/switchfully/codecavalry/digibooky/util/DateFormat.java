package be.switchfully.codecavalry.digibooky.util;

import java.time.format.DateTimeFormatter;

public class DateFormat {

    public static DateTimeFormatter getFormat(){
        return DateTimeFormatter.ofPattern("dd.MM.yyyy");
    }
}
