package org.example._2023._08_12_23;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class Book {
    private String author;
    private String name;
    private int issueYear;
    private Condition condition;
    private boolean isEBOOK;

    public boolean isEBOOK() {
        return isEBOOK;
    }

    public void setEBOOK(boolean EBOOK) {
        isEBOOK = EBOOK;
    }

    public Book(String author, String name, int issueYear, Condition condition, boolean isEBOOK) {
        this.author = author;
        this.name = name;
        this.issueYear = issueYear;
        this.condition = condition;
        this.isEBOOK = isEBOOK;
    }
}
