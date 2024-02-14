package org.example.TESTING.dryKissYagni;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class SU {

 static String formatName(String firstName, String lastName) {
        return firstName + " " + lastName;
    }

    public static String formatAddress(String street, String city, String zipCode) {
        return street + ", " + city + ", " + zipCode;
    }

    public static String formatString(String... parts) {
        StringBuilder builder = new StringBuilder();
        for (String part : parts) {
            builder.append(part).append(", ");
        }
        return builder.toString().trim();
    }
}

class SUI {

    public static String formatName(String firstName, String lastName) {
        return firstName + " " + lastName;
    }

    public static String formatAddress(String street, String city, String zipCode) {
        return street + ", " + city + ", " + zipCode;
    }

    /** Добавил еще trim() в цикле , для удаления пробелов у каждой строки и удаление послденей запятой */
    public static String formatString(String... parts) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < parts.length; i++){
            builder.append(parts[i].trim());
            if(i<parts.length-1){
               builder.append(", ");
            }
        }
        return builder.toString().trim();
    }
}
class SUITest{

@Test
    void formatNameTest() {
    Assertions.assertEquals("Anna Long",SUI.formatName("Anna","Long"));
    }
    @Test
    void formatAddressTest() {
    Assertions.assertEquals("street, city, zipCode",SUI.formatAddress("street","city","zipCode"));
    }
    @Test
    void formatStringTest() {
    Assertions.assertEquals("part1, part2, part3",SUI.formatString("part1","part2","part3"));
    }
}