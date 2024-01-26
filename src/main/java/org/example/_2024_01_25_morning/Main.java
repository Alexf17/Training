package org.example._2024_01_25_morning;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    /**
     * Создайте объекты класса Book для каждой строки.
     * Используйте Stream API для преобразования строк в объекты.
     * Сериализуйте список книг в файл с использованием ObjectOutputStream.
     */
    public static void main(String[] args) throws RuntimeException {
        try (BufferedReader reader = new BufferedReader(new FileReader("src\\main\\java\\org\\example\\_2024_01_25_morning\\taski.txt"));
             ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("src\\main\\java\\org\\example\\_2024_01_25_morning\\taski.ser"))) {
            reader.lines().forEach(s -> {
                int id = Integer.parseInt(s.split(", ")[0]);
                String title = s.split(", ")[1];
                String author = s.split(", ")[2];
                int year = Integer.parseInt(s.split(", ")[3]);
                double price = Integer.parseInt(s.split(", ")[4]);
                try {
                    outputStream.writeObject(new Book(id, title, author, year, price));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class Main1 {

    /**
     * Десериализуйте список книг из файла,
     * созданного в предыдущем задании, используя ObjectInputStream.
     * Используйте Stream API для фильтрации книг, например, по автору или году издания.
     * Результаты сохраните в новый сериализованный файл
     */
    public static void main(String[] args) {
        List<Book> bookListlist = new ArrayList<Book>();
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("src\\main\\java\\org\\example\\_2024_01_25_morning\\taski2.ser"));
             ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("src\\main\\java\\org\\example\\_2024_01_25_morning\\taski3.ser"))) {
            while (true) {
                try {
                    bookListlist.add((Book) inputStream.readObject());
                } catch (EOFException e) {
                    break;
                }
            }

            bookListlist.stream().filter(book -> book.getYear() > 1900).forEach(book -> {
                try {
                    outputStream.writeObject(book);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println(bookListlist);
    }

}


class Main2 {

    /**
     * Отфильтруйте книги с ценой выше определенной суммы. Сериализуйте отфильтрованный список книг в файл.
     */
    public static void main(String[] args) {
        List<Book> bookListlist = new ArrayList<Book>();
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("src\\main\\java\\org\\example\\_2024_01_25_morning\\taski2.ser"));
             ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("src\\main\\java\\org\\example\\_2024_01_25_morning\\taski3.ser"))) {
            while (true) {
                try {
                    bookListlist.add((Book) inputStream.readObject());
                } catch (IOException | ClassNotFoundException e) {
                    break;
                }
            }
            bookListlist.stream().filter(book -> book.getPrice() > 100).forEach(book -> {
                try {
                    outputStream.writeObject(book);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class Main3 {

    /**
     * Агрегируйте данные, например, подсчитайте среднюю цену книг по каждому автору. Сериализуйте результаты в файл.
     */
    public static void main(String[] args) {
//        try (FileInputStream fis = new FileInputStream("data.txt");
//             Scanner scanner = new Scanner(fis);
//             ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("authorAveragePrice.ser"))) {
//
//            Map<String, Double> authorAveragePrice = scanner.useDelimiter("\\A").next().lines()
//                    .skip(1)
//                    .map(line -> line.split(", "))
//
        List<Book> bookListlist = new ArrayList<Book>();
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("src\\main\\java\\org\\example\\_2024_01_25_morning\\taski.ser"));
             ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("src\\main\\java\\org\\example\\_2024_01_25_morning\\taski2.ser"))) {
            while (true) {
                try {
                    bookListlist.add((Book) inputStream.readObject());
                } catch (EOFException e) {
                    break;
                } catch (ClassCastException | IOException | ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
            Map<String,Double> map = bookListlist.stream()
                    .collect(Collectors.groupingBy(Book::getAuthor, Collectors.averagingDouble(Book::getPrice)));
            System.out.println(map);
            outputStream.writeObject(map);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}