package org.example.Pattern.builder;

public class Auto {
private String name;
private String model;
private int price;

    public void setName(String name) {
        this.name = name;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Auto{" +
                "name='" + name + '\'' +
                ", model='" + model + '\'' +
                ", price=" + price +
                '}';
    }
}
