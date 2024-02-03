package org.example._2024_01_30;

public class PrepareDate {
    public <T> String PrepareString (T channel){
        String message  = "Data for channel: " + channel.toString();
        System.out.println(message);
        return message;
    }
}
