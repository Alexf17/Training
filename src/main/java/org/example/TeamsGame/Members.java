package org.example.TeamsGame;

import lombok.Getter;

@Getter
public class Members {
    private String name;
    private int age;
    private String card;

    public Members(String name, int age, String card) {
        this.name = name;
        this.age = age;
        this.card = card;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCard(String card) {
        this.card = card;
    }

    @Override
    public String toString() {
        return "Members{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", card='" + card + '\'' +
                '}';
    }
}
