package org.example._2024_01_23_morning;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FilrWriterEx1 {
    public static void main(String[] args) {

        String text = "Olga -> Flusheble2Olga  -> Flusheble";
        try(FileWriter writer = new FileWriter("123.txt",true)) {

           for(int i=0;i<text.length();i++) {
               writer.write(text.charAt(i));
           }
            System.out.println("Yep!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
