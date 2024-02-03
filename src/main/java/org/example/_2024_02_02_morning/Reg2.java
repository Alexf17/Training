package org.example._2024_02_02_morning;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Reg2 {
    public static void main(String[] args) {
        String test = "Hello my name is Alex , my email is alex@gmail.com 12 123 ABC ACBDABA2BCABCBCABCA3BC ABabCABABC6DEFG4HIJKLMcvNOPQRSTU5VWXYZ";
        String test2 = "[ABC]";
        String test3 = "AB[C-X]D";
        String test4 = "ab[a-zA-Z0-9]A";
        String test5 = "ab[^a-z]A";
        String test6 = "ab(C|E)";
        String test7 = "ab.";
        String test8 = "^Hel";
//        String test9 = "D(AB)?;
//        String test9 = "\\d";
//        String test9 = "\\w+";
//        String test9 = "\\w{4}";
//        String test9 = "\\b\\d{2}\\b";
//        String test9 = "\\w+@\\w+\\.(com|ua)";
        String test9 = "\\w+@\\w+\\.(com|ua)";

        Pattern pattern = Pattern.compile(test9);
        Matcher matcher = pattern.matcher(test);
        while (matcher.find()) {
            System.out.println("Position: "+matcher.start()+" "+ matcher.group());
        }
    }
}
