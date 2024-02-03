package org.example._2024_01_30;

public class SimpleSender {
    public static void main(String[] args) {
        PrepareDate prepareDate = new PrepareDate();
        String date = prepareDate.PrepareString(Viber.class);
        SendMessage viberMessage = new Viber();
        String report = viberMessage.generateReport(date);
        boolean isSend = viberMessage.sendReport(report);
        System.out.println(isSend);
    }



}
