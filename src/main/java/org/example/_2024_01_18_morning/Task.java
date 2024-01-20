package org.example._2024_01_18_morning;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task {
    static class User {
        private String name;

        public User(String name, List<String> skills) {
            this.name = name;
            this.skills = skills;
        }

        private List<String> skills;
    }

    static class Book {
        private String title;

        public Book(String title, List<String> authors) {
            this.title = title;
            this.authors = authors;
        }

        private List<String> authors;
    }

    public static void main(String[] args) {

        List<List<Integer>> listOfLists = Arrays.asList(Arrays.asList(1, 2), Arrays.asList(3, 4));
//        System.out.println(flattenListOfLists(listOfLists));


        User user = new User("name", Arrays.asList("sdsd", "asdas"));
        User user2 = new User("as", Arrays.asList("sdsd", "asdas"));
        List<User> lisst = new ArrayList<>();
        lisst.add(user2);
        lisst.add(user);
//        System.out.println(getAllSkills(lisst));

        Book book1 = new Book("author1", Arrays.asList("sdsadsd", "asfgdfdas"));
        Book book2 = new Book("author2", Arrays.asList("sds3243d", "asd4354as"));
        List<Book> listBook = new ArrayList<>();
        listBook.add(book2);
        listBook.add(book1);
//        System.out.println(getAuthorsTitles(listBook));

        Map<String, List<String>> map = new HashMap<>();
        map.put("title",Arrays.asList("asdsds","asdsad","bfdbfg"));
        System.out.println(flattenMap(map));

        List<List<Integer>> listOfInt = new ArrayList<>();

    }
//    Задача 11: Обработка вложенных структур с условными фильтрами
//    Задание: Напишите метод, который обрабатывает вложенные структуры данных
//            (например мапы, содержащих списки), фильтрует элементы по условию и объединяет их в один список.
    class Order {
        private String customerName;
        private List<Item> items;
    }

    class Item {
        private String name;
        private double price;
    }

    public List<Item> getItemsByCustomerName(List<Order> orders, String customerName) {
        List<Item> listR = new ArrayList<Item>();
        return listR;
    }

    //    Задача 10: Напишите метод, который объединяет данные из нескольких списков и
//    преобразует их в один список, применяя к каждому элементу определённую функцию.
//    public List<String> combineAndTransform(List<Integer> list1, List<Double> list2, Function<Number, String> transformer) {
//
//    }



//    Задача 5: Напишите метод, который принимает список списков и фильтрует все четные числа, а затем умножает их на 2.
//    public static List<Integer> processAndFilter(List<List<Integer>> listOfLists) {
//        return listOfLists.
//    }

//    Задача 4: Напишите метод, который преобразует Map в список значений.
    public static List<String> flattenMap(Map<String, List<String>> map) {
        return  map.entrySet().stream().flatMap(e->e.getValue().stream()).toList();
    }

    //    Задача 3: Напишите метод, который объединяет строки из списка объектов.
    public static List<String> getAuthorsTitles(List<Book> books) {
        return books.stream().flatMap(e -> Stream.concat(e.authors.stream(), Stream.of(e.title.split(" ")))).toList();
    }

    //        Задача 2: Напишите метод, который преобразует список объектов с вложенными списками в один список всех вложенных элементов.
    public static List<String> getAllSkills(List<User> users) {
        return users.stream().flatMap(e -> {
            String name = e.name;
            List<String> list = e.skills;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < list.size(); i++) {
                sb.append(list.get(i)).append(" ");
            }
            sb.append(name);
            return Arrays.stream(sb.toString().split(" "));
        }).toList();
//        return users.stream().flatMap(e-> Stream.concat(e.name,e.skills.stream())).toList();
    }

    //        Задача 1: Напишите метод, который принимает список списков целых чисел
//        и преобразует его в один список
    public static List<Integer> flattenListOfLists(List<List<Integer>> listOfLists) {
        return listOfLists.stream().flatMap(e -> e.stream()).toList();
    }
}
