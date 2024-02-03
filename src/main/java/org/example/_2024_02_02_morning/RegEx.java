package org.example._2024_02_02_morning;

import com.fasterxml.jackson.core.PrettyPrinter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegEx {
    private static boolean isCorrect(String ip){
//String s = "[0-2][0-5][0-5].[0-2][0-5][0-5].[0-2][0-5]?[0-5]?.[0-2][0-5]?[0-5]?";
        String s = "((25[0-5]|2[0-4]\\\\d | [01]?\\\\d?\\\\d)(\\\\.)){3}25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?";
        Pattern pattern = Pattern.compile(s);
        Matcher matcher = pattern.matcher(ip);

     return matcher.find();
    }
    public static void main(String[] args) {
        String ip1 = "255.255.255.28";
        String ip2 = "700.5.25.111";
        System.out.println(isCorrect(ip1));
    }
}
