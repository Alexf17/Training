package org.example._2024_01_23_morning;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderEx1 {
    public static void main(String[] args) {
        try(FileReader reader = new FileReader("prog.txt")) {
int c ;
while((c=reader.read())!=-1){
    System.out.print((char) c);
}
            System.out.println("Yep!");
        } catch (IOException e) {
           throw new RuntimeException(e);
        }
    }
}
