package org.example._2024_02_03;

public class FormatEx {
    public static void show(User user){
        System.out.printf("%03d \t %-5s \t %-5s \t %,.1f \n", user.id, user.name, user.surname, user.salary);
    }
    public static void main(String[] args) {
User user = new User();
user.id = 1;
user.name="name";
user.surname = "surname";
user.salary = 155551.125;

        show(user);
    }
}
class  User {
    int id;
    String name;

    String surname;
    double salary;
}