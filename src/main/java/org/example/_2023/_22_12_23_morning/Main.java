package org.example._2023._22_12_23_morning;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        HashMap<String, Integer> users = new HashMap<String, Integer>();
        users.put("Anna", 1);
        users.put("user2", 2);
        users.put("user3", 3);
        users.put("user4", 4);
        users.put("Hanna", 5);

        HashMap<Integer, String> users2 = new HashMap<Integer, String>();
        users2.put(100, "Hanna");
        users2.put(101, "user1");
        users2.put(99, "user2");
        users2.put(98, "user3");
        users2.put(104, "user4");

        TreeMap<String, Integer> treeMap = new TreeMap<String, Integer>();
        treeMap.put("Anna", 51);
        treeMap.put("user2", 52);
        treeMap.put("user3", 53);
        treeMap.put("user4", 44);
        treeMap.put("Hanna", 45);

        HashMap<String, List<Integer>> students = new HashMap<String, List<Integer>>();
        students.put("John", new ArrayList<>(Arrays.asList(7, 2, 4, 4)));
        students.put("Alex", new ArrayList<>(Arrays.asList(8, 2, 8, 8)));
        students.put("Hanna", new ArrayList<>(Arrays.asList(2, 2, 1, 2)));
        students.put("Helen", new ArrayList<>(Arrays.asList(2, 2, 1, 2)));

//        doubleAge(users);
//        filtrList(users2);
//        creatNewMap(u1, u2);
//        convertToTreeMap(users2);
//        convertToList(users);
//        convertTreeToHashMap(treeMap);
//        studentsTree(students);
    }


    //**Создайте HashMap<String, Integer>, заполните его парами
    //"имя-возраст". Используйте цикл for-each для удвоения возраста каждого человека.
    public static void doubleAge(HashMap<String, Integer> list) {
        for (Map.Entry<String, Integer> entry : list.entrySet()) {
            int newNum = entry.getValue() * 2;
            entry.setValue(newNum);
        }
        System.out.println(list);
    }

    //    ***Создайте HashMap<Integer, String>, представляющий
    //"ID-имя пользователя". Используйте цикл для фильтрации
    //    пользователей с ID больше 100 и копируйте их в TreeMap.

    public static void filtrList(HashMap<Integer, String> list) {
        for (Map.Entry<Integer, String> entry : list.entrySet()) {
            if (entry.getKey() > 100) {
                System.out.println(entry);
            }
        }
    }

    //    3**Создайте класс User с полями name и age, реализующий Comparable
    //    для сортировки по возрасту. Используйте TreeMap<User, String>
    //    для хранения информации о пользователях и переберите его, чтобы напечатать имена.

    //    **Создайте TreeMap<User, String> (класс User как в задаче 3), но на
    //    этот раз реализуйте Comparator<User>, чтобы сортировать пользователей по имени.


    public static class User implements Comparable<User>, Comparator<User> {
        private final String name;
        private final int age;

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public void printName(TreeMap<User, String> map) {
            for (Map.Entry<User, String> entry : map.entrySet()) {
                System.out.println(entry.getKey().name);
            }
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }

        @Override
        public int compareTo(User o) {
            return this.age - o.age;
        }

        @Override
        public int compare(User o1, User o2) {
            return (o1.name.compareTo(o2.name));
        }
    }


    //        **Создайте два HashMap<String, User>  и
    //    объедините их в один, удалив дубликаты пользователей.
    static HashMap<String, User> u1 = new HashMap<String, User>();
    static HashMap<String, User> u2 = new HashMap<String, User>();

    public static void creatNewMap(HashMap<String, User> map1, HashMap<String, User> map2) {
        map1.put("user", new User("name", 47));
        map1.put("user2", new User("name", 48));
        map1.put("user3", new User("name", 49));
        map1.put("user4", new User("name", 50));
        map2.put("user5", new User("name", 51));
        map2.put("user6", new User("name", 52));
        map2.put("user", new User("name", 47));
        HashMap<String, User> newUsers = new HashMap<String, User>(map1);
        for (Map.Entry<String, User> entry : map2.entrySet()) {
            newUsers.putIfAbsent(entry.getKey(), entry.getValue());
        }
        System.out.println(newUsers);
    }
    //**Создайте HashMap<Integer, String> и перепишите его в TreeMap<String, Integer>,
    //    инвертируя ключи и значения.

    public static void convertToTreeMap(HashMap<Integer, String> map) {
        TreeMap<String, Integer> newMap = new TreeMap<String, Integer>();
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            newMap.put(entry.getValue(), entry.getKey());
        }
        System.out.println(newMap);
    }

    //    **Создайте HashMap<String, Integer>, переберите её и создайте List<Integer>,
    //    содержащий все значения HashMap.
    public static void convertToList(HashMap<String, Integer> map) {
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            list.add(entry.getValue());
        }
        System.out.println(list);
    }
    //**Создайте TreeMap<String, Integer> и переберите его, создавая HashMap<Integer, String>,
    //    включающий только те записи, где значение больше 50.

    public static void convertTreeToHashMap(TreeMap<String, Integer> treeMap) {
        HashMap<Integer, String> hashMap = new HashMap<Integer, String>();
        for (Map.Entry<String, Integer> entry : treeMap.entrySet()) {
            if (entry.getValue() > 50) {
                hashMap.put(entry.getValue(), entry.getKey());
            }
        }
        System.out.println(hashMap);
    }

    //    **Создайте HashMap<String, List<Integer>>, где ключ - это имя, а значение - список оценок.
    //    Используйте TreeMap<Integer, List<String>> для создания отображения
    //    "средняя оценка - список студентов с этой оценкой".
    public static void studentsTree(HashMap<String, List<Integer>> map) {
        TreeMap<Integer, List<String>> students = new TreeMap<Integer, List<String>>();
        for (HashMap.Entry<String, List<Integer>> entry : map.entrySet()) {
            List<Integer> averageList = entry.getValue();
            int sum = 0;
            for (int i = 0; i < averageList.size(); i++) {
                sum += averageList.get(i);
            }
            int average = sum / averageList.size();
//          students.computeIfAbsent(average,k -> new ArrayList<>()).add(entry.getKey());
            List<String> doubledStudens = students.get(average);
            if (doubledStudens == null) {
                doubledStudens = new ArrayList<>();
                students.put(average, doubledStudens);
            }
            doubledStudens.add(entry.getKey());
            students.put(average, doubledStudens);
        }
        System.out.println(students);
    }
}
