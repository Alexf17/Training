package org.example._2024_02_02_morning;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Reg {
    public static void main(String[] args) {
        String test = "Hello world! ABC";

        Pattern pattern = Pattern.compile("ABC");
        Matcher matcher = pattern.matcher(test);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
