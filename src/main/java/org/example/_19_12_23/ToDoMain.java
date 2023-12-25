package org.example._19_12_23;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class ToDoMain {
    public static void main(String[] args) {

        //    Создайте класс ToDoList, который представляет собой список задач. Каждая задача должна быть объектом класса Task,
        //    содержащим поля, такие как название задачи, описание и статус (выполнена/не выполнена). Реализуйте методы для
        //    добавления задачи, удаления задачи, отметки задачи как выполненной и вывода списка задач.


        ToDo task = new ToDo("first", "to buy some bread");
        ToDo task3 = new ToDo("third", "to buy some bread");
        ToDo task4 = new ToDo("fourth", "to buy some milk");
        ToDo task5 = new ToDo("fifth", "to buy some coffee");
        ToDo task2 = new ToDo("second", "to buy some sugar");

        ToDoList toDoList = new ToDoList();
        toDoList.addTask(task);
        toDoList.addTask(task2);
        toDoList.addTask(task3);
        toDoList.addTask(task4);
        toDoList.addTask(task5);
       List<ToDo> toDoArray = new ArrayList<ToDo>(toDoList.getOpenedTasks());
        System.out.println(toDoArray);
       

    }
}
