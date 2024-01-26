package org.example._2024_01_23_morning;

import java.io.*;
import java.util.stream.Collectors;

public class Taski {
    public static void main(String[] args) {
        String fromFile ="src\\main\\java\\org\\example\\_2024_01_23_morning\\f.txt";
        String toFile ="src\\main\\java\\org\\example\\_2024_01_23_morning\\new.txt";

//        Прочитайте файл и посчитайте средний рейтинг всех стримов.
//        Запишите результат в новый файл.
//        getAverageRating(fromFile, toFile);

//        Отфильтруйте стримы, имеющие рейтинг выше 4.5, и запишите их в новый файл.
//        getRatingMoreThan(fromFile, toFile);

//        Сгруппируйте стримы по названию и запишите количество стримов в каждой группе в новый файл.
//        getGroupingStream(fromFile, toFile);

//        Отсортируйте стримы по рейтингу от наибольшего к наименьшему и запишите результаты в новый файл.
        getSortedStream(fromFile,toFile);

    }
    public static void getSortedStream(String input, String output){
        try (BufferedReader reader = new BufferedReader(new FileReader(input));
             FileWriter writer = new FileWriter(output, true)) {

//            String filteredStreams = reader.lines().map(str->)
//                    .sorted(Integer.parseInt(split(" ")[1])).collect(Collectors.toList()).toString()
//                    .collect(Collectors.groupingBy(str -> str.split(" ")[2].split("")[0]))
//                    .entrySet().toString();

//            writer.write(filteredStreams + "\n");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void getGroupingStream(String input, String output){
        try (BufferedReader reader = new BufferedReader(new FileReader(input));
             FileWriter writer = new FileWriter(output, true)) {

            String filteredStreams = reader.lines()
                    .collect(Collectors.groupingBy(str -> str.split(" ")[2].split("")[0]))
                    .entrySet().toString();

            writer.write(filteredStreams + "\n");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void getRatingMoreThan(String input, String output) {
        try (BufferedReader reader = new BufferedReader(new FileReader(input));
             FileWriter writer = new FileWriter(output, true)) {

            String filteredStreams = reader.lines()
                    .filter(e -> Double.parseDouble(e.split(", ")[1]) > 4.5).collect(Collectors.joining());
//                    .filter(e -> Double.parseDouble(e.split(", ")[1]) > 4.5).toList().toString();
            writer.write(filteredStreams + "\n");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void getAverageRating(String input, String output) {
        try (BufferedReader reader = new BufferedReader(new FileReader(input));
             FileWriter writer = new FileWriter(output, true)) {

            double average = reader.lines()
                    .map(str -> str.split(", ")[1])
                    .mapToDouble(Double::parseDouble)
                    .average()
                    .orElse(0.0);

            writer.write(average + "\n");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
