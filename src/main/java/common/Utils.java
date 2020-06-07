package common;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Utils {

    static public void printTrace(String text)
    {
        System.out.println(getCurrentLocalDateTimeStamp() + text);
    }

    static public String getCurrentLocalDateTimeStamp() {
        return LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS "));
    }
}
