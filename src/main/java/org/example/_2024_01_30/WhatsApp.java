package org.example._2024_01_30;

public class WhatsApp extends TextReport{


    @Override
    public boolean sendReport(String report) {
        System.out.println("Message is sent to WhatsApp");
        return true;
    }
}
