package org.example._2024_01_30_morning;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class AdvancedFileOperations {
    public static void main(String[] args) throws IOException {
        countWordsInFile();
        findTxtFilesInDirectory();
        copyLastParagraphUsingRandomAccess();
    }

    // Усложненное Задание 1: Работа с классом File

    /**
     * Написать метод, который читает файл "example.txt",
     * подсчитывает количество слов в файле и записывает это количество
     * в новый файл "word_count.txt". Использовать BufferedReader и BufferedWriter
     * для эффективной работы с текстом.
     */
    public static void countWordsInFile() throws IOException {
        File file = new File("example.txt");
        if (file.exists()) {
            try (BufferedReader input = new BufferedReader(new FileReader("example.txt"));
                 BufferedWriter output = new BufferedWriter(new FileWriter("word_count.txt"))) {
//                output.write(String.valueOf(count));
                output.write(Integer.toString((int) Arrays.stream(input.readLine().split(" ")).count()));
                output.flush();
            }
        }

    }

    // Усложненное Задание 2: Работа с классом Path

    /**
     * Написать метод, который ищет все файлы с расширением ".txt"
     * в текущей директории и её поддиректориях. Результаты поиска
     * (пути к файлам) записать в файл "found_files.txt".
     */
    public static void findTxtFilesInDirectory() throws IOException {


    }

    // Усложненное Задание 3: Работа с классом RandomAccessFile

    /**
     * Написать метод, который открывает файл "example.txt"
     * с использованием RandomAccessFile, переходит к последнему абзацу
     * в файле и копирует его содержимое в новый файл "last_paragraph.txt".
     */
    public static void copyLastParagraphUsingRandomAccess() throws IOException {

    }
}
