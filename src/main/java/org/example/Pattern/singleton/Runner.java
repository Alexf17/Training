package org.example.Pattern.singleton;

public class Runner {
    public static void main(String[] args) {
       Logger.getLogger().addLogInfo("first log");
       Logger.getLogger().addLogInfo("second log");
       Logger.getLogger().addLogInfo("third log");

       Logger.getLogger().showLogFile();
    }
}
