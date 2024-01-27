package org.example._2024_01_23_morning.HW;

import java.io.*;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Taski {
    public static void main(String[] args) {
        String fromFile = "src\\main\\java\\org\\example\\_2024_01_23_morning\\HW\\f.txt";
        String toFile = "src\\main\\java\\org\\example\\_2024_01_23_morning\\HW\\results.txt";

//        Прочитайте файл и посчитайте средний рейтинг всех стримов.
//        Запишите результат в новый файл.
        getAverageRating(fromFile, toFile);

//        Отфильтруйте стримы, имеющие рейтинг выше 4.5, и запишите их в новый файл.
        getRatingMoreThan(fromFile, toFile);

//        Сгруппируйте стримы по названию и запишите количество стримов в каждой группе в новый файл.
        getGroupingStream(fromFile, toFile);

//        Отсортируйте стримы по рейтингу от наибольшего к наименьшему и запишите результаты в новый файл.
        getSortedStream(fromFile, toFile);

//        Найдите стримы с минимальным рейтингом и выведите их в новый файл.
        getMinStream(fromFile, toFile);

//        Соберите статистику по рейтингам (минимальный, максимальный, средний) и запишите ее в новый файл.
//
        getStatistics(fromFile, toFile);

//        Измените названия всех стримов, добавив к ним префикс "Stream-" и запишите обновленные названия в новый файл.
        changeName(fromFile, toFile);

//        Отфильтруйте стримы с рейтингом ниже 4.7 и преобразуйте их названия, добавив в конец "- Low Rated". Запишите результаты в новый файл.
        sortAndChangeName(fromFile, toFile);

//        Создайте сводку, включающую идентификатор стрима, название и рейтинг, и запишите ее в новый файл в формате "ID: Название - Рейтинг".
//        getNewTab(fromFile, toFile);

//        Соберите все названия стримов в одну длинную строку, разделяя их запятыми, и запишите эту строку в новый файл.
        getAllNames(fromFile, toFile);

    }

    public static void getAllNames(String input, String output) {
        try (BufferedReader reader = new BufferedReader(new FileReader(input));
             FileWriter writer = new FileWriter(output, true)) {

            String filteredStreams =
                    reader.lines().map(e -> e.split("\\[")[1].split("\\]")[0]).collect(Collectors.joining(", "));

            writer.write(filteredStreams + "\n" + "-------------------" + "\n");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void getNewTab(String input, String output) {
        try (BufferedReader reader = new BufferedReader(new FileReader(input));
             FileWriter writer = new FileWriter(output, true)) {

            String filteredStreams =
                    reader.lines().map(e -> {
                        String id = e.split(":")[0].trim();
                        String name = e.split("\\[")[1].split("\\]")[0];
                        String rating = e.split(", ")[1];
                        return "ID: " + id + ", " + name + ", -" + rating;
                    }).collect(Collectors.joining("\n"));

            writer.write(filteredStreams + "\n" + "-------------------" + "\n");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void sortAndChangeName(String input, String output) {
        try (BufferedReader reader = new BufferedReader(new FileReader(input));
             FileWriter writer = new FileWriter(output, true)) {

            String filteredStreams =
                    reader.lines()
                            .filter(e -> Double.parseDouble(e.split(", ")[1]) < 4.7)
                            .map(e -> e.concat(" - Low Rated")).collect(Collectors.joining(", "));

            writer.write(filteredStreams + "\n" + "-------------------" + "\n");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void changeName(String input, String output) {
        try (BufferedReader reader = new BufferedReader(new FileReader(input));
             FileWriter writer = new FileWriter(output, true)) {

            String filteredStreams = reader.lines().map(e -> e.replaceAll("Стрим", "Stream-Стрим"))
                    .collect(Collectors.joining(","));
            writer.write(filteredStreams + "\n" + "-------------------" + "\n");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void getStatistics(String input, String output) {
        try (BufferedReader reader = new BufferedReader(new FileReader(input));
             FileWriter writer = new FileWriter(output, true)) {

            List<Double> values = reader.lines().map(line -> Double.parseDouble(line.split(", ")[1])).toList();

            double max = values.stream().mapToDouble(Double::doubleValue).max().orElse(0.0);
            double min = values.stream().mapToDouble(Double::doubleValue).min().orElse(0.0);
            double average = values.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);

            String statistics = "Min : " + min + "; Average :" + average + "; Max : " + max;

            writer.write(statistics + "\n" + "-------------------" + "\n");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void getMinStream(String input, String output) {
        try (BufferedReader reader = new BufferedReader(new FileReader(input));
             FileWriter writer = new FileWriter(output, true)) {

            List<String> values = reader.lines().toList();

            double min = values.stream().mapToDouble(i -> Double.parseDouble(i.split(", ")[1])).min().orElse(0.0);
            String filteredStreams = values.stream().filter(line -> Double.parseDouble(line.split(", ")[1]) == min).collect(Collectors.joining(", "));

            writer.write(filteredStreams + "\n" + "-------------------" + "\n");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void getSortedStream(String input, String output) {
        try (BufferedReader reader = new BufferedReader(new FileReader(input));
             FileWriter writer = new FileWriter(output, true)) {

            String filteredStreams = reader.lines()
                    .sorted(Comparator.comparing(e -> e.split(", ")[1])).collect(Collectors.joining(", "));

            writer.write(filteredStreams + "\n" + "-------------------" + "\n");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void getGroupingStream(String input, String output) {
        try (BufferedReader reader = new BufferedReader(new FileReader(input));
             FileWriter writer = new FileWriter(output, true)) {

            String filteredStreams = reader.lines()
                    .collect(Collectors.groupingBy(str -> str.split(" ")[2].split("")[0]))
                    .entrySet()
                    .stream()
                    .map(entry -> entry.getKey() + ": " + entry.getValue())
                    .collect(Collectors.joining(", "));

            writer.write(filteredStreams + "\n" + "-------------------" + "\n");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void getRatingMoreThan(String input, String output) {
        try (BufferedReader reader = new BufferedReader(new FileReader(input));
             FileWriter writer = new FileWriter(output, true)) {

            String filteredStreams = reader.lines()
                    .filter(e -> Double.parseDouble(e.split(", ")[1]) > 4.5).collect(Collectors.joining());
            writer.write(filteredStreams + "\n" + "-------------------" + "\n");

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

            writer.write(average + "\n" + "-------------------" + "\n");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
