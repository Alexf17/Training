package org.example._2023._21_12_23;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class TaskIterator {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<Integer>();
        list1.add(1);
        list1.add(3);
        list1.add(4);
        list1.add(6);
        List<Integer> list2 = new ArrayList<Integer>();
        list2.add(7);
        list2.add(8);
        list2.add(9);
//        list1.add(0);
//        removeEvenNumbers(list1);
//        System.out.println(list1);
//        removeEvenNumbers2(list1);
//        System.out.println(list1);
//        getReversedList(list1);
//        getNewList(list1, list2);
        System.out.println(list1);
        cyclicallyRotateList(list1, 1);
        System.out.println(list1);
    }

//        Напишите метод, который принимает на вход List<Integer> и число k, и использует ListIterator для
//        циклического сдвига элементов списка на k позиций вправо.

    public static void cyclicallyRotateList(List<Integer> list, int k) {
//        if (list == null || list.isEmpty() || k < 0) {
//            // Проверка на некорректные входные данные
//            System.out.println("Некорректные входные данные.");
//            return;
//        }

        int size = list.size();
//        k = k % size; // Обработка случаев, когда k больше размера списка
//
//        if (k == 0) {
//            // Нет необходимости в сдвиге
//            return;
//        }

        ListIterator<Integer> listIterator = list.listIterator(size - k);

        while (listIterator.hasNext()) {
            // Получаем элемент с текущей позиции
            Integer current = listIterator.next();

            // Удаляем элемент с текущей позиции
            listIterator.remove();

            // Добавляем элемент в начало списка
            listIterator = list.listIterator();
            listIterator.add(current);
        }
    }

//    public static void moveList(List<Integer> list,int count){
//        ListIterator<Integer> iterator = list.listIterator();
//        while (iterator.hasNext()){
//            iterator.next()
//        }
//    }
//    Напишите метод, который принимает два списка и использует ListIterator для объединения их в один новый список.
//Напишите метод, который принимает на вход List и использует ListIterator для удаления повторяющихся элементов из списка, оставляя только уникальные.
//    Новый список должен содержать элементы поочередно из двух исходных списков.
    public static void getNewList(List<Integer> list1, List<Integer> list2) {
        List<Integer> newList = new ArrayList<>();
        ListIterator<Integer> it1 = list1.listIterator();
        ListIterator<Integer> it2 = list2.listIterator();
        while (it1.hasNext() || it2.hasNext()) {
            if (it1.hasNext()) {
                newList.add(it1.next());
            }
            if (it2.hasNext()) {
                newList.add(it2.next());
            }
        }
        System.out.println(newList);
    }

//    Напишите метод, который принимает на вход List и использует ListIterator для обхода списка
//    в обратном порядке, затем выводит элементы.

    public static void getReversedList(List<Integer> list) {
        ListIterator<Integer> it = list.listIterator(list.size());
        while (it.hasPrevious()) {
            System.out.println(it.previous());

        }
    }

    //        Напишите метод, который принимает на вход List целых чисел и использует Iterator для
//        удаления всех четных чисел из списка.
    public static void removeEvenNumbers(List<Integer> list) {
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            int next = it.next();
            if (next % 2 == 0) {
                it.remove();
            }
        }
    }

    public static void removeEvenNumbers2(List<Integer> list) {
        for (Integer my : list) {
            if (my % 2 == 0) {
                list.remove(my);
            }
        }

    }
}
