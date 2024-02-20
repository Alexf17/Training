package org.example.Pattern.abstractFactory.site;

import org.example.Pattern.abstractFactory.Tester;

public class ManualTester implements Tester {
    @Override
    public void testCode() {
        System.out.println("tester working");
    }
}
