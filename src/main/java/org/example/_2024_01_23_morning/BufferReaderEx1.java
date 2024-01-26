package org.example._2024_01_23_morning;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferReaderEx1 {
    public static void main(String[] args) {
        try(BufferedReader reader = new BufferedReader(new FileReader("prog.txt"))) {
            String str;
//            reader.lines().map(el->... ));
            while ((str = reader.readLine())!=null) {
                System.out.println(str);
            }
            System.out.println("Yep!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
