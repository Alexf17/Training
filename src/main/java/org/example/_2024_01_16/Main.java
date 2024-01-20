package org.example._2024_01_16;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.*;

public class Main {
    //    1. Создать класс Employee с характеристиками:
//            - фамилия, имя, отчество
// - должность
// - отдел
// - зарплата
//2. Вычислить среднюю зарплату всех сотрудников
//3. Получить список сотрудников с зп > 1000
//            4. Получить список сотрудников из отдела маркетинг и увеличить зп на 15%
//            5. Получить сотрудника с самой низкой зп
//6. Получить сотрудника с самой высокой зп
//7*. Получите сотрудников из всех отделов с максимальной зп
//8*. Сгрупировать сотрудников по должности
    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee("Anna", "Manager", "Sales", 1500),
                new Employee("Iren", "Manager", "IT", 2350),
                new Employee("Maria", "Director", "Sales", 10467),
                new Employee("Paul", "Programmer", "IT", 4600),
                new Employee("Peter", "Manager", "Sales", 2050),
                new Employee("Madina", "Manager", "Finance", 3000),
                new Employee("Barb", "Manager", "Sales", 2980),
                new Employee("Anna", "HR-manager", "HR", 2800),
                new Employee("Marina", "Assistant", "HR", 1000),
                new Employee("Michael", "manager", "Marketing", 2800),
                new Employee("Johanna", "Top-manager", "Marketing", 4700)
        );
        System.out.println("--------------------------------");
        //2. Вычислить среднюю зарплату всех сотрудников
        System.out.println(employees.stream().mapToInt(entry -> entry.getSalary()).average().getAsDouble());
//        Double resultDouble = employees.stream()
//                .collect(averagingDouble(Employee::getSalary));
//        System.out.println(resultDouble);
        System.out.println("--------------------------------");
//          3. Получить список сотрудников с зп > 1000
//        employees.stream().filter(entry -> entry.getSalary()>1200).forEach(e-> System.out.println(e.getFullName()));
        employees.stream().filter(entry -> entry.getSalary() > 1200).forEach(System.out::println);
        System.out.println("--------------------------------");

//        4. Получить список сотрудников из отдела маркетинг и увеличить зп на 15%
        employees.stream().filter(entity -> entity.getDepartment().equals("Marketing")).forEach(employee -> {
            employee.setSalary((int) (employee.getSalary() * 1.15));
            System.out.println(employee);
        });
        ;
        System.out.println("--------------------------------");

//        5. Получить сотрудника с самой низкой зп
        System.out.println(employees.stream().min(Comparator.comparingDouble(emp -> emp.getSalary())).orElse(null));
        System.out.println("--------------------------------");

//        6. Получить сотрудника с самой высокой зп
        System.out.println(employees.stream().max(Comparator.comparingDouble(emp -> emp.getSalary())).orElse(null));
        System.out.println("--------------------------------");

//        7. Получите сотрудников из всех отделов с максимальной зп

        // --- groupingBy
//        Map<Integer, Set<String>> resultMap1 = givenList.stream()
//                .collect(groupingBy(String::length, toSet()));
//        System.out.println(resultMap1);
//
//        List<String> list = List.of("bb", "ccc", "dd", "aj", "uiu", "aa", "bb");
//        Map<Integer, List<String>> resultMap2 = list.stream()
//                .collect(groupingBy(String::length, toList()));
//        System.out.println(resultMap2);
        System.out.println(employees.stream().collect(groupingBy(Employee::getDepartment, maxBy(Comparator.comparingInt(Employee::getSalary)))));
        System.out.println("--------------------------------");

        //    8*. Сгрупировать сотрудников по должности
        System.out.println(employees.stream().collect(groupingBy(Employee::getPosition)));

    }


}
