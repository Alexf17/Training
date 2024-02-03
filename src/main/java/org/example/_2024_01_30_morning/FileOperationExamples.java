package org.example._2024_01_30_morning;

import java.io.*;

public class FileOperationExamples {
    public static void main(String[] args) throws IOException {
        copyFileUsingFileStreams();
        copyFileUsingPath();
        copyFileUsingRandomAccessFile();
    }

    // Задание 1: Работа с классом File

    /**
     * Написать метод, который создает файл с именем
     * "example.txt" в текущей директории, затем считывает
     * этот файл с использованием FileInputStream и записывает
     * его содержимое в новый файл "copy_example.txt" с использованием FileOutputStream.
     */
    public static void copyFileUsingFileStreams() throws IOException {
        File file = new File("example.txt");
        if (file.createNewFile()) {
            try (FileInputStream input = new FileInputStream("example.txt");
                 FileOutputStream output = new FileOutputStream("copy_example.txt")) {

                output.write(input.read());
            }
        }

    }

    // Задание 2: Работа с классом Path

    /**
     * Написать метод, который использует Path и Files
     * для копирования файла "example.txt" в новый файл "copy_example_path.txt".
     * Проверить, существует ли файл "example.txt" перед копированием.
     */
    public static void copyFileUsingPath() throws IOException {
        File file = new File("example.txt");
        if (file.exists()) {
            try (FileInputStream input = new FileInputStream("example.txt");
                 FileOutputStream output = new FileOutputStream("copy_example_path.txt")) {
                output.write(input.read());
                output.flush();
            }
        }

    }

    // Задание 3: Работа с классом RandomAccessFile

    /**
     * Написать метод, который открывает файл "example.txt"
     * с использованием RandomAccessFile, читает первые 20 байт и записывает
     * их в новый файл "random_access_copy.txt".
     */
    public static void copyFileUsingRandomAccessFile() throws IOException {
        try (RandomAccessFile input = new RandomAccessFile("example.txt", "rw");
             BufferedWriter output = new BufferedWriter(new FileWriter("random_access_copy.txt"))) {
            byte[] buffer = new byte[20];
            input.read(buffer, 0, 20);
            output.write(new String(buffer));

        }


    }
}
