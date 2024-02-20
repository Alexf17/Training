package org.example.Pattern.abstractFactory.banking;

import org.example.Pattern.abstractFactory.Developer;

public class JavaDeveloper implements Developer {
    @Override
    public void writeCode() {
        System.out.println("JD writes code ");
    }
}
