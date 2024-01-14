package org.example._2024_01_09_morning.TeamsGame;

import lombok.Getter;

@Getter
public class Members {
    private String name;
    private int age;


    public Members(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }


    @Override
    public String toString() {
        return "player{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
