package org.example._2024_01_25_morning;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputStreamEx {
    public static void main(String[] args) {
        try (FileInputStream reader = new FileInputStream("img.svg");
             FileOutputStream writer = new FileOutputStream("img2.svg")) {
            int s;
            while ((s = reader.read()) != -1) {
                writer.write(s);
            }
            System.out.println("Yep!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
