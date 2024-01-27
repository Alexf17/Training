package org.example._2024_01_25_morning;

import lombok.Getter;

import java.io.Serializable;

@Getter
class Book implements Serializable {
    private int id;
    private String title;
    private String author;
    private int year;
    private double price;

    public Book(int id, String title, String author, int year, double price) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
        this.price = price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}