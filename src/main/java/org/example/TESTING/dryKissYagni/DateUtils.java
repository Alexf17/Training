package org.example.TESTING.dryKissYagni;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.text.SimpleDateFormat;
import java.util.Date;


public class DateUtils {
    public static String formatDateForDisplay(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(date);
    }

    public static String formatTimeForDisplay(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        return sdf.format(date);
    }

    public static String formatDateTimeForDisplay(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return sdf.format(date);
    }

}

class DateUtilsTest {
    @Mock
    Date date = new Date();

    @Test
    void formatDateForDisplayTest() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Assertions.assertEquals(sdf.format(date), DateUtils.formatDateForDisplay(new Date()));
    }

    @Test
    void formatTimeForDisplayTest() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        Assertions.assertEquals(sdf.format(date), DateUtils.formatTimeForDisplay(new Date()));
    }

    @Test
    void formatDateTimeForDisplayTest() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Assertions.assertEquals(sdf.format(date), DateUtils.formatDateTimeForDisplay(new Date()));
    }
}