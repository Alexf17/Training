package org.example._2024_01_30;

public abstract class TextReport implements SendMessage {

    @Override
    public String generateReport(String data) {
        String message = "Generate new txt report from data " + data+ " for Class :"+this.getClass().getName();
        System.out.println(message);
        return message;
    }

    @Override
    public abstract boolean sendReport(String report) ;
}
